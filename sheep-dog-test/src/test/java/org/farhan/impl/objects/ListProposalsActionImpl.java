package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.issues.TestStepIssueResolver;
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

    @Override
    @SuppressWarnings("unchecked")
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
        ArrayList<SheepDogIssueProposal> list = (ArrayList<SheepDogIssueProposal>) getProperty("list proposals popup");
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
            if (!stepObjectFullName.isEmpty()) {
                list.addAll(TestStepIssueResolver.suggestStepDefinitionNameTestCase(testStep));
            } else {
                list.addAll(TestStepIssueResolver.suggestStepObjectNameTestCase(testStep));
            }
        } else if (cursor instanceof IRow) {
            ITestStep testStep = SheepDogUtility.getTestStepParentForRow((IRow) cursor);
            if (testStep != null) {
                list.addAll(TestStepIssueResolver.suggestStepParametersForTestCase(testStep));
            }
        }
    }
}
