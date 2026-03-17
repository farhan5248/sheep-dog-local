package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssuesAsciidocFileImpl extends TestObjectSheepDogImpl implements ProcessIssuesAsciidocFile {

    private void navigateToDocument() {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
    }

    @Override
    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getDescriptionNodeState(HashMap<String, String> keyMap) {
        IDescription desc = getDescriptionFromCursor();
        return desc == null ? null : desc.toString();
    }

    @Override
    public String getTestStepContainerListNodeAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getTestStepContainerListNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        setCursorAtNode(keyMap.get("Node Path"));
        return null;
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
        throw new UnsupportedOperationException();
    }

    @Override
    public String getTestStepContainerListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        ITestCase tc = (ITestCase) getProperty("cursor");
        return tc.getName();
    }

    @Override
    public String getTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        throw new UnsupportedOperationException();
    }
}
