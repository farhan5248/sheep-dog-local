package org.farhan.impl.objects;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.issues.RowIssueDetector;
import org.farhan.dsl.issues.RowIssueResolver;
import org.farhan.dsl.issues.TestStepIssueDetector;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.issues.TextIssueDetector;
import org.farhan.dsl.issues.TextIssueResolver;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.junit.jupiter.api.Assertions;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class GenerateStepDefinitionActionImpl extends TestIDEObject implements GenerateStepDefinitionAction {

    public void transition() {
        try {
            ITestStep testStep = (ITestStep) TestIDEObject.focus;
            if (!TestStepIssueDetector.validateStepObjectNameWorkspace(testStep).isEmpty()) {
                TestIDEObject.applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
            }
            if (!TestStepIssueDetector.validateStepDefinitionNameWorkspace(testStep).isEmpty()) {
                TestIDEObject.applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
            }
            if (testStep.getTable() != null) {
                if (!testStep.getTable().getRowList().isEmpty()
                        && (testStep.getTable().getRowList().getFirst() != null)) {
                    if (!RowIssueDetector.validateCellListWorkspace(testStep.getTable().getRowList().getFirst())
                            .isEmpty()) {
                        TestIDEObject.applyProposal(RowIssueResolver.correctCellListWorkspace(testStep));
                    }
                }
            }
            if (testStep.getText() != null) {
                if (!TextIssueDetector.validateNameWorkspace(testStep.getText()).isEmpty()) {
                    TestIDEObject.applyProposal(TextIssueResolver.correctNameWorkspace(testStep));
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

}
