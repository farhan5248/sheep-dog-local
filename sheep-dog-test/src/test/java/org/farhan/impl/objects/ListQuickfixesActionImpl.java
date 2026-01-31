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
			String message = MockIDE.getValidationMessage();
			if (elementType.contentEquals("Cell")) {
				if (message.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
					if (currentStep.getTable() != null) {
						if (currentStep.getTable().getRowList() != null) {
							if (currentStep.getTable().getRowList().getFirst() != null) {
								// TODO I should probably save the cell that's invalid instead of just picking
								// the first
								for (ICell c : currentStep.getTable().getRowList().getFirst().getCellList()) {
									MockIDE.getProposals().addAll(CellIssueResolver.correctNameOnly(c));
									if (!MockIDE.getProposals().isEmpty()) {
										break;
									}
								}
							}
						}
					}
				}
			} else if (elementType.contentEquals("Row")) {
				if (currentStep.getTable() != null) {
					if (message.contentEquals(RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description)) {
						MockIDE.getProposals().addAll(RowIssueResolver.correctCellListWorkspace(currentStep));
					}
				}
			} else if (elementType.contentEquals("Text")) {
				if (currentStep.getText() != null) {
					if (message.contentEquals(TextIssueTypes.TEXT_NAME_WORKSPACE.description)) {
						MockIDE.getProposals().addAll(TextIssueResolver.correctNameWorkspace(currentStep));
					}
				}
			} else if (elementType.contentEquals("Test Step")) {
				if (message.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
					MockIDE.getProposals()
							.addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(currentStep));
				} else if (message.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
					MockIDE.getProposals().addAll(TestStepIssueResolver.correctStepObjectNameWorkspace(currentStep));
				}
			} else if (elementType.contentEquals("Test Step Container")) {
				if (message.contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
					MockIDE.getProposals().addAll(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
				}
			} else if (elementType.contentEquals("Test Suite")) {
				if (message.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
					MockIDE.getProposals().addAll(TestSuiteIssueResolver.correctNameOnly(testSuite));
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
		elementType = keyMap.get("Element Type");
	}
}
