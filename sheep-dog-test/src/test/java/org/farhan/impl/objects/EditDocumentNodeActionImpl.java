package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObjectIDE;
import org.farhan.objects.xtext.EditDocumentNodeAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditDocumentNodeActionImpl extends TestObjectIDE implements EditDocumentNodeAction {

    @Override
    public void setCellName(HashMap<String, String> keyMap) {
        properties.put("Cell Name", keyMap.get("Cell Name"));
    }

    @Override
    public void setLineContent(HashMap<String, String> keyMap) {
        properties.put("Line Content", keyMap.get("Line Content"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        properties.put("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setRowContent(HashMap<String, String> keyMap) {
        properties.put("Row Content", keyMap.get("Row Content"));
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        properties.put("Step Definition Name", keyMap.get("Step Definition Name"));
    }

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        properties.put("Step Parameters Name", keyMap.get("Step Parameters Name"));
    }

    @Override
    public void setTestCaseName(HashMap<String, String> keyMap) {
        properties.put("Test Case Name", keyMap.get("Test Case Name"));
    }

    @Override
    public void setTestDataName(HashMap<String, String> keyMap) {
        properties.put("Test Data Name", keyMap.get("Test Data Name"));
    }

    @Override
    public void setTestSetupName(HashMap<String, String> keyMap) {
        properties.put("Test Setup Name", keyMap.get("Test Setup Name"));
    }

    @Override
    public void setStepObjectFullName(HashMap<String, String> keyMap) {
        properties.put("Step Object Full Name", keyMap.get("Step Object Full Name"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setTestStepFullName(HashMap<String, String> keyMap) {
        properties.put("Test Step Full Name", keyMap.get("Test Step Full Name"));
    }

    @Override
    public void setPerformedToModifyTestStepListWith(HashMap<String, String> keyMap) {
    }

    @Override
    public void setPerformedToModifyTestStepContainerListWith(HashMap<String, String> keyMap) {
    }

    @Override
    public void setPerformedToModifyTestDataListWith(HashMap<String, String> keyMap) {
    }

    @Override
    public void setPerformedToModifyCellListWith(HashMap<String, String> keyMap) {
    }

    @Override
    public void setPerformedToModifyLineListWith(HashMap<String, String> keyMap) {
    }

    @Override
    public void setPerformedToModifyRowListWith(HashMap<String, String> keyMap) {
    }

    @Override
    public void setPerformedToModifyStepDefinitionListWith(HashMap<String, String> keyMap) {
    }

    @Override
    public void setPerformedToModifyStepParametersListWith(HashMap<String, String> keyMap) {
    }

    @Override
    public void transition() {
        super.transition();
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        if (properties.get("Step Definition Name") != null) {
            addStepDefinitionWithName(replaceKeyword(properties.get("Step Definition Name").toString()));
            properties.remove("Step Definition Name");
        } else if (properties.get("Test Case Name") != null) {
            addTestCaseWithName(replaceKeyword(properties.get("Test Case Name").toString()));
            properties.remove("Test Case Name");
        } else if (properties.get("Test Setup Name") != null) {
            addTestSetupWithName(replaceKeyword(properties.get("Test Setup Name").toString()));
            properties.remove("Test Setup Name");
        } else if (properties.get("Test Data Name") != null) {
            addTestDataWithName(replaceKeyword(properties.get("Test Data Name").toString()));
            properties.remove("Test Data Name");
        } else if (properties.get("Step Parameters Name") != null) {
            addStepParametersWithName(replaceKeyword(properties.get("Step Parameters Name").toString()));
            properties.remove("Step Parameters Name");
        } else if (properties.get("Row Content") != null) {
            addRowWithContent(replaceKeyword(properties.get("Row Content").toString()));
            properties.remove("Row Content");
        } else if (properties.get("Text Content") != null) {
            addTextWithContent(replaceKeyword(properties.get("Text Content").toString()));
            properties.remove("Text Content");
        } else if (properties.get("Cell Name") != null) {
            addCellWithName(replaceKeyword(properties.get("Cell Name").toString()));
            properties.remove("Cell Name");
        } else if (properties.get("Line Content") != null) {
            addLineWithContent(replaceKeyword(properties.get("Line Content").toString()));
            properties.remove("Line Content");
        } else if (properties.get("Test Step Full Name") != null) {
            addTestStepWithFullName(replaceKeyword(properties.get("Test Step Full Name").toString()));
            properties.remove("Test Step Full Name");
        }
    }

}
