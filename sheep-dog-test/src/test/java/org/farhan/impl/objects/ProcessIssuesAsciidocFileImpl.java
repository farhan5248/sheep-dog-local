package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssuesAsciidocFileImpl extends TestObjectSheepDogImpl implements ProcessIssuesAsciidocFile {

    @Override
    public String getCellListNodeCellName(HashMap<String, String> keyMap) {
        return assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public String getCellListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getDescriptionNodeState(HashMap<String, String> keyMap) {
        IDescription desc = getDescriptionFromCursor();
        return desc == null ? null : desc.toString();
    }

    @Override
    public String getRowListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getRowListNodeRowContent(HashMap<String, String> keyMap) {
        return assertRowContent(replaceKeyword(keyMap.get("Row Content")));
    }

    @Override
    public String getTableNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTableNodeState(HashMap<String, String> keyMap) {
        ITable table = getTableFromCursor();
        return table == null ? null : table.toString();
    }

    @Override
    public String getTestDataListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTestDataListNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return listToString(((ITestCase) getProperty("cursor")).getTestDataList());
    }

    @Override
    public String getTestDataListNodeTestDataName(HashMap<String, String> keyMap) {
        return assertTestDataName(replaceKeyword(keyMap.get("Test Data Name")));
    }

    @Override
    public String getTestStepContainerListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTestStepContainerListNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return listToString(((ITestSuite) getProperty("cursor")).getTestStepContainerList());
    }

    @Override
    public String getTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        return assertTestStepContainerName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public String getTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        return assertTestStepContainerName(replaceKeyword(keyMap.get("Test Setup Name")));
    }

    @Override
    public String getTestStepListNodeAndFullName(HashMap<String, String> keyMap) {
        return assertTestStepFullName(replaceKeyword(keyMap.get("And Full Name")));
    }

    @Override
    public String getTestStepListNodeAndStepDefinitionRefName(HashMap<String, String> keyMap) {
        return assertStepDefinitionRefName(replaceKeyword(keyMap.get("And StepDefinitionRef Name")));
    }

    @Override
    public String getTestStepListNodeAndStepObjectRefName(HashMap<String, String> keyMap) {
        return assertStepObjectRefName(replaceKeyword(keyMap.get("And StepObjectRef Name")));
    }

    @Override
    public String getTestStepListNodeGivenFullName(HashMap<String, String> keyMap) {
        return assertTestStepFullName(replaceKeyword(keyMap.get("Given Full Name")));
    }

    @Override
    public String getTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
        return assertStepDefinitionRefName(replaceKeyword(keyMap.get("Given StepDefinitionRef Name")));
    }

    @Override
    public String getTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap) {
        return assertStepObjectRefName(replaceKeyword(keyMap.get("Given StepObjectRef Name")));
    }

    @Override
    public String getTestStepListNodeNodePath(HashMap<String, String> keyMap) {
        setCursorAtNode(keyMap.get("Node Path"));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTestStepListNodeState(HashMap<String, String> keyMap) {
        return listToString(((ITestStepContainer) getProperty("cursor")).getTestStepList());
    }

    @Override
    public String getTestStepListNodeThenFullName(HashMap<String, String> keyMap) {
        return assertTestStepFullName(replaceKeyword(keyMap.get("Then Full Name")));
    }

    @Override
    public String getTestStepListNodeThenStepDefinitionRefName(HashMap<String, String> keyMap) {
        return assertStepDefinitionRefName(replaceKeyword(keyMap.get("Then StepDefinitionRef Name")));
    }

    @Override
    public String getTestStepListNodeThenStepObjectRefName(HashMap<String, String> keyMap) {
        return assertStepObjectRefName(replaceKeyword(keyMap.get("Then StepObjectRef Name")));
    }

    @Override
    public String getTestStepListNodeWhenFullName(HashMap<String, String> keyMap) {
        return assertTestStepFullName(replaceKeyword(keyMap.get("When Full Name")));
    }

    @Override
    public String getTestStepListNodeWhenStepDefinitionRefName(HashMap<String, String> keyMap) {
        return assertStepDefinitionRefName(replaceKeyword(keyMap.get("When StepDefinitionRef Name")));
    }

    @Override
    public String getTestStepListNodeWhenStepObjectRefName(HashMap<String, String> keyMap) {
        return assertStepObjectRefName(replaceKeyword(keyMap.get("When StepObjectRef Name")));
    }

    @Override
    public String getTextNodeNodePath(HashMap<String, String> keyMap) {
        String path = keyMap.get("Node Path");
        String parentPath = path.substring(0, path.lastIndexOf("/"));
        setCursorAtNode(parentPath);
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTextNodeState(HashMap<String, String> keyMap) {
        IText text = ((ITestStep) getProperty("cursor")).getText();
        return text == null ? null : text.toString();
    }

    @Override
    public void setCellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
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
    public void setTableNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestDataListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestDataListNodeTestDataName(HashMap<String, String> keyMap) {
        addTestDataWithName(replaceKeyword(keyMap.get("Test Data Name")));
    }

    @Override
    public void setTestStepContainerListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        addTestCaseWithName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        addTestSetupWithName(replaceKeyword(keyMap.get("Test Setup Name")));
    }

    @Override
    public void setTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
        setStepDefinitionName(replaceKeyword(keyMap.get("Given StepDefinitionRef Name")));
    }

    @Override
    public void setTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Given StepObjectRef Name")));
    }

    @Override
    public void setTestStepListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestStepListNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestSuiteName(HashMap<String, String> keyMap) {
        setTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
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
    public void setCreated(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getTestSuiteName(HashMap<String, String> keyMap) {
        return assertTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getTextNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setRowListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getRowListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setTableNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getTableNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setTestDataListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getTestDataListNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTestDataListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setTestStepContainerListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getTestStepContainerListNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTestStepContainerListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setTestStepListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    @Override
    public String getTestStepListNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTestStepListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setTextNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

}
