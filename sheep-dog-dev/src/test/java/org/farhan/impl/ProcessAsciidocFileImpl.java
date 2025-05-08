package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.AdocFileObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.app.ProcessAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessAsciidocFileImpl extends AdocFileObject implements ProcessAsciidocFile,
		org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile {

	@Override
	public void assertBackgroundSectionDescription(HashMap<String, String> keyMap) {
		assertAbstractScenarioDescription(keyMap.get("Name"), keyMap.get("Description"));
	}

	@Override
	public void assertBackgroundSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertBackgroundStepsSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertBackgroundStepsSectionStep(HashMap<String, String> keyMap) {
		assertStepExists(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public void assertContent(HashMap<String, String> keyMap) {
		assertContent(keyMap.get("Content"));
	}

	@Override
	public void assertFeatureSectionName(HashMap<String, String> keyMap) {
		assertFeatureName(keyMap.get("Name"));
	}

	@Override
	public void assertFeatureSectionStatements(HashMap<String, String> keyMap) {
		assertFeatureStatements(keyMap.get("Name"), keyMap.get("Statements"));
	}

	@Override
	public void assertPresent(HashMap<String, String> keyMap) {
		assertTestSuiteExists();
	}

	@Override
	public void assertScenarioOutlineExamplesTableSectionDescription(HashMap<String, String> keyMap) {
		assertScenarioOutlineExamplesTableDescription(keyMap.get("Name"), keyMap.get("Examples"), keyMap.get("Description"));
	}

	@Override
	public void assertScenarioOutlineExamplesTableSectionExamples(HashMap<String, String> keyMap) {
		assertScenarioOutlineExamplesExists(keyMap.get("Name"), keyMap.get("Examples"));
	}

	@Override
	public void assertScenarioOutlineExamplesTableSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenarioOutlineExamplesTableSectionRow(HashMap<String, String> keyMap) {
		assertScenarioOutlineExamplesTableRowExists(keyMap.get("Name"), keyMap.get("Examples"), keyMap.get("Row"));
	}

	@Override
	public void assertScenarioOutlineExamplesTableSectionTags(HashMap<String, String> keyMap) {
		// TODO example tags are in the description generated from asciidoc. For
		// additional tags not in the description, this should assert that it's there
	}

	@Override
	public void assertScenariosSectionDescription(HashMap<String, String> keyMap) {
		assertAbstractScenarioDescription(keyMap.get("Name"), keyMap.get("Description"));
	}

	@Override
	public void assertScenariosSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenariosSectionTags(HashMap<String, String> keyMap) {
		assertAbstractScenarioTags(keyMap.get("Name"), keyMap.get("Tags"));
	}

	@Override
	public void assertScenariosStepsDocStringSectionContent(HashMap<String, String> keyMap) {
		assertDocString(keyMap.get("Name"), keyMap.get("Step"), keyMap.get("Content"));
	}

	@Override
	public void assertScenariosStepsDocStringSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenariosStepsDocStringSectionStep(HashMap<String, String> keyMap) {
		assertStepExists(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public void assertScenariosStepsSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenariosStepsSectionStep(HashMap<String, String> keyMap) {
		assertStepExists(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public void assertScenariosStepsStepTableSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenariosStepsStepTableSectionRow(HashMap<String, String> keyMap) {
		assertAbstractScenarioStepStepTableRowExists(keyMap.get("Name"), keyMap.get("Step"), keyMap.get("Row"));
	}

	@Override
	public void assertScenariosStepsStepTableSectionStep(HashMap<String, String> keyMap) {
		assertStepExists(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

	@Override
	public void setDeleted(HashMap<String, String> keyMap) {
		deleteObject();
	}

}
