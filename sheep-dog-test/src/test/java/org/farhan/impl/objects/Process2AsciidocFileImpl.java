package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.lang.ICell;
import org.farhan.impl.ide.CellImpl;
import org.farhan.impl.ide.RowImpl;
import org.farhan.impl.ide.TableImpl;
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

		// TODO this can be called before the step is created. I probably should enforce an
		// order when going through the attributes to select methods in this class
		MockIDE.stepParametersTable = new TableImpl();
		RowImpl row = new RowImpl();
		MockIDE.stepParametersTable.addRow(row);
		for (String h : keyMap.get("Headers").split("\\|")) {
			ICell cell = new CellImpl(h);
			row.addCell(cell);
		}
	}

	public void setStepsSnippetStepName(HashMap<String, String> keyMap) {
		MockIDE.addTestCaseStep(getSpecial(keyMap.get("Step Name")));
	}

	@Override
	public void setStepsSnippetTextContent(HashMap<String, String> keyMap) {
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
