@sheep-dog-test
Feature: Validation for Only Issues

  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.
  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.
  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.
  \@sheep-dog-test
  These validations check for syntax and naming issues that can be detected by parsing the file alone, without needing to check the workspace.

  @Validate
  Scenario: Header row Cell names should start with a capital letter validation

    \@Validate

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                | Row Contents |
          | The daily batchjob Input file is present | header       |
     When The xtext plugin validate action is performed as follows
          | Selected Element                                              |
          | TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/1/Cell/1 |
     Then The xtext plugin validate dialog will be set as follows
          """
          Name should start with a capital
          """

  @Validate
  Scenario: Body row Cell names can be any case validation

    \@Validate

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                | Row Contents |
          | The daily batchjob Input file is present | Header       |
          | The daily batchjob Input file is present | value        |
     When The xtext plugin validate action is performed as follows
          | Selected Element                                              |
          | TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/2/Cell/1 |
     Then The xtext plugin validate dialog will be empty

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

  @Validate
  Scenario: Test case name should start with a capital letter validation

    \@Validate

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file is created as follows
          | Test Suite Name | Test Case Name      |
          | Process2        | lowercase test case |
     When The xtext plugin validate action is performed as follows
          | Selected Element                |
          | TestSuite/1/TestStepContainer/1 |
     Then The xtext plugin validate dialog will be set as follows
          """
          Name should start with a capital
          """

