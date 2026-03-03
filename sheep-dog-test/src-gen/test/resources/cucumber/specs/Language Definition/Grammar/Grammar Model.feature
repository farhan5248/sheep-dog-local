@sheep-dog-test
Feature: Grammar Model

  \@sheep-dog-test
  A Model is the root grammar element, dispatching to either a StepObject or TestSuite file.

  Scenario: Concrete Types

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file Model type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file Model type concrete types will be as follows
          | Type       |
          | StepObject |
          | TestSuite  |

