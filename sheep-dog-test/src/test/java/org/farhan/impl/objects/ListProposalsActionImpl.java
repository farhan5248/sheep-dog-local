package org.farhan.impl.objects;

import java.util.ArrayList;
import java.util.HashMap;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.TestStepIssueResolver;
import org.farhan.objects.xtext.ListProposalsAction;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ListProposalsActionImpl extends TestObjectSheepDogImpl implements ListProposalsAction {

    private void navigateToDocument() {
        if (getProperty("Test Suite Full Name") != null) {
            setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(replaceKeyword(getProperty("Test Suite Full Name").toString())));
            properties.remove("Test Suite Full Name");
        }
    }

    private void navigateToNode() {
        if (getProperty("Node Path") != null) {
            setCursorAtNode(getProperty("Node Path").toString());
            properties.remove("Node Path");
        }
    }

    @Override
    public void setTestSuiteFullName(HashMap<String, String> keyMap) {
        setProperty("Test Suite Full Name", keyMap.get("Test Suite Full Name"));
    }

    @Override
    public void setNodePath(HashMap<String, String> keyMap) {
        setProperty("Node Path", keyMap.get("Node Path"));
    }

    @Override
    public void setPerformedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        navigateToNode();

        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestStep) {
            ITestStep testStep = (ITestStep) cursor;
            ITestProject workspace = (ITestProject) getProperty("workspace");

            // Check if test step has both component and object AND the step object file exists
            String fullName = testStep.getFullName();
            boolean shouldSuggestDefinitions = false;

            if (fullName != null && !fullName.trim().isEmpty() && !fullName.equals("empty")) {
                // Use StepObjectRefFragments to check if we have both component and object
                String component = org.farhan.dsl.grammar.StepObjectRefFragments.getComponent(fullName);
                String object = org.farhan.dsl.grammar.StepObjectRefFragments.getObject(fullName);

                if (!component.isEmpty() && !object.isEmpty()) {
                    // Check if the step object file exists in the workspace
                    String stepObjectPath = "stepdefs/" + component + "/" + object + ".asciidoc";
                    for (ITestDocument doc : workspace.getTestDocumentList()) {
                        if (doc instanceof IStepObject) {
                            if (doc.getFullName().equals(stepObjectPath)) {
                                shouldSuggestDefinitions = true;
                                break;
                            }
                        }
                    }
                }
            }

            ArrayList<SheepDogIssueProposal> proposals;
            if (shouldSuggestDefinitions) {
                // Suggest step definitions for test steps with full object names
                proposals = TestStepIssueResolver.suggestStepDefinitionsWorkspace(testStep, workspace);
            } else {
                // Suggest step objects for test steps without full object names
                proposals = TestStepIssueResolver.suggestStepObjectNameWorkspace(testStep, workspace);
            }
            setProperty("list proposals popup", proposals);
        } else if (cursor instanceof IRow) {
            IRow row = (IRow) cursor;
            ITestProject workspace = (ITestProject) getProperty("workspace");
            ArrayList<SheepDogIssueProposal> proposals = TestStepIssueResolver.suggestStepParametersWorkspace(row, workspace);
            setProperty("list proposals popup", proposals);
        }
    }
}
