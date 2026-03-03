package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob;

import java.util.HashMap;

public interface InputFileAsciidocFile {

    public void setModelStepObjectListNodeStepObjectName(HashMap<String, String> keyMap);

    public void setModelStepObjectListNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void setModelStepObjectListNodeStepDefinitionDescription(HashMap<String, String> keyMap);

    public void setModelStepObjectListNodeStepObjectDescription(HashMap<String, String> keyMap);

    public void setModelStepObjectListNodeStepParametersName(HashMap<String, String> keyMap);

    public void setModelStepObjectListNodeStepParametersDescription(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1NodeStepObjectName(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1NodeStepDefinitionName(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1NodeStepParametersName(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1StepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1StepDefinitionList1StepParametersListNodeStepParametersName(HashMap<String, String> keyMap);

    public void setModelStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1StepDefinitionList1StepParametersList1TableRowList1CellListNodeCellName(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1StepDefinitionList1StepParametersList2TableRowList1CellListNodeCellName(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1DescriptionNodeEmpty(HashMap<String, String> keyMap);

    public void setLineContent(HashMap<String, String> keyMap);

    public void assertModelStepObjectList1StepDefinitionListNodeEmpty(HashMap<String, String> keyMap);

    public void setStepDefinitionName(HashMap<String, String> keyMap);

    public void setCreated(HashMap<String, String> keyMap);
}
