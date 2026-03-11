package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.stepdefs.blah.BlahObjectPageStepsJavaFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class BlahObjectPageStepsJavaFileImpl extends TestObjectFileJavaImpl implements BlahObjectPageStepsJavaFile {

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
	public String getMethodsSectionAnnotation(HashMap<String, String> keyMap) {
		return getMethodAnnotationExistsValue(keyMap.get("Method Name"), keyMap.get("Annotation"));
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
	public String getMethodsSectionStatement(HashMap<String, String> keyMap) {
		return getMethodStatementExistsValue(keyMap.get("Method Name"), keyMap.get("Statement"));
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
	public String getHeaderSectionClassName(HashMap<String, String> keyMap) {
		return getClassNameValue();
	}

	@Override
	public String getHeaderSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getMethodsSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getHeaderSectionExtends(HashMap<String, String> keyMap) {
		return getExtendsValue();
	}

	@Override
	public String getHeaderSectionConstructorName(HashMap<String, String> keyMap) {
		return getConstructorExistsValue(keyMap.get("Constructor Name"));
	}

	@Override
	public String getHeaderSectionStatement(HashMap<String, String> keyMap) {
		return getConstructorStatementValue(keyMap.get("Constructor Name"));
	}

	@Override
	public String getHeaderSectionClassAnnotation(HashMap<String, String> keyMap) {
		return getClassAnnotationExistsValue(keyMap.get("Class Annotation"));
	}

	@Override
	public String getHeaderSectionConstructorAnnotation(HashMap<String, String> keyMap) {
		return getConstructorAnnotationExistsValue(keyMap.get("Constructor Name"), keyMap.get("Constructor Annotation"));
	}

}
