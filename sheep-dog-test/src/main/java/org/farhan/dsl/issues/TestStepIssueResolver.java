package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.farhan.dsl.lang.SheepDogUtility;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.slf4j.Logger;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class TestStepIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueResolver.class);

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theTestStep the element needing corrections
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> correctStepObjectNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering correctStepObjectNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        logger.debug("Exiting correctStepObjectNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theTestStep the element needing corrections
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> correctStepDefinitionNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering correctStepDefinitionNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        logger.debug("Exiting correctStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    /**
     * Generates proposals suggesting values when an assignment is missing or empty.
     *
     * @param theTestStep the element needing suggestions
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering suggestStepObjectNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        // Suggest objects from all components in the workspace
        ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
        for (SheepDogIssueProposal proposal : getWorkspaceObjects(theProject)) {
            proposals.add(proposal);
        }

        // Suggest objects from previous steps
        for (SheepDogIssueProposal proposal : getPreviousObjects(theTestStep)) {
            proposals.add(proposal);
        }

        logger.debug("Exiting suggestStepObjectNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    private static ArrayList<SheepDogIssueProposal> getPreviousObjects(ITestStep theTestStep) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        for (ITestStep previousStep : SheepDogUtility.getTestStepListUpToTestStep(theTestStep)) {
            String stepObjectName = previousStep.getStepObjectName();
            if (stepObjectName == null || stepObjectName.isEmpty()) {
                continue;
            }
            String component = StepObjectRefFragments.getComponent(stepObjectName);
            String object = StepObjectRefFragments.getObject(stepObjectName);
            if (object.isEmpty()) {
                continue;
            }
            String referredIn = "Referred in: " + previousStep.toString();

            // Short form: just the object
            SheepDogIssueProposal shortProposal = new SheepDogIssueProposal();
            shortProposal.setId(object);
            shortProposal.setValue("The " + object);
            shortProposal.setDescription(referredIn);
            proposals.add(shortProposal);

            // Long form: component/object (only when component is present)
            if (!component.isEmpty()) {
                SheepDogIssueProposal longProposal = new SheepDogIssueProposal();
                longProposal.setId(component + "/" + object);
                longProposal.setValue("The " + component + " " + object);
                longProposal.setDescription(referredIn);
                proposals.add(longProposal);
            }
        }
        return proposals;
    }

    private static ArrayList<SheepDogIssueProposal> getWorkspaceObjects(ITestProject theProject) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        if (theProject == null) {
            return proposals;
        }
        for (IStepObject stepObject : theProject.getStepObjectList()) {
            String nameLong = stepObject.getNameLong();
            if (nameLong == null || nameLong.isEmpty()) {
                continue;
            }
            String objectName = stepObject.getName();
            int lastSlash = nameLong.lastIndexOf('/');
            String component = lastSlash > 0 ? nameLong.substring(0, lastSlash) : "";
            String description = SheepDogUtility.getStatementListAsString(stepObject.getStatementList());

            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId(objectName);
            proposal.setValue("The " + (component.isEmpty() ? "" : component + " ") + objectName);
            proposal.setDescription(description);
            proposals.add(proposal);
        }
        return proposals;
    }

    /**
     * Generates proposals suggesting values when an assignment is missing or empty.
     *
     * @param theTestStep the element needing suggestions
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep)
            throws Exception {
        logger.debug("Entering suggestStepDefinitionNameWorkspace for step: {}",
                theTestStep != null ? theTestStep.toString() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
