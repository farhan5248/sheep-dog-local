package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface ProcessIssuesAsciidocFile {

    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap);

    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap);

    public String getDescriptionNodeState(HashMap<String, String> keyMap);

    public String getTestStepContainerListNodeAsFollows(HashMap<String, String> keyMap);

    public String getTestStepContainerListNodeNodePath(HashMap<String, String> keyMap);

    public String getTestStepContainerListNodeState(HashMap<String, String> keyMap);

    public void setCreated(HashMap<String, String> keyMap);

    public void setTestStepContainerListNodeCreatedAsFollows(HashMap<String, String> keyMap);

    public void setTestStepContainerListNodeNodePath(HashMap<String, String> keyMap);

    public void setTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap);

    public void setTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap);

    public String getTestStepContainerListNodeCreatedAsFollows(HashMap<String, String> keyMap);

    public String getTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap);

    public String getTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap);
}
