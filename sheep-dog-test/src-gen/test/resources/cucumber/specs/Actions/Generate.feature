@sheep-dog-test
Feature: Generate

  \@sheep-dog-test

  Scenario: The object doesn't exist

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
     When The xtext plugin, generate step definition action is performed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is present           |

  Scenario: The object step definition doesn't exist

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

  Scenario: The object step definition parameter set doesn't exist

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 | Headers    |
          | The daily batchjob, Input file is present | New Header |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name | Parameters |
          | daily batchjob/Input file.feature | is present           | Old Header |
     When The xtext plugin, generate step definition action is performed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows
          | Object Name                       | Step Definition Name | Parameters |
          | daily batchjob/Input file.feature | is present           | New Header |

