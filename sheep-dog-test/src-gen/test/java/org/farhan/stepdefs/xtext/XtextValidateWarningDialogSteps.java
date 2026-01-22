package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ValidateWarningDialog;

@ScenarioScoped
public class XtextValidateWarningDialogSteps extends TestSteps {

    @Inject
    public XtextValidateWarningDialogSteps(ValidateWarningDialog object) {
        super(object, "xtext", "validate warning");
    }

    @Given("^The xtext plugin validate warning dialog will be set as follows$")
    public void willBeSetAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The xtext plugin validate warning dialog will be empty$")
    public void willBeEmpty() {
        object.assertInputOutputs("Empty");
    }
}
