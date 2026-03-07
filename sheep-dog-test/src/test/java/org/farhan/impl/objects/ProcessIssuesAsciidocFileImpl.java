package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssuesAsciidocFileImpl extends TestIDEObject implements ProcessIssuesAsciidocFile {

    @Override
    public void assertCellListNodeCellName(HashMap<String, String> keyMap) {
        assertCellName(replaceKeyword(keyMap.get("Cell Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertCellListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertDescriptionNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertDescriptionEmpty("true");
        }
    }

    @Override
    public void assertLineListNodeLineContent(HashMap<String, String> keyMap) {
        assertLineContent(replaceKeyword(keyMap.get("Line Content")), keyMap.get("Node Path"));
    }

    @Override
    public void assertLineListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertNestedDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertNestedDescriptionNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertNestedDescriptionEmpty("true");
        }
    }

    @Override
    public void assertRowListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertRowListNodeRowContent(HashMap<String, String> keyMap) {
        assertRowContent(replaceKeyword(keyMap.get("Row Content")));
    }

    @Override
    public void assertTableNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertTableNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertTableAbsent();
        } else if (keyMap.get("State").contentEquals("Present")) {
            assertTablePresent();
        }
    }

    @Override
    public void assertTestDataListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));

    }

    @Override
    public void assertTestDataListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertTestDataListEmpty("true");
        }
    }

    @Override
    public void assertTestDataListNodeTestDataName(HashMap<String, String> keyMap) {
        assertTestDataName(replaceKeyword(keyMap.get("Test Data Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeTestSuiteFullName(HashMap<String, String> keyMap) {
        assertTestSuiteFullName(replaceKeyword(keyMap.get("Test Suite Full Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeTestSuiteName(HashMap<String, String> keyMap) {
        assertTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void assertTestStepContainerListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertTestStepContainerListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertTestStepContainerListEmpty("true");
        }
    }

    @Override
    public void assertTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        assertTestStepContainerName(replaceKeyword(keyMap.get("Test Case Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        assertTestStepContainerName(replaceKeyword(keyMap.get("Test Setup Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertTestStepListNodeAndFullName(HashMap<String, String> keyMap) {
        assertTestStepFullName(replaceKeyword(keyMap.get("And Full Name")));
    }

    @Override
    public void assertTestStepListNodeAndStepDefinitionRefName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("And StepDefinitionRef Name")));
    }

    @Override
    public void assertTestStepListNodeAndStepObjectRefName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("And StepObjectRef Name")));
    }

    @Override
    public void assertTestStepListNodeGivenFullName(HashMap<String, String> keyMap) {
        assertTestStepFullName(replaceKeyword(keyMap.get("Given Full Name")));
    }

    @Override
    public void assertTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("Given StepDefinitionRef Name")));
    }

    @Override
    public void assertTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("Given StepObjectRef Name")));
    }

    @Override
    public void assertTestStepListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));

    }

    @Override
    public void assertTestStepListNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertTestStepListEmpty("true");
        }
    }

    @Override
    public void assertTestStepListNodeThenFullName(HashMap<String, String> keyMap) {
        assertTestStepFullName(replaceKeyword(keyMap.get("Then Full Name")));
    }

    @Override
    public void assertTestStepListNodeThenStepDefinitionRefName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("Then StepDefinitionRef Name")));
    }

    @Override
    public void assertTestStepListNodeThenStepObjectRefName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("Then StepObjectRef Name")));
    }

    @Override
    public void assertTestStepListNodeWhenFullName(HashMap<String, String> keyMap) {
        assertTestStepFullName(replaceKeyword(keyMap.get("When Full Name")));
    }

    @Override
    public void assertTestStepListNodeWhenStepDefinitionRefName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("When StepDefinitionRef Name")));
    }

    @Override
    public void assertTestStepListNodeWhenStepObjectRefName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("When StepObjectRef Name")));
    }

    @Override
    public void assertTextNodeNodePath(HashMap<String, String> keyMap) {
        String path = keyMap.get("Node Path");
        String parentPath = path.substring(0, path.lastIndexOf("/"));
        setCursor(parentPath);
    }

    @Override
    public void assertTextNodeState(HashMap<String, String> keyMap) {
        if (keyMap.get("State").contentEquals("Absent")) {
            assertTextAbsent();
        } else if (keyMap.get("State").contentEquals("Present")) {
            assertTextPresent();
        }
    }

    @Override
    public void setCellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void setLineListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setRowListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setRowListNodeRowContent(HashMap<String, String> keyMap) {
        addRowWithContent(keyMap.get("Row Content"));
    }

    @Override
    public void setTableNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestDataListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestDataListNodeTestDataName(HashMap<String, String> keyMap) {
        addTestDataWithName(replaceKeyword(keyMap.get("Test Data Name")));
    }

    @Override
    public void setTestDocumentListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestDocumentListNodeTestSuiteFullName(HashMap<String, String> keyMap) {
        addTestSuiteWithFullName(replaceKeyword(keyMap.get("Test Suite Full Name")));
    }

    @Override
    public void setTestDocumentListNodeTestSuiteName(HashMap<String, String> keyMap) {
        setTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public void setTestStepContainerListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestStepContainerListNodeTestCaseName(HashMap<String, String> keyMap) {
        addTestCaseWithName(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setTestStepContainerListNodeTestSetupName(HashMap<String, String> keyMap) {
        addTestSetupWithName(replaceKeyword(keyMap.get("Test Setup Name")));
    }

    @Override
    public void setTestStepListNodeAndStepDefinitionRefName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("And StepDefinitionRef Name")));
    }

    @Override
    public void setTestStepListNodeAndStepObjectRefName(HashMap<String, String> keyMap) {
        addAndWithStepObjectName(replaceKeyword(keyMap.get("And StepObjectRef Name")));
    }

    @Override
    public void setTestStepListNodeGivenStepDefinitionRefName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("Given StepDefinitionRef Name")));
    }

    @Override
    public void setTestStepListNodeGivenStepObjectRefName(HashMap<String, String> keyMap) {
        addGivenWithStepObjectName(replaceKeyword(keyMap.get("Given StepObjectRef Name")));
    }

    @Override
    public void setTestStepListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestStepListNodeTestStepFullName(HashMap<String, String> keyMap) {
        addTestStepWithFullName(replaceKeyword(keyMap.get("Test Step Full Name")));
    }

    @Override
    public void setTestStepListNodeThenStepDefinitionRefName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("Then StepDefinitionRef Name")));
    }

    @Override
    public void setTestStepListNodeThenStepObjectRefName(HashMap<String, String> keyMap) {
        addThenWithStepObjectName(replaceKeyword(keyMap.get("Then StepObjectRef Name")));
    }

    @Override
    public void setTestStepListNodeWhenStepDefinitionRefName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("When StepDefinitionRef Name")));
    }

    @Override
    public void setTestStepListNodeWhenStepObjectRefName(HashMap<String, String> keyMap) {
        addWhenWithStepObjectName(replaceKeyword(keyMap.get("When StepObjectRef Name")));
    }

    @Override
    public void setTextNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTextNodeTextContent(HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
    }

}
