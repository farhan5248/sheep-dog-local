package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestIDEObject implements InputFileAsciidocFile {

    @Override
    public void assertTestProjectTestDocumentList1DescriptionLineList2NodeLineContent(HashMap<String, String> keyMap) {
        assertLineContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void assertTestProjectTestDocumentList1DescriptionNodeEmpty(HashMap<String, String> keyMap) {
        assertDescriptionEmpty(replaceKeyword(keyMap.get("Empty")));
    }

    @Override
    public void assertTestProjectTestDocumentList1NodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1NodeStepObjectFullName(HashMap<String, String> keyMap) {
        assertStepObjectFullName(replaceKeyword(keyMap.get("Step Object Full Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1NodeStepParametersName(HashMap<String, String> keyMap) {
        assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1StepDefinitionList1StepParametersList2TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1StepDefinitionList1StepParametersListNodeStepParametersName(
            HashMap<String, String> keyMap) {
        assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1StepDefinitionList2NodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList1StepDefinitionListNodeEmpty(HashMap<String, String> keyMap) {
        assertStepDefinitionListEmpty(replaceKeyword(keyMap.get("Empty")));
    }

    @Override
    public void assertTestProjectTestDocumentList1StepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void assertTestProjectTestDocumentList2NodeStepObjectFullName(HashMap<String, String> keyMap) {
        assertStepObjectFullName(replaceKeyword(keyMap.get("Step Object Full Name")));
    }

    @Override
    public void setTestProjectTestDocumentList1DescriptionLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void setTestProjectTestDocumentList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(
            HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setTestProjectTestDocumentList1StepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setTestProjectTestDocumentListNodeStepDefinitionDescription(HashMap<String, String> keyMap) {
        setStepDefinitionDescription(replaceKeyword(keyMap.get("Step Definition Description")));
    }

    @Override
    public void setTestProjectTestDocumentListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setTestProjectTestDocumentListNodeStepObjectDescription(HashMap<String, String> keyMap) {
        setStepObjectDescription(replaceKeyword(keyMap.get("Step Object Description")));
    }

    @Override
    public void setTestProjectTestDocumentListNodeStepObjectFullName(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(replaceKeyword(keyMap.get("Step Object Full Name")));
    }

    @Override
    public void setTestProjectTestDocumentListNodeStepParametersDescription(HashMap<String, String> keyMap) {
        setStepParametersDescription(replaceKeyword(keyMap.get("Step Parameters Description")));
    }

    @Override
    public void setTestProjectTestDocumentListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

}
