package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObjectSheepDogImpl implements ListProposalsAction {

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            Object cursor = getProperty("cursor");
            @SuppressWarnings("unchecked")
            ArrayList<SheepDogIssueProposal> listProposalsDialog = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
            if (cursor instanceof IRow) {
                IRow row = (IRow) cursor;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                listProposalsDialog
                        .addAll(RowIssueResolver.suggestCellListWorkspace((ITestStep) testStep));
            } else if (cursor instanceof ITestStep) {
                listProposalsDialog
                        .addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace((ITestStep) cursor));
                listProposalsDialog.addAll(
                        TestStepIssueResolver.suggestStepDefinitionNameWorkspace((ITestStep) cursor));
            } else {
                Assertions.fail("Unknown Element Type");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }
}
