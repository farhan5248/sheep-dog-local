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

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObjectList node is created as follows$")
    public void stepObjectListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObjectList");
        object.setInputOutputs(dataTable, "StepObjectListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObjectList/1 node will be created as follows$")
    public void stepObjectList1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObjectList/1");
        object.assertInputOutputs(dataTable, "StepObjectList1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObjectList/1/StepDefinitionList node will be created as follows$")
    public void stepObjectList1StepDefinitionListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObjectList/1/StepDefinitionList");
        object.assertInputOutputs(dataTable, "StepObjectList1StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObjectList/1/StepDefinitionList/1/StepParametersList node will be created as follows$")
    public void stepObjectList1StepDefinitionList1StepParametersListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObjectList/1/StepDefinitionList/1/StepParametersList");
        object.assertInputOutputs(dataTable, "StepObjectList1StepDefinitionList1StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObjectList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList node is created as follows$")
    public void stepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObjectList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList");
        object.setInputOutputs(dataTable, "StepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObjectList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList node will be created as follows$")
    public void stepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObjectList/1/StepDefinitionList/1/StepParametersList/1/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "StepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObjectList/1/StepDefinitionList/1/StepParametersList/2/Table/RowList/1/CellList node will be created as follows$")
    public void stepObjectList1StepDefinitionList1StepParametersList2TableRowList1CellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObjectList/1/StepDefinitionList/1/StepParametersList/2/Table/RowList/1/CellList");
        object.assertInputOutputs(dataTable, "StepObjectList1StepDefinitionList1StepParametersList2TableRowList1CellListNode");
    }
}
