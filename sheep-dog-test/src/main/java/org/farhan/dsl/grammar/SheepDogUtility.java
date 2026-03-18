package org.farhan.dsl.grammar;

public class SheepDogUtility {

	/**
	 * Checks if the given text starts with a capital letter.
	 *
	 * @param text the text to check
	 * @return true if text is not null/empty and starts with a capital letter
	 */
	public static boolean startsWithCapital(String text) {
		if (text == null || text.isEmpty()) {
			return false;
		}
		return Character.isUpperCase(text.charAt(0));
	}

	/**
	 * Gets the step object full name from a test step.
	 *
	 * @param theStep the test step
	 * @param testProject the test project containing the step
	 * @return the step object full name in format "stepdefs/component/object.asciidoc" or ""
	 */
	public static String getStepObjectFullNameForTestStep(ITestStep theStep, ITestProject testProject) {
		if (theStep == null) {
			return "";
		}
		String stepObjectName = theStep.getStepObjectName();
		if (stepObjectName == null || stepObjectName.isEmpty()) {
			return "";
		}

		// Extract component and object from the step object name
		String component = StepObjectRefFragments.getComponent(stepObjectName);
		String object = StepObjectRefFragments.getObject(stepObjectName);

		if (object.isEmpty()) {
			return "";
		}

		// Get file extension from test project
		String fileExtension = "asciidoc"; // default
		if (testProject != null) {
			fileExtension = testProject.getFileExtension();
		}

		// Construct the step object full name: "stepdefs/component/object.asciidoc" or "stepdefs/object.asciidoc"
		if (component.isEmpty()) {
			return "stepdefs/" + object + "." + fileExtension;
		} else {
			return "stepdefs/" + component + "/" + object + "." + fileExtension;
		}
	}

	/**
	 * Gets the test project parent for a test step.
	 *
	 * @param theStep the test step
	 * @return the test project parent
	 */
	public static ITestProject getTestProjectParentForTestStep(ITestStep theStep) {
		if (theStep == null) {
			return null;
		}
		ITestStepContainer parent = theStep.getParent();
		if (parent == null) {
			return null;
		}
		ITestSuite grandParent = parent.getParent();
		if (grandParent == null) {
			return null;
		}
		return grandParent.getParent();
	}
}
