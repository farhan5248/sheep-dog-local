package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;
import org.slf4j.Logger;

public class RowIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(IRow theRow, ITestProject workspace) {
        logger.debug("Entering correctCellListWorkspace");

        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        // Get the parent table
        ITable table = theRow.getParent();
        if (table == null) {
            logger.debug("Exiting correctCellListWorkspace - no table");
            return proposals;
        }

        // Get the parent test step
        Object tableParent = table.getParent();
        if (!(tableParent instanceof ITestStep)) {
            logger.debug("Exiting correctCellListWorkspace - table parent is not a test step");
            return proposals;
        }

        ITestStep testStep = (ITestStep) tableParent;
        String fullName = testStep.getFullName();
        if (fullName == null || fullName.trim().isEmpty() || fullName.equals("empty")) {
            logger.debug("Exiting correctCellListWorkspace - test step has no full name");
            return proposals;
        }

        // Extract component and object from the test step
        String[] parts = extractComponentAndObject(fullName);
        if (parts == null) {
            logger.debug("Exiting correctCellListWorkspace - cannot extract component and object");
            return proposals;
        }

        String component = parts[0];
        String object = parts[1];

        // Get step definition name from the test step
        String stepDefinitionName = testStep.getStepDefinitionName();
        if (stepDefinitionName == null || stepDefinitionName.trim().isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace - no step definition name");
            return proposals;
        }

        // Find the step object in the workspace
        if (workspace == null) {
            logger.debug("Exiting correctCellListWorkspace - no workspace");
            return proposals;
        }

        // Build the step object path
        String stepObjectPath;
        if (component.isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace - component is empty");
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
            logger.debug("Exiting correctCellListWorkspace - step object not found: " + stepObjectPath);
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

        // Add proposal to generate the missing parameter set based on current row cells
        if (theRow.getCellList() != null && !theRow.getCellList().isEmpty()) {
            StringBuilder newParametersName = new StringBuilder();
            for (ICell cell : theRow.getCellList()) {
                if (newParametersName.length() > 0) {
                    newParametersName.append(", ");
                }
                newParametersName.append(cell.getName());
            }

            if (newParametersName.length() > 0) {
                SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
                generateProposal.setId("Generate " + newParametersName.toString());
                generateProposal.setDescription("");
                generateProposal.setValue(newParametersName.toString());
                proposals.add(generateProposal);
            }
        }

        if (proposals.isEmpty()) {
            logger.debug("Exiting correctCellListWorkspace - no step parameters found for step definition: " + stepDefinitionName);
        }

        logger.debug("Exiting correctCellListWorkspace with " + proposals.size() + " proposals");
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
