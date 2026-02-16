@sheep-dog-test
Feature: Code Generation for Only Issues

  \@sheep-dog-test
  These tests verify that code generation works correctly when names follow proper capitalization rules.

  @Generate
  Scenario: Cell name should start with a capital letter generation

    \@Generate

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                | Row Contents     |
          | The daily batchjob Input file is present | lowercase header |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name | Parameters       |
          | daily batchjob/Input file.feature | is present           | lowercase header |
      And The xtext plugin list quickfixes dialog is set as follows
          | Quickfix Name        | Quickfix Description                    | Quickfix         |
          | Capitalize cell name | Capitalize the first letter of the name | Lowercase header |
     When The xtext plugin apply quickfix action is performed as follows
          | Selected Element                                              |
          | TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/1/Cell/1 |
     Then The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file will be created as follows
          | Step Name                                | Row Contents     |
          | The daily batchjob Input file is present | Lowercase header |

