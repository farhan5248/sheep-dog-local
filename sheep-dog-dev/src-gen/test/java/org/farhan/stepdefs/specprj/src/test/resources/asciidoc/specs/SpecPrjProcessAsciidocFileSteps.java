package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile;

@ScenarioScoped
public class SpecPrjProcessAsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjProcessAsciidocFileSteps(ProcessAsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/specs/Process.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Background Steps section will be created as follows$")
    public void backgroundStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Background Steps section");
        object.assertInputOutputsDataTable(dataTable, "Background Steps section");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Background section will be created as follows$")
    public void backgroundSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Background section");
        object.assertInputOutputsDataTable(dataTable, "Background section");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Feature section will be created as follows$")
    public void featureSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Feature section");
        object.assertInputOutputsDataTable(dataTable, "Feature section");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenario Outline Examples Table section will be created as follows$")
    public void scenarioOutlineExamplesTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenario Outline Examples Table section");
        object.assertInputOutputsDataTable(dataTable, "Scenario Outline Examples Table section");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps Doc String section will be created as follows$")
    public void scenariosStepsDocStringSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenarios Steps Doc String section");
        object.assertInputOutputsDataTable(dataTable, "Scenarios Steps Doc String section");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps Step Table section will be created as follows$")
    public void scenariosStepsStepTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenarios Steps Step Table section");
        object.assertInputOutputsDataTable(dataTable, "Scenarios Steps Step Table section");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps section will be created as follows$")
    public void scenariosStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenarios Steps section");
        object.assertInputOutputsDataTable(dataTable, "Scenarios Steps section");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios section will be created as follows$")
    public void scenariosSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenarios section");
        object.assertInputOutputsDataTable(dataTable, "Scenarios section");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputsState("Created as follows");
        object.setInputOutputsDocString("Content", docString);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file is deleted$")
    public void isDeleted() {
        object.setInputOutputsState("Deleted");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file will be present$")
    public void willBePresent() {
        object.assertInputOutputsState("Present");
    }
}
