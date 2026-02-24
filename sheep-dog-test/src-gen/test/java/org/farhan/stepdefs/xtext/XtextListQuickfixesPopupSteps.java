package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ListQuickfixesPopup;

@ScenarioScoped
public class XtextListQuickfixesPopupSteps extends TestSteps {

    @Inject
    public XtextListQuickfixesPopupSteps(ListQuickfixesPopup object) {
        super(object, "xtext", "list quickfixes");
    }

    @Given("^The xtext plugin list quickfixes popup is set as follows$")
    public void isSetAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
    }

    @Given("^The xtext plugin list quickfixes popup will be empty$")
    public void willBeEmpty() {
        object.assertInputOutputs("Empty");
    }

    @Given("^The xtext plugin list quickfixes popup will be set as follows$")
    public void willBeSetAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }
}
