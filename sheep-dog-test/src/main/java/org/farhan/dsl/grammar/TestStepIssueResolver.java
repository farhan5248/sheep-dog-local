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

        // Collect proposals from workspace step objects for components used in previous steps
        if (workspace != null && !components.isEmpty()) {
            collectProposalsFromWorkspace(workspace, components, proposals, processedObjectNames);
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
