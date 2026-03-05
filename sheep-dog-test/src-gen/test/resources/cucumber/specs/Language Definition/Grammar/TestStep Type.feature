@sheep-dog-test
Feature: TestStep Type

  \@sheep-dog-test

  Scenario: Initial State Given

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList node is created as follows
          | Given StepObject Name | Given StepDefinition Name |
          | The First action file | is performed              |
     When The xtext plugin edit document action is performed to modify TestStepList with
          | Given StepObject Name  | Given StepDefinition Name |
          | The Second action file | is performed              |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/2 node will be created as follows
          | Given StepObject Name  | Given StepDefinition Name |
          | The Second action file | is performed              |

  Scenario: Initial State When

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList node is created as follows
          | When StepObject Name  | When StepDefinition Name |
          | The First action file | is performed             |
     When The xtext plugin edit document action is performed to modify TestStepList with
          | When StepObject Name   | When StepDefinition Name |
          | The Second action file | is performed             |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/2 node will be created as follows
          | When StepObject Name   | When StepDefinition Name |
          | The Second action file | is performed             |

  Scenario: Initial State Then

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList node is created as follows
          | Then StepObject Name  | Then StepDefinition Name |
          | The First action file | is performed             |
     When The xtext plugin edit document action is performed to modify TestStepList with
          | Then StepObject Name   | Then StepDefinition Name |
          | The Second action file | is performed             |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/2 node will be created as follows
          | Then StepObject Name   | Then StepDefinition Name |
          | The Second action file | is performed             |

  Scenario: Initial State And

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList node is created as follows
          | And StepObject Name   | And StepDefinition Name |
          | The First action file | is performed            |
     When The xtext plugin edit document action is performed to modify TestStepList with
          | And StepObject Name    | And StepDefinition Name |
          | The Second action file | is performed            |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/2 node will be created as follows
          | And StepObject Name    | And StepDefinition Name |
          | The Second action file | is performed            |

  Scenario: Table

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList node is created as follows
          | Cell Name  |
          | First Cell |
     When The xtext plugin edit document action is performed to modify CellList with
          | Cell Name   |
          | Second Cell |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList/2 node will be created as follows
          | Cell Name   |
          | Second Cell |

