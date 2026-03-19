@sheep-dog-test
Feature: TestSetup Type

  \@sheep-dog-test
  Test Setup is a grammar rule in SheepDog.xtext contained within a Test Suite. These tests verify editing Test Setup elements within a document.

  @list @EditDocumentAction
  Scenario: Test Setup

    \@list \@EditDocumentAction
    Test Setup must have
    - Name
    and optionally have these
    - Description
    - Test Step List

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows
          | Node Path             | Test Setup Name  |
          | TestStepContainerList | First Test Setup |
     When The xtext plugin edit document action is performed to modify TestStepContainerList with
          | Test Suite Full Name         | Node Path             | Test Setup Name   |
          | specs/ProcessIssues.asciidoc | TestStepContainerList | Second Test Setup |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be created as follows
          | Node Path               | Test Setup Name   |
          | TestStepContainerList/1 | First Test Setup  |
          | TestStepContainerList/2 | Second Test Setup |

  @EditDocumentAction
  Scenario: Duplicate Test Setup Name

    \@EditDocumentAction
    Test Setup name must be unique within a Test Suite. Creating a Test Setup with an existing name returns the existing one.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows
          | Node Path             | Test Setup Name |
          | TestStepContainerList | Background      |
     When The xtext plugin edit document action is performed to modify TestStepContainerList with
          | Test Suite Full Name         | Node Path             | Test Setup Name |
          | specs/ProcessIssues.asciidoc | TestStepContainerList | Background      |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be as follows
          | Node Path               | State  |
          | TestStepContainerList/2 | Absent |

