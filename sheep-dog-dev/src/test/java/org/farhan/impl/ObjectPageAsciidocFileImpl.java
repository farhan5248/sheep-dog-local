package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.AdocFileObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectPageAsciidocFileImpl extends AdocFileObject implements ObjectPageAsciidocFile {

	@Override
	public void assertHeaderSectionName(HashMap<String, String> keyMap) {
		assertStepObjectName(keyMap.get("Name"));
	}

	@Override
	public void assertHeaderSectionStatements(HashMap<String, String> keyMap) {
		assertStepObjectStatements(keyMap.get("Name"), keyMap.get("Statements"));
	}

	@Override
	public void assertPresent(HashMap<String, String> keyMap) {
		assertStepObjectExists();
	}

	@Override
	public void assertStepDefinitionParametersTableSectionName(HashMap<String, String> keyMap) {
		assertStepDefinitionExists(keyMap.get("Name"));
	}

	@Override
	public void assertStepDefinitionParametersTableSectionParameters(HashMap<String, String> keyMap) {
		assertStepDefinitionParametersExists(keyMap.get("Name"), keyMap.get("Parameters"));
	}

	@Override
	public void assertStepDefinitionParametersTableSectionRow(HashMap<String, String> keyMap) {
		assertStepDefinitionParametersTableRowExists(keyMap.get("Name"), keyMap.get("Parameters"), keyMap.get("Row"));
	}

	@Override
	public void assertStepDefinitionSectionDescription(HashMap<String, String> keyMap) {
		assertStepDefinitionDescription(keyMap.get("Name"), keyMap.get("Description"));
	}

	@Override
	public void assertStepDefinitionSectionName(HashMap<String, String> keyMap) {
		assertStepDefinitionExists(keyMap.get("Name"));
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

	@Override
	public void assertContent(HashMap<String, String> keyMap) {
		assertContent(keyMap.get("Content"));
	}

	@Override
	public void setDeleted(HashMap<String, String> keyMap) {
		deleteObject();
	}

}
