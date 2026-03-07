package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.objects.xtext.EditDocumentNodeAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditDocumentNodeActionImpl extends TestIDEObject implements EditDocumentNodeAction {

    @Override
    public void setAndStepDefinitionRefName(HashMap<String, String> keyMap) {
        properties.put("And StepDefinitionRef Name", keyMap.get("And StepDefinitionRef Name"));
    }

    @Override
    public void setAndStepObjectRefName(HashMap<String, String> keyMap) {
        properties.put("And StepObjectRef Name", keyMap.get("And StepObjectRef Name"));
    }

    @Override
    public void setCellName(HashMap<String, String> keyMap) {
        properties.put("Cell Name", keyMap.get("Cell Name"));
    }

    @Override
    public void setGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
        properties.put("Given StepDefinitionRef Name", keyMap.get("Given StepDefinitionRef Name"));
    }

    @Override
    public void setGivenStepObjectRefName(HashMap<String, String> keyMap) {
        properties.put("Given StepObjectRef Name", keyMap.get("Given StepObjectRef Name"));
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
    public void setStepObjectFullName(HashMap<String, String> keyMap) {
        properties.put("Step Object Full Name", keyMap.get("Step Object Full Name"));
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
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setThenStepDefinitionRefName(HashMap<String, String> keyMap) {
        properties.put("Then StepDefinitionRef Name", keyMap.get("Then StepDefinitionRef Name"));
    }

    @Override
    public void setThenStepObjectRefName(HashMap<String, String> keyMap) {
        properties.put("Then StepObjectRef Name", keyMap.get("Then StepObjectRef Name"));
    }

    @Override
    public void setWhenStepDefinitionRefName(HashMap<String, String> keyMap) {
        properties.put("When StepDefinitionRef Name", keyMap.get("When StepDefinitionRef Name"));
    }

    @Override
    public void setWhenStepObjectRefName(HashMap<String, String> keyMap) {
        properties.put("When StepObjectRef Name", keyMap.get("When StepObjectRef Name"));
    }

    @Override
    public void transition() {
        if (properties.get("Node Path") != null) {
            setCursor(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        if (properties.get("Step Object Full Name") != null) {
            addStepObjectWithFullName(replaceKeyword(properties.get("Step Object Full Name").toString()));
            properties.remove("Step Object Full Name");
        } else if (properties.get("Step Definition Name") != null) {
            addStepDefinitionWithName(replaceKeyword(properties.get("Step Definition Name").toString()));
            properties.remove("Step Definition Name");
        } else if (properties.get("Test Suite Full Name") != null) {
            addTestSuiteWithFullName(replaceKeyword(properties.get("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
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
        } else if (properties.get("Given StepObjectRef Name") != null) {
            addGivenWithStepObjectName(replaceKeyword(properties.get("Given StepObjectRef Name").toString()));
            if (properties.get("Given StepDefinitionRef Name") != null) {
                setTestStepDefinitionName(replaceKeyword(properties.get("Given StepDefinitionRef Name").toString()));
                properties.remove("Given StepDefinitionRef Name");
            }
            properties.remove("Given StepObjectRef Name");
        } else if (properties.get("When StepObjectRef Name") != null) {
            addWhenWithStepObjectName(replaceKeyword(properties.get("When StepObjectRef Name").toString()));
            if (properties.get("When StepDefinitionRef Name") != null) {
                setTestStepDefinitionName(replaceKeyword(properties.get("When StepDefinitionRef Name").toString()));
                properties.remove("When StepDefinitionRef Name");
            }
            properties.remove("When StepObjectRef Name");
        } else if (properties.get("Then StepObjectRef Name") != null) {
            addThenWithStepObjectName(replaceKeyword(properties.get("Then StepObjectRef Name").toString()));
            if (properties.get("Then StepDefinitionRef Name") != null) {
                setTestStepDefinitionName(replaceKeyword(properties.get("Then StepDefinitionRef Name").toString()));
                properties.remove("Then StepDefinitionRef Name");
            }
            properties.remove("Then StepObjectRef Name");
        } else if (properties.get("And StepObjectRef Name") != null) {
            addAndWithStepObjectName(replaceKeyword(properties.get("And StepObjectRef Name").toString()));
            if (properties.get("And StepDefinitionRef Name") != null) {
                setTestStepDefinitionName(replaceKeyword(properties.get("And StepDefinitionRef Name").toString()));
                properties.remove("And StepDefinitionRef Name");
            }
            properties.remove("And StepObjectRef Name");
        }
    }

}
