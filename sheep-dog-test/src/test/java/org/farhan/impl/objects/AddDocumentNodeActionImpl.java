package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObjectIDE;
import org.farhan.objects.xtext.AddDocumentNodeAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AddDocumentNodeActionImpl extends TestObjectIDE implements AddDocumentNodeAction {

    @Override
    public void transition() {
        super.transition();
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            if (properties.get("Node Path").toString().endsWith("Table")) {
                addTable();
            } else if (properties.get("Node Path").toString().endsWith("Text")) {
                addTextWithContent("Text");
            }
            properties.remove("Node Path");
        }
    }

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
        // TODO implement later
    }

    @Override
    public void setPerformedToAddTableAt(HashMap<String, String> keyMap) {
        // TODO implement later
    }

}
