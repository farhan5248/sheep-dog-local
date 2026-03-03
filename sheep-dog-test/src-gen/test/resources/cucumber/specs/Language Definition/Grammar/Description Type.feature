@sheep-dog-test
Feature: Description Type

  \@sheep-dog-test
  A Description is a grammar element representing a description block.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Description type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Description type assignments will be as follows
          | Assignment | Type | Multiplicity |
          | LineList   | Line | list         |

