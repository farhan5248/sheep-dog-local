package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogUtility;

public class RowIssueResolver {

    public static ArrayList<SheepDogIssueProposal> suggestStepParametersNameWorkspace(IRow theRow) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        ITable table = theRow.getParent();
        if (table == null) {
            return proposals;
        }
        Object tableParent = table.getParent();
        if (!(tableParent instanceof ITestStep)) {
            return proposals;
        }
        ITestStep testStep = (ITestStep) tableParent;
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
        if (stepObjectFullName.isEmpty()) {
            return proposals;
        }
        ITestProject project = SheepDogUtility.getTestProjectParentForRow(theRow);
        if (project == null) {
            return proposals;
        }
        ITestDocument doc = project.getTestDocument(stepObjectFullName);
        if (!(doc instanceof IStepObject)) {
            return proposals;
        }
        IStepObject stepObject = (IStepObject) doc;
        IStepDefinition stepDefinition = stepObject.getStepDefinition(testStep.getStepDefinitionName());
        if (stepDefinition != null) {
            for (IStepParameters stepParameters : stepDefinition.getStepParameterList()) {
                SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                proposal.setId(stepParameters.getName());
                proposal.setDescription("");
                proposal.setValue(stepParameters.getName());
                proposals.add(proposal);
            }
        }
        String cellsAsString = SheepDogUtility.getCellListAsString(theRow.getCellList());
        SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
        generateProposal.setId("Generate " + cellsAsString);
        generateProposal.setDescription("");
        proposals.add(generateProposal);
        return proposals;
    }
}
