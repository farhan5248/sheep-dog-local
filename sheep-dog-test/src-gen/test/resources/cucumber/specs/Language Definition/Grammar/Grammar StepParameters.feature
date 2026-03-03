@sheep-dog-test
Feature: Grammar StepParameters

  \@sheep-dog-test
  A StepParameters is a grammar element representing step parameters.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file StepParameters type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file StepParameters type assignments will be as follows
          | Assignment        | Type              | Multiplicity |
          | Name              | Phrase            | required     |
          | NestedDescription | NestedDescription | optional     |
          | Table             | Table             | required     |

