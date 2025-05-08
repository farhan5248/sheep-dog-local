package org.farhan.mbt.asciidoctor;

import org.farhan.mbt.core.UMLStepObject;
import org.farhan.mbt.core.UMLTestProject;
import org.farhan.mbt.core.UMLTestSuite;

public class AsciiDoctorPathConverter {

	private UMLTestProject model;
	private AsciiDoctorTestProject project;

	public AsciiDoctorPathConverter(UMLTestProject model, AsciiDoctorTestProject project) {
		this.model = model;
		this.project = project;
	}

	public String convertUMLPath(String path) {
		String projectLayer, modelLayer;
		if (path.startsWith(project.getDir(project.TEST_STEPS))) {
			projectLayer = project.TEST_STEPS;
			modelLayer = model.TEST_STEPS;
		} else {
			projectLayer = project.TEST_CASES;
			modelLayer = model.TEST_CASES;
		}
		String qualifiedName = path.replace(",", "").trim();
		qualifiedName = qualifiedName.replaceFirst(project.getFileExt(projectLayer) + "$", "");
		qualifiedName = qualifiedName.replaceFirst("^" + project.getDir(projectLayer), "");
		qualifiedName = qualifiedName.replace("/", "::");
		qualifiedName = "pst::" + modelLayer + qualifiedName;
		return qualifiedName;
	}

	public String findUMLPath(String path) {
		for (UMLTestSuite co : model.getTestSuiteList()) {
			if (convertFilePath(co.getUmlElement().getQualifiedName(), project.TEST_CASES).contentEquals(path)) {
				return co.getUmlElement().getQualifiedName();
			}
		}
		for (UMLStepObject co : model.getStepObjectList()) {
			if (convertFilePath(co.getUmlElement().getQualifiedName(), project.TEST_STEPS).contentEquals(path)) {
				return co.getUmlElement().getQualifiedName();
			}
		}
		return null;
	}

	public String convertFilePath(String umlPath, String layer) {

		if (layer.contentEquals(model.TEST_CASES)) {
			umlPath = umlPath.replace("pst::" + model.TEST_CASES, "");
		}
		if (layer.contentEquals(model.TEST_STEPS)) {
			umlPath = umlPath.replace("pst::" + model.TEST_STEPS, "");
		}
		umlPath = umlPath.replace("::", "/");
		umlPath = project.getDir(layer) + umlPath + project.getFileExt(layer);

		return umlPath;
	}
}
