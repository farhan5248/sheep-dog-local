package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestIDEObject implements ListProposalsAction {

    public void transition() {
        if (properties.get("Node Path") != null) {
            setCursor(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (TestIDEObject.cursor instanceof IRow) {
                IRow row = (IRow) TestIDEObject.cursor;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                TestIDEObject.listProposalsDialog
                        .addAll(RowIssueResolver.suggestCellListWorkspace((ITestStep) testStep));
            } else if (TestIDEObject.cursor instanceof ITestStep) {
                TestIDEObject.listProposalsDialog
                        .addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace((ITestStep) TestIDEObject.cursor));
                TestIDEObject.listProposalsDialog.addAll(
                        TestStepIssueResolver.suggestStepDefinitionNameWorkspace((ITestStep) TestIDEObject.cursor));
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
}
