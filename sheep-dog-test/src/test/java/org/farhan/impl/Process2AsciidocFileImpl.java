package org.farhan.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Process2AsciidocFileImpl extends TestObject implements Process2AsciidocFile {

	@Override
	public void setBackgroundStepsSnippetStepName(HashMap<String, String> keyMap) {
		addTestSetupStep(getSpecial(keyMap.get("Step Name")));
	}

	@Override
	public void setStepsSnippetHeaders(HashMap<String, String> keyMap) {

		// this can be called before the step is created. I probably should enforce an
		// order when going through the attributes to select methods in this class
		stepParametersTable = new ArrayList<ArrayList<String>>();
		stepParametersTable.add(new ArrayList<String>());
		for (String h : keyMap.get("Headers").split("\\|")) {
			stepParametersTable.getFirst().add(h);
		}
	}

	public void setStepsSnippetStepName(HashMap<String, String> keyMap) {
		addTestCaseStep(getSpecial(keyMap.get("Step Name")));
	}

}
