package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.objects.xtext.AddDocumentNodeAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AddDocumentNodeActionImpl extends TestObjectSheepDogImpl implements AddDocumentNodeAction {

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        properties.put("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedToAddTextAt(HashMap<String, String> keyMap) {
        if (properties.get("Test Suite Full Name") != null) {
            cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
        }
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            addTextWithContent("Text");
            properties.remove("Node Path");
        }
    }

    @Override
    public void setPerformedToAddTableAt(HashMap<String, String> keyMap) {
        if (properties.get("Test Suite Full Name") != null) {
            cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
        }
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            addTable();
            properties.remove("Node Path");
        }
    }

}
