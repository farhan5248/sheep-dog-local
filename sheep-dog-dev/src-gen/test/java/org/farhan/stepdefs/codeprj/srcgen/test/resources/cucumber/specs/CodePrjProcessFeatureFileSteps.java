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
        object.assertInputOutputs(dataTable, "BackgroundStepsSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Background section will be created as follows$")
    public void backgroundSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "BackgroundSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Feature section will be created as follows$")
    public void featureSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "FeatureSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows$")
    public void scenarioOutlineExamplesTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenarioOutlineExamplesTableSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Steps Data Table section will be created as follows$")
    public void scenarioOutlineStepsDataTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenarioOutlineStepsDataTableSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outlines section will be created as follows$")
    public void scenarioOutlinesSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenarioOutlinesSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Steps Data Table section will be created as follows$")
    public void scenarioStepsDataTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenarioStepsDataTableSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Steps Doc String section will be created as follows$")
    public void scenarioStepsDocStringSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenarioStepsDocStringSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows$")
    public void scenariosStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenariosStepsSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenarios section will be created as follows$")
    public void scenariosSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ScenariosSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputs("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertInputOutputs("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file will be present$")
    public void willBePresent() {
        object.assertInputOutputs("Present");
    }
}
