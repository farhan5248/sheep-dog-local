package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.JavaFileObject;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.stepdefs.blah.BlahObjectPageStepsJavaFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class BlahObjectPageStepsJavaFileImpl extends JavaFileObject implements BlahObjectPageStepsJavaFile,
		org.farhan.objects.codeprj.srcgen.test.java.org.farhan.suites.blah.BlahObjectPageStepsJavaFile {

	public void assertContent(HashMap<String, String> keyMap) {
		assertContent(keyMap.get("Content"));
	}

	@Override
	public void assertMethodsSectionAnnotation(HashMap<String, String> keyMap) {
		assertMethodAnnotationExists(keyMap.get("Method Name"), keyMap.get("Annotation"));
	}

	@Override
	public void assertMethodsSectionMethodName(HashMap<String, String> keyMap) {
		assertMethodExists(keyMap.get("Method Name"));
	}

	@Override
	public void assertMethodsSectionParameterName(HashMap<String, String> keyMap) {
		assertMethodParameterExists(keyMap.get("Method Name"), keyMap.get("Parameter Name"));
	}

	@Override
	public void assertMethodsSectionParameterType(HashMap<String, String> keyMap) {
		assertMethodParameterType(keyMap.get("Method Name"), keyMap.get("Parameter Name"),
				keyMap.get("Parameter Type"));
	}

	@Override
	public void assertMethodsSectionReturnType(HashMap<String, String> keyMap) {
		assertMethodReturnType(keyMap.get("Method Name"), keyMap.get("Return Type"));
	}

	@Override
	public void assertMethodsSectionStatement(HashMap<String, String> keyMap) {
		assertMethodStatementExists(keyMap.get("Method Name"), keyMap.get("Statement"));
	}

	@Override
	public void assertMethodsSectionVisibility(HashMap<String, String> keyMap) {
		assertMethodAccessSpecifier(keyMap.get("Method Name"), keyMap.get("Visibility"));
	}

	@Override
	public void assertHeaderSectionImport(HashMap<String, String> keyMap) {
		assertImportExists(keyMap.get("Import"));
	}

	@Override
	public void assertHeaderSectionPackage(HashMap<String, String> keyMap) {
		assertPackage(keyMap.get("Package"));
	}

	@Override
	public void assertPresent(HashMap<String, String> keyMap) {
		assertFileExists();
	}

	public void setContent(HashMap<String, String> keyMap) {
		setContent(keyMap.get("Content"));
	}

	@Override
	public void assertHeaderSectionClassName(HashMap<String, String> keyMap) {
		assertClassNameIs(keyMap.get("Class Name"));
	}

	@Override
	public void assertHeaderSectionExtends(HashMap<String, String> keyMap) {
		assertExtendsIs(keyMap.get("Extends"));
	}

	@Override
	public void assertHeaderSectionConstructorName(HashMap<String, String> keyMap) {
		assertConstructorExists(keyMap.get("Constructor Name"));
	}

	@Override
	public void assertHeaderSectionStatement(HashMap<String, String> keyMap) {
		assertConstructorStatementExists(keyMap.get("Constructor Name"), keyMap.get("Statement"));
	}

	@Override
	public void assertHeaderSectionClassAnnotation(HashMap<String, String> keyMap) {
		assertClassAnnotationExists(keyMap.get("Class Annotation"));
	}

	@Override
	public void assertHeaderSectionConstructorAnnotation(HashMap<String, String> keyMap) {
		assertConstructorAnnotationExists(keyMap.get("Constructor Name"), keyMap.get("Constructor Annotation"));
	}

}
