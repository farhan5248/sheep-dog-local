package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Input2FileAsciidocFileImpl extends TestObjectSheepDogImpl implements Input2FileAsciidocFile {

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
        return null;
    }

    @Override
    public String getStepObjectName(HashMap<String, String> keyMap) {
        IStepObject doc = (IStepObject) getProperty("cursor");
        return doc.getName();
    }

}
