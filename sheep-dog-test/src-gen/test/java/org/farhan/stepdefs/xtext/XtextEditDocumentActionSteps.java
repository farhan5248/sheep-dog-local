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

    @Given("^The xtext plugin edit document action is performed to modify CellList with$")
    public void isPerformedToModifyCellListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
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

    @Given("^The xtext plugin edit document action is performed to modify StepParametersList with$")
    public void isPerformedToModifyStepParametersListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin edit document action is performed to modify TestDocumentList with$")
    public void isPerformedToModifyTestDocumentListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin edit document action is performed to modify TestStepContainerList with$")
    public void isPerformedToModifyTestStepContainerListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin edit document action is performed to modify RowList with$")
    public void isPerformedToModifyRowListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin edit document action is performed to modify TestDataList with$")
    public void isPerformedToModifyTestDataListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin edit document action is performed to modify TestStepList with$")
    public void isPerformedToModifyTestStepListWith(DataTable dataTable) {
        object.setInputOutputs(dataTable);
        object.transition();
    }
}
