package org.farhan.suites;

import org.farhan.dsl.issues.TestStepIssueDetector;
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
		Assertions.assertTrue(
				TestStepUtility.hasComponent("The Something1 application, Something2 file Something3 section is empty"));
	}

	@Test
	public void testGetAppName() {
		Assertions.assertTrue(
				TestStepUtility.getComponentName("The Something1 application, Something2 file Something3 section is empty")
						.contentEquals("Something1"));
	}

	@Test
	public void testGetAppType() {
		Assertions.assertTrue(
				TestStepUtility.getComponentType("The Something1 application, Something2 file Something3 section is empty")
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
		Assertions.assertTrue(
				TestStepUtility.getDetailsName("The Something1 application, Something2 file Something3 section is empty")
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
		Assertions.assertTrue(
				TestStepUtility.getDetailsType("The Something1 application, Something2 file Something3 section is empty")
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
		Assertions.assertTrue(
				TestStepUtility.getStateModality("The Something1 application, Something2 file Something3 section is empty")
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
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is set"));
	}

	@Test
	public void testStateRegexIsUnset() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is unset"));
	}

	@Test
	public void testStateRegexIsEmpty() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is empty"));
	}

	@Test
	public void testStateRegexIsPresent() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is present"));
	}

	@Test
	public void testStateRegexIsAbsent() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is absent"));
	}

	@Test
	public void testStateRegexIsEnabled() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is enabled"));
	}

	@Test
	public void testStateRegexIsDisabled() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is disabled"));
	}

	@Test
	public void testStateRegexIsDownloaded() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is downloaded"));
	}

	@Test
	public void testStateRegexIsUploaded() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is uploaded"));
	}

	@Test
	public void testStateRegexAsFollows() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file is created as follows"));
	}

	@Test
	public void testGetAttachment() {
		Assertions.assertTrue(
				TestStepUtility.getAttachment("The Something1 application, Something2 file is created as follows")
						.contentEquals("as follows"));
	}

	@Test
	public void testIsNegativeStep() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file isn't empty"));
	}

	@Test
	public void testStateRegexIsnt() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file isn't empty"));
	}

	@Test
	public void testStateRegexWillBe() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file will be empty"));
	}

	@Test
	public void testStateRegexWontBe() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file won't be empty"));
	}

	@Test
	public void testDetailsRegexSection() {
		Assertions.assertTrue(
				TestStepIssueDetector.isValid("The Something1 application, Something2 file Something3 section is empty"));
	}

	@Test
	public void testDetailsRegexList() {
		Assertions
				.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 file Something3 list is empty"));
	}

	@Test
	public void testDetailsRegexFragment() {
		Assertions.assertTrue(
				TestStepIssueDetector.isValid("The Something1 application, Something2 file Something3 fragment is empty"));
	}

	@Test
	public void testDetailsRegexTable() {
		Assertions.assertTrue(
				TestStepIssueDetector.isValid("The Something1 application, Something2 file Something3 table is empty"));
	}

	@Test
	public void testDetailsRegexSnippet() {
		Assertions.assertTrue(
				TestStepIssueDetector.isValid("The Something1 application, Something2 file Something3 snippet is empty"));
	}

	@Test
	public void testObjectRegexDirectory() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 directory is empty"));
	}

	@Test
	public void testObjectRegexPage() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 page is empty"));
	}

	@Test
	public void testObjectRegexDialog() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 dialog is empty"));
	}

	@Test
	public void testObjectRegexResponse() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 application, Something2 response is empty"));
	}

	@Test
	public void testAppRegexProject() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 project, Something2 file is present"));
	}

	@Test
	public void testAppRegexService() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 service, Something2 file is empty"));
	}

	@Test
	public void testAppRegexPlugIn() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 plugin, Something2 file is empty"));
	}

	@Test
	public void testAppRegexBatchJob() {
		Assertions.assertTrue(TestStepIssueDetector.isValid("The Something1 batchjob, Something2 file is empty"));
	}
}
