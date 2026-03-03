package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssuesAsciidocFileImpl extends TestIDEObject implements ProcessIssuesAsciidocFile {

    @Override
    public void assertModelTestSuiteList1NodeTestSuiteName(HashMap<String, String> keyMap) {
        assertTestSuiteByName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void assertModelTestSuiteList1TestStepContainerList1NodeTestCaseName(HashMap<String, String> keyMap) {
        assertTestStepContainerByName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void assertModelTestSuiteList1TestStepContainerList1TestStepList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        assertCellByName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void setModelTestSuiteList1TestStepContainerList1TestStepList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setModelTestSuiteList1TestStepContainerList1TestStepList1TableRowList2CellListNodeCellName(
            HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setModelTestSuiteList1TestStepContainerList1TestStepList1TextNodeTextContent(
            HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
    }

    @Override
    public void setModelTestSuiteList1TestStepContainerList2TestStepListNodeTestStepFullName(
            HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setModelTestSuiteList1TestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        addTestCaseWithName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setModelTestSuiteList1TestStepContainerList1TestStepListNodeTestStepFullName(
            HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setModelTestSuiteList1TestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        addTestSetupWithName(replaceKeyword(keyMap.get("Test Setup Name")));
    }

    @Override
    public void setModelTestSuiteListNodeTestSuiteName(HashMap<String, String> keyMap) {
        addTestSuiteWithName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

}
