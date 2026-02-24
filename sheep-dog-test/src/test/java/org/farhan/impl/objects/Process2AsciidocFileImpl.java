package org.farhan.impl.objects;

import java.util.HashMap;
import java.util.List;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Process2AsciidocFileImpl extends TestIDEObject implements Process2AsciidocFile {

    @Override
    public void setBackgroundTestStepListAssignmentTestStepFullName(HashMap<String, String> keyMap) {
        addTestSetupStep(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestStepListAssignmentRowCellList(HashMap<String, String> keyMap) {
        addTable();
        addRow();
        for (String h : keyMap.get("Row Cell List").split(",")) {
            addCell(h.trim());
        }
    }

    public void setTestStepListAssignmentTestStepFullName(HashMap<String, String> keyMap) {
        addTestCaseStep(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestStepListAssignmentTextContent(HashMap<String, String> keyMap) {
        addText(keyMap.get("Text Content"));
    }

    @Override
    public void setTestCaseName(HashMap<String, String> keyMap) {
        addTestStepContainer(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setTestSuiteName(HashMap<String, String> keyMap) {
        addTestSuite(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void assertTestStepFullName(HashMap<String, String> keyMap) {
        try {
            ITestStep testStep = (ITestStep) TestIDEObject.getElementByType("TestStep");
            String expectedStepName = replaceKeyword(keyMap.get("Test Step Full Name"));
            String actualStepName = testStep.getStepObjectName() + " " + testStep.getStepDefinitionName();

            if (!actualStepName.contentEquals(expectedStepName)) {
                Assertions.fail("Expected step name: '" + expectedStepName +
                              "' but found: '" + actualStepName + "'");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void assertRowCellList(HashMap<String, String> keyMap) {
        try {
            IRow row = (IRow) TestIDEObject.getElementByType("Row");
            String[] expectedContents = keyMap.get("Row Cell List").split(",");
            List<ICell> cells = row.getCellList();

            if (cells.size() != expectedContents.length) {
                Assertions.fail("Expected " + expectedContents.length +
                              " cells but found " + cells.size());
            }

            for (int i = 0; i < expectedContents.length; i++) {
                String expected = expectedContents[i].trim();
                String actual = cells.get(i).getName();
                if (!actual.contentEquals(expected)) {
                    Assertions.fail("Cell " + i + ": Expected '" + expected +
                                  "' but found '" + actual + "'");
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void assertTestSuiteName(HashMap<String, String> keyMap) {
        try {
            ITestSuite testSuite = (ITestSuite) TestIDEObject.getElementByType("TestSuite");
            String expectedName = replaceKeyword(keyMap.get("Test Suite Name"));
            String actualName = testSuite.getName();

            if (!actualName.contentEquals(expectedName)) {
                Assertions.fail("Expected test suite name: '" + expectedName +
                              "' but found: '" + actualName + "'");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void assertTestCaseName(HashMap<String, String> keyMap) {
        try {
            ITestStepContainer testCase = (ITestStepContainer) TestIDEObject.getElementByType("TestStepContainer");
            String expectedName = replaceKeyword(keyMap.get("Test Case Name"));
            String actualName = testCase.getName();

            if (!actualName.contentEquals(expectedName)) {
                Assertions.fail("Expected test case name: '" + expectedName +
                              "' but found: '" + actualName + "'");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
