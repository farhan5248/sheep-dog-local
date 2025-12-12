package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateErrorDialog;

@ScenarioScoped
public class XtextValidateErrorDialogSteps extends TestSteps {

    @Inject
    public XtextValidateErrorDialogSteps(ValidateErrorDialog object) {
        super(object, "xtext", "validate error");
    }

    @Given("^The xtext plugin validate error dialog will be empty$")
    public void willBeEmpty() {
        object.assertInputOutputs("Empty");
    }

    @Given("^The xtext plugin validate error dialog will be set as follows$")
    public void willBeSetAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }
}
