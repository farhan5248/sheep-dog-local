package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateCellAction;

@ScenarioScoped
public class XtextValidateCellActionSteps extends TestSteps {

    @Inject
    public XtextValidateCellActionSteps(ValidateCellAction object) {
        super(object, "xtext", "validate cell");
    }

    @Given("^The xtext plugin validate cell action is performed$")
    public void isPerformed() {
        object.transition();
    }
}
