@sheep-dog-dev @round-trip
Feature: JBehaveCodeGeneration

  \@sheep-dog-dev
  \@round-trip

  Background: Create a story file and UML model

    Given The code-prj project, src-gen/test/resources/jbehave/specs/CodeGen.story file is created as follows
          """
          Meta: @code-gen

          Narrative:
          In order to test code generation
          As a developer
          I want to ensure that Java code is properly generated from JBehave stories

          Scenario: Basic Scenario

            Given The test application, Login page is displayed
             When The test application, Login page username field is set to "admin"
              And The test application, Login page password field is set to "password"
              And The test application, Login page submit button is clicked
             Then The test application, Dashboard page is displayed
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/test application/Login page.asciidoc file is created as follows
          """
          = Step-Object: Login page
          
          == Step-Definition: is displayed
          
          == Step-Definition: username field is set to
          
          == Step-Definition: password field is set to
          
          == Step-Definition: submit button is clicked
          """
      And The spec-prj project, src/test/resources/asciidoc/stepdefs/test application/Dashboard page.asciidoc file is created as follows
          """
          = Step-Object: Dashboard page
          
          == Step-Definition: is displayed
          """

  Scenario: Java step definition file is generated

     When The maven plugin, jbehave-to-uml goal is executed with
          | Tags |
          | code-gen |
      And The maven plugin, uml-to-java goal is executed with
          | Tags |
          | code-gen |
     Then The code-prj project, src-gen/test/java/org/farhan/stepdefs/test/TestLoginPageSteps.java file will be created as follows
          """
          package org.farhan.stepdefs.test;
          
          import org.jbehave.core.annotations.Given;
          import org.jbehave.core.annotations.When;
          import org.jbehave.core.annotations.Then;
          import org.farhan.common.TestSteps;
          import org.farhan.objects.test.LoginPage;
          
          public class TestLoginPageSteps extends TestSteps {
          
              public TestLoginPageSteps(LoginPage object) {
                  super(object, "test", "Login");
              }
          
              @Given("The test application, Login page is displayed")
              public void isDisplayed() {
                  object.setInputOutputs("Displayed");
              }
              
              @When("The test application, Login page username field is set to \"$value\"")
              public void usernameFieldIsSetTo(String value) {
                  object.setInputOutputs("UsernameField", value);
              }
              
              @When("The test application, Login page password field is set to \"$value\"")
              public void passwordFieldIsSetTo(String value) {
                  object.setInputOutputs("PasswordField", value);
              }
              
              @When("The test application, Login page submit button is clicked")
              public void submitButtonIsClicked() {
                  object.setInputOutputs("SubmitButtonClicked");
              }
          }
          """
      And The code-prj project, src-gen/test/java/org/farhan/stepdefs/test/TestDashboardPageSteps.java file will be created as follows
          """
          package org.farhan.stepdefs.test;
          
          import org.jbehave.core.annotations.Then;
          import org.farhan.common.TestSteps;
          import org.farhan.objects.test.DashboardPage;
          
          public class TestDashboardPageSteps extends TestSteps {
          
              public TestDashboardPageSteps(DashboardPage object) {
                  super(object, "test", "Dashboard");
              }
          
              @Then("The test application, Dashboard page is displayed")
              public void isDisplayed() {
                  object.setInputOutputs("Displayed");
              }
          }
          """

  Scenario: Java page object files are generated

     When The maven plugin, jbehave-to-uml goal is executed with
          | Tags |
          | code-gen |
      And The maven plugin, uml-to-java goal is executed with
          | Tags |
          | code-gen |
     Then The code-prj project, src-gen/test/java/org/farhan/objects/test/LoginPage.java file will be created as follows
          """
          package org.farhan.objects.test;
          
          import org.farhan.common.TestObject;
          
          public class LoginPage extends TestObject {
          
              public LoginPage() {
                  super("test", "Login");
              }
          }
          """
      And The code-prj project, src-gen/test/java/org/farhan/objects/test/DashboardPage.java file will be created as follows
          """
          package org.farhan.objects.test;
          
          import org.farhan.common.TestObject;
          
          public class DashboardPage extends TestObject {
          
              public DashboardPage() {
                  super("test", "Dashboard");
              }
          }
          """
