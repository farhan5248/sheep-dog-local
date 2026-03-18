package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.CellIssueTypes;
import org.farhan.dsl.issues.TestStepContainerIssueResolver;
import org.farhan.dsl.issues.TestStepContainerIssueTypes;
import org.farhan.dsl.issues.TestSuiteIssueResolver;
import org.farhan.dsl.issues.TestSuiteIssueTypes;
import org.farhan.objects.xtext.ListQuickfixesAction;
import org.slf4j.Logger;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesActionImpl extends TestObjectSheepDogImpl implements ListQuickfixesAction {

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
        Logger logger = SheepDogLoggerFactory.getLogger(ListQuickfixesActionImpl.class);
        logger.debug("Entering setPerformedAsFollows");

        navigateToDocument();
        navigateToNode();

        // Main code entry point - delegate to IssueResolver
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

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
            setProperty("list quickfixes popup", proposals);
            return;
        }
        logger.debug("Cursor type: " + cursor.getClass().getName());

        // Match cursor type and validation message against issue types and call appropriate resolver
        // Check cursor type first, then validation message
        if (cursor instanceof ICell && CellIssueTypes.CELL_NAME_ONLY.description.equals(validationMessage)) {
            logger.debug("Cell issue detected, calling CellIssueResolver");
            proposals.addAll(CellIssueResolver.correctCapitalizeNameOnly((ICell) cursor));
        } else if (cursor instanceof ITestSuite && TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description.equals(validationMessage)) {
            logger.debug("TestSuite issue detected, calling TestSuiteIssueResolver");
            proposals.addAll(TestSuiteIssueResolver.correctCapitalizeNameOnly((ITestSuite) cursor));
        } else if (cursor instanceof ITestStepContainer && TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description.equals(validationMessage)) {
            logger.debug("TestStepContainer issue detected, calling TestStepContainerIssueResolver");
            proposals.addAll(TestStepContainerIssueResolver.correctCapitalizeNameOnly((ITestStepContainer) cursor));
        } else {
            logger.debug("No matching issue type");
        }

        // Store the proposals in the property
        logger.debug("Storing " + proposals.size() + " proposals");
        setProperty("list quickfixes popup", proposals);
        logger.debug("Exiting setPerformedAsFollows");
    }
}
