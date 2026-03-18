package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
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
            proposals.addAll(TestStepIssueResolver.correctStepObjectNameWorkspace((ITestStep) cursor, workspace));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                logger.debug("Applying proposal: " + proposal.getValue());
                // TODO: Implement workspace modification when needed
                throw new UnsupportedOperationException("Workspace modification not yet implemented for TestStep");
            }
        } else if (cursor instanceof ITestStep && TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description.equals(validationMessage)) {
            logger.debug("TestStep step definition workspace issue detected, calling TestStepIssueResolver.correctStepDefinitionNameWorkspace");
            ITestProject workspace = (ITestProject) getProperty("workspace");
            proposals.addAll(TestStepIssueResolver.correctStepDefinitionNameWorkspace((ITestStep) cursor, workspace));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                logger.debug("Applying proposal: " + proposal.getValue());
                // TODO: Implement workspace modification when needed
                throw new UnsupportedOperationException("Workspace modification not yet implemented for TestStep");
            }
        } else if (cursor instanceof IRow && RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description.equals(validationMessage)) {
            logger.debug("Row cell list workspace issue detected, calling RowIssueResolver.correctCellListWorkspace");
            ITestProject workspace = (ITestProject) getProperty("workspace");
            proposals.addAll(RowIssueResolver.correctCellListWorkspace((IRow) cursor, workspace));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                logger.debug("Applying proposal: " + proposal.getValue());
                // TODO: Implement workspace modification when needed
                throw new UnsupportedOperationException("Workspace modification not yet implemented for Row");
            }
        } else if (cursor instanceof IText && TextIssueTypes.TEXT_CONTENT_WORKSPACE.description.equals(validationMessage)) {
            logger.debug("Text content workspace issue detected, calling TextIssueResolver.correctContentWorkspace");
            ITestProject workspace = (ITestProject) getProperty("workspace");
            proposals.addAll(TextIssueResolver.correctContentWorkspace((IText) cursor, workspace));
            // Apply proposals
            for (SheepDogIssueProposal proposal : proposals) {
                logger.debug("Applying proposal: " + proposal.getValue());
                // TODO: Implement workspace modification when needed
                throw new UnsupportedOperationException("Workspace modification not yet implemented for Text");
            }
        } else {
            logger.debug("No matching issue type");
        }

        logger.debug("Exiting setPerformedAsFollows");
    }
}
