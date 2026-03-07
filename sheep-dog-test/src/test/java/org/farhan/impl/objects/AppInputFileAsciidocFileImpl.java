package org.farhan.impl.objects;

import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AppInputFileAsciidocFileImpl extends TestIDEObject implements InputFileAsciidocFile {

    @Override
    public void setTestDocumentListNodeNodePath(HashMap<String, String> keyMap) {
        createStepDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setTestDocumentListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setTestDocumentListNodeStepObjectFullName(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(replaceKeyword(keyMap.get("Step Object Full Name")));
    }

}
