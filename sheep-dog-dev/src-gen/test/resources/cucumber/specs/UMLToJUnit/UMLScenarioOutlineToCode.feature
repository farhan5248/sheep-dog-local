@sheep-dog-dev
Feature: UMLScenarioOutlineToCode

  \@sheep-dog-dev

  Scenario: No tags, no statement, one step, one example

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          * Given: The blah application, Object page is created as follows
          +
          |===
          | h1
          | {h3}
          |===
          
          * Test-Data: Examples 1
          +
          |===
          | h3
          | v31
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Steps Data Table section will be created as follows
          | Name   | Step                                                          |
          | Submit | Given The blah application, Object page is created as follows |
          | Submit | Given The blah application, Object page is created as follows |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples   | Row       |
          | Submit | Examples 1 | \| h3 \|  |
          | Submit | Examples 1 | \| v31 \| |

  Scenario: One tag, one statement, one step, one example

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1
          Desc line 1
          
          * Given: The blah application, Object page is created as follows
          +
          |===
          | h1
          | {h3}
          |===
          
          * Test-Data: Examples 1
          +
          |===
          | h3
          | v31
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outlines section will be created as follows
          | Name   | Tags | Description         |
          | Submit | tag1 | \@tag1\nDesc line 1 |

  Scenario Outline: Two tags, two statements, two steps, two examples

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1 @tag2
          Desc line 1
          Desc line 2
          
          * Given: The blah application, Object1 page is created as follows
          +
          |===
          | h1
          | {h3}
          |===
          
          * Given: The blah application, Object2 page is created as follows
          +
          |===
          | h1
          | {h3}
          |===
          
          * Test-Data: Examples 1
          +
          |===
          | h3
          | v31
          |===
          
          * Test-Data: Examples 2
          +
          |===
          | h3
          | v32
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outlines section will be created as follows
          | Name   | Tags      | Description                             |
          | Submit | tag1,tag2 | \@tag1 \@tag2\nDesc line 1\nDesc line 2 |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Steps Data Table section will be created as follows
          | Name   | Step                                                                 |
          | Submit | Given The blah application, Object<Index> page is created as follows |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples         | Row             |
          | Submit | Examples <Index> | \| h3 \|        |
          | Submit | Examples <Index> | \| v3<Index> \| |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |

  Scenario Outline: Three tags, three statements, three steps, three examples

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1 @tag2 @tag3
          Desc line 1
          Desc line 2
          Desc line 3
          
          * Given: The blah application, Object1 page is created as follows
          +
          |===
          | h1
          | {h3}
          |===
          
          * Given: The blah application, Object2 page is created as follows
          +
          |===
          | h1
          | {h3}
          |===
          
          * Given: The blah application, Object3 page is created as follows
          +
          |===
          | h1
          | {h3}
          |===
          
          * Test-Data: Examples 1
          +
          |===
          | h3
          | v31
          |===
          
          * Test-Data: Examples 2
          +
          |===
          | h3
          | v32
          |===
          
          * Test-Data: Examples 3
          +
          |===
          | h3
          | v33
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outlines section will be created as follows
          | Name   | Tags           | Description                                                 |
          | Submit | tag1,tag2,tag3 | \@tag1 \@tag2 \@tag3\nDesc line 1\nDesc line 2\nDesc line 3 |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Steps Data Table section will be created as follows
          | Name   | Step                                                                 |
          | Submit | Given The blah application, Object<Index> page is created as follows |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples         | Row             |
          | Submit | Examples <Index> | \| h3 \|        |
          | Submit | Examples <Index> | \| v3<Index> \| |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |
          | 3     |

