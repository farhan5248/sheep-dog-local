package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.objects.xtext.ProposeContentDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProposeContentDialogImpl extends TestObject implements ProposeContentDialog {

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
				if (p.getValue().startsWith("+\n|===\n") && p.getValue().endsWith("\n|===")) {
					found = p.getValue().replace("\n", "").replace("+", "").replace("|===", "")
							.contentEquals(keyMap.get("Suggestion"));
				} else {
					found = p.getValue().contentEquals(keyMap.get("Suggestion"));
				}
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
			if (p.getId().equals(keyMap.get("Suggestion Name"))) {
				found = p.getDescription().contentEquals(keyMap.get("Suggestion Description"));
				Assertions.assertTrue(found, "Suggestion Description doesn't match: " + p.getValue());
				return;
			}
		}
		Assertions.assertTrue(found, "No proposal found with ID: " + keyMap.get("Suggestion Name"));
	}
}
