package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;

@ScenarioScoped
public class SpecPrjProcess2AsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjProcess2AsciidocFileSteps(Process2AsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/specs/Process2.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList node is created as follows$")
    public void testSuiteListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList");
        object.setInputOutputs(dataTable, "TestSuiteListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1 node will be created as follows$")
    public void testSuiteList1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1");
        object.assertInputOutputs(dataTable, "TestSuiteList1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestCaseList node is created as follows$")
    public void testSuiteList1TestCaseListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestCaseList");
        object.setInputOutputs(dataTable, "TestSuiteList1TestCaseListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestCaseList/1 node will be created as follows$")
    public void testSuiteList1TestCaseList1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestCaseList/1");
        object.assertInputOutputs(dataTable, "TestSuiteList1TestCaseList1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestCaseList/1/TestStepList node is created as follows$")
    public void testSuiteList1TestCaseList1TestStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestCaseList/1/TestStepList");
        object.setInputOutputs(dataTable, "TestSuiteList1TestCaseList1TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestCaseList/1/TestStepList/1/Table/RowList/1/CellList node is created as follows$")
    public void testSuiteList1TestCaseList1TestStepList1TableRowList1CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestCaseList/1/TestStepList/1/Table/RowList/1/CellList");
        object.setInputOutputs(dataTable, "TestSuiteList1TestCaseList1TestStepList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestCaseList/1/TestStepList/1/Table/RowList/1/CellList node will be created as follows$")
    public void testSuiteList1TestCaseList1TestStepList1TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestCaseList/1/TestStepList/1/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "TestSuiteList1TestCaseList1TestStepList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestCaseList/1/TestStepList/1/Table/RowList/2/CellList node is created as follows$")
    public void testSuiteList1TestCaseList1TestStepList1TableRowList2CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestCaseList/1/TestStepList/1/Table/RowList/2/CellList");
        object.setInputOutputs(dataTable, "TestSuiteList1TestCaseList1TestStepList1TableRowList2CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestCaseList/1/TestStepList/1/Text node is created as follows$")
    public void testSuiteList1TestCaseList1TestStepList1TextNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestCaseList/1/TestStepList/1/Text");
        object.setInputOutputs(dataTable, "TestSuiteList1TestCaseList1TestStepList1TextNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestCaseList/2/TestStepList node is created as follows$")
    public void testSuiteList1TestCaseList2TestStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestCaseList/2/TestStepList");
        object.setInputOutputs(dataTable, "TestSuiteList1TestCaseList2TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuiteList/1/TestSetupList/1/TestStepList node is created as follows$")
    public void testSuiteList1TestSetupList1TestStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuiteList/1/TestSetupList/1/TestStepList");
        object.setInputOutputs(dataTable, "TestSuiteList1TestSetupList1TestStepListNode");
    }
}
