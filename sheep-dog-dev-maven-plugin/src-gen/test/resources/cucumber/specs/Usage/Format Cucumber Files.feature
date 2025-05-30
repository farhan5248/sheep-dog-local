@sheep-dog-dev @round-trip
Feature: Format Cucumber Files

  \@sheep-dog-dev
  \@round-trip
  TODO Make more changes to the source file to demonstrate all the formatting changes.

  Scenario: Format a feature file

    The table formatting is off, this is intentional to check that the formatting works.

    Given The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file is created as follows
          """
          @tag2 @tag3
          Feature: Process
          
            Background: Setup
          
              Given The blah application, something/Object page is created as follows
                    \"\"\"
                    Text 1
                    
                    Text 2
                    \"\"\"
          
            @tag1
            Scenario: Submit One
          
              Basic EDI claim
          
               When The blah application, something/Object page is empty
               Then The blah application, something/Object page is empty
                And The blah application, something/Object page is empty
          
            Scenario Outline: Submit Several
          
              Given The blah application, DataTable page is created as follows
                    |   h1 |   h2 |
                    | <h3> | <h4> |
          
              Examples: Data Set
          
                    |  h3 |  h4 |
                    | v31 | v41 |
          """
     When The maven plugin, cucumber-to-uml goal is executed with
          | Tags |
          | tag1 |
      And The maven plugin, uml-to-cucumber goal is executed with
          | Tags |
          | tag1 |
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be created as follows
          """
          @tag2 @tag3
          Feature: Process
          
            Background: Setup
          
              Given The blah application, something/Object page is created as follows
                    \"\"\"
                    Text 1
                    
                    Text 2
                    \"\"\"
          
            @tag1
            Scenario: Submit One
          
              Basic EDI claim
          
               When The blah application, something/Object page is empty
               Then The blah application, something/Object page is empty
                And The blah application, something/Object page is empty
          
            Scenario Outline: Submit Several
          
              Given The blah application, DataTable page is created as follows
                    | h1   | h2   |
                    | <h3> | <h4> |
          
              Examples: Data Set
          
                    | h3  | h4  |
                    | v31 | v41 |
          """

