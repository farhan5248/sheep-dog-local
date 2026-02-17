@sheep-dog-test
Feature: Proposals for Workspace Step Definitions

  \@sheep-dog-test
  Because a step can have a component or not and the full path specified or not, you can have 4 keywords like:
  1. The daily batchjob path/to/file/Input file is empty
  2. The daily batchjob Input file is empty
  3. The path/to/file/Input file is empty
  4. The Input file is empty
  So instead of saving all combinations, only the details section and predicate are saved.
  When the reference look-up is done, the step-object is located using the full path and component.

  @Suggest
  Scenario: Has component no existing step object

    \@Suggest

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                     |
          | The daily batchjob Input file |
     When The xtext plugin list proposals action is performed as follows
          | Selected Element                                       |
          | TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/1 |
     Then The xtext plugin list proposals dialog will be empty

