package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IStepObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;

public class Input2FileAsciidocFileImpl extends TestObjectSheepDogImpl implements Input2FileAsciidocFile {

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getStepObjectName(HashMap<String, String> keyMap) {
        return ((IStepObject) getProperty("cursor")).getName();
    }

}
