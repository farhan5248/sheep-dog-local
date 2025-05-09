@sheep-dog-dev
Feature: UMLScenarioToCode

  \@sheep-dog-dev

  Scenario: No tags, no statements, one step

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          * Given: The blah application, Object1 page is empty
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows
          | Name   | Step                                              |
          | Submit | Given The blah application, Object1 page is empty |

  Scenario: One tag, one statement, one step

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1
          Desc line 1
          
          * Given: The blah application, Object1 page is empty
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios section will be created as follows
          | Name   | Tags | Description         |
          | Submit | tag1 | \@tag1\nDesc line 1 |

  Scenario Outline: Two tags, two statements, two steps

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1 @tag2
          Desc line 1
          Desc line 2
          
          * Given: The blah application, Object1 page is empty
          
          * Given: The blah application, Object2 page is empty
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios section will be created as follows
          | Name   | Tags      | Description                             |
          | Submit | tag1,tag2 | \@tag1 \@tag2\nDesc line 1\nDesc line 2 |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows
          | Name   | Step                                                    |
          | Submit | Given The blah application, Object<Index> page is empty |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |

  Scenario Outline: Three tags, three statements, three steps

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1 @tag2 @tag3
          Desc line 1
          Desc line 2
          Desc line 3
          
          * Given: The blah application, Object1 page is empty
          
          * Given: The blah application, Object2 page is empty
          
          * Given: The blah application, Object3 page is empty
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios section will be created as follows
          | Name   | Tags           | Description                                                 |
          | Submit | tag1,tag2,tag3 | \@tag1 \@tag2 \@tag3\nDesc line 1\nDesc line 2\nDesc line 3 |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows
          | Name   | Step                                                    |
          | Submit | Given The blah application, Object<Index> page is empty |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |
          | 3     |

