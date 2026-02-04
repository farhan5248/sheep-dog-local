package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface Process2AsciidocFile {

    public void setBackgroundStepsSnippetStepName(HashMap<String, String> keyMap);

    public void setTestSuiteName(HashMap<String, String> keyMap);

    public void setTestCaseName(HashMap<String, String> keyMap);

    public void setStepsSnippetStepName(HashMap<String, String> keyMap);

    public void setStepsSnippetHeaders(HashMap<String, String> keyMap);

    public void setStepsSnippetTextContent(HashMap<String, String> keyMap);
}
