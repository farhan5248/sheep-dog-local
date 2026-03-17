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

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        setProperty("Step Parameters Name", keyMap.get("Step Parameters Name"));
    }

    @Override
    public void setPerformedToModifyStepParametersListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        addStepParametersWithName((String) getProperty("Step Parameters Name"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setTestCaseName(HashMap<String, String> keyMap) {
        setProperty("Test Case Name", keyMap.get("Test Case Name"));
    }

    @Override
    public void setTestSetupName(HashMap<String, String> keyMap) {
        setProperty("Test Setup Name", keyMap.get("Test Setup Name"));
    }

    @Override
    public void setPerformedToModifyTestStepContainerListWith(HashMap<String, String> keyMap) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument((String) getProperty("Test Suite Full Name"));
        setProperty("cursor", doc);
        navigateToNode();
        addTestSetupWithName((String) getProperty("Test Setup Name"));
    }
}
