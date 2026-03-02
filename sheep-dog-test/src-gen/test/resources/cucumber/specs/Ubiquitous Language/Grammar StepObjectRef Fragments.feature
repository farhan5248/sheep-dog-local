@sheep-dog-test
Feature: Grammar StepObjectRef Fragments

  \@sheep-dog-test
  A StepObjectRef identifies the component and object in a test step.

  @Grammar
  Scenario Outline: Component Fragment

    \@Grammar

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

    Examples: Types

          | Test Step Full Name           | Component                 | Component Name    | Component Type |
          | The spec-prj project          | spec-prj project          | spec-prj          | project        |
          | The sheep-dog-dev-svc service | sheep-dog-dev-svc service | sheep-dog-dev-svc | service        |
          | The nightly batchjob          | nightly batchjob          | nightly           | batchjob       |
          | The xtext plugin              | xtext plugin              | xtext             | plugin         |

  @Grammar
  Scenario Outline: Object Fragment

    \@Grammar

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

  @Grammar
  Scenario Outline: Object Vertex Fragment

    \@Grammar

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file test step type is created as follows
          | Test Step Full Name   |
          | <Test Step Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file step object ref object vertex fragment will be decomposed as follows
          | Object Name   | Object Type   |
          | <Object Name> | <Object Type> |

    Examples: Fragments

          | Test Step Full Name                            | Object Name    | Object Type |
          | The xtext plugin input file is empty           | input          | file        |
          | The xtext plugin output directory is empty     | output         | directory   |
          | The xtext plugin home page is empty            | home           | page        |
          | The xtext plugin settings dialog is empty      | settings       | dialog      |
          | The xtext plugin validate response is empty    | validate       | response    |
          | The xtext plugin list proposals popup is empty | list proposals | popup       |
          | The xtext plugin validate annotation is empty  | validate       | annotation  |
          | The xtext plugin description hover is empty    | description    | hover       |
          | The xtext plugin status tooltip is empty       | status         | tooltip     |

  @Grammar
  Scenario Outline: Object Edge Fragment

    \@Grammar

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file test step type is created as follows
          | Test Step Full Name   |
          | <Test Step Full Name> |
     Then The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammar.asciidoc file step object ref object edge fragment will be decomposed as follows
          | Object Name   | Object Type   |
          | <Object Name> | <Object Type> |

    Examples: Fragments

          | Test Step Full Name                                                   | Object Name        | Object Type |
          | The graph-viewer application uml-to-cucumber request is executed with | uml-to-cucumber    | request     |
          | The maven plugin asciidoctor-to-uml goal is executed                  | asciidoctor-to-uml | goal        |
          | The xtext plugin validate action is performed                         | validate           | action      |
          | The nightly batchjob process job is executed with                     | process            | job         |

