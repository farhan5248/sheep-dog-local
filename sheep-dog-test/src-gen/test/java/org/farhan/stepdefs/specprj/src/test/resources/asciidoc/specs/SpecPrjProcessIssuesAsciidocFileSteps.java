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
}
