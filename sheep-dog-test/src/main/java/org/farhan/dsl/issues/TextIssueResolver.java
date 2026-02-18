package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
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

        String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        logger.debug("stepObjectNameLong: {}", stepObjectNameLong);
        if (!stepObjectNameLong.isEmpty()) {
            ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (project != null) {
                IStepObject stepObject = project.getStepObject(stepObjectNameLong);
                logger.debug("stepObject: {}", stepObject != null ? stepObject.getName() : "null");
                if (stepObject != null) {
                    String stepDefinitionName = theTestStep.getStepDefinitionName();
                    logger.debug("stepDefinitionName: {}", stepDefinitionName);
                    IStepDefinition stepDefinition = stepObject.getStepDefinition(stepDefinitionName);
                    logger.debug("stepDefinition: {}", stepDefinition != null ? stepDefinition.getName() : "null");
                    if (stepDefinition != null) {
                        IStepParameters newStepParameters = SheepDogBuilder.createStepParameters(stepDefinition,
                                "Content");
                        SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
                        generateProposal.setId("Generate Content");
                        generateProposal.setValue(newStepParameters);
                        proposals.add(generateProposal);
                        logger.debug("Added generate proposal: Generate Content");
                    }
                }
            }
        }

        logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
