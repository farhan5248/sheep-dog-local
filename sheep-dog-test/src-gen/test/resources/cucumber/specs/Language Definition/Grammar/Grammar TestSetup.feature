@sheep-dog-test
Feature: Grammar TestSetup

  \@sheep-dog-test
  A TestSetup is a grammar element representing a test setup.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file TestSetup type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file TestSetup type assignments will be as follows
          | Assignment   | Type        | Multiplicity |
          | Name         | Phrase      | required     |
          | Description  | Description | optional     |
          | TestStepList | TestStep    | list         |

