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
        object.setInputOutputsState("Created as follows", "CellList node");
        object.setInputOutputsDataTable(dataTable, "CellList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file CellList node will be created as follows$")
    public void cellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "CellList node");
        object.assertInputOutputsDataTable(dataTable, "CellList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Description node will be as follows$")
    public void descriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "Description node");
        object.assertInputOutputsDataTable(dataTable, "Description node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node is created as follows$")
    public void lineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "LineList node");
        object.setInputOutputsDataTable(dataTable, "LineList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node will be created as follows$")
    public void lineListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "LineList node");
        object.assertInputOutputsDataTable(dataTable, "LineList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file NestedDescription node will be as follows$")
    public void nestedDescriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "NestedDescription node");
        object.assertInputOutputsDataTable(dataTable, "NestedDescription node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows$")
    public void stepDefinitionListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "StepDefinitionList node");
        object.setInputOutputsDataTable(dataTable, "StepDefinitionList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be as follows$")
    public void stepDefinitionListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "StepDefinitionList node");
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows$")
    public void stepDefinitionListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "StepDefinitionList node");
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node is created as follows$")
    public void stepParametersListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "StepParametersList node");
        object.setInputOutputsDataTable(dataTable, "StepParametersList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be as follows$")
    public void stepParametersListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "StepParametersList node");
        object.assertInputOutputsDataTable(dataTable, "StepParametersList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be created as follows$")
    public void stepParametersListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "StepParametersList node");
        object.assertInputOutputsDataTable(dataTable, "StepParametersList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Table node will be as follows$")
    public void tableNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "Table node");
        object.assertInputOutputsDataTable(dataTable, "Table node");
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
