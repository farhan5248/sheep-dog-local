package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.objects.xtext.ValidateAnnotation;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateAnnotationImpl extends TestObjectSheepDogImpl implements ValidateAnnotation {

	@Override
	public String getEmpty(HashMap<String, String> keyMap) {
		return validateDialog;
	}

	@Override
	public String getContent(HashMap<String, String> keyMap) {
		return validateDialog;
	}

	@Override
	public void setEmpty(HashMap<String, String> keyMap) {
		validateDialog = replaceKeyword("empty");
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		validateDialog = keyMap.get("Content");
	}

	@Override
	public String getSetAsFollows(HashMap<String, String> keyMap) {
		return validateDialog;
	}

	@Override
	public void setSetAsFollows(HashMap<String, String> keyMap) {
	}
}
