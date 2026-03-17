package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObjectSheepDogImpl implements ListProposalsAction {

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
        properties.remove("Test Suite Full Name");
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStep) {
            ((ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup")).addAll(TestStepIssueResolver.suggestStepObjectNameOnly((ITestStep) cursor));
        }
    }
}
