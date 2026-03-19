package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

public class ProcessIssuesAsciidocFileImpl extends TestObjectSheepDogImpl implements ProcessIssuesAsciidocFile {

    @Override
    public void setCreated(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getDescriptionNodeState(HashMap<String, String> keyMap) {
        IDescription desc = getDescriptionFromCursor();
        return desc == null ? null : desc.toString();
    }

    @Override
    public String getTestStepContainerListNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTestStepContainerListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getTestStepContainerListNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return listToCsvString(((ITestSuite) getProperty("cursor")).getTestStepContainerList());
    }

}
