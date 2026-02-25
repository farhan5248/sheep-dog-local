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

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestStepContainer/1 node is created as follows$")
    public void testSuite1TestStepContainer1NodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestStepContainer/1 node will be created as follows$")
    public void testSuite1TestStepContainer1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestStepContainer/1/TestStep/1 node is created as follows$")
    public void testSuite1TestStepContainer1TestStep1NodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/1/Cell node is created as follows$")
    public void testSuite1TestStepContainer1TestStep1TableRow1CellNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/1/Cell node will be created as follows$")
    public void testSuite1TestStepContainer1TestStep1TableRow1CellNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestStepContainer/1/TestStep/1/Table/Row/2/Cell node is created as follows$")
    public void testSuite1TestStepContainer1TestStep1TableRow2CellNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestStepContainer/1/TestStep/1/Text node is created as follows$")
    public void testSuite1TestStepContainer1TestStep1TextNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file background test step list assignment is created as follows$")
    public void backgroundTestStepListAssignmentIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "BackgroundTestStepListAssignment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file is created as follows$")
    public void isCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file line type is created as follows$")
    public void lineTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "LineType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file phrase tag fragment will be decomposed as follows$")
    public void phraseTagFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "PhraseTagFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file phrase todo fragment will be decomposed as follows$")
    public void phraseTodoFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "PhraseTodoFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file step definition ref part fragment will be decomposed as follows$")
    public void stepDefinitionRefPartFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepDefinitionRefPartFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file step definition ref state fragment will be decomposed as follows$")
    public void stepDefinitionRefStateFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepDefinitionRefStateFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file step object ref component fragment will be decomposed as follows$")
    public void stepObjectRefComponentFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepObjectRefComponentFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file step object ref object edge fragment will be decomposed as follows$")
    public void stepObjectRefObjectEdgeFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepObjectRefObjectEdgeFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file step object ref object fragment will be decomposed as follows$")
    public void stepObjectRefObjectFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepObjectRefObjectFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file step object ref object vertex fragment will be decomposed as follows$")
    public void stepObjectRefObjectVertexFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepObjectRefObjectVertexFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file test step list assignment is created as follows$")
    public void testStepListAssignmentIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestStepListAssignment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file test step type is created as follows$")
    public void testStepTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestStepType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file will be created as follows$")
    public void willBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }
}
