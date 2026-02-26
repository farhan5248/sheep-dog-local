package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.issues.CellIssueDetector;
import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepContainerIssueDetector;
import org.farhan.dsl.issues.TestStepContainerIssueResolver;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.issues.TestSuiteIssueDetector;
import org.farhan.dsl.issues.TestSuiteIssueResolver;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.dsl.issues.TextIssueResolver;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;
import org.farhan.objects.xtext.ApplyQuickfixAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ApplyQuickfixActionImpl extends TestIDEObject implements ApplyQuickfixAction {

    public void transition() {
        try {
            if (TestIDEObject.selectedNode.contains("Cell/")) {
                ICell cell = (ICell) TestIDEObject.focus;
                if (!CellIssueDetector.validateNameOnly(cell).isEmpty()) {
                    TestIDEObject.applyProposal(CellIssueResolver.correctNameOnly(cell));
                }
            } else if (TestIDEObject.selectedNode.contains("Row/")) {
                IRow row = (IRow) TestIDEObject.focus;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                if (!testStep.getTable().getRowList().isEmpty()
                        && (testStep.getTable().getRowList().getFirst() != null)) {
                    if (!RowIssueDetector.validateCellListWorkspace(row).isEmpty()) {
                        TestIDEObject.applyProposal(RowIssueResolver.correctCellListWorkspace(testStep));
                    }
                }
            } else if (TestIDEObject.selectedNode.contains("Text/")) {
                IText text = (IText) TestIDEObject.focus;
                ITestStep testStep = (ITestStep) text.getParent();
                if (!TextIssueDetector.validateNameWorkspace(text).isEmpty()) {
                    TestIDEObject.applyProposal(TextIssueResolver.correctNameWorkspace(testStep));
                }
            } else if (TestIDEObject.selectedNode.contains("TestStep/")) {
                ITestStep testStep = (ITestStep) TestIDEObject.focus;
                if (!TestStepIssueDetector.validateStepObjectNameWorkspace(testStep).isEmpty()) {
                    TestIDEObject.applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
                }
                if (!TestStepIssueDetector.validateStepDefinitionNameWorkspace(testStep).isEmpty()) {
                    TestIDEObject.applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
                }
            } else if (TestIDEObject.selectedNode.contains("TestCase/")
                    || TestIDEObject.selectedNode.contains("TestSetup/")) {
                ITestStepContainer testStepContainer = (ITestStepContainer) TestIDEObject.focus;
                if (!TestStepContainerIssueDetector.validateNameOnly(testStepContainer).isEmpty()) {
                    TestIDEObject.applyProposal(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
                }
            } else if (TestIDEObject.selectedNode.contains("TestSuite/")) {
                ITestSuite testSuite = (ITestSuite) TestIDEObject.focus;
                if (!TestSuiteIssueDetector.validateNameOnly(testSuite).isEmpty()) {
                    TestIDEObject.applyProposal(TestSuiteIssueResolver.correctNameOnly(testSuite));
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setSelectedNode(keyMap.get("Node Path"));
    }

}
