package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObjectIDE;
import org.farhan.objects.xtext.AddDocumentAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AddDocumentActionImpl extends TestObjectIDE implements AddDocumentAction {

    @Override
    public void setStepObjectFullName(HashMap<String, String> keyMap) {
        properties.put("Step Object Full Name", keyMap.get("Step Object Full Name"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void transition() {
        cursor = testProject;
        if (properties.get("Step Object Full Name") != null) {
            addStepObjectWithFullName(replaceKeyword(properties.get("Step Object Full Name").toString()));
            properties.remove("Step Object Full Name");
        } else if (properties.get("Test Suite Full Name") != null) {
            addTestSuiteWithFullName(replaceKeyword(properties.get("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
        }
    }

}
