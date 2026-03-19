@sheep-dog-test
Feature: TestCase Type

  \@sheep-dog-test
  Test Case is a grammar rule in SheepDog.xtext contained within a Test Suite. These tests verify editing Test Case elements within a document.

  @list @EditDocumentAction
  Scenario: Test Case

    \@list \@EditDocumentAction
    Test Case must have
    - Name
    and optionally have these
    - Description
    - Test Step List
    - Test Data List

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows
          | Node Path             | Test Case Name  |
          | TestStepContainerList | First Test Case |
     When The xtext plugin edit document action is performed to modify TestStepContainerList with
          | Test Suite Full Name         | Node Path             | Test Case Name   |
          | specs/ProcessIssues.asciidoc | TestStepContainerList | Second Test Case |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be created as follows
          | Node Path               | Test Case Name   |
          | TestStepContainerList/2 | Second Test Case |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be as follows
          | Node Path                            | State |
          | TestStepContainerList/1/TestStepList | Empty |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be as follows
          | Node Path                            | State |
          | TestStepContainerList/1/TestDataList | Empty |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Description node will be as follows
          | Node Path                           | State  |
          | TestStepContainerList/1/Description | Absent |

