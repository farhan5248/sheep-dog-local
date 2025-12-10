package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.QuickfixDialog;

@ScenarioScoped
public class XtextQuickfixDialogSteps extends TestSteps {

    @Inject
    public XtextQuickfixDialogSteps(QuickfixDialog object) {
        super(object, "xtext", "quickfix");
    }

    @Given("^The xtext plugin quickfix dialog, will be set as follows$")
    public void willBeSetAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }
}
