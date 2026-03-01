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
    public void assertTestSuite1NodeTestSuiteName(HashMap<String, String> keyMap) {
        if (focus instanceof ITestSuite) {
            focus = ((ITestSuite) focus).getParent();
        }
        focus = ((ITestProject) focus).getTestSuite(replaceKeyword(keyMap.get("Test Suite Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void assertTestSuite1TestCase1NodeTestCaseName(HashMap<String, String> keyMap) {
        if (focus instanceof ITestStepContainer) {
            focus = ((ITestStepContainer) focus).getParent();
        }
        focus = ((ITestSuite) focus).getTestStepContainer(replaceKeyword(keyMap.get("Test Case Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void assertTestSuite1TestCase1TestStep1TableRow1CellNodeCellName(HashMap<String, String> keyMap) {
        if (focus instanceof ICell) {
            focus = ((ICell) focus).getParent();
        }
        focus = ((IRow) focus).getCell(replaceKeyword(keyMap.get("Cell Name")));
        Assertions.assertNotNull(focus);
    }

    @Override
    public void setTestSuite1TestCase1TestStep1TableRow1CellNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setTestSuite1TestCase1TestStep1TableRow2CellNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setTestSuite1TestCase1TestStep1TextNodeTextContent(HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
    }

    @Override
    public void setTestSuite1TestCase1TestStepNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestSuite1TestCase2TestStepNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestSuite1TestCaseNodeTestCaseName(HashMap<String, String> keyMap) {
        addTestCaseWithName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setTestSuite1TestSetup1TestStepNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestSuiteNodeTestSuiteName(HashMap<String, String> keyMap) {
        addTestSuiteWithName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

}