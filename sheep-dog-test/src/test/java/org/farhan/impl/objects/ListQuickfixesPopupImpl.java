package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesPopup;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesPopupImpl extends TestObjectSheepDogImpl implements ListQuickfixesPopup {

    private SheepDogIssueProposal findProposal(HashMap<String, String> keyMap) {
        @SuppressWarnings("unchecked")
        ArrayList<SheepDogIssueProposal> proposals = (ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup");

        if (proposals == null) {
            return null;
        }

        // Try to match by ID first
        String expectedId = keyMap.get("Proposal Id");
        if (expectedId != null) {
            for (SheepDogIssueProposal proposal : proposals) {
                if (expectedId.equals(proposal.getId())) {
                    return proposal;
                }
            }
        }

        // Try to match by Value
        String expectedValue = keyMap.get("Proposal Value");
        if (expectedValue != null) {
            for (SheepDogIssueProposal proposal : proposals) {
                if (expectedValue.equals(proposal.getValue().toString())) {
                    return proposal;
                }
            }
        }

        return null;
    }

    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        return null;
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        SheepDogIssueProposal proposal = findProposal(keyMap);
        return proposal != null ? proposal.getValue().toString() : "";
    }

    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        SheepDogIssueProposal proposal = findProposal(keyMap);
        return proposal != null ? proposal.getId() : "";
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        SheepDogIssueProposal proposal = findProposal(keyMap);
        return proposal != null ? proposal.getDescription() : "";
    }

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        @SuppressWarnings("unchecked")
        ArrayList<SheepDogIssueProposal> proposals = (ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup");
        return (proposals == null || proposals.isEmpty()) ? "true" : "false";
    }
}
