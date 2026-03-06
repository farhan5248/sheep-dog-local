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
        object.setInputOutputsDataTable(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file CellList node will be created as follows$")
    public void cellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node is created as follows$")
    public void lineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsDataTable(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node will be as follows$")
    public void lineListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node will be created as follows$")
    public void lineListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows$")
    public void stepDefinitionListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsDataTable(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be as follows$")
    public void stepDefinitionListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows$")
    public void stepDefinitionListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node is created as follows$")
    public void stepParametersListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsDataTable(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be as follows$")
    public void stepParametersListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be created as follows$")
    public void stepParametersListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestDocumentList node is created as follows$")
    public void testDocumentListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsDataTable(dataTable, "TestDocumentListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestDocumentList node will be created as follows$")
    public void testDocumentListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "TestDocumentListNode");
    }
}
