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
        object.assertInputOutputsState("Created as follows", "Background Steps section");
        object.assertInputOutputsDataTable(dataTable, "Background Steps section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Background section will be created as follows$")
    public void backgroundSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Background section");
        object.assertInputOutputsDataTable(dataTable, "Background section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Feature section will be created as follows$")
    public void featureSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Feature section");
        object.assertInputOutputsDataTable(dataTable, "Feature section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Examples Table section will be created as follows$")
    public void scenarioOutlineExamplesTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenario Outline Examples Table section");
        object.assertInputOutputsDataTable(dataTable, "Scenario Outline Examples Table section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outline Steps Data Table section will be created as follows$")
    public void scenarioOutlineStepsDataTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenario Outline Steps Data Table section");
        object.assertInputOutputsDataTable(dataTable, "Scenario Outline Steps Data Table section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Outlines section will be created as follows$")
    public void scenarioOutlinesSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenario Outlines section");
        object.assertInputOutputsDataTable(dataTable, "Scenario Outlines section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Steps Data Table section will be created as follows$")
    public void scenarioStepsDataTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenario Steps Data Table section");
        object.assertInputOutputsDataTable(dataTable, "Scenario Steps Data Table section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenario Steps Doc String section will be created as follows$")
    public void scenarioStepsDocStringSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenario Steps Doc String section");
        object.assertInputOutputsDataTable(dataTable, "Scenario Steps Doc String section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenarios Steps section will be created as follows$")
    public void scenariosStepsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenarios Steps section");
        object.assertInputOutputsDataTable(dataTable, "Scenarios Steps section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file Scenarios section will be created as follows$")
    public void scenariosSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Scenarios section");
        object.assertInputOutputsDataTable(dataTable, "Scenarios section");
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputsState("Created as follows");
        object.setInputOutputsDocString("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertInputOutputsState("Created as follows");
        object.assertInputOutputsDocString("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/resources/cucumber/specs/Process.feature file will be present$")
    public void willBePresent() {
        object.assertInputOutputsState("Present");
    }
}
