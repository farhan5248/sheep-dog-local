@sheep-dog-dev
Feature: CodeScenarioOutlineToUML

  \@sheep-dog-dev

  Scenario: No tags, no statement, one step, one example

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          
            Scenario Outline: Submit
              Given The Object page is created as follows
                | h1   |
                | <h3> |
          
              Examples: Examples 1
                | h3  |
                | v31 |
          """
     When The maven plugin, cucumber-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name       | Message                               | Argument Name | Annotation Detail |
          | specs::Process::Submit | The Object page is created as follows | dataTable     | 0 -> h1 \|        |
          | specs::Process::Submit | The Object page is created as follows | dataTable     | 1 -> <h3> \|      |
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name       | Annotation Name | Annotation Detail   |
          | specs::Process::Submit | Examples 1      | Data -> h3\|\nv31\| |

  Scenario: One tag, one statement, one step, one example

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          
            @tag1
            Scenario Outline: Submit
              Desc line 1
              Given The Object page is created as follows
                | h1   |
                | <h3> |
          
              @tag1
              Examples: Examples 1
                Desc line 1
                | h3  |
                | v31 |
          """
     When The maven plugin, cucumber-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name       | Annotation Name | Annotation Detail |
          | specs::Process::Submit | tags            | tag1              |
      And The spec-prj project, uml/pst.uml file Interaction Comments section will be created as follows
          | Interaction Name       | Comment     |
          | specs::Process::Submit | Desc line 1 |

  Scenario Outline: Two tags, two statements, two steps, two examples

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          
            @tag1 @tag2
            Scenario Outline: Submit
              Desc line 1
              Desc line 2
              Given The Object1 page is created as follows
                | h1   |
                | <h3> |
              Given The Object2 page is created as follows
                | h1   |
                | <h3> |
          
              @tag1 @tag2
              Examples: Examples 1
                Desc line 1
                Desc line 2
                | h3  |
                | v31 |
          
              Examples: Examples 2
                | h3  |
                | v32 |
          """
     When The maven plugin, cucumber-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name       | Annotation Name | Annotation Detail |
          | specs::Process::Submit | tags            | tag<Index>        |
      And The spec-prj project, uml/pst.uml file Interaction Comments section will be created as follows
          | Interaction Name       | Comment                  |
          | specs::Process::Submit | Desc line 1\nDesc line 2 |
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name       | Message                                      |
          | specs::Process::Submit | The Object<Index> page is created as follows |
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name       | Annotation Name  | Annotation Detail         |
          | specs::Process::Submit | Examples <Index> | Data -> h3\|\nv3<Index>\| |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |

  Scenario Outline: Three tags, three statements, three steps, three examples

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          
            @tag1 @tag2 @tag3
            Scenario Outline: Submit
              Desc line 1
              Desc line 2
              Desc line 3
              Given The Object1 page is created as follows
                | h1   |
                | <h3> |
              Given The Object2 page is created as follows
                | h1   |
                | <h3> |
              Given The Object3 page is created as follows
                | h1   |
                | <h3> |
          
              Examples: Examples 1
                | h3  |
                | v31 |
          
              Examples: Examples 2
                | h3  |
                | v32 |
          
              Examples: Examples 3
                | h3  |
                | v33 |
          """
     When The maven plugin, cucumber-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name       | Annotation Name | Annotation Detail |
          | specs::Process::Submit | tags            | tag<Index>        |
      And The spec-prj project, uml/pst.uml file Interaction Comments section will be created as follows
          | Interaction Name       | Comment                               |
          | specs::Process::Submit | Desc line 1\nDesc line 2\nDesc line 3 |
      And The spec-prj project, uml/pst.uml file Interaction Messages section will be created as follows
          | Interaction Name       | Message                                      |
          | specs::Process::Submit | The Object<Index> page is created as follows |
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name       | Annotation Name  | Annotation Detail         |
          | specs::Process::Submit | Examples <Index> | Data -> h3\|\nv3<Index>\| |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |
          | 3     |

  Scenario: Selected tags

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          
            @tag1
            Scenario Outline: Submit
              Given The Object1 page is empty
          
              Examples: Examples 1
                | h3  |
                | v31 |
          
            @tag2
            Scenario Outline: Submit2
              Given The Object1 page is empty
          
              Examples: Examples 1
                | h3  |
                | v31 |
          """
     When The maven plugin, cucumber-to-uml goal is executed with
          | Tags |
          | tag1 |
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction section will be created as follows
          | Interaction Name       |
          | specs::Process::Submit |
      And The spec-prj project, uml/pst.uml file Interaction section won't be created as follows
          | Interaction Name        |
          | specs::Process::Submit2 |

