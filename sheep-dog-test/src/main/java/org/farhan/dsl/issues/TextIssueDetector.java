package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.Arrays;

import org.slf4j.Logger;

public class TextIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(TextIssueDetector.class);

	public static String validateNameWorkspace(IText theText) throws Exception {
		logger.debug("validateNameWorkspace(theText={})", theText);
		String result = "";
		ITestStep testStep = theText.getParent();
		if (testStep == null) {
			return result;
		}
		String fullName = testStep.getFullName();
		if (fullName == null || fullName.isEmpty()) {
			return result;
		}
		String component = StepObjectRefFragments.getComponent(fullName);
		String objectName = StepObjectRefFragments.getObject(fullName);
		if (component.isEmpty()) {
			return result;
		}
		ITestProject workspace = SheepDogUtility.getTestProjectParentForTestStep(testStep);
		if (workspace == null) {
			return result;
		}
		IStepObject matchingStepObject = null;
		for (ITestDocument doc : workspace.getTestDocumentList()) {
			if (doc instanceof IStepObject) {
				IStepObject stepObject = (IStepObject) doc;
				String soFullName = stepObject.getFullName();
				if (soFullName == null) continue;
				String[] parts = soFullName.split("/");
				if (parts.length < 3) continue;
				String docComponent = String.join("/", Arrays.copyOfRange(parts, 1, parts.length - 1));
				if (docComponent.equals(component) && stepObject.getName().equals(objectName)) {
					matchingStepObject = stepObject;
					break;
				}
			}
		}
		if (matchingStepObject == null) {
			return result;
		}
		String stepDefinitionName = testStep.getStepDefinitionName();
		if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
			return result;
		}
		IStepDefinition stepDef = matchingStepObject.getStepDefinition(stepDefinitionName);
		if (stepDef == null) {
			return result;
		}
		if (stepDef.getStepParameterList().isEmpty()) {
			result = TextIssueTypes.TEXT_STEP_PARAMETER_LIST_WORKSPACE.description;
		}
		logger.debug("validateNameWorkspace() = {}", result);
		return result;
	}
}
