@sheep-dog-test
Feature: TestSuite Type

  \@sheep-dog-test
  Test Suite is a top-level grammar rule in SheepDog.xtext. These tests verify adding a Test Suite document to the workspace.

  @list @AddDocumentAction
  Scenario: Initial State

    \@list \@AddDocumentAction
    Test Suite must have
    - Name
    and optionally have these
    - Description
    - Test Step Container List

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file is created
     When The xtext plugin add document action is performed to create a TestSuite with
          | Test Suite Full Name          |
          | specs/ProcessIssues2.asciidoc |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues2.asciidoc file will be created as follows
          | Test Suite Name |
          | ProcessIssues2  |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be as follows
          | Node Path             | State |
          | TestStepContainerList | Empty |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Description node will be as follows
          | Node Path   | State  |
          | Description | Absent |

