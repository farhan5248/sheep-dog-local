package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListProposalsPopup;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsPopupImpl extends TestObjectPopupImpl implements ListProposalsPopup {

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        return listToString(listProposalsDialog);
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return p.getValue().toString();
            }
        }
        return null;
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getDescription().contentEquals(replaceKeyword(keyMap.get("Proposal Description")))) {
                return p.getDescription();
            }
        }
        return null;
    }

    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return p.getId();
            }
        }
        return null;
    }

    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        return listToString(listProposalsDialog);
    }

}
