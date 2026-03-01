package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestIDEObject implements InputFileAsciidocFile {

    @Override
    public void assertStepObject1NodeStepDefinitionName(HashMap<String, String> keyMap) {
        if (focus instanceof IStepDefinition) {
            focus = ((IStepDefinition) focus).getParent();
        }
        focus = ((IStepObject) focus).getStepDefinition(replaceKeyword(keyMap.get("Step Definition Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void assertStepObject1NodeStepObjectName(HashMap<String, String> keyMap) {
        if (focus instanceof IStepObject) {
            focus = ((IStepObject) focus).getParent();
        }
        focus = ((ITestProject) focus).getStepObject(replaceKeyword(keyMap.get("Step Object Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void assertStepObject1NodeStepParametersName(HashMap<String, String> keyMap) {
        if (focus instanceof IStepParameters) {
            focus = ((IStepParameters) focus).getParent();
        }
        focus = ((IStepDefinition) focus).getStepParameters(replaceKeyword(keyMap.get("Step Parameters Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void assertStepObject1StepDefinition1StepParameters1TableRow1CellNodeCellName(
            HashMap<String, String> keyMap) {
        if (focus instanceof ICell) {
            focus = ((ICell) focus).getParent();
        }
        focus = ((IRow) focus).getCell(replaceKeyword(keyMap.get("Cell Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void assertStepObject1StepDefinition1StepParameters2TableRow1CellNodeCellName(
            HashMap<String, String> keyMap) {
        if (focus instanceof ICell) {
            focus = ((ICell) focus).getParent();
        }
        focus = ((IRow) focus).getCell(replaceKeyword(keyMap.get("Cell Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void assertStepObject1StepDefinition1StepParametersNodeStepParametersName(HashMap<String, String> keyMap) {
        if (focus instanceof IStepParameters) {
            focus = ((IStepParameters) focus).getParent();
        }
        focus = ((IStepDefinition) focus).getStepParameters(replaceKeyword(keyMap.get("Step Parameters Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void assertStepObject1StepDefinitionNodeStepDefinitionName(HashMap<String, String> keyMap) {
        if (focus instanceof IStepDefinition) {
            focus = ((IStepDefinition) focus).getParent();
        }
        focus = ((IStepObject) focus).getStepDefinition(replaceKeyword(keyMap.get("Step Definition Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void setStepObject1StepDefinition1StepParameters1TableRow1CellNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setStepObjectNodeStepDefinitionDescription(HashMap<String, String> keyMap) {
        setStepDefinitionDescription(replaceKeyword(keyMap.get("Step Definition Description")));
    }

    @Override
    public void setStepObjectNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepObjectNodeStepObjectDescription(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEObject.testProject,
                    keyMap.get("Step Object Name"));
            SheepDogBuilder.createLine(stepObject, replaceKeyword(keyMap.get("Step Object Description")));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setStepObjectNodeStepObjectName(HashMap<String, String> keyMap) {
        addStepObjectWithName(replaceKeyword(keyMap.get("Step Object Name")));
    }

    @Override
    public void setStepObjectNodeStepParametersDescription(HashMap<String, String> keyMap) {
        setStepParametersDescription(replaceKeyword(keyMap.get("Step Parameters Description")));
    }

    @Override
    public void setStepObjectNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

}