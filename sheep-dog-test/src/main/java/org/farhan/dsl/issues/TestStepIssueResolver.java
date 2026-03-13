package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.StepObjectRefFragments;

public class TestStepIssueResolver {

    public static ArrayList<SheepDogIssueProposal> suggestStepObjectNameWorkspace(ITestStep theTestStep) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (!stepObjectFullName.isEmpty()) {
            String stepFullName = SheepDogUtility.getTestStepFullName(theTestStep);
            String objectName = StepObjectRefFragments.getObject(stepFullName);
            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Generate " + objectName + " - " + stepObjectFullName);
            proposal.setDescription("");
            proposals.add(proposal);
        }
        return proposals;
    }

    public static ArrayList<SheepDogIssueProposal> suggestStepDefinitionNameWorkspace(ITestStep theTestStep) {
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
        if (!stepObjectFullName.isEmpty()) {
            ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
            if (project != null) {
                ITestDocument doc = project.getTestDocument(stepObjectFullName);
                if (doc instanceof IStepObject) {
                    IStepObject stepObject = (IStepObject) doc;
                    for (IStepDefinition stepDef : stepObject.getStepDefinitionList()) {
                        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
                        proposal.setId(stepDef.getName());
                        proposal.setDescription("");
                        proposal.setValue(stepDef.getName());
                        proposals.add(proposal);
                    }
                }
            }
            String stepDefinitionName = theTestStep.getStepDefinitionName();
            SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
            generateProposal.setId("Generate " + stepDefinitionName);
            generateProposal.setDescription("");
            proposals.add(generateProposal);
        }
        return proposals;
    }
}
