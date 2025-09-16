package org.farhan.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.StatementUtility;
import org.farhan.dsl.lang.TestStepIssueProposal;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.deprecated.ILanguageAccess;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.IStepParameters;

public class LanguageAccessImpl implements ILanguageAccess {

	private ITestProject testProject;
	private ITestStep theTestStep;
	private IStepObject stepObject;
	private ArrayList<Object> allSteps;
	private ArrayList<Object> backgroundSteps;
	private ArrayList<IStepObject> componentObjects;
	private ArrayList<ArrayList<String>> stepParametersTable;
	// UI elements
	private TreeMap<String, TestStepIssueProposal> proposalMap;
	private String validationMessage;
	private Object[] alternateObjects;

	public LanguageAccessImpl(TestProjectImpl testProjectImpl) {
		testProject = testProjectImpl;
		componentObjects = new ArrayList<IStepObject>();
		allSteps = new ArrayList<Object>();
		backgroundSteps = new ArrayList<Object>();
	}

	public void addBackgroundStep(String stepName) {
		ITestSuite testSuite = testProject.createTestSuite("");
		ITestCase testCase = testSuite.createTestCase("");
		theTestStep = testCase.createTestStep(stepName);
		backgroundSteps.add(theTestStep);
	}

	public void addStep(String stepName) {

		ITestSuite testSuite = testProject.getTestSuite("");
		if (testSuite == null) {
			testSuite = testProject.createTestSuite("");
		}
		ITestStepContainer testCase = testSuite.getTestStepContainer("");
		if (testCase == null) {
			testCase = testSuite.createTestCase("");
		}
		theTestStep = testCase.createTestStep(stepName);
		allSteps.add(theTestStep);
		if (stepParametersTable != null) {
			// this is for situations where the keymap order isn't preserved
			theTestStep.setTable(stepParametersTable);
			stepParametersTable = null;
		}
	}

	private String cellsToString(List<String> cells) {
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (String cell : cells) {
			sortedCells.add(cell);
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString.trim();
	}

	@Override
	public Object createStepDefinition(Object stepObject, String predicate) {
		return createStepDefinition(predicate);
	}

	public Object createStepDefinition(String predicate) {
		IStepDefinition sd = this.stepObject.getStepDefinition(predicate);
		if (sd == null) {
			return this.stepObject.createStepDefinition(predicate);
		}
		return sd;
	}

	@Override
	public void createStepDefinitionParameters(Object predicate) {
		((IStepDefinition) predicate).createStepParameters(theTestStep.getTable().getFirst());
	}

	@Override
	public Object createStepObject(String objectQualifiedName) throws Exception {

		if (stepObject == null) {
			stepObject = testProject.createStepObject(objectQualifiedName);
			componentObjects.add(stepObject);
		}
		return stepObject;
	}

	@Override
	public ArrayList<Object> getAllSteps() {
		return allSteps;
	}

	public Object[] getAlternateObjects() {
		return this.alternateObjects;
	}

	@Override
	public ArrayList<Object> getBackgroundSteps() {
		return backgroundSteps;
	}

	@Override
	public String getFileExtension() {
		return ".feature";
	}

	@Override
	public ArrayList<String> getFiles() {

		// TODO this adds duplicates so change ArrayList to Collection in the interface
		ArrayList<String> folders = new ArrayList<String>();
		for (IStepObject stepObject : componentObjects) {
			folders.add(stepObject.getQualifiedName().split("/")[0]);
		}
		return folders;
	}

	@Override
	public ArrayList<String> getFilesRecursively(String component) {
		ArrayList<String> files = new ArrayList<String>();
		for (IStepObject so : componentObjects) {
			files.add(so.getQualifiedName());
		}
		return files;
	}

	@Override
	public ArrayList<Object> getPreviousSteps() {
		ArrayList<Object> previousSteps = new ArrayList<Object>();
		for (int i = 0; i < allSteps.size() - 1; i++) {
			previousSteps.add(allSteps.get(i));
		}
		return previousSteps;
	}

	public TreeMap<String, TestStepIssueProposal> getProposals() {
		return proposalMap;
	}

	@Override
	public Object getStep() {
		return theTestStep;
	}

	@Override
	public String getStepDefinitionDescription(Object stepDefinition) {
		return StatementUtility.getStatementListAsString(((IStepDefinition) stepDefinition).getStatementList());
	}

	@Override
	public String getStepDefinitionName(Object stepDefinition) {
		return ((IStepDefinition) stepDefinition).getName();
	}

	@Override
	public List<?> getStepDefinitionParameters(Object stepDefinition) {
		return ((IStepDefinition) stepDefinition).getStepParameterList();
	}

	@Override
	public String getStepDefinitionParametersDocumentation(Object parameters) {
		return getStepDefinitionParametersString(parameters);
	}

	@Override
	public String getStepDefinitionParametersString(Object parameters) {
		return cellsToString(((IStepParameters) parameters).getTable().getFirst());
	}

	@Override
	public List<?> getStepDefinitions(Object stepObject) {
		return ((IStepObject) stepObject).getStepDefinitionList();
	}

	@Override
	public String getStepName() {
		return theTestStep.getName();
	}

	@Override
	public String getStepName(Object step) {
		return ((ITestStep) step).getName();
	}

	@Override
	public Object getStepObject(String qualifiedName) throws Exception {

		return testProject.getStepObject(qualifiedName);
	}

	@Override
	public String getStepObjectDescription(String fileName) {
		return StatementUtility.getStatementListAsString(stepObject.getStatementList());
	}

	@Override
	public String getStepParametersString() {
		return cellsToString(theTestStep.getTable().getFirst());
	}

	public String getValidationMessage() {
		return this.validationMessage;
	}

	@Override
	public boolean hasParameters(Object stepDefinition) {
		return !((IStepDefinition) stepDefinition).getStepParameterList().isEmpty();
	}

	@Override
	public void saveObject(Object theObject, Map<Object, Object> options) throws Exception {
	}

	public void setAlternateObjects(Object[] alternateObjects) {
		this.alternateObjects = alternateObjects;
	}

	public void setProposalList(TreeMap<String, TestStepIssueProposal> proposalList) {
		this.proposalMap = proposalList;
	}

	public void setStepDefinitionDescription(String predicate, String description) {
		((IStepDefinition) createStepDefinition(predicate)).getStatementList().add(new StatementImpl(description));
	}

	public void setStepObjectDescription(String description) {
		stepObject.getStatementList().add(new StatementImpl(description));
	}

	public void setStepParameters(String header) {
		stepParametersTable = new ArrayList<ArrayList<String>>();
		stepParametersTable.add(new ArrayList<String>());
		for (String h : header.split("\\|")) {
			stepParametersTable.getFirst().add(h);
		}
	}

	public void setStepSelection(String selection) {
		theTestStep = (ITestStep) allSteps.get(Integer.valueOf(selection) - 1);
	}

	public void setValidationMessage(String message) {
		this.validationMessage = message;
	}
}
