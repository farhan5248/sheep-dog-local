package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.issues.CellIssueResolver;
import org.farhan.dsl.issues.CellIssueTypes;
import org.farhan.dsl.issues.TestStepContainerIssueResolver;
import org.farhan.dsl.issues.TestStepContainerIssueTypes;
import org.farhan.dsl.issues.TestSuiteIssueResolver;
import org.farhan.dsl.issues.TestSuiteIssueTypes;
import org.farhan.objects.xtext.ListQuickfixesAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListQuickfixesActionImpl extends TestObjectSheepDogImpl implements ListQuickfixesAction {

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
        String validateContent = getProperty("validate annotation.Content").toString();
        ArrayList<SheepDogIssueProposal> list = (ArrayList<SheepDogIssueProposal>) getProperty("list quickfixes popup");
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestSuite) {
            ITestSuite testSuite = (ITestSuite) cursor;
            if (validateContent.contentEquals(TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description)) {
                list.addAll(TestSuiteIssueResolver.correctNameOnly(testSuite));
            }
        } else if (cursor instanceof ITestStepContainer) {
            ITestStepContainer testStepContainer = (ITestStepContainer) cursor;
            if (validateContent.contentEquals(TestStepContainerIssueTypes.TEST_STEP_CONTAINER_NAME_ONLY.description)) {
                list.addAll(TestStepContainerIssueResolver.correctNameOnly(testStepContainer));
            }
        } else if (cursor instanceof ICell) {
            ICell cell = (ICell) cursor;
            if (validateContent.contentEquals(CellIssueTypes.CELL_NAME_ONLY.description)) {
                list.addAll(CellIssueResolver.correctNameOnly(cell));
            }
        }
    }
}
