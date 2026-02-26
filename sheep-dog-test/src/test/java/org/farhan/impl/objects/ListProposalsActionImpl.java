package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestIDEObject implements ListProposalsAction {

    public void transition() {
        try {
            if (TestIDEObject.selectedNode.contains("Row/")) {
                TestIDEObject.listProposalsDialog
                        .addAll(RowIssueResolver.suggestCellListWorkspace((ITestStep) TestIDEObject.focus));
            } else if (TestIDEObject.selectedNode.contains("TestStep/")) {
                TestIDEObject.listProposalsDialog
                        .addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace((ITestStep) TestIDEObject.focus));
                TestIDEObject.listProposalsDialog.addAll(
                        TestStepIssueResolver.suggestStepDefinitionNameWorkspace((ITestStep) TestIDEObject.focus));
            } else {
                Assertions.fail("Unknown Element Type");
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setSelectedNode(keyMap.get("Node Path"));
    }
}
