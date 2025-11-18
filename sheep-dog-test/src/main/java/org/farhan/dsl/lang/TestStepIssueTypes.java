package org.farhan.dsl.lang;

public enum TestStepIssueTypes {

	// TODO in the future this will just be component, object, predicate (details+state+time)

	NAME_COMPONENT("Every test case must have at least one component specified."
			+ "\nThis should be the first part of the test step name."
			+ "\nThe component is optional, but if it is present, it must be followed by a comma."
			+ "\nComponent ending words are: application, service, plugin, batchjob, project."
			+ "\nExamples are: \"The something application,\" or \"The something service,\"",
			"Component specification error"),

	NAME_DETAILS("After specifying the object, a predicate is specified."
			+ "\nIt has 3 parts, details, state and time; details is optional."
			+ "\nThis is used to specify a part in a document, like the header or body."
			+ "\nThe details ending words are: section, fragment, table, snippet, list."
			+ "\nExamples are: \"Customer details section\" or \"Order History table\"",
			"Details specification error"),

	NAME_OBJECT(
			"Every test step must have the object specified." + "\nThe object can have the complete path or not."
					+ "\nObject ending words are: file, page, response, dialog, directory, request, goal, job, action."
					+ "\nExamples are: \"src/test/resources/file.txt file\" or \"Home page\"",
			"Object specification error"),

	NAME_STATE("After specifying the object, a predicate is specified."
			+ "\nIt has 3 parts, details, state and time; state is mandatory."
			+ "\nThis part begins with words like is or isn't which get converted to setters or assertions in the test automation."
			+ "\nNext it's followed by the state attribute which is optional and can be any word."
			+ "\nThe state starting words are: is, isn't, will be, won't be."
			+ "\nExamples are: \"is present\" or \"will be created as follows\"",
			"State specification error"),

	NAME_TIME("After specifying the object, a predicate is specified."
			+ "\nIt has 3 parts, details, state and time; time is optional."
			+ "\nA test step can end with the time specified."
			+ "\nThis was useful running describing a sequence of steps like submitting an order before 5pm."
			+ "\nExamples are: \"after the next day\" or \"on time\""
			+ "\nThe time endings are: early, late, on time, at, before, after, in, on.",
			"Time specification error"),

	// TODO move to TestStepContainerIssueTypes
	CHILD_STEP_NAME("The first step must have a component", "First step component requirement"),

	// TODO add COMPONENT_NOT_FOUND
	// Rename descriptions to be more accurate

	REFERENCE_STEP_OBJECT("The object doesn't exist", "Step object file not found"),

	REFERENCE_STEP_DEFINITION("The object predicate doesn't exist", "Predicate method not found"),

	REFERENCE_STEP_PARAMETERS("The object predicate parameters doesn't exist", "Step parameters not found");

	public final String value;
	public final String description;

	TestStepIssueTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}