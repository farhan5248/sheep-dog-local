package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesDialogImpl extends TestObject implements ListQuickfixesDialog {

	public void assertQuickfix(HashMap<String, String> keyMap) {
		boolean found = false;
		for (SheepDogIssueProposal p : MockIDE.getProposals()) {
			if (p.getId().equals(keyMap.get("Quickfix Name"))) {
				found = p.getValue().contentEquals(keyMap.get("Quickfix"));
				if (found) {
					return;
				}
			}
		}
		Assertions.assertTrue(found, "No quickfix found with ID that matches the name: " + keyMap.get("Quickfix Name"));
	}

	@Override
	public void assertQuickfixName(HashMap<String, String> keyMap) {
		boolean found = false;
		for (SheepDogIssueProposal p : MockIDE.getProposals()) {
			if (p.getId().equals(keyMap.get("Quickfix Name"))) {
				found = true;
				break;
			}
		}
		Assertions.assertTrue(found, "No quickfix found with ID: " + keyMap.get("Quickfix Name"));
	}

	@Override
	public void assertQuickfixDescription(HashMap<String, String> keyMap) {
		boolean found = false;
		for (SheepDogIssueProposal p : MockIDE.getProposals()) {
			if (p.getId().equals(keyMap.get("Quickfix Name")) && p.getValue().equals(keyMap.get("Quickfix"))) {
				found = p.getDescription().contentEquals(keyMap.get("Quickfix Description"));
				Assertions.assertTrue(found, "Quickfix Description doesn't match: " + p.getValue());
				return;
			}
		}
		Assertions.assertTrue(found, "No quickfix found with ID: " + keyMap.get("Quickfix Name"));
	}
}
