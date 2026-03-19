package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.objects.xtext.EditDocumentAction;

public class EditDocumentActionImpl extends TestObjectSheepDogImpl implements EditDocumentAction {

    @Override
    public void setStepObjectFullName(HashMap<String, String> keyMap) {
        setProperty("Step Object Full Name", keyMap.get("Step Object Full Name"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        setProperty("Step Definition Name", keyMap.get("Step Definition Name"));
    }

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        setProperty("Step Parameters Name", keyMap.get("Step Parameters Name"));
    }

    @Override
    public void setPerformedToModifyStepDefinitionListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Step Definition Name") != null) {
            addStepDefinitionWithName(getProperty("Step Definition Name").toString());
            properties.remove("Step Definition Name");
        }
    }

    @Override
    public void setPerformedToModifyStepParametersListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Step Parameters Name") != null) {
            addStepParametersWithName(getProperty("Step Parameters Name").toString());
            properties.remove("Step Parameters Name");
        }
    }

    private void navigateToDocument() {
        if (getProperty("Step Object Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Step Object Full Name").toString())));
            properties.remove("Step Object Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }

}
