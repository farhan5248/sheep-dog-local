@sheep-dog-test
Feature: TestSuite Type

  \@sheep-dog-test
  A TestSuite is a top-level grammar element representing a test suite file.

  Scenario: Assignments

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSuite type is as follows
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSuite type assignments will be as follows
          | Assignment            | Type              | Multiplicity |
          | Name                  | Phrase            | required     |
          | Description           | Description       | optional     |
          | TestStepContainerList | TestStepContainer | list         |

  Scenario Outline: Derived Attributes

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSuite type is created as follows
          | Full Name   |
          | <Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSuite type derived attributes will be as follows
          | Name   |
          | <Name> |

    Examples: File name

          | Full Name                          | Name              |
          | Grammar/Grammar TestSuite.asciidoc | Grammar TestSuite |

