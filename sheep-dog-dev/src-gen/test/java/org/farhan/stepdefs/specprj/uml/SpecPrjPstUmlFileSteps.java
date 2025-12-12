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
        object.assertInputOutputs(dataTable, "ClassAnnotationsSection");
    }

    @Given("^The spec-prj project uml/pst.uml file Class Comments section will be created as follows$")
    public void classCommentsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ClassCommentsSection");
    }

    @Given("^The spec-prj project uml/pst.uml file Class section will be created as follows$")
    public void classSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ClassSection");
    }

    @Given("^The spec-prj project uml/pst.uml file Class section won't be created as follows$")
    public void classSectionWontBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "ClassSection", true);
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Annotations section will be created as follows$")
    public void interactionAnnotationsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "InteractionAnnotationsSection");
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Comments section will be created as follows$")
    public void interactionCommentsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "InteractionCommentsSection");
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Messages section will be created as follows$")
    public void interactionMessagesSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "InteractionMessagesSection");
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction section will be created as follows$")
    public void interactionSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "InteractionSection");
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction section won't be created as follows$")
    public void interactionSectionWontBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "InteractionSection", true);
    }

    @Given("^The spec-prj project uml/pst.uml file will be present$")
    public void willBePresent() {
        object.assertInputOutputs("Present");
    }
}
