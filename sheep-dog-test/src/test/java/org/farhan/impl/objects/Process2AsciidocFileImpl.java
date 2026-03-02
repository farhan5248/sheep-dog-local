package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Process2AsciidocFileImpl extends TestIDEObject implements Process2AsciidocFile {

    @Override
    public void assertTestSuiteList1NodeTestSuiteName(HashMap<String, String> keyMap) {
        assertTestSuiteByName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void assertTestSuiteList1TestCaseList1NodeTestCaseName(HashMap<String, String> keyMap) {
        assertTestStepContainerByName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void assertTestSuiteList1TestCaseList1TestStepList1TableRowList1CellListNodeCellName(HashMap<String, String> keyMap) {
        assertCellByName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void setTestSuiteList1TestCaseList1TestStepList1TableRowList1CellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setTestSuiteList1TestCaseList1TestStepList1TableRowList2CellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setTestSuiteList1TestCaseList1TestStepList1TextNodeTextContent(HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
    }

    @Override
    public void setTestSuiteList1TestCaseList1TestStepListNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestSuiteList1TestCaseList2TestStepListNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestSuiteList1TestCaseListNodeTestCaseName(HashMap<String, String> keyMap) {
        addTestCaseWithName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setTestSuiteList1TestSetupList1TestStepListNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestSuiteListNodeTestSuiteName(HashMap<String, String> keyMap) {
        addTestSuiteWithName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

}
