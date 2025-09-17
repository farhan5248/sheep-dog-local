package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.objects.xtext.ValidateErrorDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateErrorDialogImpl extends TestObject implements ValidateErrorDialog {

	public void assertMessage(HashMap<String, String> keyMap) {
		Assertions.assertEquals(keyMap.get("Message"), MockIDE.getValidationMessage());
	}

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(MockIDE.getValidationMessage().isEmpty());
	}
}
