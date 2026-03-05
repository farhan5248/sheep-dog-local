package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.objects.xtext.EditDocumentAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class EditDocumentActionImpl extends TestIDEObject implements EditDocumentAction {

    @Override
    public void transition() {
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
        } else if (properties.get("Step Parameters Name") != null) {
            addStepParametersWithName(replaceKeyword(properties.get("Step Parameters Name").toString()));
            properties.remove("Step Parameters Name");
        } else if (properties.get("Cell Name") != null) {
            addCellWithName(replaceKeyword(properties.get("Cell Name").toString()));
            properties.remove("Cell Name");
        } else if (properties.get("Line Content") != null) {
            addLineWithContent(replaceKeyword(properties.get("Line Content").toString()));
            properties.remove("Line Content");
        }
    }

    @Override
    public void setCellName(HashMap<String, String> keyMap) {
        properties.put("Cell Name", keyMap.get("Cell Name"));
    }

    @Override
    public void setLineContent(HashMap<String, String> keyMap) {
        properties.put("Line Content", keyMap.get("Line Content"));
    }

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        properties.put("Step Parameters Name", keyMap.get("Step Parameters Name"));
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
    public void setTestCaseName(HashMap<String, String> keyMap) {
        properties.put("Test Case Name", keyMap.get("Test Case Name"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

}
