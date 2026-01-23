package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateTestStepAction;

@ScenarioScoped
public class XtextValidateTestStepActionSteps extends TestSteps {

    @Inject
    public XtextValidateTestStepActionSteps(ValidateTestStepAction object) {
        super(object, "xtext", "validate test step");
    }

    @Given("^The xtext plugin validate test step action is performed$")
    public void isPerformed() {
        object.transition();
    }
}
