package org.farhan.suites;

import org.farhan.dsl.lang.TestStepIssueDetector;
import org.farhan.dsl.lang.TestStepUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeValidatorTest {

	@Test
	public void testIsEdge() {
		Assertions.assertTrue(TestStepUtility.isEdge("The Something1 application, Something2 request is executed with"));
	}

	@Test
	public void testIsComponent() {
		Assertions.assertTrue(
				TestStepUtility.hasComponent("The Something1 application, Something2 request is executed with"));
	}

	@Test
	public void testGetAppName() {
		Assertions.assertTrue(
				TestStepUtility.getComponentName("The Something1 application, Something2 request is executed with")
						.contentEquals("Something1"));
	}

	@Test
	public void testGetAppType() {
		Assertions.assertTrue(
				TestStepUtility.getComponentType("The Something1 application, Something2 request is executed with")
						.contentEquals("application"));
	}

	@Test
	public void testGetObjName() {
		Assertions
				.assertTrue(TestStepUtility.getObjectName("The Something1 application, Something2 request is executed with")
						.contentEquals("Something2"));
	}

	@Test
	public void testGetObjTypeRequest() {
		Assertions
				.assertTrue(TestStepUtility.getObjectType("The Something1 application, Something2 request is executed with")
						.contentEquals("request"));
	}

	@Test
	public void testGetObjTypeJob() {
		Assertions.assertTrue(TestStepUtility.getObjectType("The Something1 batchjob, Something2 job is executed with")
				.contentEquals("job"));
	}

	@Test
	public void testGetState() {
		Assertions.assertTrue(TestStepUtility.getState("The Something1 application, Something2 request is executed with")
				.contentEquals("is executed with"));
	}

	@Test
	public void testGetStateModality() {
		Assertions.assertTrue(
				TestStepUtility.getStateModality("The Something1 application, Something2 request is executed with")
						.contentEquals("is"));
	}

	@Test
	public void testGetStateType() {
		Assertions.assertTrue(TestStepUtility.getStateType("The Something1 application, Something2 request is executed with")
				.contentEquals("executed"));
	}

	@Test
	public void testGetAttachment() {
		Assertions
				.assertTrue(TestStepUtility.getAttachment("The Something1 application, Something2 request is executed with")
						.contentEquals("with"));
	}

	@Test
	public void testGetTime() {
		Assertions.assertTrue(TestStepUtility.getTime("The Something1 application, Something2 request is executed on time")
				.contentEquals("on time"));
	}

	@Test
	public void testStateRegexWith() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 request is executed with"));
	}

	@Test
	public void testStateRegexIsSent() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 request is sent"));
	}

	@Test
	public void testStateRegexIsPerformed() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is performed"));
	}

	@Test
	public void testStateRegexIsTriggered() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 request is triggered"));
	}

	@Test
	public void testIsNegativeStep() {
		Assertions
				.assertTrue(TestStepUtility.isNegativeStep("The Something1 application, Something2 request isn't executed"));
	}

	@Test
	public void testStateRegexIsntExecuted() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 request isn't executed"));
	}

	@Test
	public void testStateRegexWillBeExecuted() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 request will be executed"));
	}

	@Test
	public void testStateRegexWontBeExecuted() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 request won't be executed"));
	}

	@Test
	public void testObjectRegexGoal() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 goal is executed"));
	}

	@Test
	public void testObjectRegexAction() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 action is performed"));
	}

	@Test
	public void testAppRegexService() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 service, Something2 request is sent"));
	}

	@Test
	public void testAppRegexApplication() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 request is sent"));
	}

	@Test
	public void testAppRegexBatchJob() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 batchjob, Something2 request is sent"));
	}

	@Test
	public void testAppRegexPlugIn() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 plugin, Something2 request is sent"));
	}

	@Test
	public void testTimeRegexAt() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 plugin, Something2 request is sent at noon"));
	}

	@Test
	public void testTimeRegexBefore() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 plugin, Something2 request is sent before midday"));
	}

	@Test
	public void testTimeRegexAfter() {
		Assertions
				.assertTrue(TestStepIssueDetector.isValid("The Something1 plugin, Something2 request is sent after the next day"));
	}

	@Test
	public void testTimeRegexIn() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 plugin, Something2 request is sent in 5 years"));
	}

	@Test
	public void testTimeRegexOnTime() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 plugin, Something2 request is sent on time"));
	}

}
