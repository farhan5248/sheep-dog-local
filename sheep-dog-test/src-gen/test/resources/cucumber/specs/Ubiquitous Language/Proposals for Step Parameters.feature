@sheep-dog-test
Feature: Proposals for Step Parameters

  \@sheep-dog-test
  TODO Add text string tests.
  If the step definition has step parameters, they'll be proposed.

  Scenario: No proposal for absent object

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                            |
          | The daily batchjob, Input file is created as follows |
     When The xtext plugin, propose test step table action is performed
     Then The xtext plugin, propose content dialog will be empty

  Scenario: No proposal for absent step definition

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                            |
          | The daily batchjob, Input file is created as follows |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is present           |
     When The xtext plugin, propose test step table action is performed
     Then The xtext plugin, propose content dialog will be empty

  Scenario: List parameters for a step definition if it exists

    TODO I should add more parameter combinations to describe this better.

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                            |
          | The daily batchjob, Input file is created as follows |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name  | Parameters |
          | daily batchjob/Input file.feature | is created as follows | H1         |
     When The xtext plugin, propose test step table action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion | Suggestion Name |
          | \| H1      | \| H1           |

