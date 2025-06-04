@sheep-dog-dev @round-trip
Feature: JBehaveSyntaxElements

  \@sheep-dog-dev
  \@round-trip

  Background: Create story files with various JBehave syntax elements

    Given The code-prj project, src-gen/test/resources/jbehave/specs/GivenStories.story file is created as follows
          """
          Meta: @given-stories

          GivenStories: jbehave/specs/Prerequisites.story

          Scenario: Scenario with GivenStories

            Given The test application, Setup page is completed
             When The test application, Main page is accessed
             Then The test application, Main page shows welcome message
          """
      And The code-prj project, src-gen/test/resources/jbehave/specs/Prerequisites.story file is created as follows
          """
          Meta: @prerequisites

          Scenario: Prerequisites

            Given The test application, Database is initialized
             When The test application, Configuration is loaded
             Then The test application, Setup page is ready
          """
      And The code-prj project, src-gen/test/resources/jbehave/specs/ExamplesTable.story file is created as follows
          """
          Meta: @examples-table

          Scenario: Scenario with Examples Table

            Given The test application, Login page is displayed
             When The test application, Login page username field is set to <username>
              And The test application, Login page password field is set to <password>
              And The test application, Login page submit button is clicked
             Then The test application, Result page shows <message>

          Examples:
          | username | password | message  |
          | admin    | admin123 | Welcome  |
          | user     | pass123  | Welcome  |
          | invalid  | wrong    | Error    |
          """
      And The code-prj project, src-gen/test/resources/jbehave/specs/MetaTags.story file is created as follows
          """
          Meta: @level1 @priority-high @smoke-test

          Scenario: Scenario with Meta Tags

            Meta: @level2 @ui-test

            Given The test application, Feature page is accessed
             When The test application, Feature page option is selected
             Then The test application, Feature page shows confirmation
          """

  Scenario: JBehave GivenStories are properly transformed

     When The maven plugin, jbehave-to-uml goal is executed with
          | Tags |
          | given-stories |
      And The maven plugin, uml-to-jbehave goal is executed with
          | Tags |
          | given-stories |
     Then The code-prj project, src-gen/test/resources/jbehave/specs/GivenStories.story file will contain the expected content

  Scenario: JBehave Examples Tables are properly transformed

     When The maven plugin, jbehave-to-uml goal is executed with
          | Tags |
          | examples-table |
      And The maven plugin, uml-to-jbehave goal is executed with
          | Tags |
          | examples-table |
     Then The code-prj project, src-gen/test/resources/jbehave/specs/ExamplesTable.story file will contain the expected content

  Scenario: JBehave Meta Tags are properly transformed

     When The maven plugin, jbehave-to-uml goal is executed with
          | Tags |
          | level1 |
      And The maven plugin, uml-to-jbehave goal is executed with
          | Tags |
          | level1 |
     Then The code-prj project, src-gen/test/resources/jbehave/specs/MetaTags.story file will contain the expected content
