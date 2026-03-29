package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah.ObjectPageJavaFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectPageJavaFileImpl extends TestObjectFileJavaImpl
		implements ObjectPageJavaFile {

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
	public String getMethodsSectionMethodName(HashMap<String, String> keyMap) {
		return getMethodExistsValue(keyMap.get("Method Name"));
	}

	@Override
	public String getMethodsSectionParameterName(HashMap<String, String> keyMap) {
		return getMethodParameterExistsValue(keyMap.get("Method Name"), keyMap.get("Parameter Name"));
	}

	@Override
	public String getMethodsSectionParameterType(HashMap<String, String> keyMap) {
		return getMethodParameterTypeValue(keyMap.get("Method Name"), keyMap.get("Parameter Name"));
	}

	@Override
	public String getMethodsSectionReturnType(HashMap<String, String> keyMap) {
		return getMethodReturnTypeValue(keyMap.get("Method Name"));
	}

	@Override
	public String getMethodsSectionVisibility(HashMap<String, String> keyMap) {
		return getMethodAccessSpecifierValue(keyMap.get("Method Name"));
	}

	@Override
	public String getHeaderSectionImport(HashMap<String, String> keyMap) {
		return getImportExistsValue(keyMap.get("Import"));
	}

	@Override
	public String getHeaderSectionInterfaceName(HashMap<String, String> keyMap) {
		return getInterfaceNameValue();
	}

	@Override
	public String getHeaderSectionPackage(HashMap<String, String> keyMap) {
		return getPackageValue();
	}

	@Override
	public String getPresent(HashMap<String, String> keyMap) {
		return getFileExistsValue();
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
	public String getMethodsSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getHeaderSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}
}
