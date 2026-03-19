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

    @Override
    public void setPerformedToModifyTestStepContainerListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Test Case Name") != null) {
            addTestCaseWithName(getProperty("Test Case Name").toString());
            properties.remove("Test Case Name");
        }
        if (getProperty("Test Setup Name") != null) {
            addTestSetupWithName(getProperty("Test Setup Name").toString());
            properties.remove("Test Setup Name");
        }
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
    public void setTestDataName(HashMap<String, String> keyMap) {
        setProperty("Test Data Name", keyMap.get("Test Data Name"));
    }

    @Override
    public void setPerformedToModifyTestDataListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Test Data Name") != null) {
            addTestDataWithName(getProperty("Test Data Name").toString());
            properties.remove("Test Data Name");
        }
    }

    @Override
    public void setTestStepFullName(HashMap<String, String> keyMap) {
        setProperty("Test Step Full Name", keyMap.get("Test Step Full Name"));
    }

    @Override
    public void setPerformedToModifyTestStepListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Test Step Full Name") != null) {
            addTestStepWithFullName(replaceKeyword(getProperty("Test Step Full Name").toString()));
            properties.remove("Test Step Full Name");
        }
    }

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        } else if (getProperty("Step Object Full Name") != null) {
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
