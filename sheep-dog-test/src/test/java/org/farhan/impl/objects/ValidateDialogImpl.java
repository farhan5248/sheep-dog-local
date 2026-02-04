package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEElement;
import org.farhan.objects.xtext.ValidateDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateDialogImpl extends TestIDEElement implements ValidateDialog {

	@Override
	public void assertEmpty(HashMap<String, String> keyMap) {
		Assertions.assertTrue(TestIDEElement.validateDialog.isEmpty());
	}

	@Override
	public void assertContent(HashMap<String, String> keyMap) {
		Assertions.assertEquals(keyMap.get("Content"), TestIDEElement.validateDialog);
	}

	@Override
	public void setEmpty(HashMap<String, String> keyMap) {
		TestIDEElement.validateDialog = replaceKeyword("empty");
	}

	@Override
	public void setContent(HashMap<String, String> keyMap) {
		TestIDEElement.validateDialog = keyMap.get("Content");
	}
}
