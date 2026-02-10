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
import org.farhan.dsl.lang.SheepDogUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class TextIssueResolver {

    private static final Logger logger = LoggerFactory.getLogger(TextIssueResolver.class);

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theTestStep the element needing corrections
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> correctNameWorkspace(ITestStep theTestStep) throws Exception {
        logger.debug("Entering correctNameWorkspace");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();

        ITestProject theProject = theTestStep.getParent().getParent().getParent();
        String qualifiedName = SheepDogUtility.getStepObjectNameLongForTestStep(theTestStep);
        IStepObject theStepObject = theProject.getStepObject(qualifiedName);
        if (theStepObject != null) {
            String stepDefinitonName = theTestStep.getStepDefinitionName();
            IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitonName);
            if (theStepDefinition != null) {
                // This assumes that the step is valid but the parameters don't exist
                IStepParameters theStepParameters = theStepDefinition.getStepParameters("Content");
                if (theStepParameters == null) {
                    theStepParameters = SheepDogBuilder.createStepParameters(theStepDefinition, "Content");
                    ITable table = SheepDogBuilder.createTable(theStepParameters);
                    IRow row = SheepDogBuilder.createRow(table);
                    SheepDogBuilder.createCell(row, "Content");
                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                    proposal.setId("Generate "
                            + SheepDogUtility.getCellListAsString(theStepParameters.getTable().getRowList().getFirst().getCellList()));
                    proposal.setDescription(
                            SheepDogUtility.getStatementListAsString(theStepParameters.getStatementList()));
                    proposal.setValue(theStepObject.getContent());
                    proposal.setQualifiedName(theStepObject.getNameLong());
                    proposals.add(proposal);
                }
            }
        }
        logger.debug("Exiting correctNameWorkspace with {} proposals", proposals.size());
        return proposals;
    }

}
