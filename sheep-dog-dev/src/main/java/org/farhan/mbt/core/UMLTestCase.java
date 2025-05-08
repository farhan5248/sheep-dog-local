package org.farhan.mbt.core;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interaction;
import org.eclipse.uml2.uml.Message;

public class UMLTestCase extends UMLElement {

	private Interaction umlElement;
	private ArrayList<UMLTestStep> testStepList;
	private ArrayList<UMLTestData> testDataList;

	public UMLTestCase(String name, UMLTestSuite parent) {
		testStepList = new ArrayList<UMLTestStep>();
		testDataList = new ArrayList<UMLTestData>();
		umlElement = addInteraction((Class) parent.getUmlElement(), name, "");
	}

	public UMLTestCase(Interaction umlElement) {
		testStepList = new ArrayList<UMLTestStep>();
		testDataList = new ArrayList<UMLTestData>();
		this.umlElement = umlElement;
	}

	public void setTags(ArrayList<String> tags) {
		if (!tags.isEmpty()) {
			for (String t : tags) {
				createAnnotation(umlElement, "tags", t);
			}
		}
	}

	public void setDescription(String scenarioDescription) {
		umlElement.createOwnedComment().setBody(scenarioDescription);
	}

	public UMLTestStep addTestStep(String name) {
		UMLTestStep testStep = new UMLTestStep(name, this);
		testStepList.add(testStep);
		return testStep;
	}

	public Interaction getUmlElement() {
		return umlElement;
	}

	public UMLTestData addTestData(String name) {
		UMLTestData testData = new UMLTestData(name, this);
		testDataList.add(testData);
		return testData;
	}

	public boolean isBackground() {
		return umlElement.getEAnnotation("background") != null;
	}

	public boolean hasTestData() {
		// if there's an annotation not called tags or background
		for (EAnnotation a : umlElement.getEAnnotations()) {
			if (!a.getSource().contentEquals("tags") && !a.getSource().contentEquals("background")) {
				return true;
			}
		}
		return false;
	}

	public String getName() {
		return umlElement.getName();
	}

	public ArrayList<String> getTags() {
		ArrayList<String> tags = new ArrayList<String>();
		if (umlElement.getEAnnotation("tags") != null) {
			for (Entry<String, String> t : umlElement.getEAnnotation("tags").getDetails()) {
				tags.add(t.getKey());
			}
		}
		return tags;
	}

	public String getDescription() {
		if (umlElement.getOwnedComments().size() > 0) {
			return umlElement.getOwnedComments().get(0).getBody();
		}
		return "";
	}

	public ArrayList<UMLTestStep> getTestStepList() {
		if (testStepList.isEmpty()) {
			for (Message m : umlElement.getMessages()) {
				testStepList.add(new UMLTestStep(m, this));
			}
		}
		return testStepList;
	}

	public ArrayList<UMLTestData> getTestDataList() {
		if (testDataList.isEmpty()) {
			for (EAnnotation a : umlElement.getEAnnotations()) {
				if (!a.getSource().contentEquals("tags")) {
					testDataList.add(new UMLTestData(a, this));
				}
			}
		}
		return testDataList;
	}

}
