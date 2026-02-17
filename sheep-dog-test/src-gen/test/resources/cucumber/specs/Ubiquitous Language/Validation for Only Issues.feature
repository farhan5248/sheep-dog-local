@sheep-dog-test
Feature: Validation for Only Issues

  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.

  @Validate
  Scenario: Test suite name should start with a capital letter validation

    \@Validate

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file is created as follows
          | Test Suite Name   |
          | lowercase process |
     When The xtext plugin validate action is performed as follows
          | Selected Element |
          | TestSuite/1      |
     Then The xtext plugin validate dialog will be set as follows
          """
          Name should start with a capital
          """

