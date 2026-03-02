package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob;

import java.util.HashMap;

public interface InputFileAsciidocFile {

    public void setStepObjectListNodeStepObjectName(HashMap<String, String> keyMap);

    public void setStepObjectListNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void setStepObjectListNodeStepDefinitionDescription(HashMap<String, String> keyMap);

    public void setStepObjectListNodeStepObjectDescription(HashMap<String, String> keyMap);

    public void setStepObjectListNodeStepParametersName(HashMap<String, String> keyMap);

    public void setStepObjectListNodeStepParametersDescription(HashMap<String, String> keyMap);

    public void assertStepObjectList1NodeStepObjectName(HashMap<String, String> keyMap);

    public void assertStepObjectList1NodeStepDefinitionName(HashMap<String, String> keyMap);

    public void assertStepObjectList1NodeStepParametersName(HashMap<String, String> keyMap);

    public void assertStepObjectList1StepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void assertStepObjectList1StepDefinitionList1StepParametersListNodeStepParametersName(HashMap<String, String> keyMap);

    public void setStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(HashMap<String, String> keyMap);

    public void assertStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(HashMap<String, String> keyMap);

    public void assertStepObjectList1StepDefinitionList1StepParametersList2TableRowList1CellListNodeCellName(HashMap<String, String> keyMap);
}
