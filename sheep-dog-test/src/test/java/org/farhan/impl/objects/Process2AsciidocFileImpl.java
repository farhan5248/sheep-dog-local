package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Process2AsciidocFileImpl extends TestIDEObject implements Process2AsciidocFile {

    @Override
    public void assertCellName(HashMap<String, String> keyMap) {
        if (focus instanceof ICell) {
            focus = ((ICell) focus).getParent();
        }
        ICell cell = ((IRow) focus).getCell(replaceKeyword(keyMap.get("Cell Name")));
        Assertions.assertNotNull(cell);
    }

    @Override
    public void assertTestCaseName(HashMap<String, String> keyMap) {
        if (focus instanceof ITestStepContainer) {
            focus = ((ITestStepContainer) focus).getParent();
        }
        ITestStepContainer testCase = ((ITestSuite) focus)
                .getTestStepContainer(replaceKeyword(keyMap.get("Test Case Name")));
        Assertions.assertNotNull(testCase);
    }

    @Override
    public void assertTestSuiteName(HashMap<String, String> keyMap) {
        if (focus instanceof ITestSuite) {
            focus = ((ITestSuite) focus).getParent();
        }
        ITestSuite testSuite = ((ITestProject) focus).getTestSuite(replaceKeyword(keyMap.get("Test Suite Name")));
        Assertions.assertNotNull(testSuite);
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
        addTestSuiteWithName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void setTextContent(HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
    }

}
