@sheep-dog-test
Feature: Code Generation

  \@sheep-dog-test
  The Xtext framework lets you map the DSL to Java so that you can generate the Java code with minimal coding.
  I think that’s useful for a tester if every component is written in Java or the same language.
  If it’s not, and there’s PL/SQL, COBOL, webMethods, Layer 7 and other such languages, you might not need Java code but insert statements for example.
  In that case, generating Java code isn’t that useful so I generate the lower layer describing each object.
  One way to see these two layers is that the test cases in the first layer are paths in a graph model and the steps in the second are the vertices.
  There's 3 things to generate
  1. An object such as an input file or report, a web-page or web-service response etc.
  2. A keyword or statement aka step definition about that object such as whether is exists, or has certain attributes or fields.
  3. A combination of parameters for that statement. This could be different combinations of search fields used in a search page.

  Scenario: Create a new object for a component

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
     When The xtext plugin, generate step definition action is performed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is present           |

  Scenario: Create a step definition for an object

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 |
          | The daily batchjob, Input file is present |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is absent            |
     When The xtext plugin, generate step definition action is performed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows
          | Object Name                       | Step Definition Name |
          | daily batchjob/Input file.feature | is present           |

  Scenario: Create a new parameter set for the step-definition

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process2.asciidoc file steps snippet is created as follows
          | Step Name                                 | Headers    |
          | The daily batchjob, Input file is present | New Header |
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows
          | Object Name                       | Step Definition Name | Parameters |
          | daily batchjob/Input file.feature | is present           | Old Header |
     When The xtext plugin, generate step definition action is performed
     Then The spec-prj project, src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows
          | Object Name                       | Step Definition Name | Parameters |
          | daily batchjob/Input file.feature | is present           | New Header |

