package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.objects.xtext.EditDocumentAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditDocumentActionImpl extends TestObjectSheepDogImpl implements EditDocumentAction {

    private void navigateToDocument() {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument((String) getProperty("Step Object Full Name"));
        setProperty("cursor", doc);
    }

    private void navigateToNode() {
        setCursorAtNode((String) getProperty("Node Path"));
    }

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
    public void setPerformedToModifyStepDefinitionListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        addStepDefinitionWithName((String) getProperty("Step Definition Name"));
    }
}
