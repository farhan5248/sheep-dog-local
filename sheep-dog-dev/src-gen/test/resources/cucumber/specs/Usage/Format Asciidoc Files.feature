@sheep-dog-dev @round-trip
Feature: Format Asciidoc Files

  \@sheep-dog-dev
  \@round-trip
  TODO Make more changes to the source file to demonstrate all the formatting changes.

  Scenario: Format an asciidoc file

    The table formatting is off, this is intentional to check that the formatting works.

    Given The spec-prj project, src/test/resources/asciidoc/specs/app/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          Desc 1
          
          == Test-Case: Story One
          
          @tag2
          Desc 2
          
          * Given: The blah application, Object page is valid
          
          * Then: The blah application, Object page is created as follows
          +
          ----
            text1
          
            text2
          ----
          
          == Test-Case: Story Two
          
          @tag3
          Desc 3
          
          * Given: The blah application, Object page is invalid
          
          * When: The blah application, Object page is created as follows
          +
          |===
          | grp | ins
          | 8 | {ins}
          |===
          
          * Test-Data: Some data
          +
          |===
          | ins
          | 4
          |===
          
          * Test-Data: Dataset 2
          +
          |===
          | ins
          | 5
          | 6
          |===
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is valid
          
          == Step-Definition: is invalid
          
          == Step-Definition: is created as follows
          
          * Step-Parameters: 1
          +
          |===
          | grp | ins
          |===
          
          * Step-Parameters: 2
          +
          |===
          | Content
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-asciidoctor goal is executed
     Then The spec-prj project, src/test/resources/asciidoc/specs/app/Process.asciidoc file will be created as follows
          """
          = Test-Suite: Process
          
          Desc 1
          
          == Test-Case: Story One
          
          @tag2
          Desc 2
          
          * Given: The blah application, Object page is valid
          
          * Then: The blah application, Object page is created as follows
          +
          ----
            text1
          
            text2
          ----
          
          == Test-Case: Story Two
          
          @tag3
          Desc 3
          
          * Given: The blah application, Object page is invalid
          
          * When: The blah application, Object page is created as follows
          +
          |===
          | grp | ins  
          | 8   | {ins}
          |===
          
          * Test-Data: Some data
          +
          |===
          | ins
          | 4  
          |===
          
          * Test-Data: Dataset 2
          +
          |===
          | ins
          | 5  
          | 6  
          |===
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file will be created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is created as follows
          
          * Step-Parameters: 1
          +
          |===
          | grp | ins
          |===
          
          * Step-Parameters: 2
          +
          |===
          | Content
          |===
          
          == Step-Definition: is invalid
          
          == Step-Definition: is valid
          """

