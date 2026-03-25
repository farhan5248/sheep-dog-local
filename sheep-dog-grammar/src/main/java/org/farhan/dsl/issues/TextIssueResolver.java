package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
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
        logger.debug("Entering correctNameWorkspace for theTestStep: {}",
                theTestStep != null ? theTestStep.getStepObjectName() : "null");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepDefinitionName = theTestStep.getStepDefinitionName();
        if (!stepDefinitionName.isEmpty()) {
            ITestProject theProject = SheepDogUtility.getTestProjectParent(theTestStep);
            String fullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
            IStepObject theStepObject = (IStepObject) SheepDogUtility.getTestDocument(theProject, fullName);
            if (theStepObject != null) {
                IStepDefinition theStepDefinition = SheepDogUtility.getStepDefinition(theStepObject, stepDefinitionName);
                if (theStepDefinition != null && !hasContentCell(theStepDefinition)) {
                    IStepObject clonedStepObject = SheepDogUtility.cloneStepObject(theStepObject);
                    IStepDefinition clonedStepDefinition = SheepDogUtility.getStepDefinition(clonedStepObject, stepDefinitionName);
                    IStepParameters newStepParameters = SheepDogBuilder.createStepParameters(clonedStepDefinition, "Content");
                    ITable newTable = SheepDogBuilder.createTable(newStepParameters);
                    IRow newRow = SheepDogBuilder.createRow(newTable);
                    SheepDogBuilder.createCell(newRow, "Content");
                    SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                    proposal.setId("Generate Content");
                    proposal.setDescription("");
                    proposal.setValue(clonedStepObject);
                    proposals.add(proposal);
                }
            }
        }
        logger.debug("Exiting correctNameWorkspace with result: {} proposals", proposals.size());
        return proposals;
    }

    private static boolean hasContentCell(IStepDefinition theStepDefinition) {
        for (IStepParameters stepParameters : theStepDefinition.getStepParameterList()) {
            ITable paramsTable = stepParameters.getTable();
            if (paramsTable != null && !paramsTable.getRowList().isEmpty()) {
                for (ICell cell : paramsTable.getRowList().get(0).getCellList()) {
                    if ("Content".equals(cell.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
