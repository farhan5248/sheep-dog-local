package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.impl.ide.RowImpl;
import org.farhan.impl.ide.TableImpl;
import org.farhan.objects.xtext.ListProposalsAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObject implements ListProposalsAction {

	public void transition() {
		try {
			if (elementType.contentEquals("Row")) {
				currentStep.setTable(new TableImpl());
				RowImpl row = new RowImpl();
				currentStep.getTable().addRow(row);
				MockIDE.setProposalList(RowIssueResolver.suggestCellListWorkspace(currentStep));
			} else if (elementType.contentEquals("Test Step")) {
				MockIDE.getProposals().addAll(TestStepIssueResolver.suggestStepObjectNameWorkspace(currentStep));
				MockIDE.getProposals().addAll(TestStepIssueResolver.suggestStepDefinitionNameWorkspace(currentStep));
			} else {
				Assertions.fail("Unknown Element Type");
			}
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setElementType(HashMap<String, String> keyMap) {
		elementType = keyMap.get("Element Type");
	}
}
