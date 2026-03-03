@sheep-dog-test
Feature: NestedDescription Type

  \@sheep-dog-test
  A NestedDescription is a grammar element representing a nested description block attached to a step.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file NestedDescription type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file NestedDescription type assignments will be as follows
          | Assignment | Type | Multiplicity |
          | LineList   | Line | list         |

