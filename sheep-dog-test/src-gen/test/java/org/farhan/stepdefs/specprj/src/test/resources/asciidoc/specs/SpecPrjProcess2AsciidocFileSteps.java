package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;

@ScenarioScoped
public class SpecPrjProcess2AsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjProcess2AsciidocFileSteps(Process2AsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/specs/Process2.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file, background steps snippet is created as follows$")
    public void backgroundStepsSnippetIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "BackgroundStepsSnippet");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file, steps snippet is created as follows$")
    public void stepsSnippetIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "StepsSnippet");
    }
}
