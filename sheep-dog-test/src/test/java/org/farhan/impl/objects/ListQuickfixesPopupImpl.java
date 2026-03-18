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
        return p == null ? "is absent" : p.getId();
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        SheepDogIssueProposal p = findProposalById(keyMap.get("Proposal Id"));
        return p == null ? "" : p.getDescription();
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        SheepDogIssueProposal p = findProposalById(keyMap.get("Proposal Id"));
        return p == null ? "is absent" : p.getValue().toString();
    }

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        return listToString(getListQuickfixesDialog());
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setSetAsFollows(HashMap<String, String> keyMap) {
        setProperty("list quickfixes popup", new ArrayList<SheepDogIssueProposal>());
    }

    @Override
    public void setProposalId(HashMap<String, String> keyMap) {
        SheepDogIssueProposal proposal = getOrCreateCurrentProposal();
        proposal.setId(keyMap.get("Proposal Id"));
    }

    @Override
    public void setProposalDescription(HashMap<String, String> keyMap) {
        SheepDogIssueProposal proposal = getOrCreateCurrentProposal();
        proposal.setDescription(keyMap.get("Proposal Description"));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setProposalValue(HashMap<String, String> keyMap) {
        SheepDogIssueProposal proposal = getOrCreateCurrentProposal();
        proposal.setValue(keyMap.get("Proposal Value"));
        ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).add(proposal);
        setProperty("currentProposal", null);
    }

    private SheepDogIssueProposal getOrCreateCurrentProposal() {
        SheepDogIssueProposal proposal = (SheepDogIssueProposal) getProperty("currentProposal");
        if (proposal == null) {
            proposal = new SheepDogIssueProposal();
            setProperty("currentProposal", proposal);
        }
        return proposal;
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
