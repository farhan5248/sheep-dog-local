package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
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

    @Override
    public void setTestStepContainerListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public void setTestStepContainerListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        addTestCaseWithName(keyMap.get("Test Case Name"));
    }

    @Override
    public void setTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        addTestSetupWithName(keyMap.get("Test Setup Name"));
    }

    @Override
    public String getTestStepContainerListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        return assertTestStepContainerName();
    }

    @Override
    public String getTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        return assertTestStepContainerName();
    }

    @Override
    public String getTestDataListNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTestDataListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getTestDataListNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return listToCsvString(((ITestCase) getProperty("cursor")).getTestDataList());
    }

    @Override
    public String getTestStepListNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTestStepListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getTestStepListNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return listToCsvString(((ITestStepContainer) getProperty("cursor")).getTestStepList());
    }

    @Override
    public void setTableNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public void setTableNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public String getTableNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTableNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getTableNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        ITable table = null;
        if (getProperty("cursor") instanceof ITestData)
            table = ((ITestData) getProperty("cursor")).getTable();
        return table == null ? null : table.toString();
    }

    @Override
    public void setTestDataListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public void setTestDataListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestDataListNodeTestDataName(HashMap<String, String> keyMap) {
        addTestDataWithName(keyMap.get("Test Data Name"));
    }

    @Override
    public String getTestDataListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTestDataListNodeTestDataName(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return ((ITestData) getProperty("cursor")).getName();
    }

    @Override
    public void setTestStepListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public void setTestStepListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap) {
    }

    @Override
    public void setTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
    }

    @Override
    public void setTestStepListNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(keyMap.get("Test Step Full Name"));
    }

    @Override
    public String getTestStepListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTestStepListNodeAndFullName(HashMap<String, String> keyMap) {
        return assertTestStepFullName();
    }

    @Override
    public String getTestStepListNodeAndStepObjectRefName(HashMap<String, String> keyMap) {
        return assertTestStepObjectName();
    }

    @Override
    public String getTestStepListNodeAndStepDefinitionRefName(HashMap<String, String> keyMap) {
        return assertTestStepDefinitionName();
    }

    @Override
    public String getTestStepListNodeGivenFullName(HashMap<String, String> keyMap) {
        return assertTestStepFullName();
    }

    @Override
    public String getTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap) {
        return assertTestStepObjectName();
    }

    @Override
    public String getTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
        return assertTestStepDefinitionName();
    }

    @Override
    public String getTestStepListNodeThenFullName(HashMap<String, String> keyMap) {
        return assertTestStepFullName();
    }

    @Override
    public String getTestStepListNodeThenStepObjectRefName(HashMap<String, String> keyMap) {
        return assertTestStepObjectName();
    }

    @Override
    public String getTestStepListNodeThenStepDefinitionRefName(HashMap<String, String> keyMap) {
        return assertTestStepDefinitionName();
    }

    @Override
    public String getTestStepListNodeWhenFullName(HashMap<String, String> keyMap) {
        return assertTestStepFullName();
    }

    @Override
    public String getTestStepListNodeWhenStepObjectRefName(HashMap<String, String> keyMap) {
        return assertTestStepObjectName();
    }

    @Override
    public String getTestStepListNodeWhenStepDefinitionRefName(HashMap<String, String> keyMap) {
        return assertTestStepDefinitionName();
    }

    @Override
    public String getTextNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTextNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getTextNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        IText text = null;
        if (getProperty("cursor") instanceof ITestStep)
            text = ((ITestStep) getProperty("cursor")).getText();
        return text == null ? null : text.toString();
    }

    @Override
    public void setTextNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public void setTextNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTextNodeTextContent(HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
    }

    @Override
    public void setRowListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public void setRowListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setRowListNodeRowContent(HashMap<String, String> keyMap) {
        addRowWithContent(keyMap.get("Row Content"));
    }

    @Override
    public String getRowListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getRowListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getRowListNodeRowContent(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return ((IRow) getProperty("cursor")).toString();
    }

}
