@sheep-dog-test
Feature: Grammar TestStepContainer

  \@sheep-dog-test
  A TestStepContainer is a grammar element that can be either a TestCase or TestSetup.

  Scenario: Concrete Types

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file TestStepContainer type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file TestStepContainer type concrete types will be as follows
          | Type      |
          | TestCase  |
          | TestSetup |

