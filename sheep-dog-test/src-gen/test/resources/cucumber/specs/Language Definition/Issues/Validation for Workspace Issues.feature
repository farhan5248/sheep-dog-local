@sheep-dog-test
Feature: Validation for Workspace Issues

  \@sheep-dog-test
  Some problems are fixed by code generation.
  They're typically things like keywords or objects that are not defined in the step objects layer.
  I could just ignore all those warnings and then use the Build Project menu item and it'll create everything at once.
  There's 4 types of warnings, the scenarios below cover them.

  @ValidateAction
  Scenario: This object doesn't exist validation

    \@ValidateAction
    TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE validates that the step object file exists in the workspace for the specified component.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         | Node Path                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1 |
     Then The xtext plugin validate annotation will be set as follows
          """
          The step object file doesn't exist for the component
          """

  @ValidateAction
  Scenario: This object step definition doesn't exist validation

    \@ValidateAction
    TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE validates that the step definition exists in the step object file. The step object file exists but doesn't have a matching step definition.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Step Definition Name |
          | is absent            |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         | Node Path                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1 |
     Then The xtext plugin validate annotation will be set as follows
          """
          The step definition doesn't exist for the step object
          """

