package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObjectSheepDogImpl implements ListProposalsAction {

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();

        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            ITestProject workspace = (ITestProject) getProperty("workspace");
            ArrayList<SheepDogIssueProposal> proposals = TestStepIssueResolver.suggestStepObjectNameWorkspace(testStep, workspace);
            setProperty("list proposals popup", proposals);
        }
    }
}
