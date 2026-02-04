package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEElement;
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
public class ListQuickfixesActionImpl extends TestIDEElement implements ListQuickfixesAction {

	public void transition() {
		try {
			if (TestIDEElement.isElementType("Cell")) {
				if (TestIDEElement.validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
					if (TestIDEElement.testStep.getTable() != null) {
						if (TestIDEElement.testStep.getTable().getRowList() != null) {
							if (TestIDEElement.testStep.getTable().getRowList().getFirst() != null) {
								// TODO I should probably save the cell that's invalid instead of just picking
								// the first
								for (ICell c : TestIDEElement.testStep.getTable().getRowList().getFirst().getCellList()) {
									TestIDEElement.listQuickfixesDialog.addAll(CellIssueResolver.correctNameOnly(c));
									if (!TestIDEElement.listQuickfixesDialog.isEmpty()) {
										break;
									}
								}
							}
						}
					}
				}
			} else if (TestIDEElement.isElementType("Row")) {
				if (TestIDEElement.validateDialog.contentEquals(RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description)) {
					if (TestIDEElement.testStep.getTable() != null) {
						if (TestIDEElement.testStep.getTable().getRowList() != null) {
							if (TestIDEElement.testStep.getTable().getRowList().getFirst() != null) {
								TestIDEElement.listQuickfixesDialog
										.addAll(RowIssueResolver.correctCellListWorkspace(TestIDEElement.testStep));
							}
						}
					}
				}
			} else if (TestIDEElement.isElementType("Text")) {
				if (TestIDEElement.testStep.getText() != null) {
					if (TestIDEElement.validateDialog.contentEquals(TextIssueTypes.TEXT_NAME_WORKSPACE.description)) {
						TestIDEElement.listQuickfixesDialog.addAll(TextIssueResolver.correctNameWorkspace(TestIDEElement.testStep));
					}
				}
			} else if (TestIDEElement.isElementType("Test Step")) {
				if (TestIDEElement.validateDialog
						.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
					TestIDEElement.listQuickfixesDialog
							.addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(TestIDEElement.testStep));
				} else if (TestIDEElement.validateDialog
						.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
					TestIDEElement.listQuickfixesDialog
							.addAll(TestStepIssueResolver.correctStepObjectNameWorkspace(TestIDEElement.testStep));
				}
			} else if (TestIDEElement.isElementType("Test Step Container")) {
				if (TestIDEElement.validateDialog
						.contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
					TestIDEElement.listQuickfixesDialog
							.addAll(TestStepContainerIssueResolver.correctNameOnly(TestIDEElement.testStepContainer));
				}
			} else if (TestIDEElement.isElementType("Test Suite")) {
				if (TestIDEElement.validateDialog.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
					TestIDEElement.listQuickfixesDialog.addAll(TestSuiteIssueResolver.correctNameOnly(TestIDEElement.testSuite));
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
	    TestIDEElement.setElementType(keyMap.get("Element Type"));
	}
}
