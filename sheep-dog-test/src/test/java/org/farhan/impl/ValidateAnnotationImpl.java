package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.xtext.ValidateAnnotation;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateAnnotationImpl extends TestObjectSheepDogImpl implements ValidateAnnotation {

    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        Object content = getProperty("validate annotation.Content");
        return content == null ? null : content.toString();
    }

    @Override
    public String getContent(HashMap<String, String> keyMap) {
        Object content = getProperty("validate annotation.Content");
        return content == null ? null : content.toString();
    }

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        return (String) getProperty("validate annotation.Content");
    }
}
