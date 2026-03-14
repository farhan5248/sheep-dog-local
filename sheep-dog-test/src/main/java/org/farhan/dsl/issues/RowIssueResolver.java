package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class RowIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> suggestCellListWorkspace(IRow theRow) {
        logger.debug("Entering suggestCellListWorkspace for theRow: {}", theRow != null ? "non-null" : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        ITestStep testStep = SheepDogUtility.getTestStepParentForRow(theRow);
        if (testStep == null) {
            logger.debug("Exiting suggestCellListWorkspace with result: {} proposals", proposals.size());
            return proposals;
        }
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
        if (stepObjectFullName.isEmpty()) {
            logger.debug("Exiting suggestCellListWorkspace with result: {} proposals", proposals.size());
            return proposals;
        }
        ITestProject project = SheepDogUtility.getTestProjectParentForRow(theRow);
        if (project == null) {
            logger.debug("Exiting suggestCellListWorkspace with result: {} proposals", proposals.size());
            return proposals;
        }
        ITestDocument doc = project.getTestDocument(stepObjectFullName);
        if (!(doc instanceof IStepObject)) {
            logger.debug("Exiting suggestCellListWorkspace with result: {} proposals", proposals.size());
            return proposals;
        }
        IStepObject stepObject = (IStepObject) doc;
        IStepDefinition stepDefinition = stepObject.getStepDefinition(testStep.getStepDefinitionName());
        if (stepDefinition != null) {
            for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                proposal.setId(stepParameters.getName());
                proposal.setDescription("");
                proposal.setValue(stepParameters.getName());
                proposals.add(proposal);
            }
        }
        String cellsAsString = SheepDogUtility.getCellListAsString(theRow.getCellList());
        SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
        generateProposal.setId("Generate " + cellsAsString);
        generateProposal.setDescription("");
        proposals.add(generateProposal);
        logger.debug("Exiting suggestCellListWorkspace with result: {} proposals", proposals.size());
        return proposals;
    }
}
