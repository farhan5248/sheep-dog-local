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
        object.assertInputOutputsState("Created as follows", "Class Annotations section");
        object.assertInputOutputsDataTable(dataTable, "Class Annotations section");
    }

    @Given("^The spec-prj project uml/pst.uml file Class Comments section will be created as follows$")
    public void classCommentsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Class Comments section");
        object.assertInputOutputsDataTable(dataTable, "Class Comments section");
    }

    @Given("^The spec-prj project uml/pst.uml file Class section will be created as follows$")
    public void classSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Class section");
        object.assertInputOutputsDataTable(dataTable, "Class section");
    }

    @Given("^The spec-prj project uml/pst.uml file Class section won't be created as follows$")
    public void classSectionWontBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Class section", true);
        object.assertInputOutputsDataTable(dataTable, "Class section", true);
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Annotations section will be created as follows$")
    public void interactionAnnotationsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Interaction Annotations section");
        object.assertInputOutputsDataTable(dataTable, "Interaction Annotations section");
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Comments section will be created as follows$")
    public void interactionCommentsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Interaction Comments section");
        object.assertInputOutputsDataTable(dataTable, "Interaction Comments section");
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction Messages section will be created as follows$")
    public void interactionMessagesSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Interaction Messages section");
        object.assertInputOutputsDataTable(dataTable, "Interaction Messages section");
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction section will be created as follows$")
    public void interactionSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Interaction section");
        object.assertInputOutputsDataTable(dataTable, "Interaction section");
    }

    @Given("^The spec-prj project uml/pst.uml file Interaction section won't be created as follows$")
    public void interactionSectionWontBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Interaction section", true);
        object.assertInputOutputsDataTable(dataTable, "Interaction section", true);
    }

    @Given("^The spec-prj project uml/pst.uml file will be present$")
    public void willBePresent() {
        object.assertInputOutputsState("Present");
    }
}
