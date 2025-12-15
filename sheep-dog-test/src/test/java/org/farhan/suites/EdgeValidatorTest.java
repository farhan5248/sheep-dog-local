package org.farhan.suites;

import org.farhan.dsl.lang.TestStepUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeValidatorTest {

	@Test
	public void testIsEdge() {
		Assertions.assertTrue(TestStepUtility.isEdge("The Something1 application Something2 request is executed with"));
	}

	@Test
	public void testGetAppName() {
		Assertions.assertTrue(
				TestStepUtility.getComponentName("The Something1 application Something2 request is executed with")
						.contentEquals("Something1"));
	}

	@Test
	public void testGetAppType() {
		Assertions.assertTrue(
				TestStepUtility.getComponentType("The Something1 application Something2 request is executed with")
						.contentEquals("application"));
	}

	@Test
	public void testGetObjName() {
		Assertions.assertTrue(
				TestStepUtility.getObjectName("The Something1 application Something2 request is executed with")
						.contentEquals("Something2"));
	}

	@Test
	public void testGetObjTypeRequest() {
		Assertions.assertTrue(
				TestStepUtility.getObjectType("The Something1 application Something2 request is executed with")
						.contentEquals("request"));
	}

	@Test
	public void testGetObjTypeJob() {
		Assertions.assertTrue(TestStepUtility.getObjectType("The Something1 batchjob Something2 job is executed with")
				.contentEquals("job"));
	}

	@Test
	public void testGetState() {
		Assertions.assertTrue(TestStepUtility.getState("The Something1 application Something2 request is executed with")
				.contentEquals("is executed"));
	}

	@Test
	public void testGetStateModality() {
		Assertions.assertTrue(TestStepUtility
				.getStateDesc("The Something1 application Something2 request is executed with").contentEquals("is"));
	}

	@Test
	public void testGetStateType() {
		Assertions.assertTrue(
				TestStepUtility.getStateType("The Something1 application Something2 request is executed with")
						.contentEquals("executed"));
	}

	@Test
	public void testGetAttachment() {
		Assertions.assertTrue(TestStepUtility
				.getAttachment("The Something1 application Something2 request is executed with").contentEquals("with"));
	}

	@Test
	public void testGetTime() {
		Assertions.assertTrue(TestStepUtility
				.getTime("The Something1 application Something2 request is executed on time").contentEquals("on time"));
	}

	@Test
	public void testStateRegexWith() {
		Assertions.assertTrue(
				"The Something1 application Something2 request is executed with".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsSent() {
		Assertions.assertTrue("The Something1 application Something2 request is sent".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsPerformed() {
		Assertions.assertTrue("The Something1 application Something2 file is performed".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsTriggered() {
		Assertions.assertTrue(
				"The Something1 application Something2 request is triggered".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testIsNegativeStep() {
		Assertions.assertTrue(
				TestStepUtility.isNegativeStep("The Something1 application Something2 request isn't executed"));
	}

	@Test
	public void testStateRegexIsntExecuted() {
		Assertions.assertTrue(
				"The Something1 application Something2 request isn't executed".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexWillBeExecuted() {
		Assertions.assertTrue(
				"The Something1 application Something2 request will be executed".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexWontBeExecuted() {
		Assertions.assertTrue(
				"The Something1 application Something2 request won't be executed".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testObjectRegexGoal() {
		Assertions.assertTrue("The Something1 application Something2 goal is executed".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testObjectRegexAction() {
		Assertions
				.assertTrue("The Something1 application Something2 action is performed".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testAppRegexService() {
		Assertions.assertTrue("The Something1 service Something2 request is sent".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testAppRegexApplication() {
		Assertions.assertTrue("The Something1 application Something2 request is sent".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testAppRegexBatchJob() {
		Assertions.assertTrue("The Something1 batchjob Something2 request is sent".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testAppRegexPlugIn() {
		Assertions.assertTrue("The Something1 plugin Something2 request is sent".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testTimeRegexAt() {
		Assertions
				.assertTrue("The Something1 plugin Something2 request is sent at noon".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testTimeRegexBefore() {
		Assertions.assertTrue(
				"The Something1 plugin Something2 request is sent before midday".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testTimeRegexAfter() {
		Assertions.assertTrue(
				"The Something1 plugin Something2 request is sent after the next day".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testTimeRegexIn() {
		Assertions.assertTrue(
				"The Something1 plugin Something2 request is sent in 5 years".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testTimeRegexOnTime() {
		Assertions
				.assertTrue("The Something1 plugin Something2 request is sent on time".matches(TestStepUtility.REGEX));
	}

}
