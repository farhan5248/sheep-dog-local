package org.farhan.impl.objects;

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
    public void setPerformedToCreateAStepObjectWith(HashMap<String, String> keyMap) {
        setProperty("cursor", getProperty("workspace"));
        addStepObjectWithFullName((String) getProperty("Step Object Full Name"));
    }
}
