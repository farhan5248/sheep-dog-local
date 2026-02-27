package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob;

import java.util.HashMap;

public interface InputFileAsciidocFile {

    public void setStepObjectName(HashMap<String, String> keyMap);

    public void setStepObjectDescription(HashMap<String, String> keyMap);

    public void assertStepObjectName(HashMap<String, String> keyMap);

    public void setStepDefinitionName(HashMap<String, String> keyMap);

    public void setStepDefinitionDescription(HashMap<String, String> keyMap);

    public void assertStepDefinitionName(HashMap<String, String> keyMap);

    public void setStepParametersName(HashMap<String, String> keyMap);

    public void setStepParametersDescription(HashMap<String, String> keyMap);

    public void assertStepParametersName(HashMap<String, String> keyMap);

    public void setCellName(HashMap<String, String> keyMap);

    public void assertCellName(HashMap<String, String> keyMap);
}
