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

        if (theTestStep != null && theTestStep.getText() != null) {
            String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            String stepDefinitionName = theTestStep.getStepDefinitionName();

            if (stepObjectNameLong != null && !stepObjectNameLong.isEmpty()
                    && stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
                ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
                if (project != null) {
                    IStepObject existingStepObject = project.getStepObject(stepObjectNameLong);
                    if (existingStepObject != null) {
                        IStepObject clonedStepObject = SheepDogUtility.cloneStepObject(existingStepObject);
                        IStepDefinition clonedStepDefinition = clonedStepObject.getStepDefinition(stepDefinitionName);
                        if (clonedStepDefinition != null) {
                            IStepParameters newStepParameters = SheepDogBuilder.createStepParameters(clonedStepDefinition, "Content");
                            ITable table = SheepDogBuilder.createTable(newStepParameters);
                            IRow row = SheepDogBuilder.createRow(table);
                            SheepDogBuilder.createCell(row, "Content");
                            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                            proposal.setId("Generate Content");
                            proposal.setValue(clonedStepObject);
                            proposal.setDescription("");
                            proposals.add(proposal);
                            logger.debug("Added generate content proposal");
                        }
                    }
                }
            }
        }

        logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
