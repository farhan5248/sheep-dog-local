package org.farhan.dsl.sheepdog.impl;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.farhan.dsl.lang.IResourceRepository;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;

public class TestProjectImpl implements ITestProject {

	private static Logger logger = Logger.getLogger(TestProjectImpl.class);

	private IResourceRepository sr;
	public final String layer2dir;

	public TestProjectImpl(IResourceRepository sr) {
		// TODO In the future the project name should be accessible here. The
		// constructor should get a path that includes the project name. It
		// can then intercept the project name and save it.
		this.sr = sr;
		layer2dir = "src/test/resources/asciidoc/stepdefs";
	}

	public boolean addStepObject(IStepObject stepObject) {
		try {
			sr.put("", layer2dir + "/" + stepObject.getQualifiedName(), stepObject.getContent());
			return true;
		} catch (Exception e) {
			logger.error("Couldn't write step object:", e);
			return false;
		}
	}

	@Override
	public boolean addTestSuite(ITestSuite value) {
		throw new UnsupportedOperationException("addTestSuite(ITestSuite value) is not implemented");
	}

	@Override
	public String getFileExtension() {
		// TODO make a static config object for this and they layer 2 directory
		return ".asciidoc";
	}

	@Override
	public IStepObject getStepObject(int index) {
		throw new UnsupportedOperationException("getStepObject(int index) is not implemented");
	}

	@Override
	public IStepObject getStepObject(String qualifiedName) {
		if (sr.contains("", layer2dir + "/" + qualifiedName)) {
			try {
				// TODO this code doesn't work, the URI is missing the project name.
				// The sr.get hides this bug because it's reading the file system and so the URI
				// in the resource isn't used
				Resource resource = new ResourceSetImpl()
						.createResource(URI.createPlatformResourceURI(layer2dir + "/" + qualifiedName, true));
				String text = sr.get("", layer2dir + "/" + qualifiedName);
				if (text.isEmpty()) {
					logger.error("Couldn't load StepObject for, file is empty: " + qualifiedName);
				} else {
					resource.load(new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8)),
							Collections.EMPTY_MAP);
					StepObject eObject = (StepObject) resource.getContents().get(0);
					IStepObject stepObject = new StepObjectImpl(eObject);
					stepObject.setQualifiedName(qualifiedName);
					return stepObject;
				}
			} catch (Exception e) {
				logger.error("Couldn't load StepObject for: " + qualifiedName, e);
			}
		}
		return null;
	}

	@Override
	public ArrayList<IStepObject> getStepObjectList() {
		ArrayList<IStepObject> objects = new ArrayList<IStepObject>();
		try {
			// TODO instead of empty tags, append it to the prefix?
			for (String stepObjectFileName : sr.list("", layer2dir, getFileExtension())) {
				objects.add(SheepDogBuilder.createStepObject(this, stepObjectFileName.replaceFirst(layer2dir, "")));
			}
		} catch (Exception e) {
			logger.error("Couldn't get StepObject list:", e);
		}
		return objects;
	}

	@Override
	public ITestSuite getTestSuite(int index) {
		throw new UnsupportedOperationException("getTestSuite(int index) is not implemented");
	}

	@Override
	public ITestSuite getTestSuite(String name) {
		throw new UnsupportedOperationException("getTestSuite(String name) is not implemented");
	}

	@Override
	public ArrayList<ITestSuite> getTestSuiteList() {
		throw new UnsupportedOperationException("getTestSuiteList() is not implemented");
	}

	public void setProjectPath(String projectPath) {
		// TODO the method that initialises the repo should probably handle this
		throw new UnsupportedOperationException("setProjectPath(String projectPath) is not implemented");
	}

}
