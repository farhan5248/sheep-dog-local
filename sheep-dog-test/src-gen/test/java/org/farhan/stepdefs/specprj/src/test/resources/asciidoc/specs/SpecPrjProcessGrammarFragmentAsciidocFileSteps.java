package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarFragmentAsciidocFile;

@ScenarioScoped
public class SpecPrjProcessGrammarFragmentAsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjProcessGrammarFragmentAsciidocFileSteps(ProcessGrammarFragmentAsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file Line type is created as follows$")
    public void lineTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "Line type");
        object.setInputOutputsDataTable(dataTable, "Line type");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file Phrase tag fragment will be decomposed as follows$")
    public void phraseTagFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "Phrase tag fragment");
        object.assertInputOutputsDataTable(dataTable, "Phrase tag fragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file Phrase todo fragment will be decomposed as follows$")
    public void phraseTodoFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "Phrase todo fragment");
        object.assertInputOutputsDataTable(dataTable, "Phrase todo fragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepDefinitionRef part fragment will be decomposed as follows$")
    public void stepDefinitionRefPartFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepDefinitionRef part fragment");
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionRef part fragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepDefinitionRef state fragment will be decomposed as follows$")
    public void stepDefinitionRefStateFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepDefinitionRef state fragment");
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionRef state fragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef component fragment will be decomposed as follows$")
    public void stepObjectRefComponentFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepObjectRef component fragment");
        object.assertInputOutputsDataTable(dataTable, "StepObjectRef component fragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object edge fragment will be decomposed as follows$")
    public void stepObjectRefObjectEdgeFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepObjectRef object edge fragment");
        object.assertInputOutputsDataTable(dataTable, "StepObjectRef object edge fragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object fragment will be decomposed as follows$")
    public void stepObjectRefObjectFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepObjectRef object fragment");
        object.assertInputOutputsDataTable(dataTable, "StepObjectRef object fragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object vertex fragment will be decomposed as follows$")
    public void stepObjectRefObjectVertexFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepObjectRef object vertex fragment");
        object.assertInputOutputsDataTable(dataTable, "StepObjectRef object vertex fragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file TestStep type is created as follows$")
    public void testStepTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TestStep type");
        object.setInputOutputsDataTable(dataTable, "TestStep type");
    }
}
