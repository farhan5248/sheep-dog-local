@sheep-dog-test
Feature: Proposals for Workspace Step Parameters

  \@sheep-dog-test
  If the step definition has step parameters, they'll be proposed.

  @Suggest
  Scenario: No existing step object

    \@Suggest

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                           |
          | The daily batchjob Input file is created as follows |
     When The xtext plugin list proposals action is performed as follows
          | Selected Element                                       |
          | TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/1 |
     Then The xtext plugin list proposals dialog will be empty

