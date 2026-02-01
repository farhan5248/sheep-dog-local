package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.MockIDE;
import org.farhan.common.TestObject;
import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.CellIssueTypes;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.RowIssueTypes;
import org.farhan.dsl.issues.TestStepContainerIssueResolver;
import org.farhan.dsl.issues.TestStepContainerIssueTypes;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.issues.TestStepIssueTypes;
import org.farhan.dsl.issues.TestSuiteIssueResolver;
import org.farhan.dsl.issues.TestSuiteIssueTypes;
import org.farhan.dsl.issues.TextIssueResolver;
import org.farhan.dsl.issues.TextIssueTypes;
import org.farhan.dsl.lang.ICell;
import org.farhan.objects.xtext.ListQuickfixesAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesActionImpl extends TestObject implements ListQuickfixesAction {

	public void transition() {
		try {
			if (MockIDE.elementType.contentEquals("Cell")) {
				if (MockIDE.validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
					if (MockIDE.testStep.getTable() != null) {
						if (MockIDE.testStep.getTable().getRowList() != null) {
							if (MockIDE.testStep.getTable().getRowList().getFirst() != null) {
								// TODO I should probably save the cell that's invalid instead of just picking
								// the first
								for (ICell c : MockIDE.testStep.getTable().getRowList().getFirst().getCellList()) {
									MockIDE.listQuickfixesDialog.addAll(CellIssueResolver.correctNameOnly(c));
									if (!MockIDE.listQuickfixesDialog.isEmpty()) {
										break;
									}
								}
							}
						}
					}
				}
			} else if (MockIDE.elementType.contentEquals("Row")) {
				if (MockIDE.validateDialog.contentEquals(RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description)) {
					if (MockIDE.testStep.getTable() != null) {
						if (MockIDE.testStep.getTable().getRowList() != null) {
							if (MockIDE.testStep.getTable().getRowList().getFirst() != null) {
								MockIDE.listQuickfixesDialog
										.addAll(RowIssueResolver.correctCellListWorkspace(MockIDE.testStep));
							}
						}
					}
				}
			} else if (MockIDE.elementType.contentEquals("Text")) {
				if (MockIDE.testStep.getText() != null) {
					if (MockIDE.validateDialog.contentEquals(TextIssueTypes.TEXT_NAME_WORKSPACE.description)) {
						MockIDE.listQuickfixesDialog.addAll(TextIssueResolver.correctNameWorkspace(MockIDE.testStep));
					}
				}
			} else if (MockIDE.elementType.contentEquals("Test Step")) {
				if (MockIDE.validateDialog
						.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
					MockIDE.listQuickfixesDialog
							.addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(MockIDE.testStep));
				} else if (MockIDE.validateDialog
						.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
					MockIDE.listQuickfixesDialog
							.addAll(TestStepIssueResolver.correctStepObjectNameWorkspace(MockIDE.testStep));
				}
			} else if (MockIDE.elementType.contentEquals("Test Step Container")) {
				if (MockIDE.validateDialog
						.contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
					MockIDE.listQuickfixesDialog
							.addAll(TestStepContainerIssueResolver.correctNameOnly(MockIDE.testStepContainer));
				}
			} else if (MockIDE.elementType.contentEquals("Test Suite")) {
				if (MockIDE.validateDialog.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
					MockIDE.listQuickfixesDialog.addAll(TestSuiteIssueResolver.correctNameOnly(MockIDE.testSuite));
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
}
