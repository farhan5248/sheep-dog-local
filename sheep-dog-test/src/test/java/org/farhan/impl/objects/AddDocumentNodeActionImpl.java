package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.objects.xtext.AddDocumentNodeAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AddDocumentNodeActionImpl extends TestIDEObject implements AddDocumentNodeAction {

    @Override
    public void transition() {
        if (properties.get("Node Path") != null) {
            setCursor(properties.get("Node Path").toString());
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

}
