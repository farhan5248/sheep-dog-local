@sheep-dog-test
Feature: Validation for File Issues

  \@sheep-dog-test
  Some problems prevent code generation.
  For example not knowing which component an object belongs to gets in the way of knowing where to create the file.

  @Validate
  Scenario: The first step needs to have a component specified validation

    \@Validate

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name | Step Definition Description |
          | daily batchjob/Input file.feature | is present           | Creates empty file          |
      And The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                |
          | The daily batchjob Input file is present |
          | The Input file is downloaded             |
     When The xtext plugin validate action is performed as follows
          | Selected Element                |
          | TestSuite/1/TestStepContainer/1 |
     Then The xtext plugin validate dialog will be empty

