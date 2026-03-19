@sheep-dog-test
Feature: StepDefinition Type

  \@sheep-dog-test
  Step Definition is a grammar rule in SheepDog.xtext contained within a Step Object. These tests verify editing Step Definition elements within a document.

  @list @EditDocumentAction
  Scenario: Step Definition

    \@list \@EditDocumentAction
    Step Definition must have
    - Name
    and optionally have these
    - Description
    - Step Parameters List

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows
          | Node Path          | Step Definition Name  |
          | StepDefinitionList | First Step Definition |
     When The xtext plugin edit document action is performed to modify StepDefinitionList with
          | Step Object Full Name                       | Node Path          | Step Definition Name   |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList | Second Step Definition |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows
          | Node Path            | Step Definition Name   |
          | StepDefinitionList/2 | Second Step Definition |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be as follows
          | Node Path                               | State |
          | StepDefinitionList/1/StepParametersList | Empty |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Description node will be as follows
          | Node Path                        | State  |
          | StepDefinitionList/1/Description | Absent |

