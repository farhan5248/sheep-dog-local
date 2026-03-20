package org.farhan.impl;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesPopup;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesPopupImpl extends TestObjectSheepDogImpl implements ListQuickfixesPopup {

    @SuppressWarnings("unchecked")
    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        return listToCsvString(((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")));
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return p.getId();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))) {
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
        for (SheepDogIssueProposal p : ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return p.getValue().toString();
            }
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        return listToCsvString(((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")));
    }

    @Override
    public void setSetAsFollows(HashMap<String, String> keyMap) {
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setProposalId(HashMap<String, String> keyMap) {
        ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).add(new SheepDogIssueProposal());
        ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).getLast().setId(keyMap.get("Proposal Id"));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setProposalDescription(HashMap<String, String> keyMap) {
        ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).getLast().setDescription(keyMap.get("Proposal Description"));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setProposalValue(HashMap<String, String> keyMap) {
        ((ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).getLast().setValue(keyMap.get("Proposal Value"));
    }
}
