package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListQuickfixesPopup;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesPopupImpl extends TestIDEObject implements ListQuickfixesPopup {

    @Override
    public void assertEmpty(HashMap<String, String> keyMap) {
        Assertions.assertTrue(TestIDEObject.listQuickfixesDialog.isEmpty());
    }

    @Override
    public void assertProposalValue(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEObject.listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getValue().toString().contentEquals(keyMap.get("Proposal Value"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(" and value: ").append(keyMap.get("Proposal Value"));
        sb.append(listToString(TestIDEObject.listQuickfixesDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertProposalDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEObject.listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))
                    && p.getDescription().contentEquals(replaceKeyword(keyMap.get("Proposal Description")))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(" and description: ").append(keyMap.get("Proposal Description"));
        sb.append(listToString(TestIDEObject.listQuickfixesDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertProposalId(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEObject.listQuickfixesDialog) {
            if (p.getId().equals(keyMap.get("Proposal Id"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No quickfix found with ID that matches the name: ").append(keyMap.get("Proposal Id"));
        sb.append(listToString(TestIDEObject.listQuickfixesDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void setProposalId(HashMap<String, String> keyMap) {
        TestIDEObject.listQuickfixesDialog.add(new SheepDogIssueProposal());
        TestIDEObject.listQuickfixesDialog.getLast().setId(keyMap.get("Proposal Id"));
    }

    @Override
    public void setProposalDescription(HashMap<String, String> keyMap) {
        TestIDEObject.listQuickfixesDialog.getLast().setDescription(keyMap.get("Proposal Description"));
    }

    @Override
    public void setProposalValue(HashMap<String, String> keyMap) {
        TestIDEObject.listQuickfixesDialog.getLast().setValue(keyMap.get("Proposal Value"));
    }

}
