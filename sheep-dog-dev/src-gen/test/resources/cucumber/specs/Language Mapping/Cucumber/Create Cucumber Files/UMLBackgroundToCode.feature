@sheep-dog-dev
Feature: UMLBackgroundToCode

  \@sheep-dog-dev

  Scenario: One statement, one step, one scenario

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          Desc line 1
          
          * Given: The Object0 page is valid
          
          == Test-Case: Submit
          
          * Given: The Object1 page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Background section will be created as follows
          | Name  | Description |
          | Setup | Desc line 1 |

  Scenario: No statement, one step, one scenario

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object0 page is valid
          
          == Test-Case: Submit
          
          * Given: The Object1 page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Background Steps section will be created as follows
          | Name  | Step                                             |
          | Setup | Given The Unknown service, Object0 page is valid |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows
          | Name   | Step                                             |
          | Submit | Given The Unknown service, Object1 page is valid |

  Scenario: No statement, one step, two scenarios

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object0 page is valid
          
          == Test-Case: Submit 1
          
          * Given: The Object1 page is valid
          
          == Test-Case: Submit 2
          
          * Given: The Object2 page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Background Steps section will be created as follows
          | Name  | Step                                             |
          | Setup | Given The Unknown service, Object0 page is valid |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows
          | Name     | Step                                             |
          | Submit 1 | Given The Unknown service, Object1 page is valid |
          | Submit 2 | Given The Unknown service, Object2 page is valid |

  Scenario: No statement, one step, three scenarios

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object0 page is valid
          
          == Test-Case: Submit 1
          
          * Given: The Object1 page is valid
          
          == Test-Case: Submit 2
          
          * Given: The Object2 page is valid
          
          == Test-Case: Submit 3
          
          * Given: The Object3 page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Background Steps section will be created as follows
          | Name  | Step                                             |
          | Setup | Given The Unknown service, Object0 page is valid |
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows
          | Name     | Step                                             |
          | Submit 1 | Given The Unknown service, Object1 page is valid |
          | Submit 2 | Given The Unknown service, Object2 page is valid |
          | Submit 3 | Given The Unknown service, Object3 page is valid |

  Scenario Outline: No statement, two steps, one scenario

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object1 page is valid
          * Given: The Object2 page is valid
          
          == Test-Case: Submit
          
          * Given: The Object page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Background Steps section will be created as follows
          | Name  | Step                                                   |
          | Setup | Given The Unknown service, Object<Index> page is valid |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |

  Scenario Outline: No statement, three steps, one scenario

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Setup: Setup
          
          * Given: The Object1 page is valid
          * Given: The Object2 page is valid
          * Given: The Object3 page is valid
          
          == Test-Case: Submit
          
          * Given: The Object page is valid
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file will be present
      And The code-prj project, src-gen/test/resources/cucumber/specs/Process.feature file Background Steps section will be created as follows
          | Name  | Step                                                   |
          | Setup | Given The Unknown service, Object<Index> page is valid |

    Examples: Indices

          | Index |
          | 1     |
          | 2     |
          | 3     |

