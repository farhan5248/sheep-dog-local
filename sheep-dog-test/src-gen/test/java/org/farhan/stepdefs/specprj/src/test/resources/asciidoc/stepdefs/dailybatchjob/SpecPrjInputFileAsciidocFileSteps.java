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
        object.setInputOutputs(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file CellList node will be created as follows$")
    public void cellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node is created as follows$")
    public void lineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node will be as follows$")
    public void lineListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file LineList node will be created as follows$")
    public void lineListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows$")
    public void stepDefinitionListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be as follows$")
    public void stepDefinitionListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows$")
    public void stepDefinitionListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepDefinitionListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node is created as follows$")
    public void stepParametersListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be as follows$")
    public void stepParametersListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be created as follows$")
    public void stepParametersListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepParametersListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestDocumentList node is created as follows$")
    public void testDocumentListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestDocumentListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file TestDocumentList node will be created as follows$")
    public void testDocumentListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "TestDocumentListNode");
    }
}
