package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.objects.xtext.EditDocumentAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditDocumentActionImpl extends TestIDEObject implements EditDocumentAction {

    @Override
    public void transition() {
        if (properties.get("Step Object Full Name") != null) {
            addStepObjectWithFullName(replaceKeyword(properties.get("Step Object Full Name").toString()));
            properties.remove("Step Object Full Name");
        } else if (properties.get("Step Definition Name") != null) {
            addStepDefinitionWithName(replaceKeyword(properties.get("Step Definition Name").toString()));
            properties.remove("Step Definition Name");
        } else if (properties.get("Line Content") != null) {
            addLineWithContent(replaceKeyword(properties.get("Line Content").toString()));
            properties.remove("Line Content");
        }
    }

    @Override
    public void setLineContent(HashMap<String, String> keyMap) {
        properties.put("Line Content", keyMap.get("Line Content"));
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        properties.put("Step Definition Name", keyMap.get("Step Definition Name"));
    }

    @Override
    public void setStepObjectFullName(HashMap<String, String> keyMap) {
        properties.put("Step Object Full Name", keyMap.get("Step Object Full Name"));
    }

}
