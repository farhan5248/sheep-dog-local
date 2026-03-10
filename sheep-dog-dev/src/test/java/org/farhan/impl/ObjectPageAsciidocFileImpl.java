package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.AdocFileObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectPageAsciidocFileImpl extends AdocFileObject implements ObjectPageAsciidocFile {

	@Override
	public String getHeaderSectionName(HashMap<String, String> keyMap) {
		return getStepObjectNameValue();
	}

	@Override
	public String getHeaderSectionStatements(HashMap<String, String> keyMap) {
		return getStepObjectStatementsValue();
	}

	@Override
	public String getPresent(HashMap<String, String> keyMap) {
		return getStepObjectExistsValue();
	}

	@Override
	public String getStepDefinitionParametersTableSectionName(HashMap<String, String> keyMap) {
		return getStepDefinitionExistsValue(keyMap.get("Name"));
	}

	@Override
	public String getStepDefinitionParametersTableSectionParameters(HashMap<String, String> keyMap) {
		return getStepDefinitionParametersExistsValue(keyMap.get("Name"), keyMap.get("Parameters"));
	}

	@Override
	public String getStepDefinitionParametersTableSectionRow(HashMap<String, String> keyMap) {
		return getStepDefinitionParametersTableRowExistsValue(keyMap.get("Name"), keyMap.get("Parameters"), keyMap.get("Row"));
	}

	@Override
	public String getStepDefinitionSectionDescription(HashMap<String, String> keyMap) {
		return getStepDefinitionDescriptionValue(keyMap.get("Name"));
	}

	@Override
	public String getStepDefinitionSectionName(HashMap<String, String> keyMap) {
		return getStepDefinitionExistsValue(keyMap.get("Name"));
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
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
	public void setCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
	}

	@Override
	public String getHeaderSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getStepDefinitionSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getStepDefinitionParametersTableSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public void setDeleted(HashMap<String, String> keyMap) {
		deleteObject();
	}

}
