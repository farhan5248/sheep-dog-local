@sheep-dog-dev
Feature: CodeScenarioToUML

  \@sheep-dog-dev

  Scenario: No tags, no statements, one step

    Given The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          
            Scenario: Submit
              Given The blah application something/Object1 page is empty
          """
     When The maven plugin cucumber-to-uml goal is executed
     Then The spec-prj project uml/pst.uml file will be present
      And The spec-prj project uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name       | Message                                               |
          | specs::Process::Submit | The blah application something/Object1 page is empty |

  Scenario Outline: Three tags, three statements, three steps

    Given The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          
            @tag1 @tag2 @tag3
            Scenario: Submit
              Desc line 1
              Desc line 2
              Desc line 3
          
              Given The blah application something/Object1 page is empty
              Given The blah application something/Object2 page is empty
              Given The blah application something/Object3 page is empty
          """
     When The maven plugin cucumber-to-uml goal is executed
     Then The spec-prj project uml/pst.uml file will be present
      And The spec-prj project uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name       | Annotation Name | Annotation Detail |
          | specs::Process::Submit | tags            | tag<Index>        |
      And The spec-prj project uml/pst.uml file Interaction Comments section will be created as follows
          | Interaction Name       | Comment                               |
          | specs::Process::Submit | Desc line 1\nDesc line 2\nDesc line 3 |
      And The spec-prj project uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name       | Message                                                     |
          | specs::Process::Submit | The blah application something/Object<Index> page is empty |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |
          | 3     |

  Scenario: Selected tags

    Given The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          
            @tag1
            Scenario: Submit
          
              Given The Object1 page is empty
          
            @tag2
            Scenario: Submit2
          
              Given The Object1 page is empty
          """
     When The maven plugin cucumber-to-uml goal is executed with
          | Tags |
          | tag1 |
     Then The spec-prj project uml/pst.uml file will be present
      And The spec-prj project uml/pst.uml file Interaction section will be created as follows
          | Interaction Name       |
          | specs::Process::Submit |
      And The spec-prj project uml/pst.uml file Interaction section won't be created as follows
          | Interaction Name        |
          | specs::Process::Submit2 |

