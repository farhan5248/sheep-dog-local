package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface Process2AsciidocFile {

    public void setBackgroundTestStepListAssignmentTestStepFullName(HashMap<String, String> keyMap);

    public void setTestSuiteName(HashMap<String, String> keyMap);

    public void setTestCaseName(HashMap<String, String> keyMap);

    public void setTestStepListAssignmentTestStepFullName(HashMap<String, String> keyMap);

    public void setTestStepListAssignmentRowCellList(HashMap<String, String> keyMap);

    public void setTestStepListAssignmentTextContent(HashMap<String, String> keyMap);

    public void assertTestStepFullName(HashMap<String, String> keyMap);

    public void assertRowCellList(HashMap<String, String> keyMap);

    public void assertTestSuiteName(HashMap<String, String> keyMap);

    public void assertTestCaseName(HashMap<String, String> keyMap);
}
