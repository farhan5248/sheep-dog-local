package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesPopup;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesPopupImpl extends TestObjectSheepDogImpl implements ListQuickfixesPopup {

    @Override
    public String getEmpty(HashMap<String, String> keyMap) {
        return listToString(((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")));
    }

    @Override
    public String getProposalValue(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return p.getValue().toString();
            }
        }
        return null;
    }

    @Override
    public String getProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getDescription().contentEquals(replaceKeyword(keyMap.get("Proposal Description")))) {
                return p.getDescription();
            }
        }
        return null;
    }

    @Override
    public String getProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup"))) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return p.getId();
            }
        }
        return null;
    }

    @Override
    public void setProposalId(HashMap<String, String> keyMap) {
        ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).add(new SheepDogIssueProposal());
        ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).getLast().setId(keyMap.get("Proposal Id"));
    }

    @Override
    public void setProposalDescription(HashMap<String, String> keyMap) {
        ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).getLast().setDescription(keyMap.get("Proposal Description"));
    }

    @Override
    public void setProposalValue(HashMap<String, String> keyMap) {
        ((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")).getLast().setValue(keyMap.get("Proposal Value"));
    }

    @Override
    public String getSetAsFollows(HashMap<String, String> keyMap) {
        return listToString(((java.util.ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup")));
    }

    @Override
    public void setSetAsFollows(HashMap<String, String> keyMap) {
    }

}
