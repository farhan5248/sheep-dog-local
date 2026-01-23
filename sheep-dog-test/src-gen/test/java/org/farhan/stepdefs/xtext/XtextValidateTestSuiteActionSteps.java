package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateTestSuiteAction;

@ScenarioScoped
public class XtextValidateTestSuiteActionSteps extends TestSteps {

    @Inject
    public XtextValidateTestSuiteActionSteps(ValidateTestSuiteAction object) {
        super(object, "xtext", "validate test suite");
    }

    @Given("^The xtext plugin validate test suite action is performed$")
    public void isPerformed() {
        object.transition();
    }
}
