package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesPopup;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesPopupImpl extends TestObjectSheepDogImpl implements ListQuickfixesPopup {

    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        return listToString(getListQuickfixesDialog());
    }

    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        SheepDogIssueProposal p = findProposalById(keyMap.get("Proposal Id"));
        return p == null ? null : p.getId();
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        SheepDogIssueProposal p = findProposalById(keyMap.get("Proposal Id"));
        return p == null ? null : p.getDescription();
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        SheepDogIssueProposal p = findProposalById(keyMap.get("Proposal Id"));
        return p == null ? null : p.getValue().toString();
    }

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        return listToString(getListQuickfixesDialog());
    }

    @SuppressWarnings("unchecked")
    private ArrayList<SheepDogIssueProposal> getListQuickfixesDialog() {
        return (ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup");
    }

    @SuppressWarnings("unchecked")
    private SheepDogIssueProposal findProposalById(String proposalId) {
        ArrayList<SheepDogIssueProposal> dialog = (ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup");
        for (SheepDogIssueProposal proposal : dialog) {
            if (proposal.getId().equals(proposalId)) {
                return proposal;
            }
        }
        return null;
    }
}
