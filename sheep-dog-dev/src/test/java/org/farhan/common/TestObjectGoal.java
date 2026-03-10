package org.farhan.common;

import java.util.ArrayList;

import org.farhan.mbt.core.Converter;
import org.farhan.dsl.grammar.IResourceRepository;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class TestObjectGoal extends TestObject {

	private static final Logger logger = LoggerFactory.getLogger(TestObjectGoal.class);

	// TODO don't hardcode the directories
	protected String[] dirs = { "src/test/resources/asciidoc/", "src-gen/test/resources/cucumber/" };
	protected IResourceRepository or;
	protected SourceFileRepository sr;
	protected String tags;

	public TestObjectGoal() {
		or = new ServiceFileRepository();
		sr = new SourceFileRepository();
		properties.put("tags", "");
	}

	protected void runGoal(String goal) {
		logger.debug("Entering runGoal for goal: {}", goal != null ? goal : "null");
		try {
			tags = properties.get("tags").toString();
			Class<?> mojoClass = Class.forName(goal);
			Converter mojo = (Converter) mojoClass.getConstructor(String.class, IResourceRepository.class)
					.newInstance(tags, or);

			if (mojo.getClass().getName().endsWith("ToUML")) {
				mojo.clearProjects();
				for (String dir : dirs) {
					ArrayList<String> tempFiles = new ArrayList<String>();
					for (String fileName : sr.list("", dir, "")) {
						if (fileName.startsWith(dir + "stepdefs")) {
							tempFiles.add(fileName);
						} else {
							mojo.convertFile(fileName, sr.get("", fileName));
						}
					}
					for (String fileName : tempFiles) {
						mojo.convertFile(fileName, sr.get("", fileName));
					}
				}
			} else {
				for (String fileName : mojo.getFileNames()) {
					String content = mojo.convertFile(fileName, sr.contains("", fileName) ? sr.get("", fileName) : "");
					if (!content.isEmpty()) {
						sr.put("", fileName, content);
					}
				}
			}
			logger.debug("Exiting runGoal");
		} catch (Exception e) {
			logger.error("Failed in runGoal for goal '{}': {}", goal != null ? goal : "null", e.getMessage(), e);
			Assertions.fail(e);
		}
	}
}
