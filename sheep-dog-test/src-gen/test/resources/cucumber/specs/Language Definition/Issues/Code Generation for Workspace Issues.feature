@sheep-dog-test
Feature: Code Generation for Workspace Issues

  \@sheep-dog-test
  TODO Add tests for each quickfix one
  TODO Add test step ensuring step object isn't changed until after the quickfix is applied
  The Xtext framework lets you map the DSL to Java so that you can generate the Java code with minimal coding.
  I think that's useful for a tester if every component is written in Java or the same language.
  If it's not, and there's PL/SQL, COBOL, webMethods, Layer 7 and other such languages, you might not need Java code but insert statements for example.
  In that case, generating Java code isn't that useful so I generate the lower layer describing each object.
  One way to see these two layers is that the test cases in the first layer are paths in a graph model and the steps in the second are the vertices.
  There's 3 things to generate
  1. An object such as an input file or report, a web-page or web-service response etc.
  2. A keyword or statement aka step definition about that object such as whether is exists, or has certain attributes or fields.
  3. A combination of parameters for that statement. This could be different combinations of search fields used in a search page.

  @ApplyQuickfixAction
  Scenario: This object doesn't exist generation

    \@ApplyQuickfixAction
    Applying the quickfix creates the step object file with the first step definition.

    Given The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows
          | Node Path                            | Test Step Full Name                      |
          | TestStepContainerList/1/TestStepList | The daily batchjob Input file is present |
      And The xtext plugin validate annotation is set as follows
          """
          The step object file doesn't exist for the component
          """
      And The xtext plugin list quickfixes popup is set as follows
          | Proposal Id                                                       | Proposal Description |
          | Generate Input file - stepdefs/daily batchjob/Input file.asciidoc | empty                |
     When The xtext plugin apply quickfix action is performed as follows
          | Test Suite Full Name         | Node Path                              |
          | specs/ProcessIssues.asciidoc | TestStepContainerList/1/TestStepList/1 |
     Then The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows
          | Step Definition Name |
          | is present           |

