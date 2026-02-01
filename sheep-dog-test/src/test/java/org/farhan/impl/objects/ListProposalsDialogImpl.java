package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListProposalsDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsDialogImpl extends TestObject implements ListProposalsDialog {

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(MockIDE.listProposalsDialog.isEmpty());
	}

	@Override
	public void assertSuggestion(HashMap<String, String> keyMap) {
		for (SheepDogIssueProposal p : MockIDE.listProposalsDialog) {
			if (p.getId().equals(keyMap.get("Suggestion Name"))
					&& p.getValue().contentEquals(keyMap.get("Suggestion"))) {
				return;
			}
		}
		Assertions.fail("No proposal found with ID that matches the name: " + keyMap.get("Suggestion Name"));
	}

	@Override
	public void assertSuggestionDescription(HashMap<String, String> keyMap) {
		for (SheepDogIssueProposal p : MockIDE.listProposalsDialog) {
			if (p.getId().equals(keyMap.get("Suggestion Name"))
					&& p.getDescription().contentEquals(keyMap.get("Suggestion Description"))) {
				return;
			}
		}
		Assertions.fail("No proposal found with ID: " + keyMap.get("Suggestion Name"));
	}

	@Override
	public void assertSuggestionName(HashMap<String, String> keyMap) {
		for (SheepDogIssueProposal p : MockIDE.listProposalsDialog) {
			if (p.getId().equals(keyMap.get("Suggestion Name"))) {
				return;
			}
		}
		Assertions.fail("No proposal found with ID: " + keyMap.get("Suggestion Name"));
	}
}
