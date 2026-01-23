package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateTextAction;

@ScenarioScoped
public class XtextValidateTextActionSteps extends TestSteps {

    @Inject
    public XtextValidateTextActionSteps(ValidateTextAction object) {
        super(object, "xtext", "validate text");
    }

    @Given("^The xtext plugin validate text action is performed$")
    public void isPerformed() {
        object.transition();
    }
}
