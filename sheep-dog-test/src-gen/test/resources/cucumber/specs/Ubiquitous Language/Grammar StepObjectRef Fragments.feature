@sheep-dog-test
Feature: Grammar StepObjectRef Fragments

  \@sheep-dog-test
  A StepObjectRef identifies the component and object in a test step.

  Scenario Outline: Component Fragment

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file test step type is created as follows
          | Test Step Full Name   |
          | <Test Step Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file step object ref component fragment will be decomposed as follows
          | Component   | Component Name   | Component Type   |
          | <Component> | <Component Name> | <Component Type> |

    Examples: Component and object

          | Test Step Full Name                                                   | Component                | Component Name | Component Type |
          | The graph-viewer application uml-to-cucumber request is executed with | graph-viewer application | graph-viewer   | application    |
          | The graph-viewer application uml-to-cucumber request                  | graph-viewer application | graph-viewer   | application    |
          | The uml-to-cucumber request is empty                                  | empty                    | empty          | empty          |

  Scenario Outline: Object Fragment

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file test step type is created as follows
          | Test Step Full Name   |
          | <Test Step Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file step object ref object fragment will be decomposed as follows
          | Object   | Object Name   | Object Type   |
          | <Object> | <Object Name> | <Object Type> |

    Examples: Fragments

          | Test Step Full Name                                                              | Object                  | Object Name     | Object Type |
          | The graph-viewer application uml-to-cucumber request StepObjectRef type is empty | uml-to-cucumber request | uml-to-cucumber | request     |
          | The graph-viewer application uml-to-cucumber request is executed with            | uml-to-cucumber request | uml-to-cucumber | request     |
          | The graph-viewer application uml-to-cucumber request                             | uml-to-cucumber request | uml-to-cucumber | request     |

  Scenario Outline: Object Vertex Fragment

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file test step type is created as follows
          | Test Step Full Name   |
          | <Test Step Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file step object ref object vertex fragment will be decomposed as follows
          | Object Type   | Object Type Description   |
          | <Object Type> | <Object Type Description> |

    Examples: Fragments

          | Test Step Full Name                            | Object Type | Object Type Description                          |
          | The xtext plugin input file is empty           | file        | Any sort of file                                 |
          | The xtext plugin output directory is empty     | directory   | File directory                                   |
          | The xtext plugin home page is empty            | page        | Web page                                         |
          | The xtext plugin settings dialog is empty      | dialog      | Window dialog box                                |
          | The xtext plugin validate response is empty    | response    | Web service response                             |
          | The xtext plugin list proposals popup is empty | popup       | List of options for quickfix or content proposal |
          | The xtext plugin validate annotation is empty  | annotation  | Visual indicator for error or warning messages   |
          | The xtext plugin description hover is empty    | hover       | Popup displaying information on mouse hover      |
          | The xtext plugin status tooltip is empty       | tooltip     | Small popup displaying descriptive text          |

  Scenario Outline: Object Edge Fragment

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file test step type is created as follows
          | Test Step Full Name   |
          | <Test Step Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file step object ref object edge fragment will be decomposed as follows
          | Object Type   | Object Type Description   |
          | <Object Type> | <Object Type Description> |

    Examples: Fragments

          | Test Step Full Name                                                   | Object Type | Object Type Description |
          | The graph-viewer application uml-to-cucumber request is executed with | request     | Web-service request     |
          | The maven plugin asciidoctor-to-uml goal is executed                  | goal        | Maven plugin goal       |
          | The xtext plugin validate action is performed                         | action      | Eclipse plugin action   |
          | The nightly batchjob process job is executed with                     | job         | EOD or ETL batchjob     |

  Scenario Outline: Component Fragment Types

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file test step type is created as follows
          | Test Step Full Name   |
          | <Test Step Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file step object ref component fragment will be decomposed as follows
          | Component Type   | Component Type Description   |
          | <Component Type> | <Component Type Description> |

    Examples: Types

          | Test Step Full Name           | Component Type | Component Type Description                  |
          | The graph-viewer application  | application    | GUI web application                         |
          | The spec-prj project          | project        | Collection of files such as a Maven project |
          | The sheep-dog-dev-svc service | service        | RESTful or SOAP webservice                  |
          | The nightly batchjob          | batchjob       | EOD or ETL batchjob                         |
          | The xtext plugin              | plugin         | Maven or Eclipse plugin                     |

