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

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Description node will be as follows$")
    public void descriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("Description", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be as follows$")
    public void stepDefinitionListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("StepDefinitionList", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file is created$")
    public void isCreated() {
        object.setVertexStep("", "", "is", "created");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node is created as follows$")
    public void stepDefinitionListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("StepDefinitionList", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepDefinitionList node will be created as follows$")
    public void stepDefinitionListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("StepDefinitionList", "node", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be as follows$")
    public void stepParametersListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("StepParametersList", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node is created as follows$")
    public void stepParametersListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("StepParametersList", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file StepParametersList node will be created as follows$")
    public void stepParametersListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("StepParametersList", "node", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/daily batchjob/Input file.asciidoc file Table node will be as follows$")
    public void tableNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("Table", "node", "will be", "as follows", dataTable);
    }
}
