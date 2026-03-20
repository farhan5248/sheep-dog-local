@sheep-dog-test
Feature: Quickfixes for Workspace Issues

  \@sheep-dog-test
  Some problems are fixed by code generation.
  They're typically things like keywords or objects that are not defined in the step objects layer.
  I could just ignore all those warnings and then use the Build Project menu item and it'll create everything at once.
  There's 4 types of warnings, the scenarios below cover them.

  @ListQuickfixesAction
  Scenario: This object doesn't exist quickfix

    \@ListQuickfixesAction
    The quickfix proposes generating the step object file at the expected path for the component.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
      And The xtext plugin validate annotation is set as follows
          """
          The step object file doesn't exist for the component
          """
     When The xtext plugin list quickfixes action is performed as follows
          | Test Suite Full Name         | Node Path                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1 |
     Then The xtext plugin list quickfixes popup will be set as follows
          | Proposal Id                                                       | Proposal Description |
          | Generate Input file - stepdefs/daily batchjob/Input file.asciidoc | empty                |

  @ListQuickfixesAction
  Scenario: This object step definition doesn't exist quickfix

    \@ListQuickfixesAction
    The quickfix proposes two options: switching to an existing step definition, or generating the missing step definition in the step object file.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Step Definition Name |
          | is absent            |
      And The xtext plugin validate annotation is set as follows
          """
          The step definition doesn't exist for the step object
          """
     When The xtext plugin list quickfixes action is performed as follows
          | Test Suite Full Name         | Node Path                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1 |
     Then The xtext plugin list quickfixes popup will be set as follows
          | Proposal Id | Proposal Description | Proposal Value |
          | is absent   | empty                | is absent      |
      And The xtext plugin list quickfixes popup will be set as follows
          | Proposal Id         | Proposal Description |
          | Generate is present | empty                |

