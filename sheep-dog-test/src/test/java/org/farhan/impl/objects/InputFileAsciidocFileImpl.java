package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestObjectIDE;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestObjectIDE implements InputFileAsciidocFile {

    @Override
    public void assertCellListNodeCellName(HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertCellListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
    }

    @Override
    public void assertDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
    }

    @Override
    public void assertDescriptionNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertDescriptionEmpty();
        }
    }

    @Override
    public void assertLineListNodeLineContent(HashMap<String, String> keyMap) {
        assertLineContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void assertLineListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
    }

    @Override
    public void assertNestedDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
    }

    @Override
    public void assertNestedDescriptionNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertDescriptionEmpty();
        }
    }

    @Override
    public void assertStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
    }

    @Override
    public void assertStepDefinitionListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Empty")) {
            assertStepDefinitionListEmpty();
        } else if (keyMap.get("State").contentEquals("Absent")) {
            Assertions.assertNull(cursor);
        }
    }

    @Override
    public void assertStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void assertStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
    }

    @Override
    public void assertStepParametersListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Empty")) {
            assertStepParametersListEmpty();
        } else if (keyMap.get("State").contentEquals("Absent")) {
            Assertions.assertNull(cursor);
        }
    }

    @Override
    public void assertStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void assertTableNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
    }

    @Override
    public void assertTableNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertTableAbsent();
        } else if (keyMap.get("State").contentEquals("Present")) {
            assertTablePresent();
        }
    }

    @Override
    public void setCellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void setLineListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void setCreated(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public void assertStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void assertStepParametersName(HashMap<String, String> keyMap) {
        assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }
}
