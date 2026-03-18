package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;
import org.slf4j.Logger;

public class TextIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctContentWorkspace(IText theText, ITestProject workspace) {
        logger.debug("Entering correctContentWorkspace");

        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        // Get the parent test step
        ITestStep testStep = theText.getParent();
        if (testStep == null) {
            logger.debug("Exiting correctContentWorkspace - no parent test step");
            return proposals;
        }

        String fullName = testStep.getFullName();
        if (fullName == null || fullName.trim().isEmpty() || fullName.equals("empty")) {
            logger.debug("Exiting correctContentWorkspace - test step has no full name");
            return proposals;
        }

        // Extract component and object from the test step
        String[] parts = extractComponentAndObject(fullName);
        if (parts == null) {
            logger.debug("Exiting correctContentWorkspace - cannot extract component and object");
            return proposals;
        }

        String component = parts[0];
        String object = parts[1];

        // Get step definition name from the test step
        String stepDefinitionName = testStep.getStepDefinitionName();
        if (stepDefinitionName == null || stepDefinitionName.trim().isEmpty()) {
            logger.debug("Exiting correctContentWorkspace - no step definition name");
            return proposals;
        }

        // Find the step object in the workspace
        if (workspace == null) {
            logger.debug("Exiting correctContentWorkspace - no workspace");
            return proposals;
        }

        // Build the step object path
        String stepObjectPath;
        if (component.isEmpty()) {
            logger.debug("Exiting correctContentWorkspace - component is empty");
            return proposals;
        } else {
            stepObjectPath = "stepdefs/" + component + "/" + object + ".asciidoc";
        }

        // Find the step object
        IStepObject stepObject = null;
        for (ITestDocument doc : workspace.getTestDocumentList()) {
            if (doc instanceof IStepObject) {
                if (doc.getFullName().equals(stepObjectPath)) {
                    stepObject = (IStepObject) doc;
                    break;
                }
            }
        }

        if (stepObject == null) {
            logger.debug("Exiting correctContentWorkspace - step object not found: " + stepObjectPath);
            return proposals;
        }

        // Find the step definition - iterate through all step definitions to find a match
        for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
            if (stepDefinition.getName().equals(stepDefinitionName)) {
                // Get the step parameters
                for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                    String parametersName = stepParameters.getName();
                    if (parametersName != null && !parametersName.trim().isEmpty()) {
                        // Extract description from step parameters
                        String description = extractDescriptionFromParameters(stepParameters);

                        // Create proposal
                        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                        proposal.setValue(parametersName);
                        proposal.setId(parametersName);
                        if (description != null && !description.isEmpty()) {
                            proposal.setDescription(description);
                        } else {
                            proposal.setDescription("");
                        }
                        proposals.add(proposal);
                    }
                }
                break;
            }
        }

        // Add proposal to generate the "Content" parameter for text blocks
        SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
        generateProposal.setId("Generate Content");
        generateProposal.setDescription("");
        generateProposal.setValue("Content");
        proposals.add(generateProposal);

        if (proposals.isEmpty()) {
            logger.debug("Exiting correctContentWorkspace - no step parameters found for step definition: " + stepDefinitionName);
        }

        logger.debug("Exiting correctContentWorkspace with " + proposals.size() + " proposals");
        return proposals;
    }

    private static String extractDescriptionFromParameters(IStepParameters stepParameters) {
        IDescription description = stepParameters.getDescription();
        if (description != null && description.getLineList() != null && !description.getLineList().isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ILine line : description.getLineList()) {
                if (sb.length() > 0) {
                    sb.append(" ");
                }
                sb.append(line.getName());
            }
            return sb.toString();
        }
        return "";
    }

    private static String[] extractComponentAndObject(String fullName) {
        // Parse step full name to extract component and object using existing fragments
        // Format: "The <component> <object> <verb phrase>"
        // Example: "The daily batchjob Output file is present" -> ["daily batchjob", "Output file", "The daily batchjob Output file"]

        String component = StepObjectRefFragments.getComponent(fullName);
        String object = StepObjectRefFragments.getObject(fullName);

        if (object.isEmpty()) {
            return null;
        }

        // Build full object name "The <component> <object>"
        String fullObjectName;
        if (component.isEmpty()) {
            fullObjectName = "The " + object;
        } else {
            fullObjectName = "The " + component + " " + object;
        }

        return new String[] { component, object, fullObjectName };
    }
}
