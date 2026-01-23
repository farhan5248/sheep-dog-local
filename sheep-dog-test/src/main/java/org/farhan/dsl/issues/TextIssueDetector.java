package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;

public class TextIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TextIssueDetector.class);

	public static String validateNameWorkspace(IText theText) throws Exception {
		logger.debug("Entering validateNameWorkspace for text: {}", theText != null ? theText.getName() : "null");
		ITestStep theTestStep = (ITestStep) theText.getParent();
		String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
		IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
		IStepDefinition theStepDefinition = theStepObject
				.getStepDefinition(TestStepUtility.getStepDefinitionName(theTestStep.getName()));
		if (!theText.getName().isEmpty()) {
			if (theStepDefinition.getStepParameters(theText) == null) {
				logger.debug("Exiting validateNameWorkspace");
				return TextIssueTypes.TEXT_NAME_WORKSPACE.description;
			}
		}
		logger.debug("Exiting validateNameWorkspace");
		return "";
	}
}
