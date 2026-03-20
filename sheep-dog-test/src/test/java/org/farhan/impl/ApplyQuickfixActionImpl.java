package org.farhan.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
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
import org.farhan.objects.xtext.ApplyQuickfixAction;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ApplyQuickfixActionImpl extends TestObjectSheepDogImpl implements ApplyQuickfixAction {

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        try {
            String validateDialog = (String) getProperty("validate annotation.Content");
            Object cursor = getProperty("cursor");
            if (cursor instanceof ICell) {
                ICell cell = (ICell) cursor;
                if (validateDialog.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                    applyProposal(CellIssueResolver.correctNameOnly(cell));
                }
            } else if (cursor instanceof IRow) {
                IRow row = (IRow) cursor;
                if (validateDialog.contentEquals(RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description)) {
                    applyProposal(RowIssueResolver.correctCellListWorkspace(row));
                }
            } else if (cursor instanceof ITestStepContainer) {
                ITestStepContainer tsc = (ITestStepContainer) cursor;
                if (validateDialog.contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
                    applyProposal(TestStepContainerIssueResolver.correctNameOnly(tsc));
                }
            } else if (cursor instanceof ITestStep) {
                ITestStep testStep = (ITestStep) cursor;
                if (validateDialog.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
                    applyProposal(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep));
                } else if (validateDialog.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                    applyProposal(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep));
                }
            } else if (cursor instanceof ITestSuite) {
                ITestSuite testSuite = (ITestSuite) cursor;
                if (validateDialog.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
                    applyProposal(TestSuiteIssueResolver.correctNameOnly(testSuite));
                }
            } else if (cursor instanceof IText) {
                IText text = (IText) cursor;
                if (validateDialog.contentEquals(TextIssueTypes.TEXT_CONTENT_WORKSPACE.description)) {
                    applyProposal(TextIssueResolver.correctContentWorkspace(text));
                }
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private static void applyProposal(ArrayList<SheepDogIssueProposal> proposals) throws Exception {
        for (SheepDogIssueProposal proposal : proposals) {
            if (proposal.getValue() instanceof IStepObject) {
                ((ITestProject) getProperty("workspace")).addStepObject((IStepObject) proposal.getValue());
            } else {
                Object cursor = getProperty("cursor");
                if (cursor instanceof ICell) {
                    ((ICell) cursor).setName(proposal.getValue().toString());
                } else if (cursor instanceof ITestSuite) {
                    ((ITestSuite) cursor).setName(proposal.getValue().toString());
                } else if (cursor instanceof ITestStepContainer) {
                    ((ITestStepContainer) cursor).setName(proposal.getValue().toString());
                }
            }
        }
    }

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace"))
                    .getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        } else if (getProperty("Step Object Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace"))
                    .getTestDocument(replaceKeyword(getProperty("Step Object Full Name").toString())));
            properties.remove("Step Object Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            String path = getProperty("Node Path").toString();
            if (path.endsWith("/")) {
                path = path.substring(0, path.length() - 1);
            }
            setCursorAtNode(path);
            properties.remove("Node Path");
        }
    }
}
