package org.farhan.dsl.issues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogUtility;
import org.farhan.dsl.lang.StepObjectRef;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class TestStepIssueResolver {

    private static final Logger logger = LoggerFactory.getLogger(TestStepIssueResolver.class);

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
                theTestStep != null ? theTestStep.getName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
        if (!theTestStep.getStepObjectName().isEmpty()) {
            // suggest other component objects
            String component = StepObjectRef.getComponent(theTestStep.getNameLong());
            proposals.addAll(getComponentObjects(theTestStep, component));

            // or create a new one
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            IStepObject theStepObject = SheepDogBuilder.createStepObject(null, qualifiedName);
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Generate " + theStepObject.getName() + " - " + theStepObject.getNameLong());
            proposal.setDescription(SheepDogUtility.getStatementListAsString(theStepObject.getStatementList()));
            proposal.setValue(theStepObject.getContent());
            proposal.setQualifiedName(theStepObject.getNameLong());
            proposals.add(proposal);
        }
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
                theTestStep != null ? theTestStep.getName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (stepDefinitionName.isEmpty()) {
            // the step definition name is invalid
            for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep)) {
                proposals.add(proposal);
            }
        } else {
            ITestProject theProject = theTestStep.getParent().getParent().getParent();
            IStepObject theStepObject = theProject
                    .getStepObject(SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep));
            if (theStepObject != null) {
                IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                if (theStepDefinition == null) {
                    // the step definition name is valid but doesn't exist
                    for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep)) {
                        proposals.add(proposal);
                    }
                    theStepDefinition = SheepDogBuilder.createStepDefinition(theStepObject, stepDefinitionName);
                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                    proposal.setId("Generate " + theStepDefinition.getName());
                    proposal.setDescription(
                            SheepDogUtility.getStatementListAsString(theStepDefinition.getStatementList()));
                    proposal.setValue(theStepObject.getContent());
                    proposal.setQualifiedName(theStepObject.getNameLong());
                    proposals.add(proposal);
                }
            }
        }
        logger.debug("Exiting correctStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    private static ArrayList<SheepDogIssueProposal> getComponentObjects(ITestStep theTestStep, String component) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
        SheepDogIssueProposal proposal;
        ITestProject theProject = theTestStep.getParent().getParent().getParent();
        for (IStepObject so : theProject.getStepObjectList()) {
            if (so.getNameLong().split("/")[0].contentEquals(component)) {
                proposal = new SheepDogIssueProposal();
                proposal.setId(so.getNameLong().replaceFirst(component + "/", "")
                        .replaceFirst(theProject.getFileExtension() + "$", ""));
                proposal.setDescription(SheepDogUtility.getStatementListAsString(so.getStatementList()));
                proposal.setValue("The " + component + " " + proposal.getId());
                proposals.add(proposal);
            }
        }
        return proposals;
    }

    private static ArrayList<SheepDogIssueProposal> getStepDefinitions(ITestStep theTestStep) throws Exception {

        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
        SheepDogIssueProposal proposal;
        ITestProject theProject = theTestStep.getParent().getParent().getParent();
        IStepObject stepObject = theProject
                .getStepObject(SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep));
        if (stepObject != null) {
            for (IStepDefinition stepDefinition : stepObject.getStepDefinitionList()) {
                proposal = new SheepDogIssueProposal();
                proposal.setId(stepDefinition.getName());
                proposal.setDescription(SheepDogUtility.getStatementListAsString(stepDefinition.getStatementList()));
                proposal.setValue(proposal.getId());
                proposals.add(proposal);
            }
        }
        return proposals;
    }

    private static ArrayList<ITestStep> getPreviousSteps(ITestStep theTestStep) {
        ArrayList<ITestStep> steps = new ArrayList<ITestStep>();
        ITestStepContainer testSetup = theTestStep.getParent().getParent().getTestStepContainer(0);
        if (testSetup != null && testSetup instanceof ITestSetup) {
            if (testSetup.getTestStepList() != null) {
                for (ITestStep t : testSetup.getTestStepList()) {
                    steps.add(t);
                }
            }
        }

        for (ITestStep t : theTestStep.getParent().getTestStepList()) {
            if (t.equals(theTestStep)) {
                break;
            } else {
                steps.add(t);
            }
        }
        return steps;
    }

    private static Collection<SheepDogIssueProposal> getPreviousObjects(ITestStep theTestStep) throws Exception {
        TreeMap<String, SheepDogIssueProposal> proposals = new TreeMap<String, SheepDogIssueProposal>();
        SheepDogIssueProposal proposal;

        for (ITestStep step : getPreviousSteps(theTestStep)) {
            // TODO make test for this

            if (step.getName() == null) {
                continue;
            } else if (!TestStepIssueDetector.validateStepObjectNameOnly(step).isEmpty()
                    || !TestStepIssueDetector.validateStepDefinitionNameOnly(step).isEmpty()) {
                continue;
            }
            String nameLong = step.getNameLong();
            String stepObjectNameLong = SheepDogUtility.getStepObjectNameLongForTestStep(step);
            ITestProject theProject = theTestStep.getParent().getParent().getParent();
            // Give both options, just the object or with the component

            proposal = new SheepDogIssueProposal();
            proposal.setId(StepObjectRef.getObject(nameLong));
            proposal.setDescription("Referred in: " + step.getName());
            proposal.setValue("The " + proposal.getId());
            proposals.put(proposal.getId(), proposal);

            proposal = new SheepDogIssueProposal();
            proposal.setId(stepObjectNameLong.replaceFirst(theProject.getFileExtension() + "$", ""));
            proposal.setDescription("Referred in: " + step.getName());
            proposal.setValue(StepObjectRef.getStepObjectName(nameLong));
            proposals.put(proposal.getId(), proposal);
        }
        return proposals.values();
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
                theTestStep != null ? theTestStep.getName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
        ITestProject theProject = theTestStep.getParent().getParent().getParent();
        for (String componentName : getComponentList(theProject)) {
            proposals.addAll(getComponentObjects(theTestStep, componentName));
        }
        for (SheepDogIssueProposal proposal : getPreviousObjects(theTestStep)) {
            proposals.add(proposal);
        }
        logger.debug("Exiting suggestStepObjectNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

    private static ArrayList<String> getComponentList(ITestProject testProject) {
        TreeSet<String> theSet = new TreeSet<String>();
        for (IStepObject so : testProject.getStepObjectList()) {
            theSet.add(so.getNameLong().split("/")[0]);
        }
        ArrayList<String> theList = new ArrayList<String>();
        theList.addAll(theSet);
        return theList;
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
                theTestStep != null ? theTestStep.getName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
        for (SheepDogIssueProposal proposal : getStepDefinitions(theTestStep)) {
            proposals.add(proposal);
        }
        logger.debug("Exiting suggestStepDefinitionNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
