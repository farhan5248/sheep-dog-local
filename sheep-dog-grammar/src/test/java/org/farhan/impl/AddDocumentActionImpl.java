package org.farhan.impl;

import java.util.HashMap;

import org.farhan.objects.xtext.AddDocumentAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AddDocumentActionImpl extends TestObjectSheepDogImpl implements AddDocumentAction {

    @Override
    public void setStepObjectFullName(HashMap<String, String> keyMap) {
        setProperty("Step Object Full Name", keyMap.get("Step Object Full Name"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedToCreateATestSuiteWith(HashMap<String, String> keyMap) {
        setProperty("cursor", getProperty("workspace"));
        if (getProperty("Test Suite Full Name") != null) {
            addTestSuiteWithFullName(replaceKeyword(getProperty("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
        }
    }

    @Override
    public void setPerformedToCreateAStepObjectWith(HashMap<String, String> keyMap) {
        setProperty("cursor", getProperty("workspace"));
        if (getProperty("Step Object Full Name") != null) {
            addStepObjectWithFullName(replaceKeyword(getProperty("Step Object Full Name").toString()));
            properties.remove("Step Object Full Name");
        }
    }

}
