package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

@ScenarioScoped
public class SpecPrjProcessIssuesAsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjProcessIssuesAsciidocFileSteps(ProcessIssuesAsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/specs/ProcessIssues.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node is created as follows$")
    public void cellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "CellList node");
        object.setInputOutputsDataTable(dataTable, "CellList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node will be created as follows$")
    public void cellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "CellList node");
        object.assertInputOutputsDataTable(dataTable, "CellList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Description node will be as follows$")
    public void descriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "Description node");
        object.assertInputOutputsDataTable(dataTable, "Description node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file NestedDescription node will be as follows$")
    public void nestedDescriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "NestedDescription node");
        object.assertInputOutputsDataTable(dataTable, "NestedDescription node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file RowList node is created as follows$")
    public void rowListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "RowList node");
        object.setInputOutputsDataTable(dataTable, "RowList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file RowList node will be created as follows$")
    public void rowListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "RowList node");
        object.assertInputOutputsDataTable(dataTable, "RowList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Table node is created as follows$")
    public void tableNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "Table node");
        object.setInputOutputsDataTable(dataTable, "Table node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Table node will be as follows$")
    public void tableNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "Table node");
        object.assertInputOutputsDataTable(dataTable, "Table node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node is created as follows$")
    public void testDataListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TestDataList node");
        object.setInputOutputsDataTable(dataTable, "TestDataList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be as follows$")
    public void testDataListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TestDataList node");
        object.assertInputOutputsDataTable(dataTable, "TestDataList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be created as follows$")
    public void testDataListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "TestDataList node");
        object.assertInputOutputsDataTable(dataTable, "TestDataList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows$")
    public void testStepContainerListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TestStepContainerList node");
        object.setInputOutputsDataTable(dataTable, "TestStepContainerList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be as follows$")
    public void testStepContainerListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TestStepContainerList node");
        object.assertInputOutputsDataTable(dataTable, "TestStepContainerList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be created as follows$")
    public void testStepContainerListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "TestStepContainerList node");
        object.assertInputOutputsDataTable(dataTable, "TestStepContainerList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows$")
    public void testStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TestStepList node");
        object.setInputOutputsDataTable(dataTable, "TestStepList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be as follows$")
    public void testStepListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TestStepList node");
        object.assertInputOutputsDataTable(dataTable, "TestStepList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be created as follows$")
    public void testStepListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "TestStepList node");
        object.assertInputOutputsDataTable(dataTable, "TestStepList node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Text node is created as follows$")
    public void textNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "Text node");
        object.setInputOutputsDataTable(dataTable, "Text node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Text node will be as follows$")
    public void textNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "Text node");
        object.assertInputOutputsDataTable(dataTable, "Text node");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file is created$")
    public void isCreated() {
        object.setInputOutputsState("Created");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file is created as follows$")
    public void isCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows");
        object.setInputOutputsDataTable(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file will be created as follows$")
    public void willBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows");
        object.assertInputOutputsDataTable(dataTable);
    }
}
