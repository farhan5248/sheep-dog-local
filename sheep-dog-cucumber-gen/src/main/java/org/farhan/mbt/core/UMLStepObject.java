package org.farhan.mbt.core;

import java.util.ArrayList;
import java.util.TreeMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Interaction;

public class UMLStepObject extends UMLElement {

	private Class umlElement;
	private ArrayList<UMLStepDefinition> stepDefinitionList;
	public UMLStepObject(Class umlElement, UMLTestProject parent, String id) {
		this.id = id;
		stepDefinitionList = new ArrayList<UMLStepDefinition>();
		this.umlElement = umlElement;
		this.parent = parent;
	}

	public UMLStepObject(String name, UMLTestProject parent, String id) {
		this.id = id;
		stepDefinitionList = new ArrayList<UMLStepDefinition>();
		umlElement = addClass(name, parent.getUmlElement());
		this.parent = parent;
	}

	public UMLStepDefinition addStepDefinition(String name) {
		UMLStepDefinition stepDefinition = new UMLStepDefinition(name, this, String.valueOf(stepDefinitionList.size()));
		stepDefinitionList.add(stepDefinition);
		// TODO update round trip doc to doc test to test this
		TreeMap<String, UMLStepDefinition> sorted = new TreeMap<String, UMLStepDefinition>();
		EList<Behavior> behaviors = umlElement.getOwnedBehaviors();
		for (int i = stepDefinitionList.size(); i > 0; i--) {
			sorted.put(stepDefinitionList.get(i - 1).getName(), (UMLStepDefinition) stepDefinitionList.get(i - 1));
			stepDefinitionList.removeLast();
			behaviors.removeLast();
		}
		for (String s : sorted.keySet()) {
			stepDefinitionList.add(sorted.get(s));
			behaviors.add(sorted.get(s).getUmlElement());
		}
		return stepDefinition;
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

	public String getNameLong() {
		return umlElement.getEAnnotation("StepDefinition").getDetails().get("LongName");
	}

	public ArrayList<UMLStepDefinition> getStepDefinitionList() {
		if (stepDefinitionList.isEmpty()) {
			for (Behavior b : umlElement.getOwnedBehaviors()) {
				stepDefinitionList
						.add(new UMLStepDefinition((Interaction) b, this, String.valueOf(stepDefinitionList.size())));
			}
		}
		return stepDefinitionList;
	}

	public Class getUmlElement() {
		return umlElement;
	}

	public void setDescription(String description) {
		umlElement.createOwnedComment().setBody(description);
	}

}
