package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Input2FileAsciidocFileImpl extends TestIDEObject implements Input2FileAsciidocFile {

    @Override
    public void assertTestDocumentListNodeNodePath(HashMap<String, String> keyMap) {
        setCursor(keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeStepObjectFullName(HashMap<String, String> keyMap) {
        assertStepObjectFullName(replaceKeyword(keyMap.get("Step Object Full Name")), keyMap.get("Node Path"));
    }

    @Override
    public void assertTestDocumentListNodeStepObjectName(HashMap<String, String> keyMap) {
        assertStepObjectName(replaceKeyword(keyMap.get("Step Object Name")));
    }
}
