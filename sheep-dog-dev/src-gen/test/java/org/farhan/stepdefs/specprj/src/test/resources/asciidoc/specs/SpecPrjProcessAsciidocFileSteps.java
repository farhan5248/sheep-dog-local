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
        object.assertInputOutputsState("Created as follows", "BackgroundStepsSection");
        object.assertInputOutputsDataTable(dataTable, "BackgroundStepsSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Background section will be created as follows$")
    public void backgroundSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "BackgroundSection");
        object.assertInputOutputsDataTable(dataTable, "BackgroundSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Feature section will be created as follows$")
    public void featureSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "FeatureSection");
        object.assertInputOutputsDataTable(dataTable, "FeatureSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenario Outline Examples Table section will be created as follows$")
    public void scenarioOutlineExamplesTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "ScenarioOutlineExamplesTableSection");
        object.assertInputOutputsDataTable(dataTable, "ScenarioOutlineExamplesTableSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps Doc String section will be created as follows$")
    public void scenariosStepsDocStringSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "ScenariosStepsDocStringSection");
        object.assertInputOutputsDataTable(dataTable, "ScenariosStepsDocStringSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps Step Table section will be created as follows$")
    public void scenariosStepsStepTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "ScenariosStepsStepTableSection");
        object.assertInputOutputsDataTable(dataTable, "ScenariosStepsStepTableSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps section will be created as follows$")
    public void scenariosStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "ScenariosStepsSection");
        object.assertInputOutputsDataTable(dataTable, "ScenariosStepsSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios section will be created as follows$")
    public void scenariosSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "ScenariosSection");
        object.assertInputOutputsDataTable(dataTable, "ScenariosSection");
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
