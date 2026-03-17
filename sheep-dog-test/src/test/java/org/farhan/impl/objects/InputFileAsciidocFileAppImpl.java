package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileAppImpl extends TestObjectSheepDogImpl implements InputFileAsciidocFile {

    @Override
    public void setCreatedAsFollows(HashMap<String, String> keyMap) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument(getFullNameFromPath());
        if (doc == null) {
            addStepObjectWithFullName(getFullNameFromPath());
        } else {
            setProperty("cursor", doc);
        }
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(keyMap.get("Step Definition Name"));
    }
}
