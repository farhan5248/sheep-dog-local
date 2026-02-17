package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
import org.slf4j.Logger;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class TextIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctNameWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering correctNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        if (theTestStep == null) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        if (qualifiedName.isEmpty()) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        IStepObject theStepObject = theProject.getStepObject(qualifiedName);
        if (theStepObject == null) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        String stepDefinitionName = theTestStep.getStepDefinitionName();
        IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
        if (theStepDefinition == null) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        boolean hasContentParameter = theStepDefinition.getStepParameterList().stream()
                .anyMatch(sp -> "Content".equals(sp.getName()));
        if (!hasContentParameter) {
            IStepParameters contentParameters = SheepDogBuilder.createStepParameters(theStepDefinition, "Content");
            ITable table = SheepDogBuilder.createTable(contentParameters);
            IRow row = SheepDogBuilder.createRow(table);
            SheepDogBuilder.createCell(row, "Content");
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Generate Content");
            proposal.setValue(contentParameters.getName());
            proposal.setDescription("");
            proposals.add(proposal);
        }

        logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
