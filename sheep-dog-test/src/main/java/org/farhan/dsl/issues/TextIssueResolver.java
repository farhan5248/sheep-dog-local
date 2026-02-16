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

        // Get the qualified name of the step object for this test step
        String stepObjectQualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        logger.debug("Step object qualified name: {}", stepObjectQualifiedName);

        if (stepObjectQualifiedName == null || stepObjectQualifiedName.isEmpty()) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Get the test project to access workspace step objects
        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        if (theProject == null) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Find the step object with this qualified name
        IStepObject stepObject = theProject.getStepObject(stepObjectQualifiedName);
        if (stepObject == null) {
            logger.debug("Step object not found: {}", stepObjectQualifiedName);
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }
        logger.debug("Found step object: {}", stepObject.getNameLong());

        // Get the step definition name from the test step
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        logger.debug("Looking for step definition: {}", stepDefinitionName);

        if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }

        // Find the step definition in the step object
        IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
        if (stepDefinition == null) {
            logger.debug("Step definition not found: {}", stepDefinitionName);
            logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
            return proposals;
        }
        logger.debug("Found step definition: {}", stepDefinition.getName());

        // Check if this step definition already has a "Content" parameter
        IStepParameters existingContentParameter = stepDefinition.getStepParameters("Content");
        if (existingContentParameter == null) {
            // Create a proposal to generate the missing Content parameter
            IStepObject clonedStepObject = SheepDogUtility.cloneStepObject(stepObject);
            IStepDefinition clonedStepDefinition = clonedStepObject.getStepDefinition(stepDefinitionName);

            if (clonedStepDefinition != null) {
                IStepParameters stepParameters = SheepDogBuilder.createStepParameters(clonedStepDefinition, "Content");
                ITable table = SheepDogBuilder.createTable(stepParameters);
                IRow row = SheepDogBuilder.createRow(table);
                SheepDogBuilder.createCell(row, "Content");

                SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
                generateProposal.setId("Generate Content");
                generateProposal.setDescription(SheepDogUtility.getStatementListAsString(clonedStepDefinition.getStatementList()));
                generateProposal.setValue(clonedStepObject);
                proposals.add(generateProposal);

                logger.debug("Created proposal to generate Content parameter");
            }
        }

        logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
