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
        object.assertInputOutputsDataTable(dataTable, "BackgroundStepsSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Background section will be created as follows$")
    public void backgroundSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "BackgroundSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Feature section will be created as follows$")
    public void featureSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "FeatureSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows$")
    public void scenarioOutlineExamplesTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "ScenarioOutlineExamplesTableSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Steps Data Table section will be created as follows$")
    public void scenarioOutlineStepsDataTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "ScenarioOutlineStepsDataTableSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outlines section will be created as follows$")
    public void scenarioOutlinesSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "ScenarioOutlinesSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Steps Data Table section will be created as follows$")
    public void scenarioStepsDataTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "ScenarioStepsDataTableSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Steps Doc String section will be created as follows$")
    public void scenarioStepsDocStringSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "ScenarioStepsDocStringSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows$")
    public void scenariosStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "ScenariosStepsSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenarios section will be created as follows$")
    public void scenariosSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsDataTable(dataTable, "ScenariosSection");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputsDocString("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertInputOutputsDocString("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file will be present$")
    public void willBePresent() {
        object.assertInputOutputsState("Present");
    }
}
