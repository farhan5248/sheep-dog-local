package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestObjectFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Input2FileAsciidocFileImpl extends TestObjectFile implements Input2FileAsciidocFile {

    @Override
    public String getStepObjectName(HashMap<String, String> keyMap) {
        return assertStepObjectName(replaceKeyword(keyMap.get("Step Object Name")));
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        cursor = testProject.getTestDocument(getFullNameFromPath());
        return cursor == null ? null : cursor.toString();
    }
}
