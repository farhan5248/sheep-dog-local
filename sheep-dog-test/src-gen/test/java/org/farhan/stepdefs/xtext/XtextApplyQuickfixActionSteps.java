package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.ApplyQuickfixAction;

@ScenarioScoped
public class XtextApplyQuickfixActionSteps extends TestSteps {

    @Inject
    public XtextApplyQuickfixActionSteps(ApplyQuickfixAction object) {
        super(object, "xtext", "apply quickfix");
    }

    @Given("^The xtext plugin apply quickfix action is performed$")
    public void isPerformed() {
        object.transition();
    }

    @Given("^The xtext plugin apply quickfix action is performed as follows$")
    public void isPerformedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
