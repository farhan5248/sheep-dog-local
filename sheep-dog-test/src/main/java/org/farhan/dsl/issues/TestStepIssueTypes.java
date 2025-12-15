package org.farhan.dsl.issues;

public enum TestStepIssueTypes {

	TEST_STEP_STEP_OBJECT_NAME_ONLY("TEST_STEP_STEP_OBJECT_NAME_ONLY",
			"Every test case must have at least one component specified."
					+ "\nThis should be the first part of the test step name." + "\nThe component is optional."
					+ "\nComponent ending words are: application, service, plugin, batchjob, project."
					+ "\nExamples are: \"The something application,\" or \"The something service,\""
					+ "Every test step must have the object specified."
					+ "\nThe object can have the complete path or not."
					+ "\nObject ending words are: file, page, response, dialog, directory, request, goal, job, action."
					+ "\nExamples are: \"src/test/resources/file.txt file\" or \"Home page\""),

	TEST_STEP_STEP_DEFINITION_NAME_ONLY("TEST_STEP_STEP_DEFINITION_NAME_ONLY",
			"After specifying the step object name, a step definition name is specified."
					+ "\nIt has 3 parts, details (optional), state and time (optional)."
					+ "\nDetails is used to specify a part in a document, like the header or body."
					+ "\nThe details ending words are: section, fragment, table, snippet, list."
					+ "\nExamples are: \"Customer details section\" or \"Order History table\""
					+ "\nState part begins with words like is or isn't which get converted to setters or assertions in the test automation."
					+ "\nNext it's followed by the state attribute which is optional and can be any word."
					+ "\nThe state starting words are: is, isn't, will be, won't be."
					+ "\nExamples are: \"is present\" or \"will be created as follows\""
					+ "\nA test step can end with the time specified."
					+ "\nTime was useful running describing a sequence of steps like submitting an order before 5pm."
					+ "\nThe time endings are: early, late, on time, at, before, after, in, on."
					+ "\nExamples are: \"after the next day\" or \"on time\""),

	TEST_STEP_STEP_OBJECT_NAME_WORKSPACE("TEST_STEP_STEP_OBJECT_NAME_WORKSPACE",
			"The step object file doesn't exist for the component"),

	TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE("TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE",
			"The step definition doesn't exist for the step object");

	public final String id;
	public final String description;

	TestStepIssueTypes(String value, String description) {
		this.id = value;
		this.description = description;
	}
}