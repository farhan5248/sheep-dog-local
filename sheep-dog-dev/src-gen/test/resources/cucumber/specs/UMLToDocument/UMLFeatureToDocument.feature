@sheep-dog-dev
Feature: UMLFeatureToDocument

  \@sheep-dog-dev

  Scenario: No tags, no statements

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Feature section will be created as follows
          | Name    |
          | Process |

  Scenario: One statement

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          Desc line 1
          
          == Test-Case: Story One
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Feature section will be created as follows
          | Name    | Statements  |
          | Process | Desc line 1 |

  Scenario: Two statements

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          Desc line 1
          Desc line 2
          
          == Test-Case: Story One
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Feature section will be created as follows
          | Name    | Statements               |
          | Process | Desc line 1\nDesc line 2 |

  Scenario: Three tags, three statements

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          Desc line 1
          Desc line 2
          Desc line 3
          
          == Test-Case: Story One
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file Feature section will be created as follows
          | Name    | Statements                            |
          | Process | Desc line 1\nDesc line 2\nDesc line 3 |

