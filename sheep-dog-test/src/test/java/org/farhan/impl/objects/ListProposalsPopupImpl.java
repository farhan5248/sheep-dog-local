package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListProposalsPopup;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsPopupImpl extends TestObjectSheepDogImpl implements ListProposalsPopup {

    @SuppressWarnings("unchecked")
    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        ArrayList<SheepDogIssueProposal> dialog = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
        return listToString(dialog);
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        SheepDogIssueProposal p = findProposalById(keyMap.get("Proposal Id"));
        return p == null ? null : p.getValue().toString();
    }

    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        SheepDogIssueProposal p = findProposalById(keyMap.get("Proposal Id"));
        return p == null ? null : p.getId();
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        return listToString(((ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup")));
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        SheepDogIssueProposal p = findProposalById(keyMap.get("Proposal Id"));
        return p == null ? null : p.getDescription();
    }

    @SuppressWarnings("unchecked")
    private SheepDogIssueProposal findProposalById(String proposalId) {
        ArrayList<SheepDogIssueProposal> dialog = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
        for (SheepDogIssueProposal proposal : dialog) {
            if (proposal.getId().equals(proposalId)) {
                return proposal;
            }
        }
        return null;
    }
}
