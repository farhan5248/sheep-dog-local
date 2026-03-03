@sheep-dog-test
Feature: Grammar TestData

  \@sheep-dog-test
  A TestData is a grammar element representing test data.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file TestData type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file TestData type assignments will be as follows
          | Assignment        | Type              | Multiplicity |
          | Name              | Phrase            | required     |
          | NestedDescription | NestedDescription | optional     |
          | Table             | Table             | required     |

