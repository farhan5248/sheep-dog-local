package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ListQuickfixesDialog;

@ScenarioScoped
public class XtextListQuickfixesDialogSteps extends TestSteps {

    @Inject
    public XtextListQuickfixesDialogSteps(ListQuickfixesDialog object) {
        super(object, "xtext", "list quickfixes");
    }

    @Given("^The xtext plugin list quickfixes dialog will be empty$")
    public void willBeEmpty() {
        object.assertInputOutputs("Empty");
    }

    @Given("^The xtext plugin list quickfixes dialog will be set as follows$")
    public void willBeSetAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }
}
