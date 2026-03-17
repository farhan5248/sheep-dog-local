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

    @SuppressWarnings("unchecked")
    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        ArrayList<SheepDogIssueProposal> dialog = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
        for (SheepDogIssueProposal proposal : dialog) {
            if (proposal.getId().equals(keyMap.get("Proposal Id"))) {
                return proposal.getValue().toString();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        ArrayList<SheepDogIssueProposal> dialog = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
        for (SheepDogIssueProposal proposal : dialog) {
            if (proposal.getId().equals(keyMap.get("Proposal Id"))) {
                return proposal.getId();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        ArrayList<SheepDogIssueProposal> dialog = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
        for (SheepDogIssueProposal proposal : dialog) {
            if (proposal.getId().equals(keyMap.get("Proposal Id"))) {
                return proposal.getDescription();
            }
        }
        return null;
    }
}
