@sheep-dog-dev @round-trip
Feature: Update Existing Code

  \@sheep-dog-dev
  \@round-trip
  By being able to generate test automation for selected test cases on demand, means you don't need to maintain the code.
  This is one of the advantages of model based testing.
  Sometimes I only select a few test cases to generate the code for which means only a subset of the interfaces methods are generated.
  The problem is that the classes which implement the interfaces won't compile because the interface methods are missing.
  For this reason I'd at least keep the interfaces and make sure that the UML model to interfaces code generation preserves the existing methods.

  Background: Create a test suite and step object

    Given The spec-prj project, src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          == Test-Case: Submit
          
          * Given: The blah application, Object page is empty
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is empty
          """
      And The maven plugin, asciidoctor-to-uml goal is executed

  Scenario: Update existing step definitions with a new method

    The isEmpty method is added to the step definition class and the isInvalid one isn't removed.

      And The code-prj project, src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java file is created as follows
          """
          package org.farhan.stepdefs.blah;
          
          import io.cucumber.datatable.DataTable;
          import io.cucumber.java.en.Given;
          import org.farhan.common.BlahFactory;
          
          public class BlahObjectPageSteps {
          
              @Given("^The blah application, Object page is invalid$")
          
              public BlahObjectPageSteps() {
                  super("ObjectPage", "blah", "Object");
              }
          
              public void isInvalid() {
                  BlahFactory.get("ObjectPage").setComponent("blah");
                  BlahFactory.get("ObjectPage").setPath("Object");
                  BlahFactory.get("ObjectPage").setInputOutputs("Invalid");
              }
          }
          """
     When The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java file will be created as follows
          """
          package org.farhan.stepdefs.blah;
          
          import io.cucumber.datatable.DataTable;
          import io.cucumber.java.en.Given;
          import org.farhan.common.BlahFactory;
          
          public class BlahObjectPageSteps {
          
              @Given("^The blah application, Object page is invalid$")
              public BlahObjectPageSteps() {
                  super("ObjectPage", "blah", "Object");
              }
          
              public void isInvalid() {
                  BlahFactory.get("ObjectPage").setComponent("blah");
                  BlahFactory.get("ObjectPage").setPath("Object");
                  BlahFactory.get("ObjectPage").setInputOutputs("Invalid");
              }
          
              @Given("^The blah application, Object page is empty$")
              public void isEmpty() {
                  object.setInputOutputs("Empty");
              }
          }
          """

  Scenario: Update existing interface with a new method

    Same as above but the interface is updated with a new method.

      And The code-prj project, src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file is created as follows
          """
          package org.farhan.objects.blah;
          
          import java.util.HashMap;
          
          public interface ObjectPage {
          
              public void setInvalid(HashMap<String, String> keyMap);
          }
          """
     When The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file will be created as follows
          """
          package org.farhan.objects.blah;
          
          import java.util.HashMap;
          
          public interface ObjectPage {
          
              public void setInvalid(HashMap<String, String> keyMap);
          
              public void setEmpty(HashMap<String, String> keyMap);
          }
          """

