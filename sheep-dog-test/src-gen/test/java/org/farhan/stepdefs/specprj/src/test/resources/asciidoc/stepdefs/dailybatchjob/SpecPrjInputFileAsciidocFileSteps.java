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

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList node is created as follows$")
    public void modelStepObjectListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList");
        object.setInputOutputs(dataTable, "ModelStepObjectListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1 node will be created as follows$")
    public void modelStepObjectList1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1");
        object.assertInputOutputs(dataTable, "ModelStepObjectList1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/StepDefinitionList node will be created as follows$")
    public void modelStepObjectList1StepDefinitionListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/StepDefinitionList");
        object.assertInputOutputs(dataTable, "ModelStepObjectList1StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/StepDefinitionList/1/StepParametersList node will be created as follows$")
    public void modelStepObjectList1StepDefinitionList1StepParametersListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/StepDefinitionList/1/StepParametersList");
        object.assertInputOutputs(dataTable, "ModelStepObjectList1StepDefinitionList1StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList node is created as follows$")
    public void modelStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList");
        object.setInputOutputs(dataTable, "ModelStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList node will be created as follows$")
    public void modelStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "ModelStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/StepDefinitionList/1/StepParametersList/2/Table/RowList/1/CellList node will be created as follows$")
    public void modelStepObjectList1StepDefinitionList1StepParametersList2TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/StepDefinitionList/1/StepParametersList/2/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "ModelStepObjectList1StepDefinitionList1StepParametersList2TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/Description node will be empty$")
    public void modelStepObjectList1DescriptionNodeWillBeEmpty() {
        object.setPart("Model/StepObjectList/1/Description");
        object.assertInputOutputs("Empty", "ModelStepObjectList1DescriptionNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/Description/LineList node is created as follows$")
    public void modelStepObjectList1DescriptionLineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/Description/LineList");
        object.setInputOutputs(dataTable, "ModelStepObjectList1DescriptionLineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/Description/LineList/2 node will be created as follows$")
    public void modelStepObjectList1DescriptionLineList2NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/Description/LineList/2");
        object.assertInputOutputs(dataTable, "ModelStepObjectList1DescriptionLineList2Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/StepDefinitionList node is created as follows$")
    public void modelStepObjectList1StepDefinitionListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/StepDefinitionList");
        object.setInputOutputs(dataTable, "ModelStepObjectList1StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/StepDefinitionList node will be empty$")
    public void modelStepObjectList1StepDefinitionListNodeWillBeEmpty() {
        object.setPart("Model/StepObjectList/1/StepDefinitionList");
        object.assertInputOutputs("Empty", "ModelStepObjectList1StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Model/StepObjectList/1/StepDefinitionList/2 node will be created as follows$")
    public void modelStepObjectList1StepDefinitionList2NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("Model/StepObjectList/1/StepDefinitionList/2");
        object.assertInputOutputs(dataTable, "ModelStepObjectList1StepDefinitionList2Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created$")
    public void isCreated() {
        object.setInputOutputs("Created");
    }
}
