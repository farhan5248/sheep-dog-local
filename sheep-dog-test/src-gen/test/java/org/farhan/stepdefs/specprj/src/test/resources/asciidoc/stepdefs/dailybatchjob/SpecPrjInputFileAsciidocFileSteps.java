package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;

@ScenarioScoped
public class SpecPrjInputFileAsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjInputFileAsciidocFileSteps(InputFileAsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList node is created as follows$")
    public void testProjectTestDocumentListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/Description/LineList node is created as follows$")
    public void testProjectTestDocumentList1DescriptionLineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/Description/LineList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1DescriptionLineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/Description/LineList node will be empty$")
    public void testProjectTestDocumentList1DescriptionLineListNodeWillBeEmpty() {
        object.setPart("TestProject/TestDocumentList/1/Description/LineList");
        object.assertInputOutputs("Empty", "TestProjectTestDocumentList1DescriptionLineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/Description/LineList/2 node will be created as follows$")
    public void testProjectTestDocumentList1DescriptionLineList2NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/Description/LineList/2");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList1DescriptionLineList2Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList node is created as follows$")
    public void testProjectTestDocumentList1StepDefinitionListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/StepDefinitionList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList1StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList node will be empty$")
    public void testProjectTestDocumentList1StepDefinitionListNodeWillBeEmpty() {
        object.setPart("TestProject/TestDocumentList/1/StepDefinitionList");
        object.assertInputOutputs("Empty", "TestProjectTestDocumentList1StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/1/StepDefinitionList/2 node will be created as follows$")
    public void testProjectTestDocumentList1StepDefinitionList2NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/1/StepDefinitionList/2");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList1StepDefinitionList2Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2 node will be created as follows$")
    public void testProjectTestDocumentList2NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList2Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2/Description/LineList node is created as follows$")
    public void testProjectTestDocumentList2DescriptionLineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2/Description/LineList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList2DescriptionLineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2/StepDefinitionList node will be created as follows$")
    public void testProjectTestDocumentList2StepDefinitionListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2/StepDefinitionList");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList2StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2/StepDefinitionList/1/Description/LineList node is created as follows$")
    public void testProjectTestDocumentList2StepDefinitionList1DescriptionLineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2/StepDefinitionList/1/Description/LineList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList2StepDefinitionList1DescriptionLineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList node will be created as follows$")
    public void testProjectTestDocumentList2StepDefinitionList1StepParametersListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList2StepDefinitionList1StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList/1/NestedDescription/LineList node is created as follows$")
    public void testProjectTestDocumentList2StepDefinitionList1StepParametersList1NestedDescriptionLineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList/1/NestedDescription/LineList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList2StepDefinitionList1StepParametersList1NestedDescriptionLineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList node is created as follows$")
    public void testProjectTestDocumentList2StepDefinitionList1StepParametersList1TableRowList1CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList");
        object.setInputOutputs(dataTable, "TestProjectTestDocumentList2StepDefinitionList1StepParametersList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList node will be created as follows$")
    public void testProjectTestDocumentList2StepDefinitionList1StepParametersList1TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList2StepDefinitionList1StepParametersList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList/2/Table/RowList/1/CellList node will be created as follows$")
    public void testProjectTestDocumentList2StepDefinitionList1StepParametersList2TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestProject/TestDocumentList/2/StepDefinitionList/1/StepParametersList/2/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "TestProjectTestDocumentList2StepDefinitionList1StepParametersList2TableRowList1CellListNode");
    }
}
