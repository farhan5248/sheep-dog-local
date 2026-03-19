package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob;

import java.util.HashMap;

public interface InputFileAsciidocFile {

    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap);

    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap);

    public String getDescriptionNodeState(HashMap<String, String> keyMap);

    public String getStepDefinitionListNodeAsFollows(HashMap<String, String> keyMap);

    public String getStepDefinitionListNodeNodePath(HashMap<String, String> keyMap);

    public String getStepDefinitionListNodeState(HashMap<String, String> keyMap);

    public void setCreated(HashMap<String, String> keyMap);
}
