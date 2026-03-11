package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class AppInputFileAsciidocFileImpl extends TestObjectFileImpl implements InputFileAsciidocFile {

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

}
