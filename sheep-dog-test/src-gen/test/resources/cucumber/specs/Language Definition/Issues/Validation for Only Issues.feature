@sheep-dog-test
Feature: Validation for Only Issues

  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.

  @ValidateAction
  Scenario: Header row Cell names should start with a capital letter validation

    \@ValidateAction
    The first row of a table contains header cells. CellIssueTypes.CELL_NAME_ONLY validates that header cell names start with a capital letter.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node is created as follows
          | Node Path                                                       | Cell Name |
          | TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList | header    |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         | Node Path                                                         |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList/1 |
     Then The xtext plugin validate annotation will be set as follows
          """
          Name should start with a capital
          """

  @ValidateAction
  Scenario: Body row Cell names can be any case validation

    \@ValidateAction
    Body rows (non-header rows) contain data values. The capitalization rule only applies to header row cells.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node is created as follows
          | Node Path                                                       | Cell Name |
          | TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList | Header    |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node is created as follows
          | Node Path                                                       | Cell Name |
          | TestStepContainerList/1/TestStepList/1/Table/RowList/2/CellList | value     |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         | Node Path                                                         |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1/Table/RowList/2/CellList/1 |
     Then The xtext plugin validate annotation will be empty

  @ValidateAction
  Scenario: Test suite name should start with a capital letter validation

    \@ValidateAction
    TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY validates that the test suite name starts with a capital letter.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file is created as follows
          | Test Suite Name   |
          | lowercase process |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         |
          | specs/ProcessIssues.asciidoc |
     Then The xtext plugin validate annotation will be set as follows
          """
          Name should start with a capital
          """

  @ValidateAction
  Scenario: Test case name should start with a capital letter validation

    \@ValidateAction
    TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY validates that the test case name starts with a capital letter.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows
          | Node Path             | Test Case Name      |
          | TestStepContainerList | lowercase test case |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         | Node Path               |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1 |
     Then The xtext plugin validate annotation will be set as follows
          """
          Name should start with a capital
          """

  @ValidateAction
  Scenario: Test step must have a valid object name validation

    \@ValidateAction
    TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY validates that the step object reference has a valid component and object. The validation message describes the expected format.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name |
          | TestStepContainerList/1/TestStepList | The is present      |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         | Node Path                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1 |
     Then The xtext plugin validate annotation will be set as follows
          """
          Every test case must have at least one component specified.
          This should be the first part of the test step name.
          The component is optional.
          Component ending words are: application, service, plugin, batchjob, project.
          Examples are: "The something application," or "The something service,"Every test step must have the object specified.
          The object can have the complete path or not.
          Object ending words are: page, response, file, directory, dialog, popup, annotation, hover, tooltip, request, goal, job, action.
          Examples are: "src/test/resources/file.txt file" or "Home page"
          """

