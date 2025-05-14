@sheep-dog-dev
Feature: DocumentStepParametersTableToUML

  \@sheep-dog-dev

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

  Scenario: One cell

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
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name                                               | Annotation Name | Annotation Detail |
          | stepdefs::blah application::Object page::is created as follows | 1               | 0 -> h1\|         |

  Scenario: Two cells

      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is created as follows
          
          Desc line 1
          
          * Step-Parameters: 1
          +
          |===
          | h1 | h2
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name                                               | Annotation Name | Annotation Detail |
          | stepdefs::blah application::Object page::is created as follows | 1               | 0 -> h1\|h2\|     |

  Scenario: Three cells

      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is created as follows
          
          Desc line 1
          
          * Step-Parameters: 1
          +
          |===
          | h1 | h2 | h3
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
     Then The spec-prj project, uml/pst.uml file will be present
      And The spec-prj project, uml/pst.uml file Interaction Annotations section will be created as follows
          | Interaction Name                                               | Annotation Name | Annotation Detail |
          | stepdefs::blah application::Object page::is created as follows | 1               | 0 -> h1\|h2\|h3\| |

