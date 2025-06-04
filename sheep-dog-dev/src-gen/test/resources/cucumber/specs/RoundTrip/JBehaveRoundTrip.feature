@sheep-dog-dev @round-trip
Feature: JBehaveRoundTrip

  \@sheep-dog-dev
  \@round-trip

  Background: Create a story file

    Given The code-prj project, src-gen/test/resources/jbehave/specs/RoundTrip.story file is created as follows
          """
          Meta: @tag1 @tag2

          Narrative:
          In order to test round-trip transformations
          As a developer
          I want to ensure that JBehave stories are preserved during transformations

          Scenario: Basic Scenario

            Given The blah application, Object page is empty
             When The blah application, Object page is submitted
             Then The blah application, Result page is displayed

          Scenario: Scenario with Data Table

            Given The blah application, DataTable page is created as follows
                  |   name |   value |
                  | user1  | pass1   |
                  | user2  | pass2   |
             When The blah application, DataTable page is submitted
             Then The blah application, Result page shows success

          Scenario: Scenario with Multi-line Text

            Given The blah application, TextArea page contains multi-line text
             When The blah application, TextArea page is submitted
             Then The blah application, Result page shows success
          """

  Scenario: Round-trip transformation preserves story file

     When The maven plugin, jbehave-to-uml goal is executed with
          | Tags |
          | tag1 |
      And The maven plugin, uml-to-jbehave goal is executed with
          | Tags |
          | tag1 |
     Then The code-prj project, src-gen/test/resources/jbehave/specs/RoundTrip.story file will contain the expected content

  Scenario: Selective transformation with tags

     When The maven plugin, jbehave-to-uml goal is executed with
          | Tags |
          | tag2 |
      And The maven plugin, uml-to-jbehave goal is executed with
          | Tags |
          | tag2 |
     Then The code-prj project, src-gen/test/resources/jbehave/specs/RoundTrip.story file will contain the expected content
