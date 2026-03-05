@sheep-dog-test
Feature: Description Type

  \@sheep-dog-test

  Scenario: Initial State

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/Description/LineList node is created as follows
          | Line Content |
          | First Line   |
     When The xtext plugin edit document action is performed to modify LineList with
          | Line Content |
          | Second Line  |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/Description/LineList/2 node will be created as follows
          | Line Content |
          | Second Line  |

