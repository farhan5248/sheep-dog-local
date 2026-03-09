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

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file CellList node is created as follows$")
    public void cellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "CellListNode");
        object.setInputOutputsDataTable(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file CellList node will be created as follows$")
    public void cellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "CellListNode");
        object.assertInputOutputsDataTable(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Description node will be as follows$")
    public void descriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "DescriptionNode");
        object.assertInputOutputsDataTable(dataTable, "DescriptionNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node is created as follows$")
    public void lineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "LineListNode");
        object.setInputOutputsDataTable(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node will be created as follows$")
    public void lineListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "LineListNode");
        object.assertInputOutputsDataTable(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file NestedDescription node will be as follows$")
    public void nestedDescriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "NestedDescriptionNode");
        object.assertInputOutputsDataTable(dataTable, "NestedDescriptionNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows$")
    public void stepDefinitionListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "StepDefinitionListNode");
        object.setInputOutputsDataTable(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be as follows$")
    public void stepDefinitionListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "StepDefinitionListNode");
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows$")
    public void stepDefinitionListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "StepDefinitionListNode");
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node is created as follows$")
    public void stepParametersListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "StepParametersListNode");
        object.setInputOutputsDataTable(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be as follows$")
    public void stepParametersListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "StepParametersListNode");
        object.assertInputOutputsDataTable(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be created as follows$")
    public void stepParametersListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "StepParametersListNode");
        object.assertInputOutputsDataTable(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Table node will be as follows$")
    public void tableNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TableNode");
        object.assertInputOutputsDataTable(dataTable, "TableNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created$")
    public void isCreated() {
        object.setInputOutputsState("Created");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created as follows$")
    public void isCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows");
        object.setInputOutputsDataTable(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file will be created as follows$")
    public void willBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows");
        object.assertInputOutputsDataTable(dataTable);
    }
}
