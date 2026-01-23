package org.farhan.impl;

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
	public void assertSuggestionName(HashMap<String, String> keyMap) {
		boolean found = false;
		for (SheepDogIssueProposal p : MockIDE.getProposals()) {
			if (p.getId().equals(keyMap.get("Suggestion Name"))) {
				found = true;
				break;
			}
		}
		Assertions.assertTrue(found, "No proposal found with ID: " + keyMap.get("Suggestion Name"));
	}

	@Override
	public void assertSuggestion(HashMap<String, String> keyMap) {
		boolean found = false;
		for (SheepDogIssueProposal p : MockIDE.getProposals()) {
			if (p.getId().equals(keyMap.get("Suggestion Name"))) {
				found = p.getValue().contentEquals(keyMap.get("Suggestion"));
				if (found) {
					return;
				}
			}
		}
		Assertions.assertTrue(found,
				"No proposal found with ID that matches the name: " + keyMap.get("Suggestion Name"));
	}

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(MockIDE.getProposals().isEmpty());
	}

	@Override
	public void assertSuggestionDescription(HashMap<String, String> keyMap) {
		boolean found = false;
		for (SheepDogIssueProposal p : MockIDE.getProposals()) {
			if (p.getId().equals(keyMap.get("Suggestion Name")) && p.getValue().equals(keyMap.get("Suggestion"))) {
				found = p.getDescription().contentEquals(keyMap.get("Suggestion Description"));
				Assertions.assertTrue(found, "Suggestion Description doesn't match: " + p.getValue());
				return;
			}
		}
		Assertions.assertTrue(found, "No proposal found with ID: " + keyMap.get("Suggestion Name"));
	}
}
