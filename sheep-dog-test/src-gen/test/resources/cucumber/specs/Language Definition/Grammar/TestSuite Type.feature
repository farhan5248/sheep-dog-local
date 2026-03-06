@sheep-dog-test
Feature: TestSuite Type

  \@sheep-dog-test

  Scenario: Initial State

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDocumentList node is created as follows
          | Node Path                    | Test Suite Full Name   |
          | TestProject/TestDocumentList | specs/First Test Suite |
     When The xtext plugin edit document node action is performed to modify TestDocumentList with
          | Node Path                    | Test Suite Full Name    |
          | TestProject/TestDocumentList | specs/Second Test Suite |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDocumentList node will be created as follows
          | Node Path                      | Test Suite Full Name    | Test Suite Name   |
          | TestProject/TestDocumentList/2 | specs/Second Test Suite | Second Test Suite |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be as follows
          | Node Path                                            | State |
          | TestProject/TestDocumentList/1/TestStepContainerList | Empty |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Description node will be as follows
          | Node Path                                  | State  |
          | TestProject/TestDocumentList/1/Description | Absent |

  Scenario: Test Case

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows
          | Node Path                                            | Test Case Name  |
          | TestProject/TestDocumentList/1/TestStepContainerList | First Test Case |
     When The xtext plugin edit document node action is performed to modify TestStepContainerList with
          | Node Path                                            | Test Case Name   |
          | TestProject/TestDocumentList/1/TestStepContainerList | Second Test Case |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be created as follows
          | Node Path                                              | Test Case Name   |
          | TestProject/TestDocumentList/1/TestStepContainerList/2 | Second Test Case |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be as follows
          | Node Path                                                           | State |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList | Empty |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be as follows
          | Node Path                                                           | State |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/TestDataList | Empty |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Description node will be as follows
          | Node Path                                                          | State  |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/Description | Absent |

  Scenario: Test Setup

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows
          | Node Path                                            | Test Setup Name  |
          | TestProject/TestDocumentList/1/TestStepContainerList | First Test Setup |
     When The xtext plugin edit document node action is performed to modify TestStepContainerList with
          | Node Path                                            | Test Setup Name   |
          | TestProject/TestDocumentList/1/TestStepContainerList | Second Test Setup |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be created as follows
          | Node Path                                              | Test Setup Name   |
          | TestProject/TestDocumentList/1/TestStepContainerList/2 | Second Test Setup |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be as follows
          | Node Path                                                           | State |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList | Empty |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Description node will be as follows
          | Node Path                                                          | State  |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/Description | Absent |

  Scenario: Test Data

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node is created as follows
          | Node Path                                                           | Test Data Name  |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/TestDataList | First Test Data |
     When The xtext plugin edit document node action is performed to modify TestDataList with
          | Node Path                                                           | Test Data Name   |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/TestDataList | Second Test Data |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be created as follows
          | Node Path                                                             | Test Data Name   |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/TestDataList/2 | Second Test Data |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file NestedDescription node will be as follows
          | Node Path                                                                               | State  |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/TestDataList/1/NestedDescription | Absent |
      And The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Table node will be as follows
          | Node Path                                                                   | State  |
          | TestProject/TestDocumentList/1/TestStepContainerList/1/TestDataList/1/Table | Absent |

