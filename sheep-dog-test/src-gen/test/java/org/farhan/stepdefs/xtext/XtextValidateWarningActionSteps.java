package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateWarningAction;

@ScenarioScoped
public class XtextValidateWarningActionSteps extends TestSteps {

    @Inject
    public XtextValidateWarningActionSteps(ValidateWarningAction object) {
        super(object, "xtext", "validate warning");
    }

    @Given("^The xtext plugin, validate warning action is performed$")
    public void isPerformed() {
        object.transition();
    }
}
