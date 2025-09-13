package org.farhan.dsl.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepValidator {

	private static final Logger logger = LoggerFactory.getLogger(TestStepValidator.class);

	private static String validateWarningForTestStepStepObject(ILanguageAccess la, String stepObjectQualifiedName)
			throws Exception {
		logger.debug("Entering validateWarning for step: {}", la != null ? la.getStepName() : "null");
		try {
			if (la.getStepObject(stepObjectQualifiedName) == null) {
				return stepObjectQualifiedName + " doesn't exist in src/test/resources/asciidoc/stepdefs/";
			}
			logger.debug("Exiting validateWarning");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateWarning for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	private static String validateWarningForTestStepStepDefinition(ILanguageAccess la, String stepObjectQualifiedName,
			Object theStepDef, String predicate) throws Exception {
		logger.debug("Entering validateWarning for step: {}", la != null ? la.getStepName() : "null");
		try {
			if (theStepDef == null) {
				return predicate + " doesn't exist in " + stepObjectQualifiedName;
			}
			logger.debug("Exiting validateWarning");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateWarning for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	private static String validateWarningForTestStepStepParameters(ILanguageAccess la, String stepObjectQualifiedName,
			Object theStepDef, String predicate) throws Exception {
		logger.debug("Entering validateWarning for step: {}", la != null ? la.getStepName() : "null");
		try {
			if (la.hasParameters(theStepDef)) {
				String headersString = la.getStepParametersString();
				for (Object parameters : la.getStepDefinitionParameters(theStepDef)) {
					String paramSetString = la.getStepDefinitionParametersString((Object) parameters);
					if (headersString.contentEquals(paramSetString)) {
						return "";
					}
				}
				return headersString + " doesn't exist in " + stepObjectQualifiedName + " for " + predicate;
			}
			logger.debug("Exiting validateWarning");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateWarning for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	

	public static String validateErrorForTestStepTestCase(ILanguageAccess la) throws Exception {
		logger.debug("Entering validateError for step: {}", la != null ? la.getStepName() : "null");
		try {
			if (la.getAllSteps().getFirst().equals(la.getStep())) {
				if (TestStepUtility.getComponent(la.getStepName()).isEmpty()) {
					return "The first step must have a component";
				}
			}
			logger.debug("Exiting validateError");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateError for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static String validateErrorForTestStepName(ILanguageAccess la) throws Exception {
		logger.debug("Entering validateError for step: {}", la != null ? la.getStepName() : "null");
		try {
			if (!TestStepValidator.isValid(la.getStepName())) {
				return TestStepValidator.getErrorMessage(la.getStepName());
			} else {
				logger.debug("Exiting validateError");
				return "";
			}
		} catch (Exception e) {
			logger.error("Failed in validateError for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	public static String validateWarningForTestStep(ILanguageAccess la) throws Exception {
		logger.debug("Entering validateWarning for step: {}", la != null ? la.getStepName() : "null");
		try {
			String stepObjectQualifiedName = TestStepUtility.getStepObjectQualifiedNameForTestStep(la);
			Object stepObject = la.createStepObject(stepObjectQualifiedName);
			String predicate = TestStepUtility.getPredicate(la.getStepName());
			Object theStepDef = TestStepUtility.getStepDefinition(stepObject, predicate, la);
			validateWarningForTestStepStepObject(la, stepObjectQualifiedName);
			validateWarningForTestStepStepDefinition(la, stepObjectQualifiedName, theStepDef, predicate);
			validateWarningForTestStepStepParameters(la, stepObjectQualifiedName, theStepDef, predicate);
			logger.debug("Exiting validateWarning");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateWarning for step '{}': {}", la != null ? la.getStepName() : "null",
					e.getMessage(), e);
			throw e;
		}
	}

	private static String getErrorMessage() {
		return getErrorMessageComponent() + "\n\n" + getErrorMessageObject() + "\n\n" + getErrorMessageDetails()
				+ "\n\n" + getErrorMessageState() + "\n\n" + getErrorMessageTime();
	}

	public static String getErrorMessage(String text) {
		// TODO make tests for all of these documenting the message content

		if (text == null) {
			return getErrorMessage();
		}

		if (!TestStepUtility.hasObject(text)) {
			if (!TestStepUtility.hasComponent(text)) {
				return getErrorMessageComponent() + "\n\n" + getErrorMessageObject();
			} else {
				return getErrorMessageObject();
			}
		} else {
			// There can't be a predicate since it's invalid so is there at least state
			if (!TestStepUtility.hasState(text)) {
				if (!TestStepUtility.hasDetails(text)) {
					return getErrorMessageState() + "\n\n" + getErrorMessageDetails();
				} else {
					return getErrorMessageState();
				}
			} else {
				// if there's a state but it's still invalid, the only part after that is time
				// or
				// "is as" which passes for "is present" etc
				if (!TestStepUtility.hasTime(text)) {
					return getErrorMessageTime();
				} else {
					// put all the error messages because there's something weird
					return getErrorMessage();
				}
			}
		}
	}

	private static String getErrorMessageComponent() {
		return "Every test case must have at least one component specified."
				+ "\nThis should be the first part of the test step name."
				+ "\nThe component is optional, but if it is present, it must be followed by a comma."
				+ "\nComponent ending words are: application, service, plugin, batchjob, project."
				+ "\nExamples are: \"The something application,\" or \"The something service,\"";
	}

	private static String getErrorMessageDetails() {
		return "After specifying the object, a predicate is specified."
				+ "\nIt has 3 parts, details, state and time; details is optional."
				+ "\nThis is used to specify a part in a document, like the header or body."
				+ "\nThe details ending words are: section, fragment, table, snippet, list."
				+ "\nExamples are: \"Customer details section\" or \"Order History table\"";
	}

	private static String getErrorMessageObject() {
		return "Every test step must have the object specified." + "\nThe object can have the complete path or not."
				+ "\nObject ending words are: file, page, response, dialog, directory, request, goal, job, action."
				+ "\nExamples are: \"src/test/resources/file.txt file\" or \"Home page\"";
	}

	private static String getErrorMessageState() {
		return "After specifying the object, a predicate is specified."
				+ "\nIt has 3 parts, details, state and time; state is mandatory."
				+ "\nThis part begins with words like is or isn't which get converted to setters or assertions in the test automation."
				+ "\nNext it's followed by the state attribute which is optional and can be any word."
				+ "\nThe state starting words are: is, isn't, will be, won't be."
				+ "\nExamples are: \"is present\" or \"will be created as follows\"";
	}

	private static String getErrorMessageTime() {
		return "After specifying the object, a predicate is specified."
				+ "\nIt has 3 parts, details, state and time; time is optional."
				+ "\nA test step can end with the time specified."
				+ "\nThis was useful running describing a sequence of steps like submitting an order before 5pm."
				+ "\nExamples are: \"after the next day\" or \"on time\""
				+ "\nThe time endings are: early, late, on time, at, before, after, in, on.";
	}

	public static boolean isValid(String text) {
		return text.matches(TestStepUtility.REGEX);
	}

}
