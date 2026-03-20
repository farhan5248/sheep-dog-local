package org.farhan.impl;

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
        return listToCsvString(((ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup")));
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : ((ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup"))) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return p.getId();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : ((ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup"))) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getDescription().equals(replaceKeyword(keyMap.get("Proposal Description")))) {
                return p.getDescription();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : ((ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup"))) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return p.getValue().toString();
            }
        }
        return null;
    }
}
