package org.farhan.mbt.core;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interaction;

public class UMLTestSuite extends UMLElement {

	private Class umlElement;
	private UMLTestSetup testSetup;
	private ArrayList<UMLTestCase> testCaseList;

	public UMLTestSuite(Class umlElement, UMLTestProject parent, String id) {
		this.id = id;
		testCaseList = new ArrayList<UMLTestCase>();
		testSetup = null;
		this.umlElement = umlElement;
		this.parent = parent;
	}

	public UMLTestSuite(String name, UMLTestProject parent, String id) {
		this.id = id;
		testCaseList = new ArrayList<UMLTestCase>();
		testSetup = null;
		this.umlElement = addClass(name, parent.getUmlElement());
		this.parent = parent;
	}

	public UMLTestCase addTestCase(String name) {
		UMLTestCase testCase = new UMLTestCase(name, this, String.valueOf(testCaseList.size()));
		testCaseList.add(testCase);
		return testCase;
	}

	public UMLTestSetup addTestSetup(String name) {
		testSetup = new UMLTestSetup(name, this, "0");
		return testSetup;
	}

	public String getDescription() {
		if (umlElement.getOwnedComments().size() > 0) {
			return umlElement.getOwnedComments().get(0).getBody();
		}
		return "";
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

	public ArrayList<UMLTestCase> getTestCaseList() {
		// TODO treat this like get abstract scenario list and don't skip background
		if (testCaseList.isEmpty()) {
			for (Behavior b : umlElement.getOwnedBehaviors()) {
				if (b.getEAnnotation("background") == null) {
					testCaseList.add(new UMLTestCase((Interaction) b, String.valueOf(testCaseList.size())));
				}
			}
		}
		return testCaseList;
	}

	public UMLTestSetup getTestSetup() {
		if (testSetup == null) {
			for (Behavior b : umlElement.getOwnedBehaviors()) {
				if (b.getEAnnotation("background") != null) {
					testSetup = new UMLTestSetup((Interaction) b, this, "0");
				}
			}
		}
		return testSetup;
	}

	public Class getUmlElement() {
		return umlElement;
	}

	public boolean hasTestSetup() {
		return getTestSetup() != null;
	}

	public void setDescription(String description) {
		umlElement.createOwnedComment().setBody(description);
	}

	public void setTags(ArrayList<String> tags) {
		if (!tags.isEmpty()) {
			for (String t : tags) {
				createAnnotation(umlElement, "tags", t);
			}
		}
	}

}
