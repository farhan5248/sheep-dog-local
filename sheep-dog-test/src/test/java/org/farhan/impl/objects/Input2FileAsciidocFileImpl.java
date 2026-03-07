package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestObjectIDE;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Input2FileAsciidocFileImpl extends TestObjectIDE implements Input2FileAsciidocFile {

    @Override
    public void assertStepObjectName(HashMap<String, String> keyMap) {
        assertStepObjectName(replaceKeyword(keyMap.get("Step Object Name")));
    }
}
