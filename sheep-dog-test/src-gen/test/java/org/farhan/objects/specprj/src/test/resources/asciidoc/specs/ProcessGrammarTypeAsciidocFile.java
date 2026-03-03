package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface ProcessGrammarTypeAsciidocFile {

    public void assertAssignment(HashMap<String, String> keyMap);

    public void assertType(HashMap<String, String> keyMap);

    public void assertMultiplicity(HashMap<String, String> keyMap);

    public void setCellTypeAsFollows(HashMap<String, String> keyMap);

    public void setDescriptionTypeAsFollows(HashMap<String, String> keyMap);

    public void setLineTypeAsFollows(HashMap<String, String> keyMap);

    public void setModelTypeAsFollows(HashMap<String, String> keyMap);

    public void setNestedDescriptionTypeAsFollows(HashMap<String, String> keyMap);

    public void setRowTypeAsFollows(HashMap<String, String> keyMap);

    public void setStepDefinitionTypeAsFollows(HashMap<String, String> keyMap);

    public void assertName(HashMap<String, String> keyMap);

    public void setStepObjectTypeAsFollows(HashMap<String, String> keyMap);

    public void setStepObjectTypeFullName(HashMap<String, String> keyMap);

    public void setStepParametersTypeAsFollows(HashMap<String, String> keyMap);

    public void setTableTypeAsFollows(HashMap<String, String> keyMap);

    public void setTestCaseTypeAsFollows(HashMap<String, String> keyMap);

    public void setTestDataTypeAsFollows(HashMap<String, String> keyMap);

    public void setTestProjectTypeAsFollows(HashMap<String, String> keyMap);

    public void setTestSetupTypeAsFollows(HashMap<String, String> keyMap);

    public void assertGroup(HashMap<String, String> keyMap);

    public void assertKeyword(HashMap<String, String> keyMap);

    public void assertStepObjectName(HashMap<String, String> keyMap);

    public void assertStepDefinitionName(HashMap<String, String> keyMap);

    public void setTestStepTypeAsFollows(HashMap<String, String> keyMap);

    public void setTestStepTypeFullName(HashMap<String, String> keyMap);

    public void setTestStepContainerTypeAsFollows(HashMap<String, String> keyMap);

    public void setTestSuiteTypeAsFollows(HashMap<String, String> keyMap);

    public void setTestSuiteTypeFullName(HashMap<String, String> keyMap);

    public void setTextTypeAsFollows(HashMap<String, String> keyMap);
}
