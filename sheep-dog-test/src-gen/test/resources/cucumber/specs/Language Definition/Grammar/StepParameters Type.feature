@sheep-dog-test
Feature: StepParameters Type

  \@sheep-dog-test

  Scenario: Initial State

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

  Scenario: Nested Description

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/StepParametersList/1/NestedDescription/LineList node is created as follows
          | Line Content |
          | First Line   |
     When The xtext plugin edit document action is performed to modify LineList with
          | Line Content |
          | Second Line  |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/StepParametersList/1/NestedDescription/LineList/2 node will be created as follows
          | Line Content |
          | Second Line  |

  Scenario: Table

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList node is created as follows
          | Cell Name  |
          | First Cell |
     When The xtext plugin edit document action is performed to modify CellList with
          | Cell Name   |
          | Second Cell |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList/2 node will be created as follows
          | Cell Name   |
          | Second Cell |

