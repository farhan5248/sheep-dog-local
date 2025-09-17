package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.objects.xtext.ProposeContentDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProposeContentDialogImpl extends TestObject implements ProposeContentDialog {

	@Override
	public void assertSuggestionName(HashMap<String, String> keyMap) {
		Assertions.assertEquals(keyMap.get("Suggestion Name"),
				MockIDE.getProposals().get(keyMap.get("Suggestion")).getDisplay());
	}

	@Override
	public void assertSuggestion(HashMap<String, String> keyMap) {
		Assertions.assertNotNull(MockIDE.getProposals().get(keyMap.get("Suggestion")));
	}

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(MockIDE.getProposals().isEmpty());
	}

	@Override
	public void assertSuggestionDescription(HashMap<String, String> keyMap) {
		Assertions.assertEquals(keyMap.get("Suggestion Description"),
				MockIDE.getProposals().get(keyMap.get("Suggestion")).getDocumentation());
	}
}
