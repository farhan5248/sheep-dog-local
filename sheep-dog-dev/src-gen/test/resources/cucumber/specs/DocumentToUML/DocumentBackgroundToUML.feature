@sheep-dog-dev
Feature: DocumentBackgroundToUML

  \@sheep-dog-dev

  Scenario: One tag, one statement, one step

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          @tag1
          Desc line 1
          
          * Given: The Object0 page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name      | Annotation Name | Annotation Detail |
          | specs::Process::Setup | tags            | tag1              |
      And The spec-prj project, uml/pst.uml file Interaction Comments section will be created as follows
          | Interaction Name      | Comment            |
          | specs::Process::Setup | @tag1\nDesc line 1 |

  Scenario: Two tags, two statements, two steps

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          @tag1 @tag2
          Desc line 1
          Desc line 2
          
          * Given: The blah application, Object page is empty
          
          * Given: The blah application, Object2 page is empty
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name      | Annotation Name | Annotation Detail |
          | specs::Process::Setup | tags            | tag1              |
          | specs::Process::Setup | tags            | tag2              |
      And The spec-prj project, uml/pst.uml file Interaction Comments section will be created as follows
          | Interaction Name      | Comment                               |
          | specs::Process::Setup | @tag1 @tag2\nDesc line 1\nDesc line 2 |
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name      | Message                                     |
          | specs::Process::Setup | The blah application, Object page is empty  |
          | specs::Process::Setup | The blah application, Object2 page is empty |

  Scenario: Three tags, three statements, three steps

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          @tag1 @tag2 @tag3
          Desc line 1
          Desc line 2
          Desc line 3
          
          * Given: The blah application, Object page is empty
          
          * Given: The blah application, Object2 page is empty
          
          * Given: The blah application, Object3 page is empty
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name      | Annotation Name | Annotation Detail |
          | specs::Process::Setup | tags            | tag1              |
          | specs::Process::Setup | tags            | tag2              |
          | specs::Process::Setup | tags            | tag3              |
      And The spec-prj project, uml/pst.uml file Interaction Comments section will be created as follows
          | Interaction Name      | Comment                                                  |
          | specs::Process::Setup | @tag1 @tag2 @tag3\nDesc line 1\nDesc line 2\nDesc line 3 |
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name      | Message                                     |
          | specs::Process::Setup | The blah application, Object page is empty  |
          | specs::Process::Setup | The blah application, Object2 page is empty |
          | specs::Process::Setup | The blah application, Object3 page is empty |

  Scenario: No tags, no statements, one step

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object0 page is valid
          
          == Test-Case: Submit
          
          * Given: The Object page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name       | Message                   |
          | specs::Process::Setup  | The Object0 page is valid |
          | specs::Process::Submit | The Object page is valid  |

  Scenario: No statement, one step, two scenarios

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object0 page is valid
          
          == Test-Case: Submit 1
          
          * Given: The Object page is valid
          
          == Test-Case: Submit 2
          
          * Given: The Object2 page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name         | Message                   |
          | specs::Process::Setup    | The Object0 page is valid |
          | specs::Process::Submit 1 | The Object page is valid  |
          | specs::Process::Submit 2 | The Object2 page is valid |

  Scenario: No statement, one step, three scenarios

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object0 page is valid
          
          == Test-Case: Submit 1
          
          * Given: The Object page is valid
          
          == Test-Case: Submit 2
          
          * Given: The Object2 page is valid
          
          == Test-Case: Submit 3
          
          * Given: The Object3 page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name         | Message                   |
          | specs::Process::Setup    | The Object0 page is valid |
          | specs::Process::Submit 1 | The Object page is valid  |
          | specs::Process::Submit 2 | The Object2 page is valid |
          | specs::Process::Submit 3 | The Object3 page is valid |

  Scenario: No statement, two steps, one scenario

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object page is valid
          * Given: The Object2 page is valid
          
          == Test-Case: Submit
          
          * Given: The Object page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name       | Message                   |
          | specs::Process::Setup  | The Object page is valid  |
          | specs::Process::Setup  | The Object2 page is valid |
          | specs::Process::Submit | The Object page is valid  |

  Scenario: No statement, three steps, one scenario

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object page is valid
          * Given: The Object2 page is valid
          * Given: The Object3 page is valid
          
          == Test-Case: Submit
          
          * Given: The Object page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name       | Message                   |
          | specs::Process::Setup  | The Object page is valid  |
          | specs::Process::Setup  | The Object2 page is valid |
          | specs::Process::Setup  | The Object3 page is valid |
          | specs::Process::Submit | The Object page is valid  |

  Scenario: Selected tags

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Data Setup
          
          @tag1
          """
      And The spec-prj project, src/test/resources/asciidoc/specs/app/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          [tags="tag2"]
          == Test-Setup: Data Setup
          """
     When The maven plugin, asciidoctor-to-uml goal is executed with
          | Tags |
          | tag1 |
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Class section will be created as follows
          | Class Name     |
          | specs::Process |
      And The spec-prj project, uml/pst.uml file Class section won't be created as follows
          | Class Name          |
          | specs::app::Process |

