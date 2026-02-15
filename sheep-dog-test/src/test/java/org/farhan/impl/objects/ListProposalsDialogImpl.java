package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEObject;
import org.farhan.dsl.lang.SheepDogIssueProposal;
import org.farhan.objects.xtext.ListProposalsDialog;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsDialogImpl extends TestIDEObject implements ListProposalsDialog {

    @Override
    public void assertEmpty(HashMap<String, String> keyMap) {
        Assertions.assertTrue(TestIDEObject.listProposalsDialog.isEmpty());
    }

    @Override
    public void assertSuggestion(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEObject.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Suggestion Name"))
                    && p.getValue().toString().contentEquals(keyMap.get("Suggestion"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Suggestion Name"));
        sb.append(" and value: ").append(keyMap.get("Suggestion"));
        sb.append(listToString(TestIDEObject.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertSuggestionDescription(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEObject.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Suggestion Name"))
                    && p.getDescription().contentEquals(replaceKeyword(keyMap.get("Suggestion Description")))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Suggestion Name"));
        sb.append(" and description: ").append(replaceKeyword(keyMap.get("Suggestion Description")));
        sb.append(listToString(TestIDEObject.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

    @Override
    public void assertSuggestionName(HashMap<String, String> keyMap) {
        for (SheepDogIssueProposal p : TestIDEObject.listProposalsDialog) {
            if (p.getId().equals(keyMap.get("Suggestion Name"))) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("No proposal found with ID that matches the name: ").append(keyMap.get("Suggestion Name"));
        sb.append(listToString(TestIDEObject.listProposalsDialog));
        Assertions.fail(sb.toString());
    }

}
