package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.objects.xtext.QuickfixDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class QuickfixDialogImpl extends TestObject implements QuickfixDialog {

	public void assertMessage(HashMap<String, String> keyMap) {

		String message = "";
		for (SheepDogIssueProposal p : MockIDE.getAlternateObjects()) {
			if (p.getValue().contentEquals(keyMap.get("Message"))) {
				message = p.getValue();
				break;
			}
		}
		Assertions.assertTrue(!message.isEmpty());
	}
}
