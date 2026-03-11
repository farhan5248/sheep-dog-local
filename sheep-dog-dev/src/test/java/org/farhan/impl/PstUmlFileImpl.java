package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.specprj.uml.PstUmlFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class PstUmlFileImpl extends TestObjectFileUMLImpl implements PstUmlFile {

	@Override
	public String getClassAnnotationsSectionAnnotationDetail(HashMap<String, String> keyMap) {
		return getClassAnnotationDetailExistsValue(keyMap.get("Class Name"), keyMap.get("Annotation Name"),
				keyMap.get("Annotation Detail"));
	}

	@Override
	public String getClassAnnotationsSectionAnnotationName(HashMap<String, String> keyMap) {
		return getClassAnnotationNameExistsValue(keyMap.get("Class Name"), keyMap.get("Annotation Name"));
	}

	@Override
	public String getClassAnnotationsSectionClassName(HashMap<String, String> keyMap) {
		return getClassExistsValue(keyMap.get("Class Name"));
	}

	public String getClassClassName(HashMap<String, String> keyMap) {
		return getClassExistsValue(keyMap.get("Class Name"));
	}

	@Override
	public String getClassCommentsSectionClassName(HashMap<String, String> keyMap) {
		return getClassExistsValue(keyMap.get("Class Name"));
	}

	@Override
	public String getClassCommentsSectionComment(HashMap<String, String> keyMap) {
		return getClassCommentValueValue(keyMap.get("Class Name"));
	}

	@Override
	public String getClassSectionClassName(HashMap<String, String> keyMap) {
		return getClassExistsValue(keyMap.get("Class Name"));
	}

	@Override
	public String getInteractionAnnotationsSectionAnnotationDetail(HashMap<String, String> keyMap) {
		return getInteractionAnnotationDetailExistsValue(keyMap.get("Interaction Name"), keyMap.get("Annotation Name"),
				keyMap.get("Annotation Detail"));
	}

	@Override
	public String getInteractionAnnotationsSectionAnnotationName(HashMap<String, String> keyMap) {
		return getInteractionAnnotationNameExistsValue(keyMap.get("Interaction Name"), keyMap.get("Annotation Name"));
	}

	@Override
	public String getInteractionAnnotationsSectionInteractionName(HashMap<String, String> keyMap) {
		return getInteractionExistsValue(keyMap.get("Interaction Name"));
	}

	@Override
	public String getInteractionCommentsSectionComment(HashMap<String, String> keyMap) {
		return getInteractionCommentValueValue(keyMap.get("Interaction Name"));
	}

	@Override
	public String getInteractionCommentsSectionInteractionName(HashMap<String, String> keyMap) {
		return getInteractionExistsValue(keyMap.get("Interaction Name"));
	}

	@Override
	public String getInteractionMessagesSectionAnnotationDetail(HashMap<String, String> keyMap) {
		return getInteractionMessageAnnotationDetailExistsValue(keyMap.get("Interaction Name"), keyMap.get("Message"),
				keyMap.get("Argument Name"), keyMap.get("Annotation Detail"));
	}

	@Override
	public String getInteractionMessagesSectionArgumentName(HashMap<String, String> keyMap) {
		return getInteractionMessageArgumentNameExistsValue(keyMap.get("Interaction Name"), keyMap.get("Message"),
				keyMap.get("Argument Name"));
	}

	@Override
	public String getInteractionMessagesSectionInteractionName(HashMap<String, String> keyMap) {
		return getInteractionExistsValue(keyMap.get("Interaction Name"));
	}

	@Override
	public String getInteractionMessagesSectionMessage(HashMap<String, String> keyMap) {
		return getInteractionMessageValueValue(keyMap.get("Interaction Name"), keyMap.get("Message"));
	}

	@Override
	public String getInteractionSectionInteractionName(HashMap<String, String> keyMap) {
		return getInteractionExistsValue(keyMap.get("Interaction Name"));
	}

	@Override
	public String getPresent(HashMap<String, String> keyMap) {
		return getFileExistsValue();
	}

	@Override
	public String getClassAnnotationsSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getClassCommentsSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getClassSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getInteractionAnnotationsSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getInteractionCommentsSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getInteractionMessagesSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public String getInteractionSectionCreatedAsFollows(HashMap<String, String> keyMap) {
		// TODO implement later
		return "";
	}

	@Override
	public void setObject(String object) {
		properties.put("object", object);
	}

}
