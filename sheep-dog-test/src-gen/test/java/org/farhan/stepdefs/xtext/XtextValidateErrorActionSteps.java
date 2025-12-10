package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateErrorAction;

@ScenarioScoped
public class XtextValidateErrorActionSteps extends TestSteps {

    @Inject
    public XtextValidateErrorActionSteps(ValidateErrorAction object) {
        super(object, "xtext", "validate error");
    }

    @Given("^The xtext plugin validate error action, is performed as follows$")
    public void isPerformedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
