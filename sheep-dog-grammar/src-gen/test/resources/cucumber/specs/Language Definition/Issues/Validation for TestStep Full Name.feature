@sheep-dog-grammar
Feature: Validation for TestStep Full Name

  \@sheep-dog-grammar
  getTestStepFullName resolves shortened StepObjectRef Names by looking at previous steps to fill in missing component and object path.

  Scenario Outline: With Path Resolution

    StepObjectRef Name has 3 parts: component, object path, and object name. The algorithm searches previous steps for a matching object name to borrow missing component or path. It stops at the first match with a component.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Given StepObjectRef Name | Given StepDefinitionRef Name |
          | TestStepContainerList/1/TestStepList | <Line 1 StepObjectRef>   | is performed                 |
          | TestStepContainerList/1/TestStepList | <Line 2 StepObjectRef>   | is performed                 |
          | TestStepContainerList/1/TestStepList | <Line 3 StepObjectRef>   | is performed                 |
          | TestStepContainerList/1/TestStepList | <Line 4 StepObjectRef>   | is performed                 |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/app/Input file.asciidoc file is created as follows
          | Step Definition Name |
          | is performed         |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         | Node Path                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/4 |
     Then The xtext plugin validate annotation will be empty

    Examples: Full

          | Line 1 StepObjectRef              | Line 2 StepObjectRef              | Line 3 StepObjectRef              | Line 4 StepObjectRef              |
          | The daily batchjob app/Input file | The daily batchjob app/Input file | The daily batchjob app/Input file | The daily batchjob app/Input file |

    Examples: Name only

          | Line 1 StepObjectRef              | Line 2 StepObjectRef              | Line 3 StepObjectRef | Line 4 StepObjectRef |
          | The daily batchjob app/Input file | The daily batchjob app/Input file | The app/Input file   | The Input file       |
          | The daily batchjob app/Input file | The app2/Input file               | The app/Input file   | The Input file       |

    Examples: Path and Name

          | Line 1 StepObjectRef                | Line 2 StepObjectRef              | Line 3 StepObjectRef | Line 4 StepObjectRef |
          | The daily batchjob app/Input file   | The daily batchjob app/Input file | The app/Input file   | The app/Input file   |
          | The nightly batchjob app/Input file | The daily batchjob app/Input file | The app/Input file   | The app/Input file   |

  Scenario Outline: Without Path Resolution

    StepObjectRef Name has 3 parts: component, object path, and object name. The algorithm searches previous steps for a matching object name to borrow missing component or path. It stops at the first match with a component.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Given StepObjectRef Name | Given StepDefinitionRef Name |
          | TestStepContainerList/1/TestStepList | <Line 1 StepObjectRef>   | is performed                 |
          | TestStepContainerList/1/TestStepList | <Line 2 StepObjectRef>   | is performed                 |
          | TestStepContainerList/1/TestStepList | <Line 3 StepObjectRef>   | is performed                 |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Step Definition Name |
          | is performed         |
     When The xtext plugin validate action is performed as follows
          | Test Suite Full Name         | Node Path                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/3 |
     Then The xtext plugin validate annotation will be empty

    Examples: Component and Name

          | Line 1 StepObjectRef              | Line 2 StepObjectRef | Line 3 StepObjectRef          |
          | The daily batchjob app/Input file | The app/Input file   | The daily batchjob Input file |

