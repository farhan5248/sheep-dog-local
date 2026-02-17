@sheep-dog-test
Feature: Proposals for Workspace Step Objects

  \@sheep-dog-test
  TODO Collapse all these tests into fewer ones using Test Data
  The general idea behind these tests is that when no object is specified in the test step, you get a list of proposals.
  The variables are:
  1. Component: There's no suggestions if there's no component.
  2. Component Object: If there's a component, propose objects that it has.
  3. Previous Object in Test Case: If there's a previous object with the fully qualified name, then only the name is suggested
  4. Test Setup: The test setup section is checked if it has a component or object specified.

  @Suggest
  Scenario: No component no existing

    \@Suggest
    TODO make this an outline with various steps like "The" or "The batchjob" etc

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name |
          | empty     |
     When The xtext plugin list proposals action is performed as follows
          | Selected Element                           |
          | TestSuite/1/TestStepContainer/1/TestStep/1 |
     Then The xtext plugin list proposals dialog will be empty

