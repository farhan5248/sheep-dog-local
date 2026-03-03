@sheep-dog-test
Feature: Row Type

  \@sheep-dog-test
  A Row is a grammar element representing a table row.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Row type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Row type assignments will be as follows
          | Assignment | Type | Multiplicity |
          | CellList   | Cell | list         |

