package org.farhan.mbt.core;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.resource.UMLResource;
import org.eclipse.uml2.uml.resources.util.UMLResourcesUtil;
import org.farhan.dsl.lang.IResourceRepository;

public class UMLTestProject extends UMLElement {

	protected IResourceRepository fa;
	public final String TEST_CASES = "specs";
	public final String TEST_STEPS = "stepdefs";
	private Model umlElement;
	protected ArrayList<UMLTestSuite> firstLayerObjects;
	protected ArrayList<UMLStepObject> secondLayerObjects;

	public UMLTestProject(String tags, IResourceRepository fa) {
		firstLayerObjects = new ArrayList<UMLTestSuite>();
		secondLayerObjects = new ArrayList<UMLStepObject>();
		this.fa = fa;
		// TODO just assign tags, "default" is handled in the controller
		this.id = tags;
		umlElement = UMLFactory.eINSTANCE.createModel();
		umlElement.setName("pst");
		umlElement.createNestedPackage(TEST_CASES);
		umlElement.createNestedPackage(TEST_STEPS);
	}

	public UMLStepObject addStepObject(String qualifiedName) {
		if (getPackagedElement(qualifiedName, null) == null) {
			UMLStepObject stepObject = new UMLStepObject(qualifiedName, this,
					String.valueOf(secondLayerObjects.size()));
			secondLayerObjects.add(stepObject);
			return stepObject;
		}
		return null;
	}

	public UMLTestSuite addTestSuite(String qualifiedName) {
		if (getPackagedElement(qualifiedName, null) == null) {
			UMLTestSuite testSuite = new UMLTestSuite(qualifiedName, this, String.valueOf(firstLayerObjects.size()));
			firstLayerObjects.add(testSuite);
			return testSuite;
		}
		return null;
	}

	public String getDir() {
		return "uml/";
	}

	public PackageableElement getPackagedElement(String qualifiedName, Package nestingPackage) {
		if (nestingPackage == null) {
			nestingPackage = umlElement;
		}
		for (PackageableElement pe : nestingPackage.getPackagedElements()) {
			if (pe instanceof Package) {
				PackageableElement anElement = getPackagedElement(qualifiedName, (Package) pe);
				if (anElement != null) {
					return anElement;
				}
			} else {
				if (pe.getQualifiedName().contentEquals(qualifiedName)) {
					return pe;
				}
				if (pe instanceof Class) {
					Class c = (Class) pe;
					for (Behavior b : c.getOwnedBehaviors()) {
						if (b.getQualifiedName().contentEquals(qualifiedName)) {
							return b;
						}
					}
				}
			}
		}
		return null;
	}

	private ArrayList<Class> getPackagedElements(Package aPackage) {
		ArrayList<Class> classes = new ArrayList<Class>();
		for (PackageableElement pe : aPackage.getPackagedElements()) {
			if (pe instanceof Class) {
				classes.add((Class) pe);
			} else if (pe instanceof Package) {
				classes.addAll(getPackagedElements((Package) pe));
			}
		}
		return classes;
	}

	public UMLStepObject getStepObject(String qualifiedName) {
		for (UMLStepObject so : secondLayerObjects) {
			if (so.getUmlElement().getQualifiedName().contentEquals(qualifiedName)) {
				return so;
			}
		}
		return null;
	}

	public ArrayList<UMLStepObject> getStepObjectList() {
		return secondLayerObjects;
	}

	public UMLTestSuite getTestSuite(String qualifiedName) {
		for (UMLTestSuite ts : firstLayerObjects) {
			if (ts.getUmlElement().getQualifiedName().contentEquals(qualifiedName)) {
				return ts;
			}
		}
		return null;
	}

	public ArrayList<UMLTestSuite> getTestSuiteList() {
		return firstLayerObjects;
	}

	public Model getUmlElement() {
		return umlElement;
	}

	public void init() throws Exception {
		String path = getDir() + umlElement.getName() + "." + UMLResource.FILE_EXTENSION;
		if (fa.contains(id, path)) {
			URI uri = URI.createFileURI(path);
			ResourceSet resourceSet = UMLResourcesUtil.init(new ResourceSetImpl());
			Resource resource = resourceSet.createResource(uri);
			InputStream content = new ByteArrayInputStream(fa.get(id, path).getBytes(StandardCharsets.UTF_8));
			resource.load(content, Collections.EMPTY_MAP);
			umlElement = (Model) resource.getContents().getFirst();
			ArrayList<Class> objects = getPackagedElements(umlElement.getNestedPackage(TEST_CASES));
			for (Class c : objects) {
				firstLayerObjects.add(new UMLTestSuite(c, this, String.valueOf(firstLayerObjects.size())));
			}
			objects = getPackagedElements(umlElement.getNestedPackage(TEST_STEPS));
			for (Class c : objects) {
				secondLayerObjects.add(new UMLStepObject(c, this, String.valueOf(secondLayerObjects.size())));
			}
		}
	}

	public void save() throws Exception {
		String path = getDir() + umlElement.getName() + "." + UMLResource.FILE_EXTENSION;
		URI uri = URI.createFileURI(path);
		ResourceSet resourceSet = new ResourceSetImpl();
		UMLResourcesUtil.init(resourceSet);
		XMLResource resource = (XMLResource) resourceSet.createResource(uri);
		resource.getContents().add(umlElement);
		// Looks like I have this for interaction message signatures that point nowhere
		// This option lets files get saved with referenced to non-existing objects
		Map<Object, Object> options = resource.getDefaultSaveOptions();
		options.put(XMLResource.OPTION_PROCESS_DANGLING_HREF, "true");
		OutputStream os = new ByteArrayOutputStream();
		resource.save(os, options);
		fa.put(id, path, os.toString());
	}
}
