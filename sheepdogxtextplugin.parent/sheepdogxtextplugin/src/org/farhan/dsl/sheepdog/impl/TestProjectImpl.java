package org.farhan.dsl.sheepdog.impl;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeSet;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.farhan.dsl.lang.IResourceRepository;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;

public class TestProjectImpl implements ITestProject {

	private static Logger logger = Logger.getLogger(TestProjectImpl.class);

	private IResourceRepository sr;
	private final String outputPath;

	public TestProjectImpl(IResourceRepository sr) {
		this.sr = sr;
		outputPath = "src/test/resources/asciidoc/stepdefs/";
	}

	@Override
	public IStepObject createStepObject(String qualifiedName) {
		StepObject eObject = SheepDogFactory.eINSTANCE.createStepObject();
		Resource theResource = new ResourceSetImpl().createResource(URI.createFileURI(outputPath + qualifiedName));
		theResource.getContents().add(eObject);
		IStepObject stepObject = new StepObjectImpl(eObject);
		stepObject.setQualifiedName(qualifiedName);
		stepObject.setName((new File(qualifiedName)).getName().replace(getFileExtension(), ""));
		return stepObject;
	}

	@Override
	public IStepObject getStepObject(String qualifiedName) {
		if (sr.contains("", qualifiedName)) {
			Resource resource = new ResourceSetImpl().createResource(URI.createFileURI(outputPath + qualifiedName));
			try {
				String text = sr.get("", outputPath + qualifiedName);
				resource.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)), Collections.EMPTY_MAP);
			} catch (Exception e) {
				logger.error("Couldn't load StepObject for: " + qualifiedName, e);
			}
			return new StepObjectImpl((StepObject) resource.getContents().get(0));
		} else {
			return null;
		}
	}

	public void putStepObject(IStepObject stepObject) throws Exception {
		// TODO serialize should be setContent, parse should be getContent, this works
		// well for the JSON response
		sr.put("", outputPath + stepObject.getQualifiedName(), ((StepObjectImpl) stepObject).serialize());
	}

	@Override
	public ITestSuite createTestSuite(String qualifiedName) {
		// Not needed in this project
		return null;
	}

	@Override
	public ArrayList<String> getComponentList() {

		TreeSet<String> componentSet = new TreeSet<String>();
		try {
			// TODO instead of empty tags, append it to the prefix?
			for (String stepObjectFileName : sr.list("", outputPath, getFileExtension())) {
				componentSet.add(stepObjectFileName.replaceFirst(outputPath, "").split("/")[0]);
			}
		} catch (Exception e) {
			logger.error("Couldn't get component list:", e);
		}

		ArrayList<String> componentList = new ArrayList<String>();
		componentList.addAll(componentSet);
		return componentList;
	}

	@Override
	public String getFileExtension() {
		return ".asciidoc";
	}

	@Override
	public ArrayList<IStepObject> getStepObjectList() {
		ArrayList<IStepObject> objects = new ArrayList<IStepObject>();
		try {
			// TODO instead of empty tags, append it to the prefix?
			for (String stepObjectFileName : sr.list("", outputPath, getFileExtension())) {
				objects.add(createStepObject(stepObjectFileName.replaceFirst(outputPath, "")));
			}
		} catch (Exception e) {
			logger.error("Couldn't get StepObject list:", e);
		}
		return objects;
	}

	@Override
	public ArrayList<IStepObject> getStepObjectList(String component) {
		ArrayList<IStepObject> objects = new ArrayList<IStepObject>();
		try {
			for (String stepObjectFileName : sr.list("", outputPath + component, getFileExtension())) {
				objects.add(createStepObject(stepObjectFileName.replaceFirst(outputPath, "")));
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

	public void setProjectPath(String projectPath) {
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
