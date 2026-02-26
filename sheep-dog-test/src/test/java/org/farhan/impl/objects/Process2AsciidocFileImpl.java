package org.farhan.impl.objects;

import java.util.HashMap;
import java.util.List;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Process2AsciidocFileImpl extends TestIDEObject implements Process2AsciidocFile {

    @Override
    public void assertCellName(HashMap<String, String> keyMap) {
        try {
            IRow row = (IRow) focus;
            String[] expectedContents = keyMap.get("Cell Name").split(",");
            List<ICell> cells = row.getCellList();

            if (cells.size() != expectedContents.length) {
                Assertions.fail("Expected " + expectedContents.length + " cells but found " + cells.size());
            }

            for (int i = 0; i < expectedContents.length; i++) {
                String expected = expectedContents[i].trim();
                String actual = cells.get(i).getName();
                if (!actual.contentEquals(expected)) {
                    Assertions.fail("Cell " + i + ": Expected '" + expected + "' but found '" + actual + "'");
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void assertTestCaseName(HashMap<String, String> keyMap) {
        try {
            ITestStepContainer testCase = (ITestStepContainer) focus;
            String expectedName = replaceKeyword(keyMap.get("Test Case Name"));
            String actualName = testCase.getName();

            if (!actualName.contentEquals(expectedName)) {
                Assertions.fail("Expected test case name: '" + expectedName + "' but found: '" + actualName + "'");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void assertTestSuiteName(HashMap<String, String> keyMap) {
        try {
            ITestSuite testSuite = (ITestSuite) focus;
            String expectedName = replaceKeyword(keyMap.get("Test Suite Name"));
            String actualName = testSuite.getName();

            if (!actualName.contentEquals(expectedName)) {
                Assertions.fail("Expected test suite name: '" + expectedName + "' but found: '" + actualName + "'");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setTestCaseName(HashMap<String, String> keyMap) {
        addTestCaseWithName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    public void setTestStepListAssignmentTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestSuiteName(HashMap<String, String> keyMap) {
        addTestSuite(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void setTextContent(HashMap<String, String> keyMap) {
        addText(keyMap.get("Text Content"));
    }

}
