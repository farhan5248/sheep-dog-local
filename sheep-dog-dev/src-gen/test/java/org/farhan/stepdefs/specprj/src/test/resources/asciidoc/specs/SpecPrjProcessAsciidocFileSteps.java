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
        object.assertInputOutputs(dataTable, "BackgroundStepsSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Background section will be created as follows$")
    public void backgroundSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "BackgroundSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Feature section will be created as follows$")
    public void featureSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "FeatureSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenario Outline Examples Table section will be created as follows$")
    public void scenarioOutlineExamplesTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenarioOutlineExamplesTableSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps Doc String section will be created as follows$")
    public void scenariosStepsDocStringSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenariosStepsDocStringSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps Step Table section will be created as follows$")
    public void scenariosStepsStepTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenariosStepsStepTableSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios Steps section will be created as follows$")
    public void scenariosStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenariosStepsSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file Scenarios section will be created as follows$")
    public void scenariosSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenariosSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputs("Content", docString);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file is deleted$")
    public void isDeleted() {
        object.setInputOutputs("Deleted");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process.asciidoc file will be present$")
    public void willBePresent() {
        object.assertInputOutputs("Present");
    }
}
