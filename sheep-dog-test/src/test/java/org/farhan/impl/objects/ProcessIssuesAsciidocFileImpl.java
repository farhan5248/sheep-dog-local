package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSetup;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssuesAsciidocFileImpl extends TestObjectSheepDogImpl implements ProcessIssuesAsciidocFile {

    private void navigateToDocument() {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
    }

    private String navigateToDocumentAndGetCursor() {
        navigateToDocument();
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    private String navigateToNodeAndGetCursor(String nodePath) {
        navigateToDocument();
        setCursorAtNode(nodePath);
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        return navigateToNodeAndGetCursor(keyMap.get("Node Path"));
    }

    @Override
    public String getDescriptionNodeState(HashMap<String, String> keyMap) {
        IDescription desc = getDescriptionFromCursor();
        return desc == null ? null : desc.toString();
    }

    @Override
    public String getTestStepContainerListNodeAsFollows(HashMap<String, String> keyMap) {
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getTestStepContainerListNodeNodePath(HashMap<String, String> keyMap) {
        return navigateToNodeAndGetCursor(keyMap.get("Node Path"));
    }

    @Override
    public String getTestStepContainerListNodeState(HashMap<String, String> keyMap) {
        ITestSuite doc = (ITestSuite) getProperty("cursor");
        if (doc == null) {
            return null;
        }
        return listToString(doc.getTestStepContainerList());
    }

    @Override
    public void setCreated(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(getFullNameFromPath());
    }

    private void navigateToOrCreateDocument() {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument(getFullNameFromPath());
        if (doc == null) {
            addTestSuiteWithFullName(getFullNameFromPath());
        } else {
            setProperty("cursor", doc);
        }
    }

    @Override
    public void setTestStepContainerListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
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
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        ITestCase tc = (ITestCase) getProperty("cursor");
        return tc.getName();
    }

    @Override
    public String getTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        ITestSetup ts = (ITestSetup) getProperty("cursor");
        return ts.getName();
    }

    @Override
    public String getTestDataListNodeAsFollows(HashMap<String, String> keyMap) {
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getTestDataListNodeNodePath(HashMap<String, String> keyMap) {
        return navigateToNodeAndGetCursor(keyMap.get("Node Path"));
    }

    @Override
    public String getTestDataListNodeState(HashMap<String, String> keyMap) {
        ITestCase tc = (ITestCase) getProperty("cursor");
        if (tc == null) {
            return null;
        }
        return listToString(tc.getTestDataList());
    }

    @Override
    public String getTestStepListNodeAsFollows(HashMap<String, String> keyMap) {
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getTestStepListNodeNodePath(HashMap<String, String> keyMap) {
        return navigateToNodeAndGetCursor(keyMap.get("Node Path"));
    }

    @Override
    public String getTestStepListNodeState(HashMap<String, String> keyMap) {
        ITestStepContainer tsc = (ITestStepContainer) getProperty("cursor");
        if (tsc == null) {
            return null;
        }
        return listToString(tsc.getTestStepList());
    }

    @Override
    public String getTableNodeAsFollows(HashMap<String, String> keyMap) {
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getTableNodeNodePath(HashMap<String, String> keyMap) {
        return navigateToNodeAndGetCursor(keyMap.get("Node Path"));
    }

    @Override
    public String getTableNodeState(HashMap<String, String> keyMap) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITable) {
            return cursor.toString();
        }
        return null;
    }

    @Override
    public void setTestDataListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
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
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getTestDataListNodeTestDataName(HashMap<String, String> keyMap) {
        ITestData td = (ITestData) getProperty("cursor");
        return td.getName();
    }

    @Override
    public void setTestStepListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setTestStepListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap) {
        setProperty("Step Object Ref Name", keyMap.get("Given Step Object Ref Name"));
    }

    @Override
    public void setTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
        setProperty("Step Definition Ref Name", keyMap.get("Given Step Definition Ref Name"));
    }

    @Override
    public void setTestStepListNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(keyMap.get("Test Step Full Name"));
    }

    @Override
    public String getTestStepListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getTestStepListNodeAndFullName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getFullName();
    }

    @Override
    public String getTestStepListNodeAndStepObjectRefName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getStepObjectName();
    }

    @Override
    public String getTestStepListNodeAndStepDefinitionRefName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getStepDefinitionName();
    }

    @Override
    public String getTestStepListNodeGivenFullName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getFullName();
    }

    @Override
    public String getTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getStepObjectName();
    }

    @Override
    public String getTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getStepDefinitionName();
    }

    @Override
    public String getTestStepListNodeThenFullName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getFullName();
    }

    @Override
    public String getTestStepListNodeThenStepObjectRefName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getStepObjectName();
    }

    @Override
    public String getTestStepListNodeThenStepDefinitionRefName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getStepDefinitionName();
    }

    @Override
    public String getTestStepListNodeWhenFullName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getFullName();
    }

    @Override
    public String getTestStepListNodeWhenStepObjectRefName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getStepObjectName();
    }

    @Override
    public String getTestStepListNodeWhenStepDefinitionRefName(HashMap<String, String> keyMap) {
        ITestStep step = (ITestStep) getProperty("cursor");
        return step.getStepDefinitionName();
    }

    @Override
    public String getTextNodeAsFollows(HashMap<String, String> keyMap) {
        return navigateToDocumentAndGetCursor();
    }

    @Override
    public String getTextNodeNodePath(HashMap<String, String> keyMap) {
        return navigateToNodeAndGetCursor(keyMap.get("Node Path"));
    }

    @Override
    public String getTextNodeState(HashMap<String, String> keyMap) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStep) {
            IText text = ((ITestStep) cursor).getText();
            return text == null ? null : text.toString();
        }
        return null;
    }

    @Override
    public void setTableNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setTableNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTextNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setTextNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTextNodeTextContent(HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
    }
}
