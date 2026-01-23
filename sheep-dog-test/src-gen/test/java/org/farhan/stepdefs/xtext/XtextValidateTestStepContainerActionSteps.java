package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateTestStepContainerAction;

@ScenarioScoped
public class XtextValidateTestStepContainerActionSteps extends TestSteps {

    @Inject
    public XtextValidateTestStepContainerActionSteps(ValidateTestStepContainerAction object) {
        super(object, "xtext", "validate test step container");
    }

    @Given("^The xtext plugin validate test step container action is performed$")
    public void isPerformed() {
        object.transition();
    }

    @Given("^The xtext plugin validate test step container action is performed as follows$")
    public void isPerformedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
