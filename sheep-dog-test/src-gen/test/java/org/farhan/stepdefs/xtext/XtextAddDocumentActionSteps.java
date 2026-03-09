package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.AddDocumentAction;

@ScenarioScoped
public class XtextAddDocumentActionSteps extends TestSteps {

    @Inject
    public XtextAddDocumentActionSteps(AddDocumentAction object) {
        super(object, "xtext", "add document");
    }

    @Given("^The xtext plugin add document action is performed to create a StepObject with$")
    public void isPerformedToCreateAStepObjectWith(DataTable dataTable) {
        object.setInputOutputsState("Performed to create a StepObject with");
        object.setInputOutputsDataTable(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin add document action is performed to create a TestSuite with$")
    public void isPerformedToCreateATestSuiteWith(DataTable dataTable) {
        object.setInputOutputsState("Performed to create a TestSuite with");
        object.setInputOutputsDataTable(dataTable);
        object.transition();
    }
}
