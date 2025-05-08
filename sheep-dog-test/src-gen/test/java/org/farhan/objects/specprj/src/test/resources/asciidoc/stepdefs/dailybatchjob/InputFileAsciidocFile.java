package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob;

import java.util.HashMap;

public interface InputFileAsciidocFile {

    public void setObjectName(HashMap<String, String> keyMap);

    public void setObjectDescription(HashMap<String, String> keyMap);

    public void setStepDefinitionName(HashMap<String, String> keyMap);

    public void setParameters(HashMap<String, String> keyMap);

    public void setStepDefinitionDescription(HashMap<String, String> keyMap);

    public void assertObjectName(HashMap<String, String> keyMap);

    public void assertStepDefinitionName(HashMap<String, String> keyMap);

    public void assertParameters(HashMap<String, String> keyMap);
}
