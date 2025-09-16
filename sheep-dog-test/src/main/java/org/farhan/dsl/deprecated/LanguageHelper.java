package org.farhan.dsl.deprecated;

import java.util.Map;
import java.util.TreeMap;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.StepObjectBuilder;
import org.farhan.dsl.lang.TestStepIssueDetector;
import org.farhan.dsl.lang.TestStepIssueProposal;
import org.farhan.dsl.lang.TestStepIssueResolver;
import org.farhan.dsl.lang.TestStepUtility;

public class LanguageHelper {

	public static Object[] getAlternateObjects(ILanguageAccess la) throws Exception {
		return TestStepIssueResolver.proposeStepObject((ITestStep) la.getStep());
	}

	public static TreeMap<String, TestStepIssueProposal> proposeStepParameters(ILanguageAccess la) throws Exception {
		return TestStepIssueResolver.proposeStepParameters((ITestStep) la.getStep());
	}

	public static TreeMap<String, TestStepIssueProposal> proposeTestStepName(ILanguageAccess la) throws Exception {
		return TestStepIssueResolver.proposeName((ITestStep) la.getStep());
	}

	public static void generate(ILanguageAccess la, Map<Object, Object> options) throws Exception {
		StepObjectBuilder.generateStepDefinition((ITestStep) la.getStep(), options);
	}

	public static String getStepObjectQualifiedName(ILanguageAccess la) {
		return TestStepUtility.getObjectQualifiedName((ITestStep) la.getStep());
	}

	public static String validateError(ILanguageAccess la) throws Exception {
		return TestStepIssueDetector.getErrorMessage((ITestStep) la.getStep());
	}

	public static String validateWarning(ILanguageAccess la) throws Exception {
		return TestStepIssueDetector.getWarningMessage((ITestStep) la.getStep());
	}

}
