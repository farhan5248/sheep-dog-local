@sheep-dog-dev @round-trip
Feature: JBehaveToUML

  \@sheep-dog-dev
  \@round-trip

  Background: Create a story file

    The formatting of the data and example tables is intentionally different to make sure that the file is regenerated

    Given The code-prj project, src-gen/test/resources/jbehave/specs/Process.story file is created as follows
          """
          Meta: @tag2 @tag3

          Narrative:
          In order to test the process
          As a user
          I want to ensure the process works correctly

          Scenario: Submit One

          Basic EDI claim

           When The blah application, something/Object page is empty
           Then The blah application, something/Object page is empty
            And The blah application, something/Object page is empty

          Scenario: Submit Several

            Given The blah application, DataTable page is created as follows
                  |   h1 |   h2 |
                  | v31  | v41  |
          """
     When The maven plugin, jbehave-to-uml goal is executed with
          | Tags |
          | tag2 |
      And The maven plugin, uml-to-jbehave goal is executed with
          | Tags |
          | tag2 |

  Scenario: Story file is preserved

     Then The code-prj project, src-gen/test/resources/jbehave/specs/Process.story file will be created as follows
          """
          Meta: @tag2 @tag3

          Narrative:
          In order to test the process
          As a user
          I want to ensure the process works correctly

          Scenario: Submit One

          Basic EDI claim

           When The blah application, something/Object page is empty
           Then The blah application, something/Object page is empty
            And The blah application, something/Object page is empty

          Scenario: Submit Several

            Given The blah application, DataTable page is created as follows
                  | h1  | h2  |
                  | v31 | v41 |
          """
