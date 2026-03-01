package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob;

import java.util.HashMap;

public interface InputFileAsciidocFile {

    public void setStepObjectNodeStepObjectName(HashMap<String, String> keyMap);

    public void setStepObjectNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void setStepObjectNodeStepDefinitionDescription(HashMap<String, String> keyMap);

    public void setStepObjectNodeStepObjectDescription(HashMap<String, String> keyMap);

    public void setStepObjectNodeStepParametersName(HashMap<String, String> keyMap);

    public void setStepObjectNodeStepParametersDescription(HashMap<String, String> keyMap);

    public void assertStepObject1NodeStepObjectName(HashMap<String, String> keyMap);

    public void assertStepObject1NodeStepDefinitionName(HashMap<String, String> keyMap);

    public void assertStepObject1NodeStepParametersName(HashMap<String, String> keyMap);

    public void assertStepObject1StepDefinitionNodeStepDefinitionName(HashMap<String, String> keyMap);

    public void assertStepObject1StepDefinition1StepParametersNodeStepParametersName(HashMap<String, String> keyMap);

    public void setStepObject1StepDefinition1StepParameters1TableRow1CellNodeCellName(HashMap<String, String> keyMap);

    public void assertStepObject1StepDefinition1StepParameters1TableRow1CellNodeCellName(HashMap<String, String> keyMap);

    public void assertStepObject1StepDefinition1StepParameters2TableRow1CellNodeCellName(HashMap<String, String> keyMap);
}
