package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesDialogImpl extends TestObject implements ListQuickfixesDialog {

	@Override
	public void assertQuickfix(HashMap<String, String> keyMap) {
		for (SheepDogIssueProposal p : MockIDE.getProposals()) {
			if (p.getId().equals(keyMap.get("Quickfix Name"))) {
				Assertions.assertTrue(p.getValue().contentEquals(keyMap.get("Quickfix")));
				return;
			}
		}
		Assertions.fail("No quickfix found with ID that matches the name: " + keyMap.get("Quickfix Name"));
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
		for (SheepDogIssueProposal p : MockIDE.getProposals()) {
			if (p.getId().equals(keyMap.get("Quickfix Name"))) {
				Assertions.assertTrue(p.getDescription().contentEquals(getSpecial(keyMap.get("Quickfix Description"))));
				return;
			}
		}
		Assertions.fail("No quickfix found with ID: " + keyMap.get("Quickfix Name"));
	}

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(MockIDE.getProposals().isEmpty());
	}

}
