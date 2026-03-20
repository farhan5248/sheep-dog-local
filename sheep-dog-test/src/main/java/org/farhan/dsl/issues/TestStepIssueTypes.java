package org.farhan.dsl.issues;

public enum TestStepIssueTypes {

	TEST_STEP_STEP_OBJECT_NAME_ONLY("TEST_STEP_STEP_OBJECT_NAME_ONLY",
			"Every test case must have at least one component specified.\n"
					+ "This should be the first part of the test step name.\n"
					+ "The component is optional.\n"
					+ "Component ending words are: application, service, plugin, batchjob, project.\n"
					+ "Examples are: \"The something application,\" or \"The something service,\""
					+ "Every test step must have the object specified.\n"
					+ "The object can have the complete path or not.\n"
					+ "Object ending words are: page, response, file, directory, dialog, popup, annotation, hover, tooltip, request, goal, job, action.\n"
					+ "Examples are: \"src/test/resources/file.txt file\" or \"Home page\"");

	public final String id;
	public final String description;

	TestStepIssueTypes(String id, String description) {
		this.id = id;
		this.description = description;
	}
}
