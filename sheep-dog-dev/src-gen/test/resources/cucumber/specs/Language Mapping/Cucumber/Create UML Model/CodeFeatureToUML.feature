@sheep-dog-dev
Feature: CodeFeatureToUML

  \@sheep-dog-dev

  Scenario: No tags, no statements

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          Feature: Process
          """
     When The maven plugin, cucumber-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Class section will be created as follows
          | Class Name     |
          | specs::Process |

  Scenario: One tag, one statement

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          @tag1
          Feature: Process
            Desc line 1
          """
     When The maven plugin, cucumber-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Class Comments section will be created as follows
          | Class Name     | Comment     |
          | specs::Process | Desc line 1 |
      And The spec-prj project, uml/pst.uml file Class Annotations section will be created as follows
          | Class Name     | Annotation Name | Annotation Detail |
          | specs::Process | tags            | tag1              |

  Scenario: Two tags, two statements

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          @tag1 @tag2
          Feature: Process
            Desc line 1
            Desc line 2
          """
     When The maven plugin, cucumber-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Class Comments section will be created as follows
          | Class Name     | Comment                  |
          | specs::Process | Desc line 1\nDesc line 2 |
      And The spec-prj project, uml/pst.uml file Class Annotations section will be created as follows
          | Class Name     | Annotation Name | Annotation Detail |
          | specs::Process | tags            | tag1              |
          | specs::Process | tags            | tag2              |

  Scenario: Three tags, three statements

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          @tag1 @tag2 @tag3
          Feature: This is a test feature
            Desc line 1
            Desc line 2
            Desc line 3
          """
     When The maven plugin, cucumber-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Class Comments section will be created as follows
          | Class Name     | Comment                               |
          | specs::Process | Desc line 1\nDesc line 2\nDesc line 3 |
      And The spec-prj project, uml/pst.uml file Class Annotations section will be created as follows
          | Class Name     | Annotation Name | Annotation Detail |
          | specs::Process | tags            | tag1              |
          | specs::Process | tags            | tag2              |
          | specs::Process | tags            | tag3              |

  Scenario: Selected tags

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          @tag1
          Feature: Process
          """
      And The code-prj project, src-gen/test/resources/cucumber/specs/app/Process.feature file is created as follows
          """
          @tag2
          Feature: Process
          """
     When The maven plugin, cucumber-to-uml goal is executed with
          | Tags |
          | tag1 |
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Class section will be created as follows
          | Class Name     |
          | specs::Process |
      And The spec-prj project, uml/pst.uml file Class section won't be created as follows
          | Class Name          |
          | specs::app::Process |

