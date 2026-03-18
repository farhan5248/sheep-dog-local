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

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Description node will be as follows$")
    public void descriptionNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("Description", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be as follows$")
    public void testStepContainerListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("TestStepContainerList", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file is created$")
    public void isCreated() {
        object.setVertexStep("", "", "is", "created");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node is created as follows$")
    public void testStepContainerListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("TestStepContainerList", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepContainerList node will be created as follows$")
    public void testStepContainerListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("TestStepContainerList", "node", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be as follows$")
    public void testDataListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("TestDataList", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be as follows$")
    public void testStepListNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("TestStepList", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Table node will be as follows$")
    public void tableNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("Table", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node is created as follows$")
    public void testDataListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("TestDataList", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestDataList node will be created as follows$")
    public void testDataListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("TestDataList", "node", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node is created as follows$")
    public void testStepListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("TestStepList", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file TestStepList node will be created as follows$")
    public void testStepListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("TestStepList", "node", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Text node will be as follows$")
    public void textNodeWillBeAsFollows(DataTable dataTable) {
        object.assertVertexStep("Text", "node", "will be", "as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Table node is created as follows$")
    public void tableNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("Table", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file Text node is created as follows$")
    public void textNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("Text", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file RowList node is created as follows$")
    public void rowListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("RowList", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file RowList node will be created as follows$")
    public void rowListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("RowList", "node", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node is created as follows$")
    public void cellListNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("CellList", "node", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file CellList node will be created as follows$")
    public void cellListNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("CellList", "node", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file is created as follows$")
    public void isCreatedAsFollows(DataTable dataTable) {
        object.setVertexStep("", "", "is", "created as follows", dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessIssues.asciidoc file will be created as follows$")
    public void willBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("", "", "will be", "created as follows", dataTable);
    }
}
