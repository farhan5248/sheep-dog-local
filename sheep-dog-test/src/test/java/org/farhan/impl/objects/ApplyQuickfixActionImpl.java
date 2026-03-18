package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.CellIssueTypes;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.SheepDogFactory;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
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

    @SuppressWarnings("unchecked")
    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();
        try {
            Object validateProperty = getProperty("validate annotation.Content");
            String validateResult = validateProperty != null ? validateProperty.toString() : "";
            Object cursor = getProperty("cursor");
            ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
            if (cursor instanceof ITestSuite) {
                if (validateResult.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
                    proposals.addAll(TestSuiteIssueResolver.correctNameOnly((ITestSuite) cursor));
                }
            } else if (cursor instanceof ITestStepContainer) {
                if (validateResult.contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
                    proposals.addAll(TestStepContainerIssueResolver.correctNameOnly((ITestStepContainer) cursor));
                }
            } else if (cursor instanceof ICell) {
                if (validateResult.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                    proposals.addAll(CellIssueResolver.correctNameOnly((ICell) cursor));
                }
            } else if (cursor instanceof ITestStep) {
                if (validateResult.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description)) {
                    proposals.addAll(TestStepIssueResolver.correctStepObjectNameWorkspace((ITestStep) cursor));
                } else if (validateResult.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description)) {
                    proposals.addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace((ITestStep) cursor));
                }
            } else if (cursor instanceof IRow) {
                if (validateResult.contentEquals(TestStepIssueTypes.TEST_STEP_STEP_PARAMETER_LIST_WORKSPACE.description)) {
                    proposals.addAll(TestStepIssueResolver.correctStepParameterListWorkspace((IRow) cursor));
                }
            } else if (cursor instanceof IText) {
                if (validateResult.contentEquals(TextIssueTypes.TEXT_STEP_PARAMETER_LIST_WORKSPACE.description)) {
                    proposals.addAll(TextIssueResolver.correctStepParameterListWorkspace((IText) cursor));
                }
            }
            applyProposal(proposals, cursor);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private void applyProposal(ArrayList<SheepDogIssueProposal> proposals, Object cursor) {
        for (SheepDogIssueProposal proposal : proposals) {
            if (cursor instanceof ITestSuite) {
                ((ITestSuite) cursor).setName(proposal.getValue().toString());
            } else if (cursor instanceof ITestStepContainer) {
                ((ITestStepContainer) cursor).setName(proposal.getValue().toString());
            } else if (cursor instanceof ICell) {
                ((ICell) cursor).setName(proposal.getValue().toString());
            } else if (cursor instanceof ITestStep) {
                ITestProject workspace = (ITestProject) getProperty("workspace");
                String value = proposal.getValue().toString();
                if (value.contains("/")) {
                    IStepObject newStepObject = SheepDogBuilder.createStepObject(workspace, value);
                    SheepDogBuilder.createStepDefinition(newStepObject, ((ITestStep) cursor).getStepDefinitionName());
                } else {
                    String fullName = ((ITestStep) cursor).getFullName();
                    String component = StepObjectRefFragments.getComponent(fullName);
                    String objectName = StepObjectRefFragments.getObject(fullName);
                    for (ITestDocument doc : workspace.getTestDocumentList()) {
                        if (!(doc instanceof IStepObject)) continue;
                        IStepObject stepObject = (IStepObject) doc;
                        if (!stepObject.getName().equals(objectName)) continue;
                        if (!component.isEmpty()) {
                            String docFullName = stepObject.getFullName();
                            String[] parts = docFullName.split("/");
                            if (parts.length < 3) continue;
                            String docComponent = String.join("/", Arrays.copyOfRange(parts, 1, parts.length - 1));
                            if (!docComponent.equals(component)) continue;
                        }
                        SheepDogBuilder.createStepDefinition(stepObject, value);
                    }
                }
            } else if (cursor instanceof IText) {
                IText theText = (IText) cursor;
                ITestStep testStep = theText.getParent();
                String stepDefinitionName = testStep.getStepDefinitionName();
                String stepObjectName = testStep.getStepObjectName();
                String component = StepObjectRefFragments.getComponent(stepObjectName);
                String objectName = StepObjectRefFragments.getObject(stepObjectName);
                ITestProject workspace = (ITestProject) getProperty("workspace");
                for (ITestDocument doc : workspace.getTestDocumentList()) {
                    if (!(doc instanceof IStepObject)) continue;
                    IStepObject stepObject = (IStepObject) doc;
                    if (!stepObject.getName().equals(objectName)) continue;
                    String docFullName = stepObject.getFullName();
                    String[] parts = docFullName.split("/");
                    if (parts.length < 3) continue;
                    String docComponent = String.join("/", Arrays.copyOfRange(parts, 1, parts.length - 1));
                    if (!component.isEmpty() && !docComponent.equals(component)) continue;
                    IStepDefinition stepDef = stepObject.getStepDefinition(stepDefinitionName);
                    if (stepDef == null) continue;
                    String value = proposal.getValue().toString();
                    IStepParameters stepParams = SheepDogBuilder.createStepParameters(stepDef, value);
                    if (stepParams.getTable() == null) {
                        ITable spTable = SheepDogFactory.instance.createTable();
                        stepParams.setTable(spTable);
                        IRow headerRow = SheepDogBuilder.createRow(spTable);
                        SheepDogBuilder.createCell(headerRow, value);
                    }
                }
            } else if (cursor instanceof IRow) {
                IRow theRow = (IRow) cursor;
                ITable table = theRow.getParent();
                Object tableParent = table.getParent();
                if (tableParent instanceof ITestStep) {
                    ITestStep testStep = (ITestStep) tableParent;
                    String stepDefinitionName = testStep.getStepDefinitionName();
                    String stepObjectName = testStep.getStepObjectName();
                    String component = StepObjectRefFragments.getComponent(stepObjectName);
                    String objectName = StepObjectRefFragments.getObject(stepObjectName);
                    ITestProject workspace = (ITestProject) getProperty("workspace");
                    for (ITestDocument doc : workspace.getTestDocumentList()) {
                        if (!(doc instanceof IStepObject)) continue;
                        IStepObject stepObject = (IStepObject) doc;
                        if (!stepObject.getName().equals(objectName)) continue;
                        String docFullName = stepObject.getFullName();
                        String[] parts = docFullName.split("/");
                        if (parts.length < 3) continue;
                        String docComponent = String.join("/", Arrays.copyOfRange(parts, 1, parts.length - 1));
                        if (!component.isEmpty() && !docComponent.equals(component)) continue;
                        IStepDefinition stepDef = stepObject.getStepDefinition(stepDefinitionName);
                        if (stepDef == null) continue;
                        String value = proposal.getValue().toString();
                        IStepParameters stepParams = SheepDogBuilder.createStepParameters(stepDef, value);
                        if (stepParams.getTable() == null) {
                            ITable spTable = SheepDogFactory.instance.createTable();
                            stepParams.setTable(spTable);
                            IRow headerRow = SheepDogBuilder.createRow(spTable);
                            for (ICell cell : theRow.getCellList()) {
                                SheepDogBuilder.createCell(headerRow, cell.getName());
                            }
                        }
                    }
                }
            }
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
