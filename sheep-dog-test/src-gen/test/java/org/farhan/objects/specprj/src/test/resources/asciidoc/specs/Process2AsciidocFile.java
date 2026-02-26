package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface Process2AsciidocFile {

    public void setTestSuiteName(HashMap<String, String> keyMap);

    public void setTestCaseName(HashMap<String, String> keyMap);

    public void assertTestCaseName(HashMap<String, String> keyMap);

    public void setTestStepFullName(HashMap<String, String> keyMap);

    public void setCellName(HashMap<String, String> keyMap);

    public void assertCellName(HashMap<String, String> keyMap);

    public void setTextContent(HashMap<String, String> keyMap);

    public void assertTestSuiteName(HashMap<String, String> keyMap);
}
