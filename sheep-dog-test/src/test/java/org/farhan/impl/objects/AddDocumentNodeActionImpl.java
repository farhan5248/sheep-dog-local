package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.objects.xtext.AddDocumentNodeAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AddDocumentNodeActionImpl extends TestObjectSheepDogImpl implements AddDocumentNodeAction {

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedToAddTextAt(HashMap<String, String> keyMap) {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            addTextWithContent("Text");
            properties.remove("Node Path");
        }
    }

    @Override
    public void setPerformedToAddTableAt(HashMap<String, String> keyMap) {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            addTable();
            properties.remove("Node Path");
        }
    }

}
