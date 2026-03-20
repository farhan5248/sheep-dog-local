@sheep-dog-test
Feature: Quickfixes for Only Issues

  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.

  @ListQuickfixesAction
  Scenario: Cell name should start with a capital letter quickfix

    \@ListQuickfixesAction
    The quickfix capitalizes the first letter of a header cell name that starts with a lowercase letter.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node is created as follows
          | Node Path                                                       | Cell Name        |
          | TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList | lowercase header |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Step Definition Name | Step Parameters Name |
          | is present           | lowercase header     |
      And The xtext plugin validate annotation is set as follows
          """
          Name should start with a capital
          """
     When The xtext plugin list quickfixes action is performed as follows
          | Test Suite Full Name         | Node Path                                                         |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList/1 |
     Then The xtext plugin list quickfixes popup will be set as follows
          | Proposal Id          | Proposal Description                    | Proposal Value   |
          | Capitalize cell name | Capitalize the first letter of the name | Lowercase header |

  @ListQuickfixesAction
  Scenario: Body row Cell names can be any case quickfix

    \@ListQuickfixesAction
    Body row cells don't trigger a validation error, so no quickfix is available.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node is created as follows
          | Node Path                                                       | Cell Name |
          | TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList | Header    |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node is created as follows
          | Node Path                                                       | Cell Name |
          | TestStepContainerList/1/TestStepList/1/Table/RowList/2/CellList | value     |
      And The xtext plugin validate annotation is empty
     When The xtext plugin list quickfixes action is performed as follows
          | Test Suite Full Name         | Node Path                                                         |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1/Table/RowList/2/CellList/1 |
     Then The xtext plugin list quickfixes popup will be empty

