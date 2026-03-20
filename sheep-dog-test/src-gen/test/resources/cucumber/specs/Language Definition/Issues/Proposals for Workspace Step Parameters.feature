@sheep-dog-test
Feature: Proposals for Workspace Step Parameters

  \@sheep-dog-test
  If the step definition has step parameters, they'll be proposed.

  @ListProposalsAction
  Scenario: No existing step object

    \@ListProposalsAction
    If the step object file doesn't exist in the workspace, no parameter proposals are available.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                                 |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is created as follows |
     When The xtext plugin list proposals action is performed as follows
          | Test Suite Full Name         | Node Path                                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1/Table/RowList/1 |
     Then The xtext plugin list proposals popup will be empty

