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
        object.setInputOutputsState("Created as follows", "CellListNode");
        object.setInputOutputsDataTable(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node will be created as follows$")
    public void cellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "CellListNode");
        object.assertInputOutputsDataTable(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Description node will be as follows$")
    public void descriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "DescriptionNode");
        object.assertInputOutputsDataTable(dataTable, "DescriptionNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file NestedDescription node will be as follows$")
    public void nestedDescriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "NestedDescriptionNode");
        object.assertInputOutputsDataTable(dataTable, "NestedDescriptionNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file RowList node is created as follows$")
    public void rowListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "RowListNode");
        object.setInputOutputsDataTable(dataTable, "RowListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file RowList node will be created as follows$")
    public void rowListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "RowListNode");
        object.assertInputOutputsDataTable(dataTable, "RowListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Table node is created as follows$")
    public void tableNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TableNode");
        object.setInputOutputsDataTable(dataTable, "TableNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Table node will be as follows$")
    public void tableNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TableNode");
        object.assertInputOutputsDataTable(dataTable, "TableNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node is created as follows$")
    public void testDataListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TestDataListNode");
        object.setInputOutputsDataTable(dataTable, "TestDataListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be as follows$")
    public void testDataListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TestDataListNode");
        object.assertInputOutputsDataTable(dataTable, "TestDataListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be created as follows$")
    public void testDataListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "TestDataListNode");
        object.assertInputOutputsDataTable(dataTable, "TestDataListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows$")
    public void testStepContainerListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TestStepContainerListNode");
        object.setInputOutputsDataTable(dataTable, "TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be as follows$")
    public void testStepContainerListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TestStepContainerListNode");
        object.assertInputOutputsDataTable(dataTable, "TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be created as follows$")
    public void testStepContainerListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "TestStepContainerListNode");
        object.assertInputOutputsDataTable(dataTable, "TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows$")
    public void testStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TestStepListNode");
        object.setInputOutputsDataTable(dataTable, "TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be as follows$")
    public void testStepListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TestStepListNode");
        object.assertInputOutputsDataTable(dataTable, "TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be created as follows$")
    public void testStepListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "TestStepListNode");
        object.assertInputOutputsDataTable(dataTable, "TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Text node is created as follows$")
    public void textNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TextNode");
        object.setInputOutputsDataTable(dataTable, "TextNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Text node will be as follows$")
    public void textNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("As follows", "TextNode");
        object.assertInputOutputsDataTable(dataTable, "TextNode");
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
