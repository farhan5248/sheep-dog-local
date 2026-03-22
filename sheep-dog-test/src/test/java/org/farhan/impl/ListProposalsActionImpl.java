package org.farhan.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObjectSheepDogImpl implements ListProposalsAction {

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
        try {
            Object cursor = getProperty("cursor");
            @SuppressWarnings("unchecked")
            ArrayList<SheepDogIssueProposal> listProposalsDialog = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
            listProposalsDialog.clear();
            if (cursor instanceof IRow) {
                Object tableParent = ((IRow) cursor).getParent().getParent();
                if (tableParent instanceof ITestStep) {
                    listProposalsDialog.addAll(
                            TestStepIssueResolver.suggestStepParameterListWorkspace((ITestStep) tableParent));
                }
            } else if (cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) cursor;
                String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
                if (!stepObjectFullName.isEmpty()) {
                    listProposalsDialog.addAll(TestStepIssueResolver.suggestStepDefinitionNameWorkspace(testStep));
                }
                listProposalsDialog.addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace(testStep));
                listProposalsDialog.addAll(TestStepIssueResolver.suggestStepObjectNameFile(testStep));
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace"))
                    .getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }
}
