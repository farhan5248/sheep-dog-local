@sheep-dog-test
Feature: StepObject Type

  \@sheep-dog-test

  Scenario: Initial State

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList node is created as follows
          | Step Object Full Name      |
          | stepdefs/First Step Object |
     When The xtext plugin edit document action is performed to modify TestDocumentList with
          | Step Object Full Name       |
          | stepdefs/Second Step Object |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2 node will be created as follows
          | Step Object Full Name       | Step Object Name   |
          | stepdefs/Second Step Object | Second Step Object |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList node will be empty
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/Description/LineList node will be empty

  Scenario: Step Definition

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList node is created as follows
          | Step Definition Name  |
          | First Step Definition |
     When The xtext plugin edit document action is performed to modify StepDefinitionList with
          | Step Definition Name   |
          | Second Step Definition |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/2 node will be created as follows
          | Step Definition Name   |
          | Second Step Definition |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/StepParametersList node will be empty
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/Description/LineList node will be empty

  Scenario: Step Parameters

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/StepParametersList node is created as follows
          | Step Parameters Name  |
          | First Step Parameters |
     When The xtext plugin edit document action is performed to modify StepParametersList with
          | Step Parameters Name   |
          | Second Step Parameters |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/StepParametersList/2 node will be created as follows
          | Step Parameters Name   |
          | Second Step Parameters |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/StepParametersList/1/NestedDescription/LineList node will be empty

