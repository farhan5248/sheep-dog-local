@sheep-dog-dev
Feature: UMLStepDefinitionToDocument

  \@sheep-dog-dev
  TODO there's no test for no parameters and docstring vs datatable. Other tests implicitly cover docstring as a special parameter with the name content

  Background: Create a test case

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          * Given: The blah application, Object page is created as follows
          +
          |===
          | h1
          |===
          """

  Scenario: No statement, one step parameter

      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is created as follows
          
          * Step-Parameters: 1
          +
          |===
          | h1
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Step Definition Parameters Table section will be created as follows
          | Name                  | Parameters | Row |
          | is created as follows | 1          | h1  |

  Scenario: One statement, one step parameter

      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is created as follows
          
          Desc line 1
          
          * Step-Parameters: 1
          +
          |===
          | h1
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Step Definition section will be created as follows
          | Name                  | Description |
          | is created as follows | Desc line 1 |

  Scenario Outline: Two statements, two step parameters

      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is created as follows
          
          Desc line 1
          Desc line 2
          
          * Step-Parameters: 1
          +
          |===
          | h1
          |===
          
          * Step-Parameters: 2
          +
          |===
          | h2
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Step Definition section will be created as follows
          | Name                  | Description              |
          | is created as follows | Desc line 1\nDesc line 2 |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Step Definition Parameters Table section will be created as follows
          | Name                  | Parameters | Row      |
          | is created as follows | <Index>    | h<Index> |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |

  Scenario Outline: Three statements, three step parameters

      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is created as follows
          
          Desc line 1
          Desc line 2
          Desc line 3
          
          * Step-Parameters: 1
          +
          |===
          | h1
          |===
          
          * Step-Parameters: 2
          +
          |===
          | h2
          |===
          
          * Step-Parameters: 3
          +
          |===
          | h3
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is deleted
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file will be present
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Step Definition section will be created as follows
          | Name                  | Description                           |
          | is created as follows | Desc line 1\nDesc line 2\nDesc line 3 |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Step Definition Parameters Table section will be created as follows
          | Name                  | Parameters | Row      |
          | is created as follows | <Index>    | h<Index> |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |
          | 3     |

