package org.farhan.suites;

import org.farhan.dsl.lang.TestStepUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VertexValidatorTest {

	@Test
	public void testIsVertex() {
		Assertions.assertTrue(
				TestStepUtility.isVertex("The Something1 application, Something2 file Something3 section is empty"));
	}

	@Test
	public void testIsComponent() {
		Assertions.assertTrue(TestStepUtility
				.hasComponent("The Something1 application, Something2 file Something3 section is empty"));
	}

	@Test
	public void testGetAppName() {
		Assertions.assertTrue(TestStepUtility
				.getComponentName("The Something1 application, Something2 file Something3 section is empty")
				.contentEquals("Something1"));
	}

	@Test
	public void testGetAppType() {
		Assertions.assertTrue(TestStepUtility
				.getComponentType("The Something1 application, Something2 file Something3 section is empty")
				.contentEquals("application"));
	}

	@Test
	public void testGetObjName() {
		Assertions.assertTrue(
				TestStepUtility.getObjectName("The Something1 application, Something2 file Something3 section is empty")
						.contentEquals("Something2"));
	}

	@Test
	public void testGetObjType() {
		Assertions.assertTrue(
				TestStepUtility.getObjectType("The Something1 application, Something2 file Something3 section is empty")
						.contentEquals("file"));
	}

	@Test
	public void testGetDetailsName() {
		Assertions.assertTrue(TestStepUtility
				.getDetailsName("The Something1 application, Something2 file Something3 section is empty")
				.contentEquals("Something3"));
	}

	@Test
	public void testGetDetails() {
		Assertions.assertTrue(
				TestStepUtility.getDetails("The Something1 application, Something2 file Something3 section is empty")
						.contentEquals("Something3 section"));
	}

	@Test
	public void testGetDetailsType() {
		Assertions.assertTrue(TestStepUtility
				.getDetailsType("The Something1 application, Something2 file Something3 section is empty")
				.contentEquals("section"));
	}

	@Test
	public void testGetState() {
		Assertions.assertTrue(
				TestStepUtility.getState("The Something1 application, Something2 file Something3 section is empty")
						.contentEquals("is empty"));
	}

	@Test
	public void testGetStateModality() {
		Assertions.assertTrue(TestStepUtility
				.getStateModality("The Something1 application, Something2 file Something3 section is empty")
				.contentEquals("is"));
	}

	@Test
	public void testGetStateType() {
		Assertions.assertTrue(
				TestStepUtility.getStateType("The Something1 application, Something2 file Something3 section is empty")
						.contentEquals("empty"));
	}

	@Test
	public void testStateRegexIsSet() {
		Assertions.assertTrue("The Something1 application, Something2 file is set".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsUnset() {
		Assertions.assertTrue("The Something1 application, Something2 file is unset".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsEmpty() {
		Assertions.assertTrue("The Something1 application, Something2 file is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsPresent() {
		Assertions.assertTrue("The Something1 application, Something2 file is present".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsAbsent() {
		Assertions.assertTrue("The Something1 application, Something2 file is absent".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsEnabled() {
		Assertions.assertTrue("The Something1 application, Something2 file is enabled".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsDisabled() {
		Assertions.assertTrue("The Something1 application, Something2 file is disabled".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsDownloaded() {
		Assertions
				.assertTrue("The Something1 application, Something2 file is downloaded".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsUploaded() {
		Assertions.assertTrue("The Something1 application, Something2 file is uploaded".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexAsFollows() {
		Assertions.assertTrue(
				"The Something1 application, Something2 file is created as follows".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testGetAttachment() {
		Assertions.assertTrue(
				TestStepUtility.getAttachment("The Something1 application, Something2 file is created as follows")
						.contentEquals("as follows"));
	}

	@Test
	public void testIsNegativeStep() {
		Assertions.assertTrue("The Something1 application, Something2 file isn't empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexIsnt() {
		Assertions.assertTrue("The Something1 application, Something2 file isn't empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexWillBe() {
		Assertions
				.assertTrue("The Something1 application, Something2 file will be empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testStateRegexWontBe() {
		Assertions.assertTrue(
				"The Something1 application, Something2 file won't be empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testDetailsRegexSection() {
		Assertions.assertTrue("The Something1 application, Something2 file Something3 section is empty"
				.matches(TestStepUtility.REGEX));
	}

	@Test
	public void testDetailsRegexList() {
		Assertions.assertTrue(
				"The Something1 application, Something2 file Something3 list is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testDetailsRegexFragment() {
		Assertions.assertTrue("The Something1 application, Something2 file Something3 fragment is empty"
				.matches(TestStepUtility.REGEX));
	}

	@Test
	public void testDetailsRegexTable() {
		Assertions.assertTrue(
				"The Something1 application, Something2 file Something3 table is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testDetailsRegexSnippet() {
		Assertions.assertTrue("The Something1 application, Something2 file Something3 snippet is empty"
				.matches(TestStepUtility.REGEX));
	}

	@Test
	public void testObjectRegexDirectory() {
		Assertions
				.assertTrue("The Something1 application, Something2 directory is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testObjectRegexPage() {
		Assertions.assertTrue("The Something1 application, Something2 page is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testObjectRegexDialog() {
		Assertions.assertTrue("The Something1 application, Something2 dialog is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testObjectRegexResponse() {
		Assertions
				.assertTrue("The Something1 application, Something2 response is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testAppRegexProject() {
		Assertions.assertTrue("The Something1 project, Something2 file is present".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testAppRegexService() {
		Assertions.assertTrue("The Something1 service, Something2 file is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testAppRegexPlugIn() {
		Assertions.assertTrue("The Something1 plugin, Something2 file is empty".matches(TestStepUtility.REGEX));
	}

	@Test
	public void testAppRegexBatchJob() {
		Assertions.assertTrue("The Something1 batchjob, Something2 file is empty".matches(TestStepUtility.REGEX));
	}
}
