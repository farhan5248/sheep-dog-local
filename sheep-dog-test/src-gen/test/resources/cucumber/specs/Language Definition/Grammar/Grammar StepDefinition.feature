@sheep-dog-test
Feature: Grammar StepDefinition

  \@sheep-dog-test
  A StepDefinition is a grammar element representing a step definition.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file StepDefinition type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file StepDefinition type assignments will be as follows
          | Assignment        | Type           | Multiplicity |
          | Name              | Phrase         | required     |
          | Description       | Description    | optional     |
          | StepParameterList | StepParameters | list         |

