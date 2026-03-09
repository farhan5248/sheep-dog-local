package org.farhan.stepdefs.xtext;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.xtext.AddDocumentNodeAction;

@ScenarioScoped
public class XtextAddDocumentNodeActionSteps extends TestSteps {

    @Inject
    public XtextAddDocumentNodeActionSteps(AddDocumentNodeAction object) {
        super(object, "xtext", "add document node");
    }

    @Given("^The xtext plugin add document node action is performed to add Table at$")
    public void isPerformedToAddTableAt(DataTable dataTable) {
        object.setInputOutputsState("Performed to add Table at");
        object.setInputOutputsDataTable(dataTable);
        object.transition();
    }

    @Given("^The xtext plugin add document node action is performed to add Text at$")
    public void isPerformedToAddTextAt(DataTable dataTable) {
        object.setInputOutputsState("Performed to add Text at");
        object.setInputOutputsDataTable(dataTable);
        object.transition();
    }
}
