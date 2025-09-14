package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.objects.xtext.QuickfixDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class QuickfixDialogImpl extends TestObject implements QuickfixDialog {

	public void assertMessage(HashMap<String, String> keyMap) {

		String message = "";
		for (Object alternateObject : getLanguageAccess().getAlternateObjects()) {
			if (alternateObject.toString().contentEquals(keyMap.get("Message"))) {
				message = alternateObject.toString();
				break;
			}
		}
		Assertions.assertTrue(!message.isEmpty());
	}
}
