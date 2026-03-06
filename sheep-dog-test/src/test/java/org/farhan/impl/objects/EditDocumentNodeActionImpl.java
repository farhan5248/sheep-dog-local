package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.objects.xtext.EditDocumentNodeAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditDocumentNodeActionImpl extends TestIDEObject implements EditDocumentNodeAction {

    @Override
    public void setAndStepDefinitionName(HashMap<String, String> keyMap) {
        properties.put("And StepDefinition Name", keyMap.get("And StepDefinition Name"));
    }

    @Override
    public void setAndStepObjectName(HashMap<String, String> keyMap) {
        properties.put("And StepObject Name", keyMap.get("And StepObject Name"));
    }

    @Override
    public void setCellName(HashMap<String, String> keyMap) {
        properties.put("Cell Name", keyMap.get("Cell Name"));
    }

    @Override
    public void setGivenStepDefinitionName(HashMap<String, String> keyMap) {
        properties.put("Given StepDefinition Name", keyMap.get("Given StepDefinition Name"));
    }

    @Override
    public void setGivenStepObjectName(HashMap<String, String> keyMap) {
        properties.put("Given StepObject Name", keyMap.get("Given StepObject Name"));
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
    public void setThenStepDefinitionName(HashMap<String, String> keyMap) {
        properties.put("Then StepDefinition Name", keyMap.get("Then StepDefinition Name"));
    }

    @Override
    public void setThenStepObjectName(HashMap<String, String> keyMap) {
        properties.put("Then StepObject Name", keyMap.get("Then StepObject Name"));
    }

    @Override
    public void setWhenStepDefinitionName(HashMap<String, String> keyMap) {
        properties.put("When StepDefinition Name", keyMap.get("When StepDefinition Name"));
    }

    @Override
    public void setWhenStepObjectName(HashMap<String, String> keyMap) {
        properties.put("When StepObject Name", keyMap.get("When StepObject Name"));
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
        } else if (properties.get("Given StepObject Name") != null) {
            addGivenWithStepObjectName(replaceKeyword(properties.get("Given StepObject Name").toString()));
            if (properties.get("Given StepDefinition Name") != null) {
                setTestStepDefinitionName(replaceKeyword(properties.get("Given StepDefinition Name").toString()));
                properties.remove("Given StepDefinition Name");
            }
            properties.remove("Given StepObject Name");
        } else if (properties.get("When StepObject Name") != null) {
            addWhenWithStepObjectName(replaceKeyword(properties.get("When StepObject Name").toString()));
            if (properties.get("When StepDefinition Name") != null) {
                setTestStepDefinitionName(replaceKeyword(properties.get("When StepDefinition Name").toString()));
                properties.remove("When StepDefinition Name");
            }
            properties.remove("When StepObject Name");
        } else if (properties.get("Then StepObject Name") != null) {
            addThenWithStepObjectName(replaceKeyword(properties.get("Then StepObject Name").toString()));
            if (properties.get("Then StepDefinition Name") != null) {
                setTestStepDefinitionName(replaceKeyword(properties.get("Then StepDefinition Name").toString()));
                properties.remove("Then StepDefinition Name");
            }
            properties.remove("Then StepObject Name");
        } else if (properties.get("And StepObject Name") != null) {
            addAndWithStepObjectName(replaceKeyword(properties.get("And StepObject Name").toString()));
            if (properties.get("And StepDefinition Name") != null) {
                setTestStepDefinitionName(replaceKeyword(properties.get("And StepDefinition Name").toString()));
                properties.remove("And StepDefinition Name");
            }
            properties.remove("And StepObject Name");
        }
    }

}
