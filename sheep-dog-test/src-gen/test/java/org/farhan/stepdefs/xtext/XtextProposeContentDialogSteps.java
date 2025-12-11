package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ProposeContentDialog;

@ScenarioScoped
public class XtextProposeContentDialogSteps extends TestSteps {

    @Inject
    public XtextProposeContentDialogSteps(ProposeContentDialog object) {
        super(object, "xtext", "propose content");
    }

    @Given("^The xtext plugin, propose content dialog will be empty$")
    public void willBeEmpty() {
        object.assertInputOutputs("Empty");
    }

    @Given("^The xtext plugin, propose content dialog will be set as follows$")
    public void willBeSetAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }
}
