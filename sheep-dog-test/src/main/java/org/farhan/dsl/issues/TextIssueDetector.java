package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TextIssueDetector.class);

	// TODO make test for this
	public static String validateNameWorkspace(IText theText) {
		logger.debug("Entering validateNameWorkspace for text: {}", theText != null ? theText.getName() : "null");
		try {
			ITestStep theTestStep = (ITestStep) theText.getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			IStepDefinition theStepDefinition = theStepObject
					.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
			if (!theText.getName().isEmpty()) {
				if (theStepDefinition.getStepParameters(theText) == null) {
					logger.debug("Exiting validateNameWorkspace");
					return TextIssueTypes.TEXT_NAME_WORKSPACE.description;
				}
			}

			logger.debug("Exiting validateNameWorkspace");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateNameWorkspace for text '{}': {}",
					theText != null ? theText.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}
}
