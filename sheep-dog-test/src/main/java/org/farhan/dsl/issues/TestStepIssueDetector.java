package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueDetector.class);

	// TODO make test for this
	public static String validateNameComponentOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateNameComponentOnly for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		String text = theTestStep.getName();
		if (text != null) {
			if (!text.matches(TestStepUtility.REGEX)) {
				if (!TestStepUtility.hasStepObjectName(text)) {
					if (!TestStepUtility.hasComponent(text)) {
						logger.debug("Exiting validateNameComponentOnly");
						return TestStepIssueTypes.TEST_STEP_NAME_COMPONENT_ONLY.description;
					}
				}
			}
		}
		logger.debug("Exiting validateNameComponentOnly");
		return "";
	}

	public static String validateNameObjectOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateNameObjectOnly for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		String text = theTestStep.getName();
		if (text != null) {
			if (!text.matches(TestStepUtility.REGEX)) {
				if (!TestStepUtility.hasStepObjectName(text)) {
					logger.debug("Exiting validateNameObjectOnly");
					return TestStepIssueTypes.TEST_STEP_NAME_OBJECT_ONLY.description;
				}
			}
		}
		logger.debug("Exiting validateNameObjectOnly");
		return "";
	}

	public static String validateNamePredicateOnly(ITestStep theTestStep) throws Exception {

		logger.debug("Entering validateNamePredicateOnly for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		String text = theTestStep.getName();
		if (text != null) {
			if (!text.matches(TestStepUtility.REGEX)) {
				if (!TestStepUtility.hasStepDefinitionName(text)) {
					return TestStepIssueTypes.TEST_STEP_NAME_PREDICATE_ONLY.description;
				}
			}
		}
		logger.debug("Exiting validateNamePredicateOnly");
		return "";
	}

	public static String validateNameObjectWorkspace(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateNameObjectWorkspace for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {

			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			if (theStepObject == null) {
				logger.debug("Exiting validateNameObjectWorkspace");
				return TestStepIssueTypes.TEST_STEP_NAME_OBJECT_WORKSPACE.description;
			}
			logger.debug("Exiting validateNameObjectWorkspace");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateNameObjectWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static String validateNamePredicateWorkspace(ITestStep theTestStep) throws Exception {
		// validates for a good name if the reference is valid
		logger.debug("Entering validateNamePredicateWorkspace for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {

			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			if (theStepObject != null) {
				IStepDefinition theStepDefinition = theStepObject
						.getStepDefinition(TestStepUtility.getStepDefinitionName(theTestStep.getName()));
				if (theStepDefinition == null) {
					logger.debug("Exiting validateNamePredicateWorkspace");
					return TestStepIssueTypes.TEST_STEP_NAME_PREDICATE_WORKSPACE.description;
				}
			}
			logger.debug("Exiting validateNamePredicateWorkspace");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateNamePredicateWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
