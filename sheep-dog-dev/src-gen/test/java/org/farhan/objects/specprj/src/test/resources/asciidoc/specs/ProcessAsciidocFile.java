package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface ProcessAsciidocFile {

    public String getBackgroundStepsSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getBackgroundStepsSectionName(HashMap<String, String> keyMap);

    public String getBackgroundStepsSectionStep(HashMap<String, String> keyMap);

    public String getBackgroundSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getBackgroundSectionName(HashMap<String, String> keyMap);

    public String getBackgroundSectionDescription(HashMap<String, String> keyMap);

    public String getFeatureSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getFeatureSectionName(HashMap<String, String> keyMap);

    public String getFeatureSectionStatements(HashMap<String, String> keyMap);

    public String getScenarioOutlineExamplesTableSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getScenarioOutlineExamplesTableSectionName(HashMap<String, String> keyMap);

    public String getScenarioOutlineExamplesTableSectionExamples(HashMap<String, String> keyMap);

    public String getScenarioOutlineExamplesTableSectionTags(HashMap<String, String> keyMap);

    public String getScenarioOutlineExamplesTableSectionDescription(HashMap<String, String> keyMap);

    public String getScenarioOutlineExamplesTableSectionRow(HashMap<String, String> keyMap);

    public String getScenariosStepsDocStringSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getScenariosStepsDocStringSectionName(HashMap<String, String> keyMap);

    public String getScenariosStepsDocStringSectionStep(HashMap<String, String> keyMap);

    public String getScenariosStepsDocStringSectionContent(HashMap<String, String> keyMap);

    public String getScenariosStepsStepTableSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getScenariosStepsStepTableSectionName(HashMap<String, String> keyMap);

    public String getScenariosStepsStepTableSectionStep(HashMap<String, String> keyMap);

    public String getScenariosStepsStepTableSectionRow(HashMap<String, String> keyMap);

    public String getScenariosStepsSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getScenariosStepsSectionName(HashMap<String, String> keyMap);

    public String getScenariosStepsSectionStep(HashMap<String, String> keyMap);

    public String getScenariosSectionCreatedAsFollows(HashMap<String, String> keyMap);

    public String getScenariosSectionName(HashMap<String, String> keyMap);

    public String getScenariosSectionTags(HashMap<String, String> keyMap);

    public String getScenariosSectionDescription(HashMap<String, String> keyMap);

    public void setCreatedAsFollows(HashMap<String, String> keyMap);

    public void setContent(HashMap<String, String> keyMap);

    public void setDeleted(HashMap<String, String> keyMap);

    public String getPresent(HashMap<String, String> keyMap);
}
