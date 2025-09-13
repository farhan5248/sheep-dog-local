package org.farhan.dsl.lang;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepObjectBuilder {
	private static final Logger logger = LoggerFactory.getLogger(StepObjectBuilder.class);

	private static Object getStepDefinition(Object stepObject, String predicate, ILanguageAccess la) {
		for (Object stepDef : la.getStepDefinitions(stepObject)) {
			if (la.getStepDefinitionName((Object) stepDef).contentEquals(predicate)) {
				return (Object) stepDef;
			}
		}
		return null;
	}

	private static Object createStepDefinition(Object stepObject, ILanguageAccess la) {
		String predicate = TestStepUtility.getPredicate(la.getStepName());
		Object stepDef = getStepDefinition(stepObject, predicate, la);
		if (stepDef == null) {
			return la.createStepDefinition(stepObject, predicate);
		} else {
			return stepDef;
		}
	}

	private static void createStepParameters(Object theStepDef, ILanguageAccess la) {
		if (la.hasParameters(theStepDef)) {
			String headersString = la.getStepParametersString();
			for (Object parameters : la.getStepDefinitionParameters(theStepDef)) {
				String paramSetString = la.getStepDefinitionParametersString((Object) parameters);
				if (headersString.contentEquals(paramSetString)) {
					return;
				}
			}
			la.createStepDefinitionParameters(theStepDef);
		}
	}

	public static void generateStepDefinition(ILanguageAccess la, Map<Object, Object> options) throws Exception {
		logger.debug("Entering generateStepDefinition for step: {}", la != null ? la.getStepName() : "null");
		try {
			Object stepObject = la.createStepObject(TestStepUtility.getObjectQualifiedName(la));
			Object stepDefinition = createStepDefinition(stepObject, la);
			createStepParameters(stepDefinition, la);
			la.saveObject(stepObject, options);
			logger.debug("Exiting generateStepDefinition");
		} catch (Exception e) {
			logger.error("Failed in generateStepDefinition for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

}
