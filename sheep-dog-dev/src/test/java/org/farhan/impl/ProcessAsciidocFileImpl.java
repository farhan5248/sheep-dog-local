package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.AdocFileObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.app.ProcessAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessAsciidocFileImpl extends AdocFileObject implements ProcessAsciidocFile,
		org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile {

	@Override
	public String getBackgroundSectionDescription(HashMap<String, String> keyMap) {
		return getAbstractScenarioDescriptionValue(keyMap.get("Name"));
	}

	@Override
	public String getBackgroundSectionName(HashMap<String, String> keyMap) {
		return getAbstractScenarioExistsValue(keyMap.get("Name"));
	}

	@Override
	public String getBackgroundStepsSectionName(HashMap<String, String> keyMap) {
		return getAbstractScenarioExistsValue(keyMap.get("Name"));
	}

	@Override
	public String getBackgroundStepsSectionStep(HashMap<String, String> keyMap) {
		return getStepExistsValue(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public String getContent(HashMap<String, String> keyMap) {
		return getContent();
	}

	@Override
	public String getCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getFeatureSectionName(HashMap<String, String> keyMap) {
		return getFeatureNameValue();
	}

	@Override
	public String getFeatureSectionStatements(HashMap<String, String> keyMap) {
		return getFeatureStatementsValue();
	}

	@Override
	public String getPresent(HashMap<String, String> keyMap) {
		return getTestSuiteExistsValue();
	}

	@Override
	public String getScenarioOutlineExamplesTableSectionDescription(HashMap<String, String> keyMap) {
		return getScenarioOutlineExamplesTableDescriptionValue(keyMap.get("Name"), keyMap.get("Examples"));
	}

	@Override
	public String getScenarioOutlineExamplesTableSectionExamples(HashMap<String, String> keyMap) {
		return getScenarioOutlineExamplesExistsValue(keyMap.get("Name"), keyMap.get("Examples"));
	}

	@Override
	public String getScenarioOutlineExamplesTableSectionName(HashMap<String, String> keyMap) {
		return getAbstractScenarioExistsValue(keyMap.get("Name"));
	}

	@Override
	public String getScenarioOutlineExamplesTableSectionRow(HashMap<String, String> keyMap) {
		return getScenarioOutlineExamplesTableRowExistsValue(keyMap.get("Name"), keyMap.get("Examples"), keyMap.get("Row"));
	}

	@Override
	public String getScenarioOutlineExamplesTableSectionTags(HashMap<String, String> keyMap) {
		return getExamplesTagsValue(keyMap.get("Name"), keyMap.get("Examples"));
	}

	@Override
	public String getScenariosSectionDescription(HashMap<String, String> keyMap) {
		return getAbstractScenarioDescriptionValue(keyMap.get("Name"));
	}

	@Override
	public String getScenariosSectionName(HashMap<String, String> keyMap) {
		return getAbstractScenarioExistsValue(keyMap.get("Name"));
	}

	@Override
	public String getScenariosSectionTags(HashMap<String, String> keyMap) {
		return getAbstractScenarioTagsValue(keyMap.get("Name"));
	}

	@Override
	public String getScenariosStepsDocStringSectionContent(HashMap<String, String> keyMap) {
		return getDocStringValue(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public String getScenariosStepsDocStringSectionName(HashMap<String, String> keyMap) {
		return getAbstractScenarioExistsValue(keyMap.get("Name"));
	}

	@Override
	public String getScenariosStepsDocStringSectionStep(HashMap<String, String> keyMap) {
		return getStepExistsValue(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public String getScenariosStepsSectionName(HashMap<String, String> keyMap) {
		return getAbstractScenarioExistsValue(keyMap.get("Name"));
	}

	@Override
	public String getScenariosStepsSectionStep(HashMap<String, String> keyMap) {
		return getStepExistsValue(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public String getScenariosStepsStepTableSectionName(HashMap<String, String> keyMap) {
		return getAbstractScenarioExistsValue(keyMap.get("Name"));
	}

	@Override
	public String getScenariosStepsStepTableSectionRow(HashMap<String, String> keyMap) {
		return getAbstractScenarioStepStepTableRowExistsValue(keyMap.get("Name"), keyMap.get("Step"), keyMap.get("Row"));
	}

	@Override
	public String getScenariosStepsStepTableSectionStep(HashMap<String, String> keyMap) {
		return getStepExistsValue(keyMap.get("Name"), keyMap.get("Step"));
	}

	@Override
	public String getBackgroundSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getBackgroundStepsSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getFeatureSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getScenarioOutlineExamplesTableSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getScenariosSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getScenariosStepsDocStringSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getScenariosStepsSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getScenariosStepsStepTableSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

	@Override
	public void setCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
	}

	@Override
	public void setDeleted(HashMap<String, String> keyMap) {
		deleteObject();
	}

}
