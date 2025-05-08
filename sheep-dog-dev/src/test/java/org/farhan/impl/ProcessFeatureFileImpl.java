package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.FeatureFileObject;
import org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.app.ProcessFeatureFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessFeatureFileImpl extends FeatureFileObject implements ProcessFeatureFile,
		org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.ProcessFeatureFile {

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
	public void assertFeatureSectionTags(HashMap<String, String> keyMap) {
		assertFeatureTags(keyMap.get("Name"), keyMap.get("Tags"));
	}

	@Override
	public void assertPresent(HashMap<String, String> keyMap) {
		assertFileExists();
	}

	@Override
	public void assertScenarioOutlineExamplesTableSectionDescription(HashMap<String, String> keyMap) {
		assertScenarioOutlineExamplesTableDescription(keyMap.get("Name"), keyMap.get("Examples"),
				keyMap.get("Description"));
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
		assertScenarioOutlineExamplesTableTagsExists(keyMap.get("Name"), keyMap.get("Examples"), keyMap.get("Tags"));
	}

	@Override
	public void assertScenarioOutlinesSectionDescription(HashMap<String, String> keyMap) {
		assertAbstractScenarioDescription(keyMap.get("Name"), keyMap.get("Description"));
	}

	@Override
	public void assertScenarioOutlinesSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenarioOutlinesSectionTags(HashMap<String, String> keyMap) {
		assertAbstractScenarioTags(keyMap.get("Name"), keyMap.get("Tags"));
	}

	@Override
	public void assertScenarioOutlineStepsDataTableSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenarioOutlineStepsDataTableSectionStep(HashMap<String, String> keyMap) {
		assertStepExists(keyMap.get("Name"), keyMap.get("Step"));
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
	public void assertScenariosStepsSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenariosStepsSectionStep(HashMap<String, String> keyMap) {
		assertStepExists(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public void assertScenarioStepsDataTableSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenarioStepsDataTableSectionRow(HashMap<String, String> keyMap) {
		assertAbstractScenarioStepStepTableRowExists(keyMap.get("Name"), keyMap.get("Step"), keyMap.get("Row"));
	}

	@Override
	public void assertScenarioStepsDataTableSectionStep(HashMap<String, String> keyMap) {
		assertStepExists(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public void assertScenarioStepsDocStringSectionContent(HashMap<String, String> keyMap) {
		assertDocString(keyMap.get("Name"), keyMap.get("Step"), keyMap.get("Content"));
	}

	@Override
	public void assertScenarioStepsDocStringSectionName(HashMap<String, String> keyMap) {
		assertAbstractScenarioExists(keyMap.get("Name"));
	}

	@Override
	public void assertScenarioStepsDocStringSectionStep(HashMap<String, String> keyMap) {
		assertStepExists(keyMap.get("Name"), keyMap.get("Step"));
	}

	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

}
