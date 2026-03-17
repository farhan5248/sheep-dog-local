package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.HashSet;
import org.slf4j.Logger;

public class TestStepIssueResolver {

    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep, ITestProject workspace) {
        Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);
        logger.debug("Entering suggestStepObjectNameWorkspace");

        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        HashSet<String> processedObjectNames = new HashSet<>();
        HashSet<String> components = new HashSet<>();

        // Get the parent container (test case or test setup)
        ITestStepContainer container = theTestStep.getParent();
        if (container == null) {
            logger.debug("Exiting suggestStepObjectNameWorkspace - no container");
            return proposals;
        }

        // Get the test suite to check background steps
        ITestSuite testSuite = container.getParent();
        if (testSuite == null) {
            logger.debug("Exiting suggestStepObjectNameWorkspace - no test suite");
            return proposals;
        }

        // Collect object names from background (test setup) steps
        for (ITestStepContainer tsc : testSuite.getTestStepContainerList()) {
            if (tsc instanceof ITestSetup) {
                collectProposalsFromContainer(tsc, theTestStep, proposals, processedObjectNames, components);
            }
        }

        // Collect object names from previous steps in the same container
        collectProposalsFromContainer(container, theTestStep, proposals, processedObjectNames, components);

        // Collect proposals from workspace step objects
        if (workspace != null) {
            if (!components.isEmpty()) {
                // If components were found, collect only step objects for those components
                collectProposalsFromWorkspace(workspace, components, proposals, processedObjectNames);
            } else {
                // If no components were found, collect all step objects with descriptions
                collectAllProposalsFromWorkspace(workspace, proposals, processedObjectNames);
            }
        }

        logger.debug("Exiting suggestStepObjectNameWorkspace with " + proposals.size() + " proposals");
        return proposals;
    }

    private static void collectProposalsFromContainer(ITestStepContainer container, ITestStep targetStep,
            ArrayList<SheepDogIssueProposal> proposals, HashSet<String> processedObjectNames, HashSet<String> components) {

        for (ITestStep step : container.getTestStepList()) {
            // Stop when we reach the target step (only look at previous steps)
            if (step == targetStep) {
                break;
            }

            String fullName = step.getFullName();
            if (fullName == null || fullName.trim().isEmpty() || fullName.equals("empty")) {
                continue;
            }

            // Extract component and object names from the step full name
            // Format: "The <component> <object> ..."
            String[] parts = extractComponentAndObject(fullName);
            if (parts != null) {
                String component = parts[0];
                String object = parts[1];
                String fullObjectName = parts[2];  // "The <component> <object>"
                String objectName = component.isEmpty() ? object : component + "/" + object;

                // Track components for workspace lookup
                if (!component.isEmpty()) {
                    components.add(component);
                }

                if (!processedObjectNames.contains(objectName)) {
                    processedObjectNames.add(objectName);

                    // Add short form proposal (just the object name)
                    String shortForm = "The " + object;
                    SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
                    shortProposal.setValue(shortForm);
                    shortProposal.setId(object);
                    shortProposal.setDescription("Referred in: " + fullName);
                    proposals.add(shortProposal);

                    // Add long form proposal (component/object)
                    SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                    longProposal.setValue(fullObjectName);
                    longProposal.setId(objectName);
                    longProposal.setDescription("Referred in: " + fullName);
                    proposals.add(longProposal);
                }
            }
        }
    }

    private static void collectProposalsFromWorkspace(ITestProject workspace, HashSet<String> components,
            ArrayList<SheepDogIssueProposal> proposals, HashSet<String> processedObjectNames) {

        // Iterate through all documents in workspace
        for (ITestDocument doc : workspace.getTestDocumentList()) {
            // Only process step objects, not test suites
            if (doc instanceof IStepObject) {
                IStepObject stepObject = (IStepObject) doc;
                String stepObjectFullName = stepObject.getFullName();

                // Step object full name format: "stepdefs/component/object" or "stepdefs/object"
                // We need to check if any of the components match
                for (String component : components) {
                    String prefix = "stepdefs/" + component + "/";
                    if (stepObjectFullName.startsWith(prefix)) {
                        // Extract the object name (after the component) and strip file extension
                        String objectPartWithExt = stepObjectFullName.substring(prefix.length());
                        // Strip file extension (e.g., ".asciidoc")
                        String objectPart = objectPartWithExt.replaceFirst("\\.[^.]+$", "");
                        String objectName = objectPart;  // Just the object name for the ID

                        // Check if we haven't already added this
                        if (!processedObjectNames.contains(objectName)) {
                            processedObjectNames.add(objectName);

                            // Add proposal for workspace step object
                            String fullObjectProposalName = "The " + component + " " + objectPart;
                            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                            proposal.setValue(fullObjectProposalName);
                            proposal.setId(objectName);
                            proposals.add(proposal);
                        }
                    }
                }
            }
        }
    }

    private static void collectAllProposalsFromWorkspace(ITestProject workspace,
            ArrayList<SheepDogIssueProposal> proposals, HashSet<String> processedObjectNames) {

        // Iterate through all documents in workspace
        for (ITestDocument doc : workspace.getTestDocumentList()) {
            // Only process step objects, not test suites
            if (doc instanceof IStepObject) {
                IStepObject stepObject = (IStepObject) doc;
                String stepObjectFullName = stepObject.getFullName();

                // Step object full name format: "stepdefs/component/object.asciidoc"
                // Parse the full name to extract component and object
                if (stepObjectFullName.startsWith("stepdefs/")) {
                    String pathAfterStepdefs = stepObjectFullName.substring("stepdefs/".length());
                    // Strip file extension
                    pathAfterStepdefs = pathAfterStepdefs.replaceFirst("\\.[^.]+$", "");

                    // Split by "/" to get component and object
                    String[] parts = pathAfterStepdefs.split("/");
                    if (parts.length >= 2) {
                        String component = parts[0];
                        String objectName = parts[1];
                        String fullObjectName = component + "/" + objectName;

                        // Check if we haven't already added this
                        if (!processedObjectNames.contains(objectName)) {
                            processedObjectNames.add(objectName);

                            // Extract description from step object
                            String description = extractDescription(stepObject);

                            // Add proposal for workspace step object
                            String fullObjectProposalName = "The " + component + " " + objectName;
                            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                            proposal.setValue(fullObjectProposalName);
                            proposal.setId(objectName);
                            if (description != null && !description.isEmpty()) {
                                proposal.setDescription(description);
                            }
                            proposals.add(proposal);
                        }
                    }
                }
            }
        }
    }

    private static String extractDescription(IStepObject stepObject) {
        IDescription description = stepObject.getDescription();
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

    public static ArrayList<SheepDogIssueProposal> suggestStepParametersWorkspace(IRow theRow, ITestProject workspace) {
        Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);
        logger.debug("Entering suggestStepParametersWorkspace");

        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        // Get the parent table
        ITable table = theRow.getParent();
        if (table == null) {
            logger.debug("Exiting suggestStepParametersWorkspace - no table");
            return proposals;
        }

        // Get the parent test step
        Object tableParent = table.getParent();
        if (!(tableParent instanceof ITestStep)) {
            logger.debug("Exiting suggestStepParametersWorkspace - table parent is not a test step");
            return proposals;
        }

        ITestStep testStep = (ITestStep) tableParent;
        String fullName = testStep.getFullName();
        if (fullName == null || fullName.trim().isEmpty() || fullName.equals("empty")) {
            logger.debug("Exiting suggestStepParametersWorkspace - test step has no full name");
            return proposals;
        }

        // Extract component and object from the test step
        String[] parts = extractComponentAndObject(fullName);
        if (parts == null) {
            logger.debug("Exiting suggestStepParametersWorkspace - cannot extract component and object");
            return proposals;
        }

        String component = parts[0];
        String object = parts[1];

        // Get step definition name from the test step
        String stepDefinitionName = testStep.getStepDefinitionName();
        if (stepDefinitionName == null || stepDefinitionName.trim().isEmpty()) {
            logger.debug("Exiting suggestStepParametersWorkspace - no step definition name");
            return proposals;
        }

        // Find the step object in the workspace
        if (workspace == null) {
            logger.debug("Exiting suggestStepParametersWorkspace - no workspace");
            return proposals;
        }

        // Build the step object path
        String stepObjectPath;
        if (component.isEmpty()) {
            logger.debug("Exiting suggestStepParametersWorkspace - component is empty");
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
            logger.debug("Exiting suggestStepParametersWorkspace - step object not found: " + stepObjectPath);
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
                        }
                        proposals.add(proposal);
                    }
                }
                break;
            }
        }

        if (proposals.isEmpty()) {
            logger.debug("Exiting suggestStepParametersWorkspace - no step parameters found for step definition: " + stepDefinitionName);
        }

        logger.debug("Exiting suggestStepParametersWorkspace with " + proposals.size() + " proposals");
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
}
