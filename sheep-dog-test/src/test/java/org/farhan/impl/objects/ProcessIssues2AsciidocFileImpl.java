package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestObjectIDE;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssues2AsciidocFileImpl extends TestObjectIDE implements ProcessIssues2AsciidocFile {

    @Override
    public void assertTestSuiteName(HashMap<String, String> keyMap) {
        assertTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
    }
}
