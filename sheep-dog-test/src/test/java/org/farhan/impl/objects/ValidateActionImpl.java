package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.dsl.lang.ICell;
import org.farhan.impl.ide.TestStepImpl;
import org.farhan.objects.xtext.ValidateAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ValidateActionImpl extends TestObject implements ValidateAction {
	
	public void transition() {
		try {
			if (MockIDE.elementType.contentEquals("Cell")) {
				if (MockIDE.validateDialog.isEmpty()) {
					if (MockIDE.testStep.getTable() != null) {
						if (MockIDE.testStep.getTable().getRowList() != null) {
							if (MockIDE.testStep.getTable().getRowList().getFirst() != null) {
								for (ICell c : MockIDE.testStep.getTable().getRowList().getFirst().getCellList()) {
									MockIDE.validateDialog = CellIssueDetector.validateNameOnly(c);
									if (!MockIDE.validateDialog.isEmpty()) {
										break;
									}
								}
							}
						}
					}
				}
			} else if (MockIDE.elementType.contentEquals("Row")) {
				if (MockIDE.validateDialog.isEmpty()) {
					if (MockIDE.testStep.getTable() != null) {
						if (MockIDE.testStep.getTable().getRowList() != null) {
							if (MockIDE.testStep.getTable().getRowList().getFirst() != null) {
								MockIDE.validateDialog = RowIssueDetector
										.validateCellListWorkspace(MockIDE.testStep.getTable().getRowList().getFirst());
							}
						}
					}
				}
			} else if (MockIDE.elementType.contentEquals("Text")) {
				if (MockIDE.validateDialog.isEmpty()) {
					if (MockIDE.testStep.getText() != null) {
						MockIDE.validateDialog = TextIssueDetector.validateNameWorkspace(MockIDE.testStep.getText());
					}
				}
			} else if (MockIDE.elementType.contentEquals("Test Step")) {
				if (MockIDE.validateDialog.isEmpty()) {
					MockIDE.validateDialog = TestStepIssueDetector.validateStepObjectNameOnly(MockIDE.testStep);
					if (MockIDE.validateDialog.isEmpty()) {
						MockIDE.validateDialog = TestStepIssueDetector.validateStepDefinitionNameOnly(MockIDE.testStep);
						if (MockIDE.validateDialog.isEmpty()) {
							MockIDE.validateDialog = TestStepIssueDetector
									.validateStepObjectNameWorkspace(MockIDE.testStep);
							if (MockIDE.validateDialog.isEmpty()) {
								MockIDE.validateDialog = TestStepIssueDetector
										.validateStepDefinitionNameWorkspace(MockIDE.testStep);
							}
						}
					}
				}
			} else if (MockIDE.elementType.contentEquals("Test Step Container")) {
				if (MockIDE.validateDialog.isEmpty()) {
					MockIDE.validateDialog = TestStepContainerIssueDetector
							.validateTestStepListFile(MockIDE.testStepContainer);
					if (MockIDE.validateDialog.isEmpty()) {
						MockIDE.validateDialog = TestStepContainerIssueDetector
								.validateNameOnly(MockIDE.testStepContainer);
					}
				}
			} else if (MockIDE.elementType.contentEquals("Test Suite")) {
				if (MockIDE.validateDialog.isEmpty()) {
					MockIDE.validateDialog = TestSuiteIssueDetector.validateNameOnly(MockIDE.testSuite);
				}
			} else {
				Assertions.fail("Unknown Element Type");
			}
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}

	@Override
	public void setElementType(HashMap<String, String> keyMap) {
		MockIDE.elementType = keyMap.get("Element Type");
	}

	@Override
	public void setSelectedStep(HashMap<String, String> keyMap) {
		MockIDE.testStep = (TestStepImpl) MockIDE.testStep.getParent().getTestStepList()
				.get(Integer.valueOf(keyMap.get("Selected Step")) - 1);
	}
}
