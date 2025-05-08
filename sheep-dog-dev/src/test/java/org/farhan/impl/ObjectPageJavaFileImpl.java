package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.JavaFileObject;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah.ObjectPageJavaFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ObjectPageJavaFileImpl extends JavaFileObject
		implements ObjectPageJavaFile {

	public void assertContent(HashMap<String, String> keyMap) {
		assertContent(keyMap.get("Content"));
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
	public void assertMethodsSectionVisibility(HashMap<String, String> keyMap) {
		assertMethodAccessSpecifier(keyMap.get("Method Name"), keyMap.get("Visibility"));
	}

	@Override
	public void assertHeaderSectionImport(HashMap<String, String> keyMap) {
		assertImportExists(keyMap.get("Import"));
	}

	@Override
	public void assertHeaderSectionInterfaceName(HashMap<String, String> keyMap) {
		assertInterfaceNameIs(keyMap.get("Interface Name"));
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
}
