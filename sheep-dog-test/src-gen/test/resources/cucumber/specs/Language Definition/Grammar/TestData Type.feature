@sheep-dog-test
Feature: TestData Type

  \@sheep-dog-test
  A TestData is a grammar element representing test data.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestData type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestData type assignments will be as follows
          | Assignment        | Type              | Multiplicity |
          | Name              | Phrase            | required     |
          | NestedDescription | NestedDescription | optional     |
          | Table             | Table             | required     |

