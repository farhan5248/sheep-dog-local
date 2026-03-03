package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.objects.xtext.EditDocumentAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditDocumentActionImpl extends TestIDEObject implements EditDocumentAction {

    @Override
    public void transition() {
        if (objectKeyMap.get("Step Object Name") != null) {
            addStepObjectWithName(replaceKeyword(objectKeyMap.get("Step Object Name").toString()));
            objectKeyMap.remove("Step Object Name");
        } else if (objectKeyMap.get("Step Definition Name") != null) {
            addStepDefinitionWithName(replaceKeyword(objectKeyMap.get("Step Definition Name").toString()));
            objectKeyMap.remove("Step Definition Name");
        } else if (objectKeyMap.get("Line Content") != null) {
            addLineWithContent(replaceKeyword(objectKeyMap.get("Line Content").toString()));
            objectKeyMap.remove("Line Content");
        }
    }

    @Override
    public void setLineContent(HashMap<String, String> keyMap) {
        objectKeyMap.put("Line Content", keyMap.get("Line Content"));
        transition();
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        objectKeyMap.put("Step Definition Name", keyMap.get("Step Definition Name"));
        transition();
    }

    @Override
    public void setStepObjectName(HashMap<String, String> keyMap) {
        objectKeyMap.put("Step Object Name", keyMap.get("Step Object Name"));
        transition();
    }

}
