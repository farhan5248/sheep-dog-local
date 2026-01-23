package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.objects.xtext.ListQuickfixesAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesActionImpl extends TestObject implements ListQuickfixesAction {

	public void transition() {
		try {
			if (elementType.contentEquals("Cell")) {
				Assertions.fail("Unknown Element Type");
			} else if (elementType.contentEquals("Row")) {
				Assertions.fail("Unknown Element Type");
			} else if (elementType.contentEquals("Text")) {
				Assertions.fail("Unknown Element Type");
			} else if (elementType.contentEquals("Test Step")) {
				Assertions.fail("Unknown Element Type");
			} else if (elementType.contentEquals("Test Step Container")) {
				Assertions.fail("Unknown Element Type");
			} else if (elementType.contentEquals("Test Suite")) {
				Assertions.fail("Unknown Element Type");
			} else {
				Assertions.fail("Unknown Element Type");
			}
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}

	@Override
	public void setElementType(HashMap<String, String> keyMap) {
		elementType = keyMap.get("Element Type");
	}
}
