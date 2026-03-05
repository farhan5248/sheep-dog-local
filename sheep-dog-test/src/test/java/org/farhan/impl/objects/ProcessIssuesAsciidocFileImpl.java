package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssuesAsciidocFileImpl extends TestIDEObject implements ProcessIssuesAsciidocFile {

    @Override
    public void assertTestProjectTestDocumentList1NodeTestSuiteName(HashMap<String, String> keyMap) {
        assertTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1NodeTestCaseName(HashMap<String, String> keyMap) {
        assertTestStepContainerName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList2CellListNodeCellName(
            HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepList1TextNodeTextContent(
            HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList2TestStepListNodeTestStepFullName(
            HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        addTestCaseWithName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeTestStepFullName(
            HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        addTestSetupWithName(replaceKeyword(keyMap.get("Test Setup Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1DescriptionLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void setTestProjectTestDocumentListNodeTestSuiteFullName(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(replaceKeyword(keyMap.get("Test Suite Full Name")));
    }

    @Override
    public void setTestProjectTestDocumentListNodeTestSuiteName(HashMap<String, String> keyMap) {
        setTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1DescriptionLineListNodeEmpty(HashMap<String, String> keyMap) {
        assertDescriptionEmpty(replaceKeyword(keyMap.get("Empty")));
    }

    @Override
    public void assertTestProjectTestDocumentList1DescriptionLineList2NodeLineContent(HashMap<String, String> keyMap) {
        assertLineContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerListNodeEmpty(HashMap<String, String> keyMap) {
        assertTestStepContainerListEmpty(replaceKeyword(keyMap.get("Empty")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList2NodeTestCaseName(HashMap<String, String> keyMap) {
        assertTestStepContainerName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList2NodeTestSuiteFullName(HashMap<String, String> keyMap) {
        assertTestSuiteFullName(replaceKeyword(keyMap.get("Test Suite Full Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList2NodeTestSuiteName(HashMap<String, String> keyMap) {
        assertTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

}
