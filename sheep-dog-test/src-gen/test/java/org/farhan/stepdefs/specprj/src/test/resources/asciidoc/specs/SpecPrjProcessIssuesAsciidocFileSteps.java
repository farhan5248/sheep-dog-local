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

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList node is created as follows$")
    public void testProjectTestDocumentListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1 node will be created as follows$")
    public void testProjectTestDocumentList1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/Description/LineList node is created as follows$")
    public void testProjectTestDocumentList1DescriptionLineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/Description/LineList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1DescriptionLineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/Description/LineList node will be empty$")
    public void testProjectTestDocumentList1DescriptionLineListNodeWillBeEmpty() {
        object.setPart("TestProject/TestDocumentList/1/Description/LineList");
        object.assertInputOutputs("Empty", "TestProjectTestDocumentList1DescriptionLineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/Description/LineList/2 node will be created as follows$")
    public void testProjectTestDocumentList1DescriptionLineList2NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/Description/LineList/2");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList1DescriptionLineList2Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList node is created as follows$")
    public void testProjectTestDocumentList1TestStepContainerListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList node will be empty$")
    public void testProjectTestDocumentList1TestStepContainerListNodeWillBeEmpty() {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList");
        object.assertInputOutputs("Empty", "TestProjectTestDocumentList1TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1 node will be created as follows$")
    public void testProjectTestDocumentList1TestStepContainerList1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList/1");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerList1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList node is created as follows$")
    public void testProjectTestDocumentList1TestStepContainerList1TestStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerList1TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList node is created as follows$")
    public void testProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList1CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList node will be created as follows$")
    public void testProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/2/CellList node is created as follows$")
    public void testProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList2CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Table/RowList/2/CellList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList2CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Text node is created as follows$")
    public void testProjectTestDocumentList1TestStepContainerList1TestStepList1TextNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList/1/TestStepList/1/Text");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerList1TestStepList1TextNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/2 node will be created as follows$")
    public void testProjectTestDocumentList1TestStepContainerList2NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList/2");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerList2Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/1/TestStepContainerList/2/TestStepList node is created as follows$")
    public void testProjectTestDocumentList1TestStepContainerList2TestStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/TestStepContainerList/2/TestStepList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1TestStepContainerList2TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestProject/TestDocumentList/2 node will be created as follows$")
    public void testProjectTestDocumentList2NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList2Node");
    }
}
