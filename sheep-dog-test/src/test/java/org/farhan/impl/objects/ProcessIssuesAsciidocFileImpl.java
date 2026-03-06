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
    public void assertLineListNodeLineContent(HashMap<String, String> keyMap) {
        assertLineContent(replaceKeyword(keyMap.get("Line Content")), keyMap.get("Node Path"));
    }

    @Override
    public void assertLineListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
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
    public void assertTestStepListNodeAndStepDefinitionName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("And StepDefinition Name")));
    }

    @Override
    public void assertTestStepListNodeAndStepObjectName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("And StepObject Name")));
    }

    @Override
    public void assertTestStepListNodeGivenStepDefinitionName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("Given StepDefinition Name")));
    }

    @Override
    public void assertTestStepListNodeGivenStepObjectName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("Given StepObject Name")));
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
    public void assertTestStepListNodeThenStepDefinitionName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("Then StepDefinition Name")));
    }

    @Override
    public void assertTestStepListNodeThenStepObjectName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("Then StepObject Name")));
    }

    @Override
    public void assertTestStepListNodeWhenStepDefinitionName(HashMap<String, String> keyMap) {
        assertTestStepStepDefinitionName(replaceKeyword(keyMap.get("When StepDefinition Name")));
    }

    @Override
    public void assertTestStepListNodeWhenStepObjectName(HashMap<String, String> keyMap) {
        assertTestStepStepObjectName(replaceKeyword(keyMap.get("When StepObject Name")));
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
    public void setTestStepListNodeAndStepDefinitionName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("And StepDefinition Name")));
    }

    @Override
    public void setTestStepListNodeAndStepObjectName(HashMap<String, String> keyMap) {
        addAndWithStepObjectName(replaceKeyword(keyMap.get("And StepObject Name")));
    }

    @Override
    public void setTestStepListNodeGivenStepDefinitionName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("Given StepDefinition Name")));
    }

    @Override
    public void setTestStepListNodeGivenStepObjectName(HashMap<String, String> keyMap) {
        addGivenWithStepObjectName(replaceKeyword(keyMap.get("Given StepObject Name")));
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
    public void setTestStepListNodeThenStepDefinitionName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("Then StepDefinition Name")));
    }

    @Override
    public void setTestStepListNodeThenStepObjectName(HashMap<String, String> keyMap) {
        addThenWithStepObjectName(replaceKeyword(keyMap.get("Then StepObject Name")));
    }

    @Override
    public void setTestStepListNodeWhenStepDefinitionName(HashMap<String, String> keyMap) {
        setTestStepDefinitionName(replaceKeyword(keyMap.get("When StepDefinition Name")));
    }

    @Override
    public void setTestStepListNodeWhenStepObjectName(HashMap<String, String> keyMap) {
        addWhenWithStepObjectName(replaceKeyword(keyMap.get("When StepObject Name")));
    }

    @Override
    public void setTableNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
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
    public void setTextNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTextNodeTextContent(HashMap<String, String> keyMap) {
        addTextWithContent(keyMap.get("Text Content"));
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

}
