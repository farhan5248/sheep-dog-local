package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssues2AsciidocFileImpl extends TestObjectSheepDogImpl implements ProcessIssues2AsciidocFile {

    @Override
    public String getTestSuiteName(HashMap<String, String> keyMap) {
        return assertTestSuiteName(replaceKeyword(keyMap.get("Test Suite Name")));
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }
}
