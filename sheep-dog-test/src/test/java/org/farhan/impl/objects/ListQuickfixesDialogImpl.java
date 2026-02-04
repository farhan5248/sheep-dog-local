package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEElement;
import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesDialogImpl extends TestIDEElement implements ListQuickfixesDialog {

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(TestIDEElement.listQuickfixesDialog.isEmpty());
	}

	@Override
	public void assertQuickfix(HashMap<String, String> keyMap) {
		for (SheepDogIssueProposal p : TestIDEElement.listQuickfixesDialog) {
			if (p.getId().equals(keyMap.get("Quickfix Name")) && p.getValue().contentEquals(keyMap.get("Quickfix"))) {
				return;
			}
		}
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Quickfix Name"));
        sb.append(" and value: ").append(keyMap.get("Quickfix"));
        sb.append(listToString(TestIDEElement.listQuickfixesDialog));
        Assertions.fail(sb.toString());
	}

	@Override
	public void assertQuickfixDescription(HashMap<String, String> keyMap) {
		for (SheepDogIssueProposal p : TestIDEElement.listQuickfixesDialog) {
			if (p.getId().equals(keyMap.get("Quickfix Name"))
					&& p.getDescription().contentEquals(replaceKeyword(keyMap.get("Quickfix Description")))) {
				return;
			}
		}
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Quickfix Name"));
        sb.append(" and description: ").append(keyMap.get("Quickfix Description"));
        sb.append(listToString(TestIDEElement.listQuickfixesDialog));
        Assertions.fail(sb.toString());
	}

	@Override
	public void assertQuickfixName(HashMap<String, String> keyMap) {
		for (SheepDogIssueProposal p : TestIDEElement.listQuickfixesDialog) {
			if (p.getId().equals(keyMap.get("Quickfix Name"))) {
				return;
			}
		}
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Quickfix Name"));
        sb.append(listToString(TestIDEElement.listQuickfixesDialog));
        Assertions.fail(sb.toString());
	}

}
