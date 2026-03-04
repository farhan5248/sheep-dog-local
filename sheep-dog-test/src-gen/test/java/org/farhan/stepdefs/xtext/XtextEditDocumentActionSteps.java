package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.EditDocumentAction;

@ScenarioScoped
public class XtextEditDocumentActionSteps extends TestSteps {

    @Inject
    public XtextEditDocumentActionSteps(EditDocumentAction object) {
        super(object, "xtext", "edit document");
    }

    @Given("^The xtext plugin edit document action is performed to modify LineList with$")
    public void isPerformedToModifyLineListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin edit document action is performed to modify StepDefinitionList with$")
    public void isPerformedToModifyStepDefinitionListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin edit document action is performed to modify TestDocumentList with$")
    public void isPerformedToModifyTestDocumentListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
