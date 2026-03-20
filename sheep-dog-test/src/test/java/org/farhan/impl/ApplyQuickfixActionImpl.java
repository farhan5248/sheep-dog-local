package org.farhan.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogUtility;
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
                } else if (cursor instanceof IRow && proposal.getId().startsWith("Generate")) {
                    applyRowCellListWorkspaceQuickfix((IRow) cursor);
                    return;
                } else if (cursor instanceof IText && proposal.getId().startsWith("Generate")) {
                    applyTextContentWorkspaceQuickfix((IText) cursor);
                    return;
                } else if (cursor instanceof ITestStep && proposal.getId().startsWith("Generate")) {
                    applyStepDefinitionWorkspaceQuickfix((ITestStep) cursor);
                    return;
                }
            }
        }
    }

    private static void applyStepDefinitionWorkspaceQuickfix(ITestStep testStep) throws Exception {
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
        if (!stepObjectFullName.isEmpty()) {
            ITestDocument doc = ((ITestProject) getProperty("workspace")).getTestDocument(stepObjectFullName);
            if (doc instanceof IStepObject) {
                SheepDogBuilder.createStepDefinition((IStepObject) doc, testStep.getStepDefinitionName());
            }
        }
    }

    private static void applyRowCellListWorkspaceQuickfix(IRow row) throws Exception {
        ITable table = row.getParent();
        if (table == null || !(table.getParent() instanceof ITestStep))
            return;
        ITestStep testStep = (ITestStep) table.getParent();
        IStepDefinition stepDef = getStepDefinitionForTestStep(testStep);
        if (stepDef == null)
            return;
        String rowCells = SheepDogUtility.getCellListAsString(row.getCellList());
        IStepParameters stepParameters = SheepDogBuilder.createStepParameters(stepDef, rowCells);
        ITable newTable = SheepDogBuilder.createTable(stepParameters);
        IRow newRow = SheepDogBuilder.createRow(newTable);
        for (ICell cell : row.getCellList()) {
            SheepDogBuilder.createCell(newRow, cell.getName());
        }
    }

    private static void applyTextContentWorkspaceQuickfix(IText text) throws Exception {
        ITestStep testStep = text.getParent();
        if (testStep == null)
            return;
        IStepDefinition stepDef = getStepDefinitionForTestStep(testStep);
        if (stepDef == null)
            return;
        IStepParameters stepParameters = SheepDogBuilder.createStepParameters(stepDef, "Content");
        ITable newTable = SheepDogBuilder.createTable(stepParameters);
        IRow newRow = SheepDogBuilder.createRow(newTable);
        SheepDogBuilder.createCell(newRow, "Content");
    }

    private static IStepDefinition getStepDefinitionForTestStep(ITestStep testStep) throws Exception {
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
        if (stepObjectFullName.isEmpty())
            return null;
        ITestDocument doc = ((ITestProject) getProperty("workspace")).getTestDocument(stepObjectFullName);
        if (!(doc instanceof IStepObject))
            return null;
        return ((IStepObject) doc).getStepDefinition(testStep.getStepDefinitionName());
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
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }
}
