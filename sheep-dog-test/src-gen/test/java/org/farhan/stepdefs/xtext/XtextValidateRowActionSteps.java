package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateRowAction;

@ScenarioScoped
public class XtextValidateRowActionSteps extends TestSteps {

    @Inject
    public XtextValidateRowActionSteps(ValidateRowAction object) {
        super(object, "xtext", "validate row");
    }

    @Given("^The xtext plugin validate row action is performed$")
    public void isPerformed() {
        object.transition();
    }
}
