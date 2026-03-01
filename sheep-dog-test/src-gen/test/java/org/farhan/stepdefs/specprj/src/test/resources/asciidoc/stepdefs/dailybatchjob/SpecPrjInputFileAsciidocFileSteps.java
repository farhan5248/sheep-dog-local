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

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObject node is created as follows$")
    public void stepObjectNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObject");
        object.setInputOutputs(dataTable, "StepObjectNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObject/1 node will be created as follows$")
    public void stepObject1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObject/1");
        object.assertInputOutputs(dataTable, "StepObject1Node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObject/1/StepDefinition node will be created as follows$")
    public void stepObject1StepDefinitionNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObject/1/StepDefinition");
        object.assertInputOutputs(dataTable, "StepObject1StepDefinitionNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObject/1/StepDefinition/1/StepParameters node will be created as follows$")
    public void stepObject1StepDefinition1StepParametersNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObject/1/StepDefinition/1/StepParameters");
        object.assertInputOutputs(dataTable, "StepObject1StepDefinition1StepParametersNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObject/1/StepDefinition/1/StepParameters/1/Table/Row/1/Cell node is created as follows$")
    public void stepObject1StepDefinition1StepParameters1TableRow1CellNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObject/1/StepDefinition/1/StepParameters/1/Table/Row/1/Cell");
        object.setInputOutputs(dataTable, "StepObject1StepDefinition1StepParameters1TableRow1CellNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObject/1/StepDefinition/1/StepParameters/1/Table/Row/1/Cell node will be created as follows$")
    public void stepObject1StepDefinition1StepParameters1TableRow1CellNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObject/1/StepDefinition/1/StepParameters/1/Table/Row/1/Cell");
        object.assertInputOutputs(dataTable, "StepObject1StepDefinition1StepParameters1TableRow1CellNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepObject/1/StepDefinition/1/StepParameters/2/Table/Row/1/Cell node will be created as follows$")
    public void stepObject1StepDefinition1StepParameters2TableRow1CellNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("StepObject/1/StepDefinition/1/StepParameters/2/Table/Row/1/Cell");
        object.assertInputOutputs(dataTable, "StepObject1StepDefinition1StepParameters2TableRow1CellNode");
    }
}
