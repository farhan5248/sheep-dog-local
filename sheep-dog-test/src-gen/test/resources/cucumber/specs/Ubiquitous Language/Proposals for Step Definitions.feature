@sheep-dog-test
Feature: Proposals for Step Definitions

  \@sheep-dog-test
  Because a step can have a component or not and the full path specified or not, you can have 4 keywords like:
  1. The daily batchjob, path/to/file/Input file is empty
  2. The daily batchjob, Input file is empty
  3. The path/to/file/Input file is empty
  4. The Input file is empty
  So instead of saving all combinations, only the details section and predicate are saved.
  When the reference look-up is done, the step-object is located using the full path and component.

  Scenario: Nothing is proposed if there's no step-definition

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                      |
          | The daily batchjob, Input file |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion                        | Suggestion Name | Suggestion Description |
          | The daily batchjob, Input file is | is              | Maps to setter method  |

  Scenario: Something is proposed if there's a step-definition

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                      |
          | The daily batchjob, Input file |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name | Step Definition Description |
          | daily batchjob/Input file.feature | is present           | Creates empty file          |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion                                | Suggestion Name | Suggestion Description |
          | The daily batchjob, Input file is present | is present      | Creates empty file     |

  Scenario: Something is proposed even if the step is complete

    This is a documented bug, if the step is complete, it shouldn't suggest anything
    TODO Fix this bug

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is present           |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion                                | Suggestion Name |
          | The daily batchjob, Input file is present | is present      |

