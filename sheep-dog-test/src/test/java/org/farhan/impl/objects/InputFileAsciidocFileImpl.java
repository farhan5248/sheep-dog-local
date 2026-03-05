package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestIDEObject implements InputFileAsciidocFile {

    @Override
    public void assertCellListNodeCellName(HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertCellListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertLineListNodeLineContent(HashMap<String, String> keyMap) {
        assertLineContent(replaceKeyword(keyMap.get("Line Content")), keyMap.get("Node Path"));
    }

    @Override
    public void assertLineListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertLineListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Empty")) {
            if (keyMap.get("Node Path").contains("NestedDescription")) {
                assertNestedDescriptionEmpty("true");
            } else {
                assertDescriptionEmpty("true");
            }
        }
    }

    @Override
    public void assertStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertStepDefinitionListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Empty")) {
            assertStepDefinitionListEmpty("true");
        }
    }

    @Override
    public void assertStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertStepParametersListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Empty")) {
            assertStepParametersListEmpty("true");
        }

    }

    @Override
    public void assertStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeStepObjectFullName(HashMap<String, String> keyMap) {
        assertStepObjectFullName(replaceKeyword(keyMap.get("Step Object Full Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeStepObjectName(HashMap<String, String> keyMap) {
        assertStepObjectName(replaceKeyword(keyMap.get("Step Object Name")));
    }

    @Override
    public void assertTestDocumentListNodeStepParametersName(HashMap<String, String> keyMap) {
        assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")), keyMap.get("Node Path"));
    }

    @Override
    public void setCellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void setLineListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void setTestDocumentListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestDocumentListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setTestDocumentListNodeStepObjectFullName(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(replaceKeyword(keyMap.get("Step Object Full Name")));
    }

    @Override
    public void setTestDocumentListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

}
