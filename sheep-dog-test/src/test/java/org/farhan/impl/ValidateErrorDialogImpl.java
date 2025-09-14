package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.objects.xtext.ValidateErrorDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateErrorDialogImpl extends TestObject implements ValidateErrorDialog {

	public void assertMessage(HashMap<String, String> keyMap) {
		Assertions.assertEquals(keyMap.get("Message"), getLanguageAccess().getValidationMessage());
	}

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(getLanguageAccess().getValidationMessage().isEmpty());
	}
}
