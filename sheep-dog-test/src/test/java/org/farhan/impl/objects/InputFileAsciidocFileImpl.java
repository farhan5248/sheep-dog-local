package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestIDEObject implements InputFileAsciidocFile {

    @Override
    public void assertStepObjectName(HashMap<String, String> keyMap) {
        try {
            Assertions.assertNotNull(TestIDEObject.testProject.getStepObject(keyMap.get("Step Object Name")));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void assertStepParametersName(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = TestIDEObject.testProject.getStepObject(keyMap.get("Step Object Name"));
            IStepDefinition stepDefinition = stepObject.getStepDefinition(keyMap.get("Step Definition Name"));
            if (stepDefinition.getStepParameters(keyMap.get("Step Parameters Name")) != null) {
                return;
            }
            Assertions.fail("No parameters found: " + keyMap.get("Step Parameters Name"));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void assertStepDefinitionName(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = TestIDEObject.testProject.getStepObject(keyMap.get("Step Object Name"));
            Assertions.assertNotNull(stepObject);
            for (IStepDefinition stepDef : stepObject.getStepDefinitionList()) {
                if (stepDef.getName().contentEquals(keyMap.get("Step Definition Name"))) {
                    return;
                }
            }
            Assertions.fail("No step defintion found" + keyMap.get("Step Definition Name"));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setStepObjectDescription(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEObject.testProject,
                    keyMap.get("Step Object Name"));
            SheepDogBuilder.createLine(stepObject, replaceKeyword(keyMap.get("Step Object Description")));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setStepObjectName(HashMap<String, String> keyMap) {
        try {
            SheepDogBuilder.createStepObject(TestIDEObject.testProject, keyMap.get("Step Object Name"));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEObject.testProject,
                    keyMap.get("Step Object Name"));
            IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
                    keyMap.get("Step Definition Name"));
            String name = keyMap.get("Step Parameters Name");
            IStepParameters stepParameters = SheepDogBuilder.createStepParameters(stepDefinition, name);
            ITable table = SheepDogBuilder.createTable(stepParameters);
            IRow row = SheepDogBuilder.createRow(table);
            for (String h : name.split(",")) {
                SheepDogBuilder.createCell(row, h.trim());
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setStepDefinitionDescription(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEObject.testProject,
                    keyMap.get("Step Object Name"));
            IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
                    keyMap.get("Step Definition Name"));
            SheepDogBuilder.createLine(stepDefinition, replaceKeyword(keyMap.get("Step Definition Description")));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEObject.testProject,
                    keyMap.get("Step Object Name"));
            SheepDogBuilder.createStepDefinition(stepObject, keyMap.get("Step Definition Name"));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setStepParametersDescription(HashMap<String, String> keyMap) {
        try {
            IStepObject stepObject = SheepDogBuilder.createStepObject(TestIDEObject.testProject,
                    keyMap.get("Step Object Name"));
            IStepDefinition stepDefinition = SheepDogBuilder.createStepDefinition(stepObject,
                    keyMap.get("Step Definition Name"));
            String name = keyMap.get("Step Parameters Name");
            IStepParameters stepParameters = SheepDogBuilder.createStepParameters(stepDefinition, name);
            ITable table = SheepDogBuilder.createTable(stepParameters);
            IRow row = SheepDogBuilder.createRow(table);
            for (String h : name.split(",")) {
                SheepDogBuilder.createCell(row, h.trim());
            }
            SheepDogBuilder.createLine(stepParameters, replaceKeyword(keyMap.get("Step Parameters Description")));
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }
}
