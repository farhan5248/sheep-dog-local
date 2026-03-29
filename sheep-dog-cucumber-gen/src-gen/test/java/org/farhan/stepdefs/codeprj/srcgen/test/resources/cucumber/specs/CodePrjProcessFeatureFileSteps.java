package org.farhan.stepdefs.codeprj.srcgen.test.resources.cucumber.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.ProcessFeatureFile;

@ScenarioScoped
public class CodePrjProcessFeatureFileSteps extends TestSteps {

    @Inject
    public CodePrjProcessFeatureFileSteps(ProcessFeatureFile object) {
        super(object, "code-prj", "src-gen/test/resources/cucumber/specs/Process.feature");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Background Steps section will be created as follows$")
    public void backgroundStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Background Steps", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Background section will be created as follows$")
    public void backgroundSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Background", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Feature section will be created as follows$")
    public void featureSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Feature", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows$")
    public void scenarioOutlineExamplesTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Scenario Outline Examples Table", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Steps Data Table section will be created as follows$")
    public void scenarioOutlineStepsDataTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Scenario Outline Steps Data Table", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outlines section will be created as follows$")
    public void scenarioOutlinesSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Scenario Outlines", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Steps Data Table section will be created as follows$")
    public void scenarioStepsDataTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Scenario Steps Data Table", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Steps Doc String section will be created as follows$")
    public void scenarioStepsDocStringSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Scenario Steps Doc String", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows$")
    public void scenariosStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Scenarios Steps", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenarios section will be created as follows$")
    public void scenariosSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Scenarios", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setVertexStep("", "", "is", "created as follows", docString);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertVertexStep("", "", "will be", "created as follows", docString);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file will be present$")
    public void willBePresent() {
        object.assertVertexStep("", "", "will be", "present");
    }
}
