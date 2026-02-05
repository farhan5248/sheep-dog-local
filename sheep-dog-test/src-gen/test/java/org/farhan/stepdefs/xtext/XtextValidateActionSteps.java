package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateAction;

@ScenarioScoped
public class XtextValidateActionSteps extends TestSteps {

    @Inject
    public XtextValidateActionSteps(ValidateAction object) {
        super(object, "xtext", "validate");
    }

    @Given("^The xtext plugin validate action is performed as follows$")
    public void isPerformedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
