package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestStepIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(TestStepIssueDetector.class);

	public static String validateStepObjectNameOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entering validateStepObjectNameOnly for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		String text = theTestStep.getName();
		if (text != null) {
			if (!TestStepUtility.isValid(text)) {
				if (TestStepUtility.getStepObjectName(text).isEmpty()) {
					logger.debug("Exiting validateStepObjectNameOnly");
					return TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
				}
			}
		}
		logger.debug("Exiting validateStepObjectNameOnly");
		return "";
	}

	public static String validateStepDefinitionNameOnly(ITestStep theTestStep) throws Exception {

		logger.debug("Entering validateStepDefinitionNameOnly for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		String text = theTestStep.getName();
		if (text != null) {
			if (!TestStepUtility.isValid(text)) {
				if (TestStepUtility.getStepDefinitionName(text).isEmpty()) {
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
			String message = "";
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			if (theStepObject == null) {
				message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
			}
			logger.debug("Exiting validateStepObjectNameWorkspace");
			return message;
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
			String message = "";
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject != null) {
				String stepDefinitionName = TestStepUtility.getStepDefinitionName(theTestStep.getName());
				if (!stepDefinitionName.isEmpty()) {
					IStepDefinition theStepDefinition = theStepObject.getStepDefinition(stepDefinitionName);
					if (theStepDefinition == null) {
						message = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
					}
				} 
			}
			logger.debug("Exiting validateStepDefinitionNameWorkspace");
			return message;
		} catch (Exception e) {
			logger.error("Failed in validateStepDefinitionNameWorkspace for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
