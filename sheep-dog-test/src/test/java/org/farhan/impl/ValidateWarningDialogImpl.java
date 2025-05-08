package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.objects.xtext.ValidateWarningDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateWarningDialogImpl extends TestObject implements ValidateWarningDialog {

	public void assertMessage(HashMap<String, String> keyMap) {
		Assertions.assertEquals(keyMap.get("Message"), getEclipseMock().getValidationMessage());
	}

}
