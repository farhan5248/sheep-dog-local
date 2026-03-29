package org.farhan.stepdefs.specprj.uml;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.uml.PstUmlFile;

@ScenarioScoped
public class SpecPrjPstUmlFileSteps extends TestSteps {

    @Inject
    public SpecPrjPstUmlFileSteps(PstUmlFile object) {
        super(object, "spec-prj", "uml/pst.uml");
    }

    @Given("^The spec-prj project uml/pst.uml file Class Annotations section will be created as follows$")
    public void classAnnotationsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Class Annotations", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file Class Comments section will be created as follows$")
    public void classCommentsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Class Comments", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file Class section will be created as follows$")
    public void classSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Class", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file Class section won't be created as follows$")
    public void classSectionWontBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Class", "section", "won't be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Annotations section will be created as follows$")
    public void interactionAnnotationsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Interaction Annotations", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Comments section will be created as follows$")
    public void interactionCommentsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Interaction Comments", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Messages section will be created as follows$")
    public void interactionMessagesSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Interaction Messages", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction section will be created as follows$")
    public void interactionSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Interaction", "section", "will be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction section won't be created as follows$")
    public void interactionSectionWontBeCreatedAsFollows(DataTable dataTable) {
        object.assertVertexStep("Interaction", "section", "won't be", "created as follows", dataTable);
    }

    @Given("^The spec-prj project uml/pst.uml file will be present$")
    public void willBePresent() {
        object.assertVertexStep("", "", "will be", "present");
    }
}
