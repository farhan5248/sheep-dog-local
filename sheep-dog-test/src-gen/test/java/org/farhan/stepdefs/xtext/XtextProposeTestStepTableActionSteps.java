package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ProposeTestStepTableAction;

@ScenarioScoped
public class XtextProposeTestStepTableActionSteps extends TestSteps {

    @Inject
    public XtextProposeTestStepTableActionSteps(ProposeTestStepTableAction object) {
        super(object, "xtext", "propose test step table");
    }

    @Given("^The xtext plugin propose test step table action, is performed$")
    public void isPerformed() {
        object.transition();
    }
}
