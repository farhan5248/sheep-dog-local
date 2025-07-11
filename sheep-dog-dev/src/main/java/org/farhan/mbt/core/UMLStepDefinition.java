package org.farhan.mbt.core;

import java.util.ArrayList;
import java.util.TreeMap;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.uml2.uml.Behavior;
import org.eclipse.uml2.uml.Interaction;

public class UMLStepDefinition extends UMLElement {

	private Interaction umlElement;
	private ArrayList<UMLStepParameters> stepParametersList;
	public UMLStepDefinition(Interaction umlElement, UMLStepObject parent, String id) {
		this.id = id;
		stepParametersList = new ArrayList<UMLStepParameters>();
		this.umlElement = umlElement;
		this.parent = parent;
	}

	public UMLStepDefinition(String name, UMLStepObject parent, String id) {
		this.id = id;
		stepParametersList = new ArrayList<UMLStepParameters>();
		umlElement = addInteraction(parent.getUmlElement(), name, "");
		// TODO make tests for this by doing adoc(unsorted) uml adoc (sorted)
		TreeMap<String, Interaction> sorted = new TreeMap<String, Interaction>();
		EList<Behavior> behaviors = umlElement.getOwnedBehaviors();
		for (int i = behaviors.size(); i > 0; i--) {
			sorted.put(behaviors.get(i - 1).getName(), (Interaction) behaviors.get(i - 1));
			behaviors.removeLast();
		}
		for (String key : sorted.keySet()) {
			behaviors.add(sorted.get(key));
		}
		this.parent = parent;
	}

	public UMLStepParameters addStepParameters(String name) {
		UMLStepParameters stepParameters = new UMLStepParameters(name, this, String.valueOf(stepParametersList.size()));
		stepParametersList.add(stepParameters);
		return stepParameters;
	}

	public String getDescription(UMLStepDefinition srcStepDefinition) {
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

	public ArrayList<UMLStepParameters> getStepParametersList() {
		if (stepParametersList.isEmpty()) {
			for (EAnnotation a : umlElement.getEAnnotations()) {
				if (!a.getSource().contentEquals("StepDefinition")) {
					stepParametersList.add(new UMLStepParameters(a, this, String.valueOf(stepParametersList.size())));
				}
			}
		}
		return stepParametersList;
	}

	public Interaction getUmlElement() {
		return umlElement;
	}

	public void setDescription(String description) {
		umlElement.createOwnedComment().setBody(description);
	}

	public void setNameLong(String stepDefinitionNameLong) {
		createAnnotation(umlElement, "StepDefinition", "LongName", stepDefinitionNameLong);
	}
}
