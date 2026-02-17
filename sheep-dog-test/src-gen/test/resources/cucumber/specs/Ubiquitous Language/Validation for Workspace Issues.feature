@sheep-dog-test
Feature: Validation for Workspace Issues

  \@sheep-dog-test
  Some problems are fixed by code generation.
  They're typically things like keywords or objects that are not defined in the step objects layer.
  I could just ignore all those warnings and then use the Build Project menu item and it'll create everything at once.
  There's 4 types of warnings, the scenarios below cover them.
  \@sheep-dog-test
  Some problems are fixed by code generation.
  They're typically things like keywords or objects that are not defined in the step objects layer.
  I could just ignore all those warnings and then use the Build Project menu item and it'll create everything at once.
  There's 4 types of warnings, the scenarios below cover them.

  @Validate
  Scenario: This object doesn't exist validation

    \@Validate

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                |
          | The daily batchjob Input file is present |
     When The xtext plugin validate action is performed as follows
          | Selected Element                           |
          | TestSuite/1/TestStepContainer/1/TestStep/1 |
     Then The xtext plugin validate dialog will be set as follows
          """
          The step object file doesn't exist for the component
          """

  @Validate
  Scenario: This object step definition doesn't exist validation

    \@Validate

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                |
          | The daily batchjob Input file is present |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is absent            |
     When The xtext plugin validate action is performed as follows
          | Selected Element                           |
          | TestSuite/1/TestStepContainer/1/TestStep/1 |
     Then The xtext plugin validate dialog will be set as follows
          """
          The step definition doesn't exist for the step object
          """

