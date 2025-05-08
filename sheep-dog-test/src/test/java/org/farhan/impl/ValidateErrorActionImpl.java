package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.dsl.common.LanguageHelper;
import org.farhan.dsl.common.Utilities;
import org.farhan.objects.xtext.ValidateErrorAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateErrorActionImpl extends TestObject implements ValidateErrorAction {

	public void transition() {
		try {
			getEclipseMock().setValidationMessage(LanguageHelper.validateError(getEclipseMock()));
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + Utilities.getStackTraceAsString(e));
		}
	}

	@Override
	public void setSelectedStep(HashMap<String, String> keyMap) {
		getEclipseMock().setStepSelection(keyMap.get("Selected Step"));
	}
}
