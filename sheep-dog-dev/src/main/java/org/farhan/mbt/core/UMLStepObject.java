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

	public UMLStepObject(String name, UMLTestProject parent) {
		stepDefinitionList = new ArrayList<UMLStepDefinition>();
		umlElement = addClass(name, parent.getUmlElement());
	}

	public UMLStepObject(Class umlElement, UMLTestProject parent) {
		stepDefinitionList = new ArrayList<UMLStepDefinition>();
		this.umlElement = umlElement;
	}

	public void setDescription(String description) {
		umlElement.createOwnedComment().setBody(description);
	}

	public UMLStepDefinition addStepDefinition(String name) {
		UMLStepDefinition stepDefinition = new UMLStepDefinition(name, this);
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

	public Class getUmlElement() {
		return umlElement;
	}

	public String getName() {
		return umlElement.getName();
	}

	public String getDescription() {
		if (umlElement.getOwnedComments().size() > 0) {
			return umlElement.getOwnedComments().get(0).getBody();
		}
		return "";
	}

	public ArrayList<UMLStepDefinition> getStepDefinitionList() {
		if (stepDefinitionList.isEmpty()) {
			for (Behavior b : umlElement.getOwnedBehaviors()) {
				stepDefinitionList.add(new UMLStepDefinition((Interaction) b, this));
			}
		}
		return stepDefinitionList;
	}

	public String getNameLong() {
		return umlElement.getEAnnotation("StepDefinition").getDetails().get("LongName");
	}

}
