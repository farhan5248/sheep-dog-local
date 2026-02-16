@sheep-dog-test
Feature: Quickfixes for Workspace Issues

  \@sheep-dog-test
  Some problems are fixed by code generation.
  They're typically things like keywords or objects that are not defined in the step objects layer.
  I could just ignore all those warnings and then use the Build Project menu item and it'll create everything at once.
  There's 4 types of warnings, the scenarios below cover them.
  \@sheep-dog-test
  Some problems are fixed by code generation.
  They're typically things like keywords or objects that are not defined in the step objects layer.
  I could just ignore all those warnings and then use the Build Project menu item and it'll create everything at once.
  There's 4 types of warnings, the scenarios below cover them.
  \@sheep-dog-test
  Some problems are fixed by code generation.
  They're typically things like keywords or objects that are not defined in the step objects layer.
  I could just ignore all those warnings and then use the Build Project menu item and it'll create everything at once.
  There's 4 types of warnings, the scenarios below cover them.

  @Correct
  Scenario: This object doesn't exist quickfix

    \@Correct

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                |
          | The daily batchjob Input file is present |
      And The xtext plugin validate dialog is set as follows
          """
          The step object file doesn't exist for the component
          """
     When The xtext plugin list quickfixes action is performed as follows
          | Selected Element                           |
          | TestSuite/1/TestStepContainer/1/TestStep/1 |
     Then The xtext plugin list quickfixes dialog will be set as follows
          | Quickfix Name                                           | Quickfix Description |
          | Generate Input file - daily batchjob/Input file.feature | empty                |

  @Correct
  Scenario: This object step definition doesn't exist quickfix

    \@Correct

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                |
          | The daily batchjob Input file is present |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is absent            |
      And The xtext plugin validate dialog is set as follows
          """
          The step definition doesn't exist for the step object
          """
     When The xtext plugin list quickfixes action is performed as follows
          | Selected Element                           |
          | TestSuite/1/TestStepContainer/1/TestStep/1 |
     Then The xtext plugin list quickfixes dialog will be set as follows
          | Quickfix Name | Quickfix Description | Quickfix  |
          | is absent     | empty                | is absent |
      And The xtext plugin list quickfixes dialog will be set as follows
          | Quickfix Name       | Quickfix Description |
          | Generate is present | empty                |

  @Correct
  Scenario: This object step definition parameter set doesn't exist quickfix

    \@Correct

    Given The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                       | Row Contents |
          | The daily batchjob Input file is set as follows | N1, N2       |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name | Parameters |
          | daily batchjob/Input file.feature | is set as follows    | E1, E2, E3 |
      And The xtext plugin validate dialog is set as follows
          """
          The step parameters don't exist for the step definition
          """
     When The xtext plugin list quickfixes action is performed as follows
          | Selected Element                                       |
          | TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/1 |
     Then The xtext plugin list quickfixes dialog will be set as follows
          | Quickfix Name | Quickfix Description | Quickfix   |
          | E1, E2, E3    | empty                | E1, E2, E3 |
      And The xtext plugin list quickfixes dialog will be set as follows
          | Quickfix Name   | Quickfix Description |
          | Generate N1, N2 | empty                |

