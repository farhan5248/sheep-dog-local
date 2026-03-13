package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ITestSuite;

public class TestSuiteIssueDetector {

    public static String validateNameOnly(ITestSuite theTestSuite) {
        String name = theTestSuite.getName();
        if (name == null || name.isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            return TestSuiteIssueTypes.TEST_SUITE_NAME_ONLY.description;
        }
        return "";
    }
}
