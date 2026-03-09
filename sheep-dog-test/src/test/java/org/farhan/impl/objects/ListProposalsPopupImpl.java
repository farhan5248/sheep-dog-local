package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestObjectIDE;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListProposalsPopup;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsPopupImpl extends TestObjectIDE implements ListProposalsPopup {

    @Override
    public void assertEmpty(HashMap<String, String> keyMap) {
        Assertions.assertTrue(TestObjectIDE.listProposalsDialog.isEmpty());
    }

    @Override
    public void assertProposalValue(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObjectIDE.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(" and value: ").append(keyMap.get("Proposal Value"));
        sb.append(listToString(TestObjectIDE.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObjectIDE.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getDescription().contentEquals(replaceKeyword(keyMap.get("Proposal Description")))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(" and description: ").append(replaceKeyword(keyMap.get("Proposal Description")));
        sb.append(listToString(TestObjectIDE.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestObjectIDE.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(listToString(TestObjectIDE.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertSetAsFollows(HashMap<String, String> keyMap) {
    }

}
