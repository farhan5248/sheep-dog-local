@sheep-dog-dev @round-trip
Feature: DocumentToCode

  \@sheep-dog-dev
  \@round-trip

  Scenario: Create a feature file from adoc file

    Given The spec-prj project, src/test/resources/asciidoc/specs/app/Process.asciidoc file is created as follows
          """
          = Test-Suite: Process
          
          @tag1
          Desc 1
          
          == Test-Case: Story One
          
          @tag2
          Desc 2
          
          * Given: The blah application, Object page is valid
          
          * Then: The Object page is created as follows
          +
          ----
            text1
          
            text2
          ----
          
          == Test-Case: Story Two
          
          @tag3
          Desc 3
          
          * Given: The blah application, Object page is invalid
          
          * When: The Object page is created as follows
          +
          |===
          | grp | ins
          | 8 | {ins}
          |===
          
          * Test-Data: Some data
          +
          |===
          | ins
          | 4
          |===
          
          * Test-Data: Dataset 2
          +
          |===
          | ins
          | 5
          | 6
          |===
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows
          """
          = Step-Object: Object page
          
          == Step-Definition: is valid
          
          == Step-Definition: is invalid
          
          == Step-Definition: is created as follows
          
          * Step-Parameters: 1
          +
          |===
          | grp | ins
          |===
          
          * Step-Parameters: 2
          +
          |===
          | Content
          |===
          """
     When The maven plugin, asciidoctor-to-uml goal is executed
      And The maven plugin, uml-to-cucumber goal is executed
     Then The code-prj project, src-gen/test/resources/cucumber/specs/app/Process.feature file will be created as follows
          """
          @tag1
          Feature: Process
          
            \@tag1
            Desc 1
          
            @tag2
            Scenario: Story One
          
              \@tag2
              Desc 2
          
              Given The blah application, Object page is valid
               Then The blah application, Object page is created as follows
                    \"\"\"
                      text1
                    
                      text2
                    \"\"\"
          
            @tag3
            Scenario Outline: Story Two
          
              \@tag3
              Desc 3
          
              Given The blah application, Object page is invalid
               When The blah application, Object page is created as follows
                    | grp | ins   |
                    | 8   | <ins> |
          
              Examples: Some data
          
                    | ins |
                    | 4   |
          
              Examples: Dataset 2
          
                    | ins |
                    | 5   |
                    | 6   |
          """
      And The code-prj project, src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file will be created as follows
          """
          package org.farhan.objects.blah;
          
          import java.util.HashMap;
          
          public interface ObjectPage {
          
              public void setGrp(HashMap<String, String> keyMap);
          
              public void setIns(HashMap<String, String> keyMap);
          
              public void setContent(HashMap<String, String> keyMap);
          
              public void setInvalid(HashMap<String, String> keyMap);
          
              public void setValid(HashMap<String, String> keyMap);
          }
          """
      And The code-prj project, src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java file will be created as follows
          """
          package org.farhan.stepdefs.blah;
          
          import io.cucumber.datatable.DataTable;
          import io.cucumber.java.en.Given;
          import org.farhan.common.TestSteps;
          
          public class BlahObjectPageSteps extends TestSteps {
          
              public BlahObjectPageSteps() {
                  super("ObjectPage", "blah", "Object");
              }
          
              @Given("^The blah application, Object page is created as follows$")
              public void isCreatedAsFollows(DataTable dataTable) {
                  object.setInputOutputs(dataTable);
              }
          
              @Given("^The blah application, Object page is invalid$")
              public void isInvalid() {
                  object.setInputOutputs("Invalid");
              }
          
              @Given("^The blah application, Object page is valid$")
              public void isValid() {
                  object.setInputOutputs("Valid");
              }
          }
          """

