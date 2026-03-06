package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
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
import org.farhan.objects.xtext.ApplyQuickfixAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ApplyQuickfixActionImpl extends TestIDEObject implements ApplyQuickfixAction {

    public void transition() {
        if (properties.get("Node Path") != null) {
            setCursor(properties.get("Node Path").toString());
            properties.remove("Node Path");
        }
        try {
            if (TestIDEObject.cursor instanceof ICell) {
                ICell cell = (ICell) TestIDEObject.cursor;
                if (!CellIssueDetector.validateNameOnly(cell).isEmpty()) {
                    TestIDEObject.applyProposal(CellIssueResolver.correctNameOnly(cell));
                }
            } else if (TestIDEObject.cursor instanceof IRow) {
                IRow row = (IRow) TestIDEObject.cursor;
                ITestStep testStep = (ITestStep) row.getParent().getParent();
                if (!testStep.getTable().getRowList().isEmpty()
                        && (testStep.getTable().getRowList().getFirst() != null)) {
                    if (!RowIssueDetector.validateCellListWorkspace(row).isEmpty()) {
                        TestIDEObject.applyProposal(RowIssueResolver.correctCellListWorkspace(testStep));
                    }
                }
            } else if (TestIDEObject.cursor instanceof IText) {
                IText text = (IText) TestIDEObject.cursor;
                ITestStep testStep = (ITestStep) text.getParent();
                if (!TextIssueDetector.validateNameWorkspace(text).isEmpty()) {
                    TestIDEObject.applyProposal(TextIssueResolver.correctNameWorkspace(testStep));
                }
            } else if (TestIDEObject.cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) TestIDEObject.cursor;
                if (!TestStepIssueDetector.validateStepObjectNameWorkspace(testStep).isEmpty()) {
                    TestIDEObject.applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
                }
                if (!TestStepIssueDetector.validateStepDefinitionNameWorkspace(testStep).isEmpty()) {
                    TestIDEObject.applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
                }
            } else if (TestIDEObject.cursor instanceof ITestStepContainer) {
                ITestStepContainer testStepContainer = (ITestStepContainer) TestIDEObject.cursor;
                if (!TestStepContainerIssueDetector.validateNameOnly(testStepContainer).isEmpty()) {
                    TestIDEObject.applyProposal(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
                }
            } else if (TestIDEObject.cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) TestIDEObject.cursor;
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
        properties.put("Node Path", keyMap.get("Node Path"));
    }

}
