@sheep-dog-test
Feature: Grammar Table

  \@sheep-dog-test
  A Table is a grammar element representing a data table.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file Table type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file Table type assignments will be as follows
          | Assignment | Type | Multiplicity |
          | RowList    | Row  | list         |

