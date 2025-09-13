package org.farhan.dsl.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueDetector.class);

	public static String getErrorMessage(String text) {
		// TODO make tests for all of these documenting the message content

		if (text == null) {
			return TestStepIssueTypes.NAME_COMPONENT.value;
		}

		if (!TestStepUtility.hasObject(text)) {
			if (!TestStepUtility.hasComponent(text)) {
				return TestStepIssueTypes.NAME_COMPONENT.value + "\n\n" + TestStepIssueTypes.NAME_OBJECT.value;
			} else {
				return TestStepIssueTypes.NAME_OBJECT.value;
			}
		} else {
			// There can't be a predicate since it's invalid so is there at least state
			if (!TestStepUtility.hasState(text)) {
				if (!TestStepUtility.hasDetails(text)) {
					return TestStepIssueTypes.NAME_STATE.value + "\n\n" + TestStepIssueTypes.NAME_DETAILS.value;
				} else {
					return TestStepIssueTypes.NAME_STATE.value;
				}
			} else {
				// if there's a state but it's still invalid, the only part after that is time
				// or
				// "is as" which passes for "is present" etc
				if (!TestStepUtility.hasTime(text)) {
					return TestStepIssueTypes.NAME_TIME.value;
				} else {
					// put all the error messages because there's something weird
					return TestStepIssueTypes.NAME_COMPONENT.value + "\n\n" + TestStepIssueTypes.NAME_OBJECT.value
							+ "\n\n" + TestStepIssueTypes.NAME_DETAILS.value + "\n\n"
							+ TestStepIssueTypes.NAME_STATE.value + "\n\n" + TestStepIssueTypes.NAME_TIME.value;
				}
			}
		}
	}

	public static boolean isValid(String text) {
		return text.matches(TestStepUtility.REGEX);
	}

	public static String getErrorMessage(ILanguageAccess la) throws Exception {
		logger.debug("Entering validateError for step: {}", la != null ? la.getStepName() : "null");
		try {
			if (!TestStepIssueDetector.isValid(la.getStepName())) {
				logger.debug("Exiting validateError");
				return TestStepIssueDetector.getErrorMessage(la.getStepName());
			} else {
				if (la.getAllSteps().getFirst().equals(la.getStep())) {
					if (TestStepUtility.getComponent(la.getStepName()).isEmpty()) {
						logger.debug("Exiting validateError");
						return TestStepIssueTypes.FIRST_STEP_COMPONENT.value;
					}
				}
				logger.debug("Exiting validateError");
				return "";
			}
		} catch (Exception e) {
			logger.error("Failed in validateError for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static String getWarningMessage(ILanguageAccess la) throws Exception {
		logger.debug("Entering validateWarning for step: {}", la != null ? la.getStepName() : "null");
		try {
			String stepObjectQualifiedName = TestStepUtility.getObjectQualifiedName(la);
			Object stepObject = la.createStepObject(stepObjectQualifiedName);
			String predicate = TestStepUtility.getPredicate(la.getStepName());
			Object theStepDef = null;
			for (Object stepDef : la.getStepDefinitions(stepObject)) {
				if (la.getStepDefinitionName((Object) stepDef).contentEquals(predicate)) {
					theStepDef = (Object) stepDef;
				}
			}
			if (la.getStepObject(stepObjectQualifiedName) == null) {
				return TestStepIssueTypes.STEP_OBJECT_NOT_FOUND.value;
			}
			if (theStepDef == null) {
				return TestStepIssueTypes.PREDICATE_NOT_FOUND.value;
			}
			if (la.hasParameters(theStepDef)) {
				String headersString = la.getStepParametersString();
				for (Object parameters : la.getStepDefinitionParameters(theStepDef)) {
					String paramSetString = la.getStepDefinitionParametersString((Object) parameters);
					if (headersString.contentEquals(paramSetString)) {
						return "";
					}
				}
				return TestStepIssueTypes.PARAMETERS_NOT_FOUND.value;
			}
			logger.debug("Exiting validateWarning");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateWarning for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

}
