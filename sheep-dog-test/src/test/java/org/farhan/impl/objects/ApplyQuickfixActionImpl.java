package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.objects.xtext.ApplyQuickfixAction;

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
    @SuppressWarnings("unchecked")
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
        ArrayList<SheepDogIssueProposal> proposals = (ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup");
        if (proposals == null || proposals.isEmpty()) {
            return;
        }
        SheepDogIssueProposal proposal = proposals.get(0);
        String value = proposal.getValue().toString();
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestSuite) {
            ((ITestSuite) cursor).setName(value);
        } else if (cursor instanceof ITestStepContainer) {
            ((ITestStepContainer) cursor).setName(value);
        } else if (cursor instanceof ICell) {
            ((ICell) cursor).setName(value);
        } else if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            String proposalId = proposal.getId();
            if (proposalId.contains(" - ")) {
                String stepObjectFullName = proposalId.substring(proposalId.indexOf(" - ") + 3);
                IStepObject stepObject = SheepDogBuilder.createStepObject((ITestProject) getProperty("workspace"), stepObjectFullName);
                SheepDogBuilder.createStepDefinition(stepObject, testStep.getStepDefinitionName());
            } else {
                String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
                ITestDocument doc = ((ITestProject) getProperty("workspace")).getTestDocument(stepObjectFullName);
                if (doc instanceof IStepObject) {
                    SheepDogBuilder.createStepDefinition((IStepObject) doc, testStep.getStepDefinitionName());
                }
            }
        } else if (cursor instanceof IRow) {
            IRow row = (IRow) cursor;
            String proposalId = proposal.getId();
            if (proposalId.startsWith("Generate ")) {
                ITestStep testStep = SheepDogUtility.getTestStepParentForRow(row);
                if (testStep != null) {
                    String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
                    ITestDocument doc = ((ITestProject) getProperty("workspace")).getTestDocument(stepObjectFullName);
                    if (doc instanceof IStepObject) {
                        IStepDefinition stepDefinition = ((IStepObject) doc).getStepDefinition(testStep.getStepDefinitionName());
                        if (stepDefinition != null) {
                            String stepParametersName = proposalId.substring("Generate ".length());
                            IStepParameters stepParameters = SheepDogBuilder.createStepParameters(stepDefinition, stepParametersName);
                            ITable table = SheepDogBuilder.createTable(stepParameters);
                            IRow newRow = SheepDogBuilder.createRow(table);
                            for (ICell cell : row.getCellList()) {
                                SheepDogBuilder.createCell(newRow, cell.getName());
                            }
                        }
                    }
                }
            }
        } else if (cursor instanceof IText) {
            IText text = (IText) cursor;
            String proposalId = proposal.getId();
            if (proposalId.startsWith("Generate ")) {
                ITestStep testStep = text.getParent();
                if (testStep != null) {
                    String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
                    ITestDocument doc = ((ITestProject) getProperty("workspace")).getTestDocument(stepObjectFullName);
                    if (doc instanceof IStepObject) {
                        IStepDefinition stepDefinition = ((IStepObject) doc).getStepDefinition(testStep.getStepDefinitionName());
                        if (stepDefinition != null) {
                            String stepParametersName = proposalId.substring("Generate ".length());
                            IStepParameters stepParameters = SheepDogBuilder.createStepParameters(stepDefinition, stepParametersName);
                            ITable table = SheepDogBuilder.createTable(stepParameters);
                            IRow newRow = SheepDogBuilder.createRow(table);
                            SheepDogBuilder.createCell(newRow, stepParametersName);
                        }
                    }
                }
            }
        }
    }
}
