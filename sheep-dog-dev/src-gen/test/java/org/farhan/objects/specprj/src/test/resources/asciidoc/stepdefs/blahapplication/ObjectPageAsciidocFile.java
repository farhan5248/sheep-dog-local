package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication;

import java.util.HashMap;

public interface ObjectPageAsciidocFile {

    public void assertHeaderSectionName(HashMap<String, String> keyMap);

    public void assertHeaderSectionStatements(HashMap<String, String> keyMap);

    public void assertStepDefinitionParametersTableSectionName(HashMap<String, String> keyMap);

    public void assertStepDefinitionParametersTableSectionParameters(HashMap<String, String> keyMap);

    public void assertStepDefinitionParametersTableSectionRow(HashMap<String, String> keyMap);

    public void assertStepDefinitionSectionName(HashMap<String, String> keyMap);

    public void assertStepDefinitionSectionDescription(HashMap<String, String> keyMap);

    public void setContent(HashMap<String, String> keyMap);

    public void setDeleted(HashMap<String, String> keyMap);

    public void assertContent(HashMap<String, String> keyMap);

    public void assertPresent(HashMap<String, String> keyMap);
}
