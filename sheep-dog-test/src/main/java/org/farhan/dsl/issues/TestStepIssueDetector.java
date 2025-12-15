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
	public static String validateStepObjectNameComponentOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateStepObjectNameComponentOnly for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		String text = theTestStep.getName();
		if (text != null) {
			if (!text.matches(TestStepUtility.REGEX)) {
				if (!TestStepUtility.hasStepObjectName(text)) {
					if (!TestStepUtility.hasComponent(text)) {
						logger.debug("Exiting validateStepObjectNameComponentOnly");
						return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_COMPONENT_ONLY.description;
					}
				}
			}
		}
		logger.debug("Exiting validateStepObjectNameComponentOnly");
		return "";
	}

	public static String validateStepObjectNameObjectOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateStepObjectNameObjectOnly for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		String text = theTestStep.getName();
		if (text != null) {
			if (!text.matches(TestStepUtility.REGEX)) {
				if (!TestStepUtility.hasStepObjectName(text)) {
					logger.debug("Exiting validateStepObjectNameObjectOnly");
					return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_OBJECT_ONLY.description;
				}
			}
		}
		logger.debug("Exiting validateStepObjectNameObjectOnly");
		return "";
	}

	public static String validateStepDefinitionNameOnly(ITestStep theTestStep) throws Exception {

		logger.debug("Entering validateStepDefinitionNameOnly for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		String text = theTestStep.getName();
		if (text != null) {
			if (!text.matches(TestStepUtility.REGEX)) {
				if (!TestStepUtility.hasStepDefinitionName(text)) {
					return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
				}
			}
		}
		logger.debug("Exiting validateStepDefinitionNameOnly");
		return "";
	}

	public static String validateStepObjectNameWorkspace(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateStepObjectNameWorkspace for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {

			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			if (theStepObject == null) {
				logger.debug("Exiting validateStepObjectNameWorkspace");
				return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
			}
			logger.debug("Exiting validateStepObjectNameWorkspace");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateStepObjectNameWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static String validateStepDefinitionNameWorkspace(ITestStep theTestStep) throws Exception {
		// validates for a good name if the reference is valid
		logger.debug("Entering validateStepDefinitionNameWorkspace for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {

			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			if (theStepObject != null) {
				IStepDefinition theStepDefinition = theStepObject
						.getStepDefinition(TestStepUtility.getStepDefinitionName(theTestStep.getName()));
				if (theStepDefinition == null) {
					logger.debug("Exiting validateStepDefinitionNameWorkspace");
					return TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
				}
			}
			logger.debug("Exiting validateStepDefinitionNameWorkspace");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateStepDefinitionNameWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
