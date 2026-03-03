@sheep-dog-test
Feature: Grammar StepObject

  \@sheep-dog-test
  A StepObject is a top-level grammar element representing a step object file.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file StepObject type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file StepObject type assignments will be as follows
          | Assignment         | Type           | Multiplicity |
          | Name               | Phrase         | required     |
          | Description        | Description    | optional     |
          | StepDefinitionList | StepDefinition | list         |

  Scenario Outline: Derived Attributes

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file StepObject type is created as follows
          | Full Name   |
          | <Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file StepObject type derived attributes will be as follows
          | Name   |
          | <Name> |

    Examples: File name

          | Full Name                             | Name        |
          | blah application/Object page.asciidoc | Object page |

