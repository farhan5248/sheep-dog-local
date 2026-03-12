package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class Input2FileAsciidocFileImpl extends TestObjectSheepDogImpl implements Input2FileAsciidocFile {

    @Override
    public String getStepObjectName(HashMap<String, String> keyMap) {
        return assertStepObjectName(replaceKeyword(keyMap.get("Step Object Name")));
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }
}
