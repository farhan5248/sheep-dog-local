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
        object.setInputOutputs(dataTable, "LineType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file Phrase tag fragment will be decomposed as follows$")
    public void phraseTagFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "PhraseTagFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file Phrase todo fragment will be decomposed as follows$")
    public void phraseTodoFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "PhraseTodoFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepDefinitionRef part fragment will be decomposed as follows$")
    public void stepDefinitionRefPartFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepDefinitionRefPartFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepDefinitionRef state fragment will be decomposed as follows$")
    public void stepDefinitionRefStateFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepDefinitionRefStateFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef component fragment will be decomposed as follows$")
    public void stepObjectRefComponentFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepObjectRefComponentFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object edge fragment will be decomposed as follows$")
    public void stepObjectRefObjectEdgeFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepObjectRefObjectEdgeFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object fragment will be decomposed as follows$")
    public void stepObjectRefObjectFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepObjectRefObjectFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file StepObjectRef object vertex fragment will be decomposed as follows$")
    public void stepObjectRefObjectVertexFragmentWillBeDecomposedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "StepObjectRefObjectVertexFragment");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarFragment.asciidoc file TestStep type is created as follows$")
    public void testStepTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestStepType");
    }
}
