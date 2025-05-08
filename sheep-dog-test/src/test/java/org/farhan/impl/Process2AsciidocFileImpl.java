package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import io.cucumber.guice.ScenarioScoped;
@ScenarioScoped
public class Process2AsciidocFileImpl extends TestObject implements Process2AsciidocFile {

	public void setStepsSnippetStepName(HashMap<String, String> keyMap) {
		getEclipseMock().addStep(getSpecial(keyMap.get("Step Name")));
	}

	@Override
	public void setStepsSnippetHeaders(HashMap<String, String> keyMap) {
		getEclipseMock().setStepParameters(keyMap.get("Headers"));
	}

	@Override
	public void setBackgroundStepsSnippetStepName(HashMap<String, String> keyMap) {
		getEclipseMock().addBackgroundStep(getSpecial(keyMap.get("Step Name")));
	}

}
