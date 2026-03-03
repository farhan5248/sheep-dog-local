@sheep-dog-test
Feature: Line Type

  \@sheep-dog-test
  A Line is a grammar element representing a line of text in a description block.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Line type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Line type assignments will be as follows
          | Assignment | Type   | Multiplicity |
          | Content    | Phrase | required     |

