package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
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
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (!stepDefinitionName.isEmpty()) {
            ITestProject theProject = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
            IStepObject theStepObject = theProject.getStepObject(qualifiedName);
            if (theStepObject != null) {
                IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
                if (theStepDefinition != null) {
                    boolean found = false;
                    for (IStepParameters stepParameters : theStepDefinition.getStepParameterList()) {
                        ITable paramsTable = stepParameters.getTable();
                        if (paramsTable != null && !paramsTable.getRowList().isEmpty()) {
                            for (ICell cell : paramsTable.getRow(0).getCellList()) {
                                if ("Content".equals(cell.getName())) {
                                    found = true;
                                    break;
                                }
                            }
                        }
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                        proposal.setId("Generate Content");
                        proposal.setDescription("");
                        proposal.setValue(theStepObject.getContent());
                        proposals.add(proposal);
                    }
                }
            }
        }
        logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
