package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.impl.ide.RowImpl;
import org.farhan.impl.ide.TextImpl;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Process2AsciidocFileImpl extends TestObject implements Process2AsciidocFile {

	@Override
	public void setBackgroundStepsSnippetStepName(HashMap<String, String> keyMap) {
		MockIDE.addTestSetupStep(getSpecial(keyMap.get("Step Name")));
	}

	@Override
	public void setStepsSnippetHeaders(HashMap<String, String> keyMap) {

		if (MockIDE.testStep == null) {
			MockIDE.addTestCaseStep(getSpecial(keyMap.get("Step Name")));
		}
		MockIDE.stepTable = SheepDogBuilder.createTable(MockIDE.testStep);
		RowImpl row = (RowImpl) SheepDogBuilder.createRow(MockIDE.stepTable);
		for (String h : keyMap.get("Headers").split("\\|")) {
			SheepDogBuilder.createCell(row, h);
		}
	}

	public void setStepsSnippetStepName(HashMap<String, String> keyMap) {
		MockIDE.addTestCaseStep(getSpecial(keyMap.get("Step Name")));
	}

	@Override
	public void setStepsSnippetTextContent(HashMap<String, String> keyMap) {
		if (MockIDE.testStep == null) {
			MockIDE.addTestCaseStep(getSpecial(keyMap.get("Step Name")));
		}
		MockIDE.stepText = new TextImpl();
		MockIDE.stepText.setName(keyMap.get("Text Content"));
		if (MockIDE.testStep != null) {
			MockIDE.testStep.setText(MockIDE.stepText);
		}
	}

	@Override
	public void setTestCaseName(HashMap<String, String> keyMap) {
		MockIDE.addTestStepContainer(getSpecial(keyMap.get("Test Case Name")));
	}

	@Override
	public void setTestSuiteName(HashMap<String, String> keyMap) {
		MockIDE.addTestSuite(getSpecial(keyMap.get("Test Suite Name")));
	}

}
