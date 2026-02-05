package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ListQuickfixesAction;

@ScenarioScoped
public class XtextListQuickfixesActionSteps extends TestSteps {

    @Inject
    public XtextListQuickfixesActionSteps(ListQuickfixesAction object) {
        super(object, "xtext", "list quickfixes");
    }

    @Given("^The xtext plugin list quickfixes action is performed as follows$")
    public void isPerformedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
