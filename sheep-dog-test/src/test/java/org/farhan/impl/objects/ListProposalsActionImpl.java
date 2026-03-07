package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObjectIDE;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObjectIDE implements ListProposalsAction {

    public void transition() {
        super.transition();
        if (properties.get("Node Path") != null) {
            setCursorAtNode(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (TestObjectIDE.cursor instanceof IRow) {
                IRow row = (IRow) TestObjectIDE.cursor;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                TestObjectIDE.listProposalsDialog
                        .addAll(RowIssueResolver.suggestCellListWorkspace((ITestStep) testStep));
            } else if (TestObjectIDE.cursor instanceof ITestStep) {
                TestObjectIDE.listProposalsDialog
                        .addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace((ITestStep) TestObjectIDE.cursor));
                TestObjectIDE.listProposalsDialog.addAll(
                        TestStepIssueResolver.suggestStepDefinitionNameWorkspace((ITestStep) TestObjectIDE.cursor));
            } else {
                Assertions.fail("Unknown Element Type");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        properties.put("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        properties.put("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }
}
