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

