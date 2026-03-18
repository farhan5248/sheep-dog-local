package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import org.slf4j.Logger;

public class TestStepIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TestStepIssueDetector.class);

	public static String validateNameOnly(ITestStep theTestStep) throws Exception {
		logger.debug("validateNameOnly(theTestStep={})", theTestStep);
		String result = "";
		String fullName = theTestStep.getFullName();
		if (fullName != null && !fullName.isEmpty()) {
			String object = StepObjectRefFragments.getObject(fullName);
			if (object.isEmpty()) {
				result = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_ONLY.description;
			} else if (StepObjectRefFragments.getAll(fullName).isEmpty()) {
				result = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_ONLY.description;
			}
		}
		logger.debug("validateNameOnly() = {}", result);
		return result;
	}

	public static String validateNameWorkspace(ITestStep theTestStep) throws Exception {
		logger.debug("validateNameWorkspace(theTestStep={})", theTestStep);
		String result = "";
		String fullName = theTestStep.getFullName();
		if (fullName != null && !fullName.isEmpty()) {
			String component = StepObjectRefFragments.getComponent(fullName);
			String objectName = StepObjectRefFragments.getObject(fullName);
			if (!component.isEmpty()) {
				ITestProject workspace = SheepDogUtility.getTestProjectParentForTestStep(theTestStep);
				if (workspace != null) {
					IStepObject matchingStepObject = null;
					for (ITestDocument doc : workspace.getTestDocumentList()) {
						if (doc instanceof IStepObject) {
							IStepObject stepObject = (IStepObject) doc;
							String soFullName = stepObject.getFullName();
							if (soFullName == null) continue;
							String[] parts = soFullName.split("/");
							if (parts.length < 3) continue;
							String docComponent = String.join("/",
									java.util.Arrays.copyOfRange(parts, 1, parts.length - 1));
							if (docComponent.equals(component) && stepObject.getName().equals(objectName)) {
								matchingStepObject = stepObject;
								break;
							}
						}
					}
					if (matchingStepObject == null) {
						result = TestStepIssueTypes.TEST_STEP_STEP_OBJECT_NAME_WORKSPACE.description;
					} else {
						String stepDefinitionName = theTestStep.getStepDefinitionName();
						if (stepDefinitionName != null && !stepDefinitionName.isEmpty()) {
							IStepDefinition stepDef = matchingStepObject.getStepDefinition(stepDefinitionName);
							if (stepDef == null) {
								result = TestStepIssueTypes.TEST_STEP_STEP_DEFINITION_NAME_WORKSPACE.description;
							}
						}
					}
				}
			}
		}
		logger.debug("validateNameWorkspace() = {}", result);
		return result;
	}
}
