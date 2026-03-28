package org.farhan.dsl.asciidoc.ide.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.lsp4j.ExecuteCommandParams;
import org.eclipse.xtext.ide.server.ILanguageServerAccess;
import org.eclipse.xtext.ide.server.commands.IExecutableCommandService;
import org.eclipse.xtext.util.CancelIndicator;
import org.farhan.dsl.asciidoc.generator.AsciiDocGenerator;
import org.slf4j.Logger;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.gson.JsonPrimitive;

public class AsciiDocGeneratorCommandService implements IExecutableCommandService {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(AsciiDocGeneratorCommandService.class);

	@Override
	public List<String> initialize() {
		logger.debug("Entering initialize");
		List<String> commands = Lists.newArrayList("asciidoc.generate2");
		logger.debug("Exiting initialize");
		return commands;
	}

	@Override
	public Object execute(ExecuteCommandParams params, ILanguageServerAccess access, CancelIndicator cancelIndicator) {
		logger.info("Entering command: {} with parameters: {}", params.getCommand(), params.getArguments());
		final String commandName = params.getCommand();
		final long startTime = System.currentTimeMillis();

		try {
			if ("asciidoc.generate2".equals(commandName)) {
				JsonPrimitive uriArg = (JsonPrimitive) Iterables.getFirst(params.getArguments(), null);
				final String uri = (uriArg != null) ? uriArg.getAsString() : null;

				logger.debug("Command {} parameters: {uri: {}}", commandName, uri);

				if (uri != null && !uri.isEmpty()) {
					return generateForAllIndexedResources(access, commandName, startTime);
				} else {
					String errorMsg = "Document URI missing";
					logger.error("Command {} failed: {}", commandName, errorMsg);
					return errorMsg;
				}
			}

			String errorMsg = "Bad Command: " + commandName;
			logger.error("Command execution failed: {}", errorMsg);
			return errorMsg;
		} finally {
			logger.debug("Exiting execute for command: {}", commandName);
		}
	}

	private Object generateForAllIndexedResources(ILanguageServerAccess access, String commandName, long startTime) {
		try {
			// Get all indexed .asciidoc URIs from the Xtext index
			List<String> asciidocUris = access.doReadIndex((ILanguageServerAccess.IndexContext indexContext) -> {
				List<String> uris = new ArrayList<>();
				for (org.eclipse.xtext.resource.IResourceDescription desc : indexContext.getIndex().getAllResourceDescriptions()) {
					String uri = desc.getURI().toString();
					if (uri.endsWith(".asciidoc")) {
						uris.add(uri);
					}
				}
				return uris;
			}).get();

			logger.info("Command {} found {} .asciidoc resources in index", commandName, asciidocUris.size());

			int successCount = 0;
			int errorCount = 0;

			for (String resourceUri : asciidocUris) {
				try {
					Object result = access.doRead(resourceUri, (ILanguageServerAccess.Context context) -> {
						Resource resource = context.getResource();
						if (resource != null) {
							logger.debug("Command {} executing generator for resource: {}", commandName,
									resource.getURI());
							AsciiDocGenerator.generateFromResource(resource);
							return "success";
						}
						return "not found";
					}).get();

					if ("success".equals(result)) {
						successCount++;
					}
				} catch (InterruptedException | ExecutionException e) {
					errorCount++;
					logger.error("Command {} failed for {}: {}", commandName, resourceUri, e.getMessage(), e);
				}
			}

			long duration = System.currentTimeMillis() - startTime;
			String result = String.format("Code generation completed in %dms: %d succeeded, %d failed",
					duration, successCount, errorCount);
			logger.info("Command {} result: {}", commandName, result);
			return result;
		} catch (InterruptedException | ExecutionException e) {
			long duration = System.currentTimeMillis() - startTime;
			String errorMsg = "Failed to read index: " + e.getMessage();
			logger.error("Command {} failed after {}ms: {}", commandName, duration, errorMsg, e);
			return errorMsg;
		}
	}
}
