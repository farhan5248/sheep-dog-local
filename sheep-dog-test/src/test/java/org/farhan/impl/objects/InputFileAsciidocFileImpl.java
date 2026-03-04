package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestIDEObject implements InputFileAsciidocFile {

    @Override
    public void assertModelStepObjectList1NodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void assertModelStepObjectList1NodeStepObjectName(HashMap<String, String> keyMap) {
        assertStepObjectName(replaceKeyword(keyMap.get("Step Object Name")));
    }

    @Override
    public void assertModelStepObjectList1NodeStepParametersName(HashMap<String, String> keyMap) {
        assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void assertModelStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertModelStepObjectList1StepDefinitionList1StepParametersList2TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertModelStepObjectList1StepDefinitionList1StepParametersListNodeStepParametersName(
            HashMap<String, String> keyMap) {
        assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void assertModelStepObjectList1StepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setCreated(HashMap<String, String> keyMap) {
        // TODO clear the list of step objects and test suites or change the step to
        // doesn't exist
    }

    @Override
    public void setModelStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setModelStepObjectListNodeStepDefinitionDescription(HashMap<String, String> keyMap) {
        setStepDefinitionDescription(replaceKeyword(keyMap.get("Step Definition Description")));
    }

    @Override
    public void setModelStepObjectListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setModelStepObjectListNodeStepObjectName(HashMap<String, String> keyMap) {
        addStepObjectWithName(replaceKeyword(keyMap.get("Step Object Name")));
    }

    @Override
    public void setModelStepObjectListNodeStepParametersDescription(HashMap<String, String> keyMap) {
        setStepParametersDescription(replaceKeyword(keyMap.get("Step Parameters Description")));
    }

    @Override
    public void setModelStepObjectListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void setModelStepObjectList1StepDefinitionList1NodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void assertModelStepObjectList1StepDefinitionList2NodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setModelStepObjectList1DescriptionLineList1NodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void assertModelStepObjectList1DescriptionLineList2NodeLineContent(HashMap<String, String> keyMap) {
        assertLineContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void assertModelStepObjectList1DescriptionNodeEmpty(HashMap<String, String> keyMap) {
        Assertions.assertTrue(((IDescription) cursor).getLineList().isEmpty());
    }

    @Override
    public void assertModelStepObjectList1StepDefinitionListNodeEmpty(HashMap<String, String> keyMap) {
        Assertions.assertTrue(((IStepObject) cursor).getStepDefinitionList().isEmpty());
    }

    @Override
    public void setModelStepObjectListNodeStepObjectDescription(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEObject.testProject,
                    keyMap.get("Step Object Name"));
            IDescription description = SheepDogBuilder.createDescription(stepObject);
            SheepDogBuilder.createLine(description, replaceKeyword(keyMap.get("Step Object Description")));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
