package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEElement;
import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListProposalsDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsDialogImpl extends TestIDEElement implements ListProposalsDialog {

    @Override
    public void assertEmpty(HashMap<String, String> keyMap) {
        Assertions.assertTrue(TestIDEElement.listProposalsDialog.isEmpty());
    }

    @Override
    public void assertSuggestion(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEElement.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Suggestion Name"))
                    && p.getValue().contentEquals(keyMap.get("Suggestion"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Suggestion Name"));
        sb.append(" and value: ").append(keyMap.get("Suggestion"));
        sb.append(listToString(TestIDEElement.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertSuggestionDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEElement.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Suggestion Name"))
                    && p.getDescription().contentEquals(keyMap.get("Suggestion Description"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Suggestion Name"));
        sb.append(" and description: ").append(keyMap.get("Suggestion Description"));
        sb.append(listToString(TestIDEElement.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertSuggestionName(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEElement.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Suggestion Name"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Suggestion Name"));
        sb.append(listToString(TestIDEElement.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

}
