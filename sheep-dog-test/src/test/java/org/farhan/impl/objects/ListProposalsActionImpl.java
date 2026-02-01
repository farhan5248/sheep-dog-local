package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObject implements ListProposalsAction {

	public void transition() {
		try {
			if (MockIDE.elementType.contentEquals("Row")) {
				MockIDE.listProposalsDialog.addAll(RowIssueResolver.suggestCellListWorkspace(MockIDE.testStep));
			} else if (MockIDE.elementType.contentEquals("Test Step")) {
				MockIDE.listProposalsDialog
						.addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace(MockIDE.testStep));
				MockIDE.listProposalsDialog
						.addAll(TestStepIssueResolver.suggestStepDefinitionNameWorkspace(MockIDE.testStep));
			} else {
				Assertions.fail("Unknown Element Type");
			}
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setElementType(HashMap<String, String> keyMap) {
		MockIDE.elementType = keyMap.get("Element Type");
	}
}
