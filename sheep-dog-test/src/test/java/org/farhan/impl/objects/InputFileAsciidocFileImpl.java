package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestIDEObject implements InputFileAsciidocFile {

    @Override
    public void assertStepObjectList1NodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionByName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void assertStepObjectList1NodeStepObjectName(HashMap<String, String> keyMap) {
        assertStepObjectByName(replaceKeyword(keyMap.get("Step Object Name")));
    }

    @Override
    public void assertStepObjectList1NodeStepParametersName(HashMap<String, String> keyMap) {
        assertStepParametersByName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void assertStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        assertCellByName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertStepObjectList1StepDefinitionList1StepParametersList2TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        assertCellByName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertStepObjectList1StepDefinitionList1StepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        assertStepParametersByName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void assertStepObjectList1StepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionByName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setStepObjectListNodeStepDefinitionDescription(HashMap<String, String> keyMap) {
        setStepDefinitionDescription(replaceKeyword(keyMap.get("Step Definition Description")));
    }

    @Override
    public void setStepObjectListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepObjectListNodeStepObjectDescription(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEObject.testProject,
                    keyMap.get("Step Object Name"));
            SheepDogBuilder.createLine(stepObject, replaceKeyword(keyMap.get("Step Object Description")));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setStepObjectListNodeStepObjectName(HashMap<String, String> keyMap) {
        addStepObjectWithName(replaceKeyword(keyMap.get("Step Object Name")));
    }

    @Override
    public void setStepObjectListNodeStepParametersDescription(HashMap<String, String> keyMap) {
        setStepParametersDescription(replaceKeyword(keyMap.get("Step Parameters Description")));
    }

    @Override
    public void setStepObjectListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

}
