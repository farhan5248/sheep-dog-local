package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEElement;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestIDEElement implements ListProposalsAction {

	public void transition() {
		try {
			if (TestIDEElement.isElementType("Row")) {
				TestIDEElement.listProposalsDialog.addAll(RowIssueResolver.suggestCellListWorkspace(TestIDEElement.testStep));
			} else if (TestIDEElement.isElementType("Test Step")) {
				TestIDEElement.listProposalsDialog
						.addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace(TestIDEElement.testStep));
				TestIDEElement.listProposalsDialog
						.addAll(TestStepIssueResolver.suggestStepDefinitionNameWorkspace(TestIDEElement.testStep));
			} else {
				Assertions.fail("Unknown Element Type");
			}
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setElementType(HashMap<String, String> keyMap) {
		TestIDEElement.setElementType(keyMap.get("Element Type"));
	}
}
