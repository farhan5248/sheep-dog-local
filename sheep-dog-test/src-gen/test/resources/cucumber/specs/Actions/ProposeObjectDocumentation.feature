@sheep-dog-test
Feature: ProposeObjectDocumentation

  \@sheep-dog-test

  Scenario: Documentation for component

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name |
          | empty     |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Object Description |
          | daily batchjob/Input file.feature | Description        |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion          | Suggestion Name | Suggestion Description |
          | The daily batchjob, | daily batchjob  | daily batchjob         |

  Scenario: Documentation for component object

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name           |
          | The daily batchjob, |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Object Description |
          | daily batchjob/Input file.feature | Description\n      |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion                     | Suggestion Name | Suggestion Description |
          | The daily batchjob, Input file | Input file      | Description\n          |

  Scenario: Documentation for previous object which doesn't exist

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
          | empty                                     |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion     | Suggestion Name | Suggestion Description                                 |
          | The Input file | Input file      | Referred in: The daily batchjob, Input file is present |

  Scenario: Documentation for previous object which exists and has no doc

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
          | empty                                     |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Object Description |
          | daily batchjob/Input file.feature | empty              |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion     | Suggestion Name | Suggestion Description                                 |
          | The Input file | Input file      | Referred in: The daily batchjob, Input file is present |

  Scenario: Documentation for previous object which exists and has doc

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
          | empty                                     |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Object Description |
          | daily batchjob/Input file.feature | Description        |
     When The xtext plugin, propose test step action is performed
     Then The xtext plugin, propose content dialog will be set as follows
          | Suggestion     | Suggestion Name | Suggestion Description                                 |
          | The Input file | Input file      | Referred in: The daily batchjob, Input file is present |

