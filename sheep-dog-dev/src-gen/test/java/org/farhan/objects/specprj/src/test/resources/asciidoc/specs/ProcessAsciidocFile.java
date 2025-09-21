package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface ProcessAsciidocFile {

    public void assertBackgroundSectionDescription(HashMap<String, String> keyMap);

    public void assertBackgroundSectionName(HashMap<String, String> keyMap);

    public void assertBackgroundStepsSectionName(HashMap<String, String> keyMap);

    public void assertBackgroundStepsSectionStep(HashMap<String, String> keyMap);

    public void assertFeatureSectionName(HashMap<String, String> keyMap);

    public void assertFeatureSectionStatements(HashMap<String, String> keyMap);

    public void assertPresent(HashMap<String, String> keyMap);

    public void assertScenarioOutlineExamplesTableSectionDescription(HashMap<String, String> keyMap);

    public void assertScenarioOutlineExamplesTableSectionExamples(HashMap<String, String> keyMap);

    public void assertScenarioOutlineExamplesTableSectionName(HashMap<String, String> keyMap);

    public void assertScenarioOutlineExamplesTableSectionRow(HashMap<String, String> keyMap);

    public void assertScenarioOutlineExamplesTableSectionTags(HashMap<String, String> keyMap);

    public void assertScenariosSectionDescription(HashMap<String, String> keyMap);

    public void assertScenariosSectionName(HashMap<String, String> keyMap);

    public void assertScenariosSectionTags(HashMap<String, String> keyMap);

    public void assertScenariosStepsDocStringSectionContent(HashMap<String, String> keyMap);

    public void assertScenariosStepsDocStringSectionName(HashMap<String, String> keyMap);

    public void assertScenariosStepsDocStringSectionStep(HashMap<String, String> keyMap);

    public void assertScenariosStepsSectionName(HashMap<String, String> keyMap);

    public void assertScenariosStepsSectionStep(HashMap<String, String> keyMap);

    public void assertScenariosStepsStepTableSectionName(HashMap<String, String> keyMap);

    public void assertScenariosStepsStepTableSectionRow(HashMap<String, String> keyMap);

    public void assertScenariosStepsStepTableSectionStep(HashMap<String, String> keyMap);

    public void setContent(HashMap<String, String> keyMap);

    public void setDeleted(HashMap<String, String> keyMap);
}
