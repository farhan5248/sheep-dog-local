package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
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
import org.slf4j.Logger;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ApplyQuickfixActionImpl extends TestObjectSheepDogImpl implements ApplyQuickfixAction {

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }

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
        Logger logger = SheepDogLoggerFactory.getLogger(ApplyQuickfixActionImpl.class);
        logger.debug("Entering setPerformedAsFollows");

        navigateToDocument();
        navigateToNode();

        // Main code entry point - delegate to IssueResolver
        // Get the validation annotation content
        String validationMessage = "";
        Object validationContent = getProperty("validate annotation.Content");
        if (validationContent != null) {
            validationMessage = validationContent.toString();
        }
        logger.debug("Validation message: " + validationMessage);

        // Get the current cursor (node)
        Object cursor = getProperty("cursor");
        if (cursor == null) {
            logger.debug("Cursor is null");
            logger.debug("Exiting setPerformedAsFollows");
            return;
        }
        logger.debug("Cursor type: " + cursor.getClass().getName());

        // Match cursor type and validation message against issue types and call appropriate resolver
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        if (cursor instanceof ICell && CellIssueTypes.CELL_NAME_ONLY.description.equals(validationMessage)) {
            logger.debug("Cell issue detected, calling CellIssueResolver");
            proposals.addAll(CellIssueResolver.correctCapitalizeNameOnly((ICell) cursor));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                if ("Capitalize cell name".equals(proposal.getId())) {
                    logger.debug("Applying proposal: " + proposal.getValue());
                    ((ICell) cursor).setName(proposal.getValue().toString());
                }
            }
        } else if (cursor instanceof ITestSuite && TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description.equals(validationMessage)) {
            logger.debug("TestSuite issue detected, calling TestSuiteIssueResolver");
            proposals.addAll(TestSuiteIssueResolver.correctCapitalizeNameOnly((ITestSuite) cursor));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                if ("Capitalize test suite name".equals(proposal.getId())) {
                    logger.debug("Applying proposal: " + proposal.getValue());
                    ((ITestSuite) cursor).setName(proposal.getValue().toString());
                }
            }
        } else if (cursor instanceof ITestStepContainer && TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description.equals(validationMessage)) {
            logger.debug("TestStepContainer issue detected, calling TestStepContainerIssueResolver");
            proposals.addAll(TestStepContainerIssueResolver.correctCapitalizeNameOnly((ITestStepContainer) cursor));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                if ("Capitalize test step container name".equals(proposal.getId())) {
                    logger.debug("Applying proposal: " + proposal.getValue());
                    ((ITestStepContainer) cursor).setName(proposal.getValue().toString());
                }
            }
        } else if (cursor instanceof ITestStep && TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description.equals(validationMessage)) {
            logger.debug("TestStep workspace issue detected, calling TestStepIssueResolver.correctStepObjectNameWorkspace");
            ITestProject workspace = (ITestProject) getProperty("workspace");
            ITestStep testStep = (ITestStep) cursor;
            proposals.addAll(TestStepIssueResolver.correctStepObjectNameWorkspace(testStep, workspace));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                logger.debug("Applying proposal: " + proposal.getValue());
                // Apply by adding step object to workspace
                addStepObjectWithFullName(proposal.getValue().toString());
                // Also add the step definition from the test step to the newly created step object
                String stepDefinitionName = testStep.getStepDefinitionName();
                if (stepDefinitionName != null && !stepDefinitionName.trim().isEmpty()) {
                    logger.debug("Adding step definition: " + stepDefinitionName);
                    addStepDefinitionWithName(stepDefinitionName);
                }
            }
        } else if (cursor instanceof ITestStep && TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description.equals(validationMessage)) {
            logger.debug("TestStep step definition workspace issue detected, calling TestStepIssueResolver.correctStepDefinitionNameWorkspace");
            ITestProject workspace = (ITestProject) getProperty("workspace");
            ITestStep testStep = (ITestStep) cursor;
            proposals.addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace(testStep, workspace));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                logger.debug("Applying proposal: " + proposal.getValue());
                // Get the step object path from the test step
                String stepObjectFullName = org.farhan.dsl.grammar.SheepDogUtility.getStepObjectFullNameForTestStep(testStep, workspace);
                if (stepObjectFullName != null && !stepObjectFullName.isEmpty()) {
                    logger.debug("Step object full name: " + stepObjectFullName);
                    // Navigate to the step object
                    Object stepObjectDoc = workspace.getTestDocument(stepObjectFullName);
                    if (stepObjectDoc != null) {
                        setProperty("cursor", stepObjectDoc);
                        // Add the step definition to the existing step object
                        addStepDefinitionWithName(proposal.getValue().toString());
                    } else {
                        logger.debug("Step object not found: " + stepObjectFullName);
                    }
                }
            }
        } else if (cursor instanceof IRow && RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description.equals(validationMessage)) {
            logger.debug("Row cell list workspace issue detected, calling RowIssueResolver.correctCellListWorkspace");
            ITestProject workspace = (ITestProject) getProperty("workspace");
            IRow row = (IRow) cursor;
            proposals.addAll(RowIssueResolver.correctCellListWorkspace(row, workspace));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                logger.debug("Applying proposal: " + proposal.getId() + " with value: " + proposal.getValue());
                // Check if this is a "Generate" proposal
                if (proposal.getId() != null && proposal.getId().startsWith("Generate ")) {
                    // This is a proposal to add a new parameter set
                    // Navigate to the step object and step definition
                    ITable table = row.getParent();
                    if (table != null && table.getParent() instanceof ITestStep) {
                        ITestStep testStep = (ITestStep) table.getParent();
                        String stepObjectFullName = org.farhan.dsl.grammar.SheepDogUtility.getStepObjectFullNameForTestStep(testStep, workspace);
                        if (stepObjectFullName != null && !stepObjectFullName.isEmpty()) {
                            logger.debug("Step object full name: " + stepObjectFullName);
                            // Navigate to the step object
                            Object stepObjectDoc = workspace.getTestDocument(stepObjectFullName);
                            if (stepObjectDoc instanceof IStepObject) {
                                IStepObject stepObject = (IStepObject) stepObjectDoc;
                                // Find the step definition
                                String stepDefinitionName = testStep.getStepDefinitionName();
                                if (stepDefinitionName != null) {
                                    for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
                                        if (stepDefinition.getName().equals(stepDefinitionName)) {
                                            logger.debug("Found step definition: " + stepDefinitionName);
                                            // Set cursor to step definition
                                            setProperty("cursor", stepDefinition);
                                            // Add the step parameters
                                            addStepParametersWithName(proposal.getValue().toString());
                                            // After adding step parameters, cursor is at the new StepParameters
                                            // Add cells to the newly created step parameters
                                            String parametersValue = proposal.getValue().toString();
                                            if (parametersValue != null && !parametersValue.trim().isEmpty()) {
                                                // Parse comma-separated cell names
                                                String[] cellNames = parametersValue.split(",");
                                                if (cellNames.length > 0) {
                                                    // Create table and row structure
                                                    Object stepParamsObj = getProperty("cursor");
                                                    if (stepParamsObj instanceof org.farhan.dsl.grammar.IStepParameters) {
                                                        org.farhan.dsl.grammar.IStepParameters stepParams = (org.farhan.dsl.grammar.IStepParameters) stepParamsObj;
                                                        // Create table if it doesn't exist
                                                        org.farhan.dsl.grammar.ITable paramTable = stepParams.getTable();
                                                        if (paramTable == null) {
                                                            paramTable = org.farhan.dsl.grammar.SheepDogBuilder.createTable(stepParams);
                                                        }
                                                        // Create row
                                                        org.farhan.dsl.grammar.IRow paramRow = org.farhan.dsl.grammar.SheepDogBuilder.createRow(paramTable);
                                                        // Add cells
                                                        for (String cellName : cellNames) {
                                                            String trimmedCellName = cellName.trim();
                                                            if (!trimmedCellName.isEmpty()) {
                                                                logger.debug("Adding cell: " + trimmedCellName);
                                                                setProperty("cursor", paramRow);
                                                                addCellWithName(trimmedCellName);
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }
                            } else {
                                logger.debug("Step object not found: " + stepObjectFullName);
                            }
                        }
                    }
                } else {
                    // This is a proposal to add a step object
                    addStepObjectWithFullName(proposal.getValue().toString());
                }
            }
        } else if (cursor instanceof IText && TextIssueTypes.TEXT_CONTENT_WORKSPACE.description.equals(validationMessage)) {
            logger.debug("Text content workspace issue detected, calling TextIssueResolver.correctContentWorkspace");
            ITestProject workspace = (ITestProject) getProperty("workspace");
            IText text = (IText) cursor;
            proposals.addAll(TextIssueResolver.correctContentWorkspace(text, workspace));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                logger.debug("Applying proposal: " + proposal.getId() + " with value: " + proposal.getValue());
                // Check if this is a "Generate Content" proposal
                if ("Generate Content".equals(proposal.getId())) {
                    // This is a proposal to add a new parameter set for text content
                    // Navigate to the step object and step definition
                    if (text.getParent() instanceof ITestStep) {
                        ITestStep testStep = (ITestStep) text.getParent();
                        String stepObjectFullName = org.farhan.dsl.grammar.SheepDogUtility.getStepObjectFullNameForTestStep(testStep, workspace);
                        if (stepObjectFullName != null && !stepObjectFullName.isEmpty()) {
                            logger.debug("Step object full name: " + stepObjectFullName);
                            // Navigate to the step object
                            Object stepObjectDoc = workspace.getTestDocument(stepObjectFullName);
                            if (stepObjectDoc instanceof IStepObject) {
                                IStepObject stepObject = (IStepObject) stepObjectDoc;
                                // Find the step definition
                                String stepDefinitionName = testStep.getStepDefinitionName();
                                if (stepDefinitionName != null) {
                                    for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
                                        if (stepDefinition.getName().equals(stepDefinitionName)) {
                                            logger.debug("Found step definition: " + stepDefinitionName);
                                            // Set cursor to step definition
                                            setProperty("cursor", stepDefinition);
                                            // Add the step parameters
                                            addStepParametersWithName(proposal.getValue().toString());
                                            // After adding step parameters, cursor is at the new StepParameters
                                            // Add cells to the newly created step parameters
                                            Object stepParamsObj = getProperty("cursor");
                                            if (stepParamsObj instanceof org.farhan.dsl.grammar.IStepParameters) {
                                                org.farhan.dsl.grammar.IStepParameters stepParams = (org.farhan.dsl.grammar.IStepParameters) stepParamsObj;
                                                // Create table if it doesn't exist
                                                org.farhan.dsl.grammar.ITable paramTable = stepParams.getTable();
                                                if (paramTable == null) {
                                                    paramTable = org.farhan.dsl.grammar.SheepDogBuilder.createTable(stepParams);
                                                }
                                                // Create row
                                                org.farhan.dsl.grammar.IRow paramRow = org.farhan.dsl.grammar.SheepDogBuilder.createRow(paramTable);
                                                // Add cell with name "Content"
                                                logger.debug("Adding cell: Content");
                                                setProperty("cursor", paramRow);
                                                addCellWithName("Content");
                                            }
                                            break;
                                        }
                                    }
                                }
                            } else {
                                logger.debug("Step object not found: " + stepObjectFullName);
                            }
                        }
                    }
                }
            }
        } else {
            logger.debug("No matching issue type");
        }

        logger.debug("Exiting setPerformedAsFollows");
    }
}
