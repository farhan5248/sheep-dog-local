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
        object.setInputOutputsState("Created as follows", "LineType");
        object.setInputOutputsDataTable(dataTable, "LineType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file Phrase tag fragment will be decomposed as follows$")
    public void phraseTagFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "PhraseTagFragment");
        object.assertInputOutputsDataTable(dataTable, "PhraseTagFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file Phrase todo fragment will be decomposed as follows$")
    public void phraseTodoFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "PhraseTodoFragment");
        object.assertInputOutputsDataTable(dataTable, "PhraseTodoFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepDefinitionRef part fragment will be decomposed as follows$")
    public void stepDefinitionRefPartFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepDefinitionRefPartFragment");
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionRefPartFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepDefinitionRef state fragment will be decomposed as follows$")
    public void stepDefinitionRefStateFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepDefinitionRefStateFragment");
        object.assertInputOutputsDataTable(dataTable, "StepDefinitionRefStateFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef component fragment will be decomposed as follows$")
    public void stepObjectRefComponentFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepObjectRefComponentFragment");
        object.assertInputOutputsDataTable(dataTable, "StepObjectRefComponentFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object edge fragment will be decomposed as follows$")
    public void stepObjectRefObjectEdgeFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepObjectRefObjectEdgeFragment");
        object.assertInputOutputsDataTable(dataTable, "StepObjectRefObjectEdgeFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object fragment will be decomposed as follows$")
    public void stepObjectRefObjectFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepObjectRefObjectFragment");
        object.assertInputOutputsDataTable(dataTable, "StepObjectRefObjectFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object vertex fragment will be decomposed as follows$")
    public void stepObjectRefObjectVertexFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Decomposed as follows", "StepObjectRefObjectVertexFragment");
        object.assertInputOutputsDataTable(dataTable, "StepObjectRefObjectVertexFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file TestStep type is created as follows$")
    public void testStepTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputsState("Created as follows", "TestStepType");
        object.setInputOutputsDataTable(dataTable, "TestStepType");
    }
}
