@sheep-dog-test
Feature: Proposals for Workspace Step Definitions

  \@sheep-dog-test
  Because a step can have a component or not and the full path specified or not, you can have 4 keywords like:
  1. The daily batchjob path/to/file/Input file is empty
  2. The daily batchjob Input file is empty
  3. The path/to/file/Input file is empty
  4. The Input file is empty
  So instead of saving all combinations, only the details section and predicate are saved.
  If the reference look-up is done, the step-object is located using the full path and component.

  @ListProposalsAction
  Scenario: Has component no existing step object

    \@ListProposalsAction
    If the step object file doesn't exist in the workspace, no step definition proposals are available.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name           |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file |
     When The xtext plugin list proposals action is performed as follows
          | Test Suite Full Name         | Node Path                                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1/Table/RowList/1 |
     Then The xtext plugin list proposals popup will be empty

