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

    @Given("^The xtext plugin edit document action is performed to modify StepDefinitionList with$")
    public void isPerformedToModifyStepDefinitionListWith(DataTable dataTable) {
        object.doEdgeStep("", "", "is", "performed to modify StepDefinitionList with", dataTable);
    }

    @Given("^The xtext plugin edit document action is performed to modify StepParametersList with$")
    public void isPerformedToModifyStepParametersListWith(DataTable dataTable) {
        object.doEdgeStep("", "", "is", "performed to modify StepParametersList with", dataTable);
    }

    @Given("^The xtext plugin edit document action is performed to modify TestStepContainerList with$")
    public void isPerformedToModifyTestStepContainerListWith(DataTable dataTable) {
        object.doEdgeStep("", "", "is", "performed to modify TestStepContainerList with", dataTable);
    }

    @Given("^The xtext plugin edit document action is performed to modify TestDataList with$")
    public void isPerformedToModifyTestDataListWith(DataTable dataTable) {
        object.doEdgeStep("", "", "is", "performed to modify TestDataList with", dataTable);
    }

    @Given("^The xtext plugin edit document action is performed to modify TestStepList with$")
    public void isPerformedToModifyTestStepListWith(DataTable dataTable) {
        object.doEdgeStep("", "", "is", "performed to modify TestStepList with", dataTable);
    }

    @Given("^The xtext plugin edit document action is performed to add Text at$")
    public void isPerformedToAddTextAt(DataTable dataTable) {
        object.doEdgeStep("", "", "is", "performed to add Text at", dataTable);
    }
}
