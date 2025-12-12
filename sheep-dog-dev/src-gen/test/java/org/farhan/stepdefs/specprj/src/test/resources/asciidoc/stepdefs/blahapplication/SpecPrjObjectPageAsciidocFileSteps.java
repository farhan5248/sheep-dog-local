package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.stepdefs.blahapplication;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;

@ScenarioScoped
public class SpecPrjObjectPageAsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjObjectPageAsciidocFileSteps(ObjectPageAsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Header section will be created as follows$")
    public void headerSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "HeaderSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Step Definition Parameters Table section will be created as follows$")
    public void stepDefinitionParametersTableSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepDefinitionParametersTableSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file Step Definition section will be created as follows$")
    public void stepDefinitionSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepDefinitionSection");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputs("Content", docString);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file is deleted$")
    public void isDeleted() {
        object.setInputOutputs("Deleted");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertInputOutputs("Content", docString);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/stepdefs/blah application/Object page.asciidoc file will be present$")
    public void willBePresent() {
        object.assertInputOutputs("Present");
    }
}
