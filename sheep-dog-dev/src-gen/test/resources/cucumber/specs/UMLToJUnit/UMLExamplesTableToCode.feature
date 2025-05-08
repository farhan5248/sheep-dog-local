@sheep-dog-dev
Feature: UMLExamplesTableToCode

  \@sheep-dog-dev

  Scenario: One row, one cell

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          * Given: The Object page is created as follows
          +
          |===
          | h1
          | {h1}
          |===
          
          * Test-Data: Examples 1
          +
          |===
          | h1
          | v1
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples   | Row      |
          | Submit | Examples 1 | \| h1 \| |
          | Submit | Examples 1 | \| v1 \| |

  Scenario: Two rows, two cells

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          * Given: The Object page is created as follows
          +
          |===
          | h1 | h2
          | {h1} | {h2}
          |===
          
          * Test-Data: Examples 1
          +
          |===
          | h1 | h2
          | v1 | v2
          | v3 | v4
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples   | Row            |
          | Submit | Examples 1 | \| h1 \| h2 \| |
          | Submit | Examples 1 | \| v1 \| v2 \| |
          | Submit | Examples 1 | \| v3 \| v4 \| |

  Scenario: Three rows, three cells

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          * Given: The Object page is created as follows
          +
          |===
          | h1 | h2 | h3
          | {h1} | {h2} | {h3}
          |===
          
          * Test-Data: Examples 1
          +
          |===
          | h1 | h2 | h3
          | v1 | v2 | v3
          | v4 | v5 | v6
          | v7 | v8 | v9
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows
          | Name   | Examples   | Row                  |
          | Submit | Examples 1 | \| h1 \| h2 \| h3 \| |
          | Submit | Examples 1 | \| v1 \| v2 \| v3 \| |
          | Submit | Examples 1 | \| v4 \| v5 \| v6 \| |
          | Submit | Examples 1 | \| v7 \| v8 \| v9 \| |

