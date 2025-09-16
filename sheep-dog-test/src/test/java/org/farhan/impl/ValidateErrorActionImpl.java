package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.dsl.deprecated.LanguageHelper;
import org.farhan.dsl.deprecated.Utilities;
import org.farhan.objects.xtext.ValidateErrorAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateErrorActionImpl extends TestObject implements ValidateErrorAction {

	public void transition() {
		try {
			getLanguageAccess().setValidationMessage(LanguageHelper.validateError(getLanguageAccess()));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setSelectedStep(HashMap<String, String> keyMap) {
		getLanguageAccess().setStepSelection(keyMap.get("Selected Step"));
	}
}
