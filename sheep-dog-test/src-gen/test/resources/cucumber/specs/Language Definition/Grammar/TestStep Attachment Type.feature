@sheep-dog-test
Feature: TestStep Attachment Type

  \@sheep-dog-test
  Test Step attachments (Text and Table) are mutually exclusive within a Test Step. These tests verify attachment constraints, duplicate behavior, and insertion order.

  @EditDocumentAction
  Scenario: Table Excludes Text

    \@EditDocumentAction
    Table and Text are mutually exclusive on a Test Step. A Test Step with a Table cannot also have Text.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Table node is created as follows
          | Node Path                                    |
          | TestStepContainerList/1/TestStepList/1/Table |
     When The xtext plugin edit document action is performed to add Text at
          | Test Suite Full Name         | Node Path                                   |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1/Text |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Text node will be as follows
          | Node Path                                   | State  |
          | TestStepContainerList/1/TestStepList/1/Text | Absent |

