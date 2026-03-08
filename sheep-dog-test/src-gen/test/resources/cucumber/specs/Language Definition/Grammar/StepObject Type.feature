@sheep-dog-test
Feature: StepObject Type

  \@sheep-dog-test
  Step Object is a top-level grammar rule in SheepDog.xtext. A Step Object contains Step Definitions which contain Step Parameters.

  @list
  Scenario: Initial State

    \@list
    Step Object must have
    - Name
    and optionally have these
    - Description
    - Step Definition List

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created
     When The xtext plugin add document action is performed to create a StepObject with
          | Step Object Full Name                        |
          | stepdefs/daily batchjob/Input2 file.asciidoc |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input2 file.asciidoc file will be created as follows
          | Step Object Name |
          | Input2 file      |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be as follows
          | Node Path          | State |
          | StepDefinitionList | Empty |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Description node will be as follows
          | Node Path   | State  |
          | Description | Absent |

  @list
  Scenario: Step Definition

    \@list
    Step Definition must have
    - Name
    and optionally have these
    - Description
    - Step Parameters List

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows
          | Node Path          | Step Definition Name  |
          | StepDefinitionList | First Step Definition |
     When The xtext plugin edit document node action is performed to modify StepDefinitionList with
          | Step Object Full Name                       | Node Path          | Step Definition Name   |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList | Second Step Definition |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows
          | Node Path            | Step Definition Name   |
          | StepDefinitionList/2 | Second Step Definition |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be as follows
          | Node Path                               | State |
          | StepDefinitionList/1/StepParametersList | Empty |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Description node will be as follows
          | Node Path                        | State  |
          | StepDefinitionList/1/Description | Absent |

  @list
  Scenario: Step Parameters

    \@list
    Step Parameters must have
    - Name
    and optionally have these
    - Description
    - Table

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node is created as follows
          | Node Path                               | Step Parameters Name  |
          | StepDefinitionList/1/StepParametersList | First Step Parameters |
     When The xtext plugin edit document node action is performed to modify StepParametersList with
          | Step Object Full Name                       | Node Path                               | Step Parameters Name   |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList/1/StepParametersList | Second Step Parameters |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be created as follows
          | Node Path                                 | Step Parameters Name   |
          | StepDefinitionList/1/StepParametersList/2 | Second Step Parameters |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file NestedDescription node will be as follows
          | Node Path                                             | State  |
          | StepDefinitionList/1/StepParametersList/2/Description | Absent |
      And The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Table node will be as follows
          | Node Path                                       | State  |
          | StepDefinitionList/1/StepParametersList/2/Table | Absent |

  Scenario: Duplicate Step Object Full Name

    Step Object full name must be unique within a Test Project. Creating a Step Object with an existing full name returns the existing one.

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows
          | Node Path          | Step Definition Name  |
          | StepDefinitionList | First Step Definition |
     When The xtext plugin add document action is performed to create a StepObject with
          | Step Object Full Name                       |
          | stepdefs/daily batchjob/Input file.asciidoc |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows
          | Node Path            | Step Definition Name  |
          | StepDefinitionList/1 | First Step Definition |

  Scenario: Duplicate Step Definition Name

    Step Definition name must be unique within a Step Object. Creating a Step Definition with an existing name returns the existing one.

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows
          | Node Path          | Step Definition Name  |
          | StepDefinitionList | First Step Definition |
     When The xtext plugin edit document node action is performed to modify StepDefinitionList with
          | Step Object Full Name                       | Node Path          | Step Definition Name  |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList | First Step Definition |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be as follows
          | Node Path            | State  |
          | StepDefinitionList/2 | Absent |

  Scenario: Duplicate Step Parameters Name

    Step Parameters name must be unique within a Step Definition. Creating Step Parameters with an existing name returns the existing one.

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node is created as follows
          | Node Path                               | Step Parameters Name  |
          | StepDefinitionList/1/StepParametersList | First Step Parameters |
     When The xtext plugin edit document node action is performed to modify StepParametersList with
          | Step Object Full Name                       | Node Path                               | Step Parameters Name  |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList/1/StepParametersList | First Step Parameters |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be as follows
          | Node Path                                 | State  |
          | StepDefinitionList/1/StepParametersList/2 | Absent |

  Scenario: Sorted Step Definition Name

    Step Definitions are sorted alphabetically by name within a Step Object.

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows
          | Node Path          | Step Definition Name   |
          | StepDefinitionList | Second Step Definition |
     When The xtext plugin edit document node action is performed to modify StepDefinitionList with
          | Step Object Full Name                       | Node Path          | Step Definition Name  |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList | First Step Definition |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows
          | Node Path            | Step Definition Name   |
          | StepDefinitionList/1 | First Step Definition  |
          | StepDefinitionList/2 | Second Step Definition |

  Scenario: Sorted Step Parameters Name

    Step Parameters are sorted alphabetically by name within a Step Definition.

    Given The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node is created as follows
          | Node Path                               | Step Parameters Name   |
          | StepDefinitionList/1/StepParametersList | Second Step Parameters |
     When The xtext plugin edit document node action is performed to modify StepParametersList with
          | Step Object Full Name                       | Node Path                               | Step Parameters Name  |
          | stepdefs/daily batchjob/Input file.asciidoc | StepDefinitionList/1/StepParametersList | First Step Parameters |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be created as follows
          | Node Path                                 | Step Parameters Name   |
          | StepDefinitionList/1/StepParametersList/1 | First Step Parameters  |
          | StepDefinitionList/1/StepParametersList/2 | Second Step Parameters |

