package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.common.TestIDEElement;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Process2AsciidocFileImpl extends TestIDEElement implements Process2AsciidocFile {

    @Override
    public void setBackgroundStepsSnippetStepName(HashMap<String, String> keyMap) {
        addTestSetupStep(replaceKeyword(keyMap.get("Step Name")));
    }

    @Override
    public void setStepsSnippetHeaders(HashMap<String, String> keyMap) {
        addTable();
        addRow();
        for (String h : keyMap.get("Headers").split("\\|")) {
            addCell(h);
        }
    }

    public void setStepsSnippetStepName(HashMap<String, String> keyMap) {
        addTestCaseStep(replaceKeyword(keyMap.get("Step Name")));
    }

    @Override
    public void setStepsSnippetTextContent(HashMap<String, String> keyMap) {
        addText(keyMap.get("Text Content"));
    }

    @Override
    public void setTestCaseName(HashMap<String, String> keyMap) {
        addTestStepContainer(replaceKeyword(keyMap.get("Test Case Name")));
    }

    @Override
    public void setTestSuiteName(HashMap<String, String> keyMap) {
        addTestSuite(replaceKeyword(keyMap.get("Test Suite Name")));
    }

}
