@sheep-dog-dev @round-trip
Feature: Select Documentation By Tags

  \@sheep-dog-dev
  \@round-trip
  The goal is to specify that if you have two test cases with different tags, you can generate two different models.
  Each model will contain the test cases that are tagged with the same tag.
  So the resulting feature file will contain the selected test case only.
  Multiple tags are also supported. Take this file itself, it has more than one tag.
  One is for the sheep-dog-dev component but the round-trip one is for other components.

  Scenario: Create two models from different tags

    TODO Combine both asciidoc files into one asciidoc file. Keep the two different tags.
    The test was good enough to code what I wanted but I can see how if I break the code, the test will still pass

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          @tag1
          
          * Given: The Object1 page is empty
          """
    Given The spec-prj project, src/test/resources/asciidoc/specs/app/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit2
          
          @tag2
          
          * Given: The Object1 page is empty
          """
     When The maven plugin, asciidoctor-to-uml goal is executed with
          | Tags |
          | tag1 |
      And The maven plugin, asciidoctor-to-uml goal is executed with
          | Tags |
          | tag2 |
      And The maven plugin, uml-to-cucumber goal is executed with
          | Tags |
          | tag1 |
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be created as follows
          """
          Feature: Process
          
            @tag1
            Scenario: Submit
          
              \@tag1
          
              Given The Unknown service, Object1 page is empty
          """

