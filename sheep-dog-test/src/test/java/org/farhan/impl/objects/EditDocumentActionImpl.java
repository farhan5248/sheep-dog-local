package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.objects.xtext.EditDocumentAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditDocumentActionImpl extends TestObjectSheepDogImpl implements EditDocumentAction {

    @Override
    public void setCellName(HashMap<String, String> keyMap) {
        setProperty("Cell Name", keyMap.get("Cell Name"));
    }

    @Override
    public void setLineContent(HashMap<String, String> keyMap) {
        setProperty("Line Content", keyMap.get("Line Content"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setRowContent(HashMap<String, String> keyMap) {
        setProperty("Row Content", keyMap.get("Row Content"));
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
    public void setTestCaseName(HashMap<String, String> keyMap) {
        setProperty("Test Case Name", keyMap.get("Test Case Name"));
    }

    @Override
    public void setTestDataName(HashMap<String, String> keyMap) {
        setProperty("Test Data Name", keyMap.get("Test Data Name"));
    }

    @Override
    public void setTestSetupName(HashMap<String, String> keyMap) {
        setProperty("Test Setup Name", keyMap.get("Test Setup Name"));
    }

    @Override
    public void setStepObjectFullName(HashMap<String, String> keyMap) {
        setProperty("Step Object Full Name", keyMap.get("Step Object Full Name"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setTestStepFullName(HashMap<String, String> keyMap) {
        setProperty("Test Step Full Name", keyMap.get("Test Step Full Name"));
    }

    @Override
    public void setPerformedToAddTextAt(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        addTextWithContent("Text");
    }

    @Override
    public void setPerformedToAddTableAt(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        addTable();
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

    @Override
    public void setPerformedToModifyTestStepContainerListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Test Case Name") != null) {
            addTestCaseWithName(replaceKeyword(getProperty("Test Case Name").toString()));
            properties.remove("Test Case Name");
        } else if (getProperty("Test Setup Name") != null) {
            addTestSetupWithName(replaceKeyword(getProperty("Test Setup Name").toString()));
            properties.remove("Test Setup Name");
        }
    }

    @Override
    public void setPerformedToModifyTestDataListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Test Data Name") != null) {
            addTestDataWithName(replaceKeyword(getProperty("Test Data Name").toString()));
            properties.remove("Test Data Name");
        }
    }

    @Override
    public void setPerformedToModifyCellListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Cell Name") != null) {
            addCellWithName(replaceKeyword(getProperty("Cell Name").toString()));
            properties.remove("Cell Name");
        }
    }

    @Override
    public void setPerformedToModifyLineListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Line Content") != null) {
            addLineWithContent(replaceKeyword(getProperty("Line Content").toString()));
            properties.remove("Line Content");
        }
    }

    @Override
    public void setPerformedToModifyRowListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Row Content") != null) {
            addRowWithContent(replaceKeyword(getProperty("Row Content").toString()));
            properties.remove("Row Content");
        }
    }

    @Override
    public void setPerformedToModifyStepDefinitionListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Step Definition Name") != null) {
            addStepDefinitionWithName(replaceKeyword(getProperty("Step Definition Name").toString()));
            properties.remove("Step Definition Name");
        }
    }

    @Override
    public void setPerformedToModifyStepParametersListWith(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        if (getProperty("Step Parameters Name") != null) {
            addStepParametersWithName(replaceKeyword(getProperty("Step Parameters Name").toString()));
            properties.remove("Step Parameters Name");
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
