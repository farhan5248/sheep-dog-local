package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.farhan.dsl.grammar.StepDefinitionRefFragments;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.slf4j.Logger;

public class TestStepIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);

	public static String validateStepObjectNameOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entry: validateStepObjectNameOnly({})", theTestStep);
		String message = "";
		String text = theTestStep.getFullName();
		if (text != null && !text.isEmpty()) {
			if (StepObjectRefFragments.getObject(text).isEmpty()) {
				message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
			}
		}
		logger.debug("Exit: validateStepObjectNameOnly({})", message);
		return message;
	}

	public static String validateStepObjectNameWorkspace(ITestStep theTestStep) throws Exception {
		logger.debug("Entry: validateStepObjectNameWorkspace({})", theTestStep);
		String message = "";
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(theTestStep);
		if (!stepObjectFullName.isEmpty()) {
			ITestProject project = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
			if (project != null && project.getTestDocument(stepObjectFullName) == null) {
				message = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
			}
		}
		logger.debug("Exit: validateStepObjectNameWorkspace({})", message);
		return message;
	}

	public static String validateStepDefinitionNameOnly(ITestStep theTestStep) throws Exception {
		logger.debug("Entry: validateStepDefinitionNameOnly({})", theTestStep);
		String message = "";
		String text = theTestStep.getFullName();
		if (text != null && !text.isEmpty()) {
			String stepObjectRef = StepObjectRefFragments.getAll(text);
			String remainingText = text.substring(stepObjectRef.length()).trim();
			if (StepDefinitionRefFragments.getAll(remainingText).isEmpty()) {
				message = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
			}
		}
		logger.debug("Exit: validateStepDefinitionNameOnly({})", message);
		return message;
	}
}
