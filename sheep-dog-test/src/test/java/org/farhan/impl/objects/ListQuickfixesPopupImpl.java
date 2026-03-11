package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesPopup;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesPopupImpl extends TestObjectPopupImpl implements ListQuickfixesPopup {

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        return listToString(listQuickfixesDialog);
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return p.getValue().toString();
            }
        }
        return null;
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getDescription().contentEquals(replaceKeyword(keyMap.get("Proposal Description")))) {
                return p.getDescription();
            }
        }
        return null;
    }

    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return p.getId();
            }
        }
        return null;
    }

    @Override
    public void setProposalId(HashMap<String, String> keyMap) {
        listQuickfixesDialog.add(new SheepDogIssueProposal());
        listQuickfixesDialog.getLast().setId(keyMap.get("Proposal Id"));
    }

    @Override
    public void setProposalDescription(HashMap<String, String> keyMap) {
        listQuickfixesDialog.getLast().setDescription(keyMap.get("Proposal Description"));
    }

    @Override
    public void setProposalValue(HashMap<String, String> keyMap) {
        listQuickfixesDialog.getLast().setValue(keyMap.get("Proposal Value"));
    }

    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        return listToString(listQuickfixesDialog);
    }

    @Override
    public void setSetAsFollows(HashMap<String, String> keyMap) {
    }

}
