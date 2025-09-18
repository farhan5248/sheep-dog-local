package org.farhan.dsl.sheepdog.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;

public class TestProjectImpl implements ITestProject {

	private static Logger logger = Logger.getLogger(TestProjectImpl.class);

	private static String projectPath;
	private static String outputPath;

	public void setProjectPath(String projectPath) {
		TestProjectImpl.projectPath = projectPath;
		outputPath = "src/test/resources/asciidoc/stepdefs/".replace("/", File.separator);
	}

	@Override
	public IStepObject createStepObject(String qualifiedName) {
		StepObject eObject = SheepDogFactory.eINSTANCE.createStepObject();
		Resource theResource = new ResourceSetImpl().createResource(getObjectURI(qualifiedName));
		theResource.getContents().add(eObject);
		IStepObject stepObject = new StepObjectImpl(eObject);
		stepObject.setQualifiedName(qualifiedName);
		stepObject.setName(
				(new File(projectPath + outputPath + qualifiedName)).getName().replace(getFileExtension(), ""));
		return stepObject;
	}

	@Override
	public ITestSuite createTestSuite(String qualifiedName) {
		// Not needed in this project
		return null;
	}

	@Override
	public ArrayList<String> getComponentList() {
		File folder = new File(projectPath + outputPath);
		ArrayList<String> components = new ArrayList<String>();
		for (File ir : folder.listFiles()) {
			components.add(ir.getName());
		}
		return components;
	}

	@Override
	public String getFileExtension() {
		return ".asciidoc";
	}

	private ArrayList<String> getFiles(File folder) throws Exception {
		ArrayList<String> files = new ArrayList<String>();
		if (folder.exists()) {
			for (File r : folder.listFiles()) {
				if (!r.isFile()) {
					files.addAll(getFiles(r));
				} else {
					files.add(r.getAbsolutePath());
				}
			}
		}
		return files;
	}

	private URI getObjectURI(String qualifiedName) {

		String objectPath = projectPath + outputPath + qualifiedName.replace("/", File.separator);
		URI uri = URI.createFileURI(objectPath);
		return uri;
	}

	@Override
	public IStepObject getStepObject(String qualifiedName) {
		Resource resource = new ResourceSetImpl().createResource(getObjectURI(qualifiedName));
		if (new ResourceSetImpl().getURIConverter().exists(resource.getURI(), null)) {
			try {
				resource.load(new HashMap());
			} catch (IOException e) {
				logger.error("Couldn't load StepObject for: " + qualifiedName, e);
			}
			return new StepObjectImpl((StepObject) resource.getContents().get(0));
		} else {
			return null;
		}
	}

	@Override
	public ArrayList<IStepObject> getStepObjectList() {
		ArrayList<IStepObject> objects = new ArrayList<IStepObject>();
		try {
			for (String stepObjectFileName : getFiles(new File(projectPath + outputPath))) {
				stepObjectFileName = stepObjectFileName.replace(File.separator, "/");
				String qualifiedName = stepObjectFileName.replaceFirst(projectPath + outputPath, "");
				objects.add(createStepObject(qualifiedName));
			}
		} catch (Exception e) {
			logger.error("Couldn't get StepObject list:", e);
		}
		return objects;
	}

	@Override
	public ArrayList<IStepObject> getStepObjectList(String component) {
		// logger.error("Component is: " + component);
		ArrayList<IStepObject> objects = new ArrayList<IStepObject>();
		try {
			// logger.error("Directory is: " + projectPath + outputPath + component);
			for (String stepObjectFileName : getFiles(new File(projectPath + outputPath + component))) {
				// logger.error("stepObjectFileName is: " + stepObjectFileName);
				stepObjectFileName = stepObjectFileName.replace(File.separator, "/");
				String qualifiedName = stepObjectFileName.replaceFirst(".*" + component + "/", component + "/");
				// logger.error("qualifiedName is: " + qualifiedName);
				objects.add(createStepObject(qualifiedName));
			}
		} catch (Exception e) {
			logger.error("Couldn't get StepObject list: for" + component, e);
		}
		return objects;
	}

	@Override
	public ITestSuite getTestSuite(String name) {
		// Not needed in this project
		return null;
	}

	@Override
	public ArrayList<ITestSuite> getTestSuiteList() {
		// Not needed in this project
		return null;
	}

	@Override
	public void setStepObjectList(ArrayList<IStepObject> stepObjectList) {
		// Not needed in this project
	}

	@Override
	public void setTestSuiteList(ArrayList<ITestSuite> testSuiteList) {
		// Not needed in this project
	}

}
