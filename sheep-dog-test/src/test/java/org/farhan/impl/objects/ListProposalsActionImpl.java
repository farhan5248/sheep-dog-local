package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObjectActionImpl implements ListProposalsAction {

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        properties.put("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        if (properties.get("Test Suite Full Name") != null) {
            cursor = testProject.getTestDocument(replaceKeyword(properties.get("Test Suite Full Name").toString()));
            properties.remove("Test Suite Full Name");
        }
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
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
