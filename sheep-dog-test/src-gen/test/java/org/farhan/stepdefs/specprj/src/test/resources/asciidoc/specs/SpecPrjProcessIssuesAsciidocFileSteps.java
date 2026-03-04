package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

@ScenarioScoped
public class SpecPrjProcessIssuesAsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjProcessIssuesAsciidocFileSteps(ProcessIssuesAsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/specs/ProcessIssues.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList node is created as follows$")
    public void modelTestSuiteListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList");
        object.setInputOutputs(dataTable, "ModelTestSuiteListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1/TestStepContainerList node is created as follows$")
    public void modelTestSuiteList1TestStepContainerListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1/TestStepContainerList");
        object.setInputOutputs(dataTable, "ModelTestSuiteList1TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1/TestStepContainerList/1/TestStepList node is created as follows$")
    public void modelTestSuiteList1TestStepContainerList1TestStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1/TestStepContainerList/1/TestStepList");
        object.setInputOutputs(dataTable, "ModelTestSuiteList1TestStepContainerList1TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList node is created as follows$")
    public void modelTestSuiteList1TestStepContainerList1TestStepList1TableRowList1CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList");
        object.setInputOutputs(dataTable, "ModelTestSuiteList1TestStepContainerList1TestStepList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/2/CellList node is created as follows$")
    public void modelTestSuiteList1TestStepContainerList1TestStepList1TableRowList2CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/2/CellList");
        object.setInputOutputs(dataTable, "ModelTestSuiteList1TestStepContainerList1TestStepList1TableRowList2CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1/TestStepContainerList/1/TestStepList/1/Text node is created as follows$")
    public void modelTestSuiteList1TestStepContainerList1TestStepList1TextNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1/TestStepContainerList/1/TestStepList/1/Text");
        object.setInputOutputs(dataTable, "ModelTestSuiteList1TestStepContainerList1TestStepList1TextNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1/TestStepContainerList/2/TestStepList node is created as follows$")
    public void modelTestSuiteList1TestStepContainerList2TestStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1/TestStepContainerList/2/TestStepList");
        object.setInputOutputs(dataTable, "ModelTestSuiteList1TestStepContainerList2TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1 node will be created as follows$")
    public void modelTestSuiteList1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1");
        object.assertInputOutputs(dataTable, "ModelTestSuiteList1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1/TestStepContainerList/1 node will be created as follows$")
    public void modelTestSuiteList1TestStepContainerList1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1/TestStepContainerList/1");
        object.assertInputOutputs(dataTable, "ModelTestSuiteList1TestStepContainerList1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Model/TestSuiteList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList node will be created as follows$")
    public void modelTestSuiteList1TestStepContainerList1TestStepList1TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/TestSuiteList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "ModelTestSuiteList1TestStepContainerList1TestStepList1TableRowList1CellListNode");
    }
}
