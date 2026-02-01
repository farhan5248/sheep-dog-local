package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.dsl.lang.SheepDogFactory;
import org.farhan.impl.ide.TestStepContainerImpl;
import org.farhan.impl.ide.TestStepImpl;
import org.farhan.impl.ide.TestSuiteImpl;

public class MockIDE {

	public static ArrayList<SheepDogIssueProposal> listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
	public static ArrayList<SheepDogIssueProposal> listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
	public static String validateDialog = "";
	public static ITestProject testProject;
	public static TestSuiteImpl testSuite;
	public static TestStepContainerImpl testStepContainer;
	public static TestStepImpl testStep;
	public static ITable stepParametersTable;
	public static IText stepText;
	public static String elementType;

	public static void reset() {
		validateDialog = "";
		listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
		listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
		testSuite = null;
		testStepContainer = null;
		testStep = null;
		elementType = null;
		testProject = SheepDogFactory.instance.createTestProject();
	}

	public static void addTestSuite(String testSuiteName) {
		ITestSuite testSuite = testProject.getTestSuite(testSuiteName);
		if (testSuite == null) {
			testSuite = SheepDogBuilder.createTestSuite(testProject, testSuiteName);
		}
		MockIDE.testSuite = (TestSuiteImpl) testSuite;
	}

	public static void addTestCaseStep(String stepName) {
		if (testSuite == null) {
			addTestSuite("Test Suite");
		}
		if (testStepContainer == null) {
			addTestStepContainer("Test Step Container");
		}
		testStep = (TestStepImpl) SheepDogBuilder.createTestStep(testStepContainer, stepName);
		testStepContainer.addTestStep(testStep);
		if (stepParametersTable != null) {
			// this is for situations where the keymap order isn't preserved
			testStep.setTable(stepParametersTable);
			stepParametersTable = null;
		}
		if (stepText != null) {
			testStep.setText(stepText);
			stepText = null;
		}
	}

	public static void addTestSetupStep(String stepName) {
		if (testSuite == null) {
			addTestSuite("");
		}
		if (testStepContainer == null) {
			addTestStepContainer("");
		}
		testStep = (TestStepImpl) SheepDogBuilder.createTestStep(testStepContainer, stepName);
		testStepContainer.addTestStep(testStep);
		if (stepParametersTable != null) {
			// this is for situations where the keymap order isn't preserved
			testStep.setTable(stepParametersTable);
			stepParametersTable = null;
		}
		if (stepText != null) {
			testStep.setText(stepText);
			stepText = null;
		}
	}

	public static void addTestStepContainer(String testStepContainerName) {
		if (testSuite == null) {
			addTestSuite("Test Suite");
		}
		ITestStepContainer testCase = testSuite.getTestStepContainer(testStepContainerName);
		if (testCase == null) {
			testCase = SheepDogBuilder.createTestCase(testSuite, testStepContainerName);
		}
		testStepContainer = (TestStepContainerImpl) testCase;
	}
}
