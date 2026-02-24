package org.farhan.dsl.issues;

/**
 * Validation issue types for test step grammar elements.
 * <p>
 * Separates issue definitions from validation logic, enabling consistent error
 * messages across validators.
 * </p>
 */
public enum TestStepIssueTypes {

    TEST_STEP_STEP_OBJECT_NAME_ONLY("TEST_STEP_STEP_OBJECT_NAME_ONLY",
            "Every test case must have at least one component specified.\n"
                    + "This should be the first part of the test step name.\n" + "The component is optional.\n"
                    + "Component ending words are: application, service, plugin, batchjob, project.\n"
                    + "Examples are: \"The something application,\" or \"The something service,\"Every test step must have the object specified.\n"
                    + "The object can have the complete path or not.\n"
                    + "Object ending words are: page, response, file, directory, dialog, popup, annotation, hover, tooltip, request, goal, job, action.\n"
                    + "Examples are: \"src/test/resources/file.txt file\" or \"Home page\""),

    TEST_STEP_STEP_DEFINITION_NAME_ONLY("TEST_STEP_STEP_DEFINITION_NAME_ONLY",
            "After specifying the step object name, a step definition name is specified.\n"
                    + "It has a part (optional) and state.\n"
                    + "Part is used to specify a part in a document, like the header or body.\n"
                    + "The part types are: language, type, assignment, fragment, scope.\n"
                    + "Examples are: \"Customer details section\" or \"Order History table\"\n"
                    + "State determines what gets converted to setters or assertions in the test automation.\n"
                    + "Next it's followed by the state description which is optional and can be any word.\n"
                    + "The state types are: is, isn't, will be, won't be.\n"
                    + "Examples are: \"is present\" or \"will be created as follows\""),

    TEST_STEP_STEP_OBJECT_NAME_WORKSPACE("TEST_STEP_STEP_OBJECT_NAME_WORKSPACE",
            "The step object file doesn't exist for the component"),

    TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE("TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE",
            "The step definition doesn't exist for the step object");

    /**
     * Issue identifier following structured naming pattern.
     */
    public final String id;

    /**
     * Human-readable description of the validation issue.
     */
    public final String description;

    /**
     * Initializes issue type with identifier and description.
     *
     * @param value       the issue identifier
     * @param description the issue description
     */
    TestStepIssueTypes(String value, String description) {
        this.id = value;
        this.description = description;
    }

}
