@sheep-dog-test
Feature: Quickfixes for Only Issues

  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.
  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.

  @Correct
  Scenario: Cell name should start with a capital letter quickfix

    \@Correct

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                | Row Contents     |
          | The daily batchjob Input file is present | lowercase header |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name | Parameters       |
          | daily batchjob/Input file.feature | is present           | lowercase header |
      And The xtext plugin validate dialog is set as follows
          """
          Name should start with a capital
          """
     When The xtext plugin list quickfixes action is performed as follows
          | Selected Element                                              |
          | TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/1/Cell/1 |
     Then The xtext plugin list quickfixes dialog will be set as follows
          | Quickfix Name        | Quickfix Description                    | Quickfix         |
          | Capitalize cell name | Capitalize the first letter of the name | Lowercase header |

  @Correct
  Scenario: Body row Cell names can be any case quickfix

    \@Correct

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                | Row Contents |
          | The daily batchjob Input file is present | Header       |
          | The daily batchjob Input file is present | value        |
      And The xtext plugin validate dialog is empty
     When The xtext plugin list quickfixes action is performed as follows
          | Selected Element                                              |
          | TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/2/Cell/1 |
     Then The xtext plugin list quickfixes dialog will be empty

