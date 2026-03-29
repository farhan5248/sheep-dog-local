package org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication;

import java.util.HashMap;

public interface ObjectPageAsciidocFile {

    public String getHeaderSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getHeaderSectionName(HashMap<String, String> keyMap);

    public String getHeaderSectionStatements(HashMap<String, String> keyMap);

    public String getStepDefinitionParametersTableSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getStepDefinitionParametersTableSectionName(HashMap<String, String> keyMap);

    public String getStepDefinitionParametersTableSectionParameters(HashMap<String, String> keyMap);

    public String getStepDefinitionParametersTableSectionRow(HashMap<String, String> keyMap);

    public String getStepDefinitionSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getStepDefinitionSectionName(HashMap<String, String> keyMap);

    public String getStepDefinitionSectionDescription(HashMap<String, String> keyMap);

    public void setCreatedAsFollows(HashMap<String, String> keyMap);

    public void setContent(HashMap<String, String> keyMap);

    public void setDeleted(HashMap<String, String> keyMap);

    public String getCreatedAsFollows(HashMap<String, String> keyMap);

    public String getContent(HashMap<String, String> keyMap);

    public String getPresent(HashMap<String, String> keyMap);
}
