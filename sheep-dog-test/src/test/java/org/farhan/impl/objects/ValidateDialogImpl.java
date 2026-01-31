package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.objects.xtext.ValidateDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateDialogImpl extends TestObject implements ValidateDialog {

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(MockIDE.getValidationMessage().isEmpty());
	}

	@Override
	public void assertContent(HashMap<String, String> keyMap) {
		Assertions.assertEquals(keyMap.get("Content"), MockIDE.getValidationMessage());
	}

	@Override
	public void setEmpty(HashMap<String, String> keyMap) {
		MockIDE.setValidationMessage("");
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		MockIDE.setValidationMessage(keyMap.get("Content"));
	}
}
