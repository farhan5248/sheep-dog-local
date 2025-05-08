@sheep-dog-test
Feature: ProposePredicate

  \@sheep-dog-test

  Scenario: No predicate no definition

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                      |
          | The daily batchjob, Input file |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion                        | Suggestion Name | Suggestion Description |
          | The daily batchjob, Input file is | is              | Maps to setter method  |

  Scenario: No predicate has definition has description

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

  Scenario: Has predicate no definition

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion                                           | Suggestion Name |
          | The daily batchjob, Input file is present as follows | as follows      |

  Scenario: Has predicate has definition

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

