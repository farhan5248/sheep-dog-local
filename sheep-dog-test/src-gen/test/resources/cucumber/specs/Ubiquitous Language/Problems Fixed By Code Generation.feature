@sheep-dog-test
Feature: Problems Fixed By Code Generation
  
  \@sheep-dog-test
  Some problems are fixed by code generation.
  They're typically things like keywords or objects that are not defined in the step objects layer.
  I could just ignore all those warnings and then use the Build Project menu item and it’ll create everything at once.
  There's 4 types of warnings, the scenarios below cover them.

  Scenario: This object doesn't exist validation
    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
      | Step Name                                 |
      | The daily batchjob, Input file is present |
    When The xtext plugin, validate warning action is performed
    Then The xtext plugin, validate warning dialog will be set as follows
      | Message                                              |
      | The step object file doesn't exist for the component |

  Scenario: This object step definition doesn't exist validation
    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
      | Step Name                                 |
      | The daily batchjob, Input file is present |
    And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
      | Object Name                       | Step Definition Name |
      | daily batchjob/Input file.feature | is absent            |
    When The xtext plugin, validate warning action is performed
    Then The xtext plugin, validate warning dialog will be set as follows
      | Message                                               |
      | The step definition doesn't exist for the step object |

  Scenario: This object step definition parameter set doesn't exist validation
    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
      | Step Name                                 | Headers    |
      | The daily batchjob, Input file is present | New Header |
    And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
      | Object Name                       | Step Definition Name | Parameters |
      | daily batchjob/Input file.feature | is present           | Old Header |
    When The xtext plugin, validate warning action is performed
    Then The xtext plugin, validate warning dialog will be set as follows
      | Message                                                 |
      | The step parameters don't exist for the step definition |

  Scenario: This object doesn't exist and there is an alternate
    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
      | Step Name                                 |
      | The daily batchjob, Input file is present |
    And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/app/Input file.asciidoc file is created as follows
      | Object Name                           | Step Definition Name |
      | daily batchjob/app/Input file.feature | is present           |
    When The xtext plugin, validate warning action is performed
    Then The xtext plugin, validate warning dialog will be set as follows
      | Message                                              |
      | The step object file doesn't exist for the component |
    And The xtext plugin, quickfix dialog will be set as follows
      | Message                                       |
      | The daily batchjob, app/Input file is present |
