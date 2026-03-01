package org.farhan.objects.specprj.src.test.resources.asciidoc.specs;

import java.util.HashMap;

public interface Process2AsciidocFile {

    public void setTestSuiteNodeTestSuiteName(HashMap<String, String> keyMap);

    public void assertTestSuite1NodeTestSuiteName(HashMap<String, String> keyMap);

    public void setTestSuite1TestCaseNodeTestCaseName(HashMap<String, String> keyMap);

    public void assertTestSuite1TestCase1NodeTestCaseName(HashMap<String, String> keyMap);

    public void setTestSuite1TestCase1TestStepNodeTestStepFullName(HashMap<String, String> keyMap);

    public void setTestSuite1TestCase1TestStep1TableRow1CellNodeCellName(HashMap<String, String> keyMap);

    public void assertTestSuite1TestCase1TestStep1TableRow1CellNodeCellName(HashMap<String, String> keyMap);

    public void setTestSuite1TestCase1TestStep1TableRow2CellNodeCellName(HashMap<String, String> keyMap);

    public void setTestSuite1TestCase1TestStep1TextNodeTextContent(HashMap<String, String> keyMap);

    public void setTestSuite1TestCase2TestStepNodeTestStepFullName(HashMap<String, String> keyMap);

    public void setTestSuite1TestSetup1TestStepNodeTestStepFullName(HashMap<String, String> keyMap);
}
