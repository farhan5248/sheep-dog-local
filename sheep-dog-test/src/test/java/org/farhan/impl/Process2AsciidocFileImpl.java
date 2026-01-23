package org.farhan.impl;

import java.util.HashMap;

import org.farhan.common.TestObject;
import org.farhan.dsl.lang.ICell;
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
		stepParametersTable = new TableImpl();
		RowImpl row = new RowImpl();
		stepParametersTable.addRow(row);
		for (String h : keyMap.get("Headers").split("\\|")) {
			ICell cell = new CellImpl(h);
			row.addCell(cell);
		}
	}

	public void setStepsSnippetStepName(HashMap<String, String> keyMap) {
		addTestCaseStep(getSpecial(keyMap.get("Step Name")));
	}

	@Override
	public void setTestSuiteName(HashMap<String, String> keyMap) {
		addTestSuite(getSpecial(keyMap.get("Test Suite Name")));
	}

	@Override
	public void setTestCaseName(HashMap<String, String> keyMap) {
		addTestStepContainer(getSpecial(keyMap.get("Test Case Name")));
	}

	@Override
	public void setStepsSnippetTextContent(HashMap<String, String> keyMap) {
		// this is called after the step is created. I probably should enforce an
		// order when going through the attributes to select methods in this class
		stepText = new TextImpl();
		stepText.setName(keyMap.get("Text Content"));
		if (currentStep != null) {
			currentStep.setText(stepText);
		}
	}

}
