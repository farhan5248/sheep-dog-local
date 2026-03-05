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

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1DescriptionLineListNodeEmpty(HashMap<String, String> keyMap) {
        assertDescriptionEmpty(replaceKeyword(keyMap.get("Empty")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestDataListNodeTestDataName(HashMap<String, String> keyMap) {
        addTestDataWithName(replaceKeyword(keyMap.get("Test Data Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestDataListNodeEmpty(HashMap<String, String> keyMap) {
        assertTestDataListEmpty(replaceKeyword(keyMap.get("Empty")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestDataList1NestedDescriptionLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestDataList1NestedDescriptionLineListNodeEmpty(HashMap<String, String> keyMap) {
        assertNestedDescriptionEmpty(replaceKeyword(keyMap.get("Empty")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestDataList1NestedDescriptionLineList2NodeLineContent(HashMap<String, String> keyMap) {
        assertLineContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestDataList1TableRowListNodeRowContent(HashMap<String, String> keyMap) {
        addRowWithContent(keyMap.get("Row Content"));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestDataList1TableRowList1CellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestDataList1TableRowList1CellList2NodeCellName(HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestDataList1TableRowList2NodeRowContent(HashMap<String, String> keyMap) {
        assertRowContent(replaceKeyword(keyMap.get("Row Content")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestDataList2NodeTestDataName(HashMap<String, String> keyMap) {
        assertTestDataName(replaceKeyword(keyMap.get("Test Data Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeAndStepObjectName(HashMap<String, String> keyMap) {
        addAndWithStepObjectName(replaceKeyword(keyMap.get("And StepObject Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeAndStepDefinitionName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("And StepDefinition Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeGivenStepObjectName(HashMap<String, String> keyMap) {
        addGivenWithStepObjectName(replaceKeyword(keyMap.get("Given StepObject Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeGivenStepDefinitionName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("Given StepDefinition Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeThenStepObjectName(HashMap<String, String> keyMap) {
        addThenWithStepObjectName(replaceKeyword(keyMap.get("Then StepObject Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeThenStepDefinitionName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("Then StepDefinition Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeWhenStepObjectName(HashMap<String, String> keyMap) {
        addWhenWithStepObjectName(replaceKeyword(keyMap.get("When StepObject Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeWhenStepDefinitionName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("When StepDefinition Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepListNodeEmpty(HashMap<String, String> keyMap) {
        assertTestStepListEmpty(replaceKeyword(keyMap.get("Empty")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList1TableRowList1CellList2NodeCellName(HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList2NodeAndStepObjectName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("And StepObject Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList2NodeAndStepDefinitionName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("And StepDefinition Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList2NodeGivenStepObjectName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("Given StepObject Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList2NodeGivenStepDefinitionName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("Given StepDefinition Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList2NodeThenStepObjectName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("Then StepObject Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList2NodeThenStepDefinitionName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("Then StepDefinition Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList2NodeWhenStepObjectName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("When StepObject Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList1TestStepList2NodeWhenStepDefinitionName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("When StepDefinition Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1TestStepContainerList2NodeTestSetupName(HashMap<String, String> keyMap) {
        assertTestStepContainerName(replaceKeyword(keyMap.get("Test Setup Name")));
    }

}
