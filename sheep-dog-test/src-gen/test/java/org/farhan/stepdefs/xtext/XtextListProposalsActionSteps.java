package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestStepdef;
import org.farhan.objects.xtext.ListProposalsAction;

@ScenarioScoped
public class XtextListProposalsActionSteps extends TestStepdef {

    @Inject
    public XtextListProposalsActionSteps(ListProposalsAction object) {
        super(object, "xtext", "list proposals");
    }

    @Given("^The xtext plugin list proposals action is performed as follows$")
    public void isPerformedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
