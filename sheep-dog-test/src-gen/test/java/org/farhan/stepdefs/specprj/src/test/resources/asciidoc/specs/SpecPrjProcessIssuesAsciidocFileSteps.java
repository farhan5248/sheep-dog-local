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
        object.setInputOutputs(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node will be created as follows$")
    public void cellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "CellListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file LineList node is created as follows$")
    public void lineListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file LineList node will be as follows$")
    public void lineListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file LineList node will be created as follows$")
    public void lineListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "LineListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file RowList node is created as follows$")
    public void rowListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "RowListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file RowList node will be created as follows$")
    public void rowListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "RowListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node is created as follows$")
    public void testDataListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestDataListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be as follows$")
    public void testDataListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "TestDataListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be created as follows$")
    public void testDataListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "TestDataListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDocumentList node is created as follows$")
    public void testDocumentListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestDocumentListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDocumentList node will be created as follows$")
    public void testDocumentListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "TestDocumentListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows$")
    public void testStepContainerListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be as follows$")
    public void testStepContainerListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be created as follows$")
    public void testStepContainerListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "TestStepContainerListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows$")
    public void testStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be as follows$")
    public void testStepListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be created as follows$")
    public void testStepListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "TestStepListNode");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Text node is created as follows$")
    public void textNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TextNode");
    }
}
