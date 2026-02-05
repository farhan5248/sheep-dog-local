package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ListProposalsDialog;

@ScenarioScoped
public class XtextListProposalsDialogSteps extends TestSteps {

    @Inject
    public XtextListProposalsDialogSteps(ListProposalsDialog object) {
        super(object, "xtext", "list proposals");
    }

    @Given("^The xtext plugin list proposals dialog will be empty$")
    public void willBeEmpty() {
        object.assertInputOutputs("Empty");
    }

    @Given("^The xtext plugin list proposals dialog will be set as follows$")
    public void willBeSetAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }
}
