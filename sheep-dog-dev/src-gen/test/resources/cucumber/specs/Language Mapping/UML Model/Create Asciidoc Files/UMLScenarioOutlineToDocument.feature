@sheep-dog-dev
Feature: UMLScenarioOutlineToDocument

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
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps section will be created as follows
          | Name   | Step                                                           |
          | Submit | Given: The blah application, Object page is created as follows |
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples   | Row |
          | Submit | Examples 1 | h3  |
          | Submit | Examples 1 | v31 |

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
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios section will be created as follows
          | Name   | Tags | Description        |
          | Submit | tag1 | @tag1\nDesc line 1 |

  Scenario: Two tags, two statements, two steps, two examples

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1 @tag2
          Desc line 1
          Desc line 2
          
          * Given: The blah application, Object page is created as follows
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
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios section will be created as follows
          | Name   | Tags      | Description                           |
          | Submit | tag1,tag2 | @tag1 @tag2\nDesc line 1\nDesc line 2 |
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps section will be created as follows
          | Name   | Step                                                            |
          | Submit | Given: The blah application, Object page is created as follows  |
          | Submit | Given: The blah application, Object2 page is created as follows |
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples   | Row |
          | Submit | Examples 1 | h3  |
          | Submit | Examples 1 | v31 |
          | Submit | Examples 2 | h3  |
          | Submit | Examples 2 | v32 |

  Scenario: Three tags, three statements, three steps, three examples

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1 @tag2 @tag3
          Desc line 1
          Desc line 2
          Desc line 3
          
          * Given: The blah application, Object page is created as follows
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
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios section will be created as follows
          | Name   | Tags           | Description                                              |
          | Submit | tag1,tag2,tag3 | @tag1 @tag2 @tag3\nDesc line 1\nDesc line 2\nDesc line 3 |
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps section will be created as follows
          | Name   | Step                                                            |
          | Submit | Given: The blah application, Object page is created as follows  |
          | Submit | Given: The blah application, Object2 page is created as follows |
          | Submit | Given: The blah application, Object3 page is created as follows |
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples   | Row |
          | Submit | Examples 1 | h3  |
          | Submit | Examples 1 | v31 |
          | Submit | Examples 2 | h3  |
          | Submit | Examples 2 | v32 |
          | Submit | Examples 3 | h3  |
          | Submit | Examples 3 | v33 |

