@sheep-dog-test
Feature: Create Documentation

  \@sheep-dog-test
  These four tests describe the Eclipse IDE features that can be customised.
  1. Error validation
  2. Content proposal
  3. Quick fixes
  4. Code generation

  Scenario: Start a step without the component specified

    Start with single step and trigger an error by not specifying a component.

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                 |
          | The Input file is present |
     When The xtext plugin, validate error action is performed as follows
          | Selected Step |
          | 1             |
     Then The xtext plugin, validate error dialog will be set as follows
          | Message                              |
          | The first step must have a component |

  Scenario: Select from list of existing objects in the component

    Now that there's a component, select from a list of its existing objects.

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name           |
          | The daily batchjob, |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is present           |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion                     | Suggestion Name |
          | The daily batchjob, Input file | Input file      |

  Scenario: Confirm that this is a new step definition

    Create a new step instead of picking from what exists and ignore the warning.

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is absent            |
     When The xtext plugin, validate warning action is performed
     Then The xtext plugin, validate warning dialog will be set as follows
          | Message                                                       |
          | is present doesn't exist in daily batchjob/Input file.feature |

  Scenario: Create the new step definition

    Use the suggested quick fix to add this new step to the step object file.

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is absent            |
     When The xtext plugin, generate step definition action is performed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is present           |

