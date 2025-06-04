@sheep-dog-dev @round-trip
Feature: UMLToJBehave

  \@sheep-dog-dev
  \@round-trip

  Background: Create a UML model

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          * Given: The blah application, Object page is empty
          * When: The blah application, Object page is submitted
          * Then: The blah application, Result page is displayed
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is empty
          
          == Step-Definition: is submitted
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Result page.asciidoc file is created as follows
          """
          = Step-Object: Result page
          
          == Step-Definition: is displayed
          """

  Scenario: JBehave story file is generated

     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-jbehave goal is executed with
          | Tags |
          | tag1 |
     Then The code-prj project, src-gen/test/resources/jbehave/specs/Process.story file will be created as follows
          """
          Meta: @tag1

          Narrative:
          In order to test the process
          As a user
          I want to ensure the process works correctly

          Scenario: Submit

            Given The blah application, Object page is empty
             When The blah application, Object page is submitted
             Then The blah application, Result page is displayed
          """

  Scenario: JBehave story file with multiple scenarios is generated

     Given The spec-prj project, src/test/resources/asciidoc/specs/MultiScenario.asciidoc file is created as follows
          """
          = Test-Suite: MultiScenario
          
          == Test-Case: First Scenario
          
          * Given: The blah application, Object page is empty
          * When: The blah application, Object page is submitted
          * Then: The blah application, Result page is displayed
          
          == Test-Case: Second Scenario
          
          * Given: The blah application, Object page is filled
          * When: The blah application, Object page is submitted
          * Then: The blah application, Confirmation page is displayed
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is empty
          
          == Step-Definition: is filled
          
          == Step-Definition: is submitted
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Result page.asciidoc file is created as follows
          """
          = Step-Object: Result page
          
          == Step-Definition: is displayed
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Confirmation page.asciidoc file is created as follows
          """
          = Step-Object: Confirmation page
          
          == Step-Definition: is displayed
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-jbehave goal is executed with
          | Tags |
          | tag2 |
     Then The code-prj project, src-gen/test/resources/jbehave/specs/MultiScenario.story file will be created as follows
          """
          Meta: @tag2

          Narrative:
          In order to test multiple scenarios
          As a user
          I want to ensure all scenarios work correctly

          Scenario: First Scenario

            Given The blah application, Object page is empty
             When The blah application, Object page is submitted
             Then The blah application, Result page is displayed

          Scenario: Second Scenario

            Given The blah application, Object page is filled
             When The blah application, Object page is submitted
             Then The blah application, Confirmation page is displayed
          """
