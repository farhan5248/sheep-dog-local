package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssues2AsciidocFileImpl extends TestIDEObject implements ProcessIssues2AsciidocFile {

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
}
