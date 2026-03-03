@sheep-dog-test
Feature: Grammar Cell

  \@sheep-dog-test
  A Cell is a grammar element representing a table cell.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file Cell type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file Cell type assignments will be as follows
          | Assignment | Type   | Multiplicity |
          | Name       | Phrase | required     |

