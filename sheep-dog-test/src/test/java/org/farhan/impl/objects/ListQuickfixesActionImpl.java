package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.CellIssueTypes;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.issues.TestStepContainerIssueResolver;
import org.farhan.dsl.issues.TestStepContainerIssueTypes;
import org.farhan.dsl.issues.TestStepIssueResolver;
import org.farhan.dsl.issues.TestStepIssueTypes;
import org.farhan.dsl.issues.TestSuiteIssueResolver;
import org.farhan.dsl.issues.TestSuiteIssueTypes;
import org.farhan.dsl.issues.TextIssueResolver;
import org.farhan.dsl.issues.TextIssueTypes;
import org.farhan.objects.xtext.ListQuickfixesAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesActionImpl extends TestObjectSheepDogImpl implements ListQuickfixesAction {

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        try {
            Object validateProperty = getProperty("validate annotation.Content");
            String validateResult = validateProperty != null ? validateProperty.toString() : "";
            Object cursor = getProperty("cursor");
            if (cursor instanceof ITestSuite) {
                if (validateResult.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
                    ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))
                            .addAll(TestSuiteIssueResolver.correctNameOnly((ITestSuite) cursor));
                }
            } else if (cursor instanceof ITestStepContainer) {
                if (validateResult.contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
                    ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))
                            .addAll(TestStepContainerIssueResolver.correctNameOnly((ITestStepContainer) cursor));
                }
            } else if (cursor instanceof ICell) {
                if (validateResult.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                    ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))
                            .addAll(CellIssueResolver.correctNameOnly((ICell) cursor));
                }
            } else if (cursor instanceof ITestStep) {
                if (validateResult.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
                    ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))
                            .addAll(TestStepIssueResolver.correctStepObjectNameWorkspace((ITestStep) cursor));
                } else if (validateResult.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                    ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))
                            .addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace((ITestStep) cursor));
                }
            } else if (cursor instanceof IRow) {
                if (validateResult.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_PARAMETER_LIST_WORKSPACE.description)) {
                    ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))
                            .addAll(TestStepIssueResolver.correctStepParameterListWorkspace((IRow) cursor));
                }
            } else if (cursor instanceof IText) {
                if (validateResult.contentEquals(TextIssueTypes.TEXT_STEP_PARAMETER_LIST_WORKSPACE.description)) {
                    ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))
                            .addAll(TextIssueResolver.correctStepParameterListWorkspace((IText) cursor));
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace"))
                    .getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }
}
