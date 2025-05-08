package org.farhan.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.farhan.dsl.common.ILanguageAccess;
import org.farhan.dsl.common.Proposal;

public class EclipseImpl implements ILanguageAccess {

	// TODO when moving the adoc, redo this because it's definitely going to be hard
	// to understand this 3 months from now when I return to this

	private String validationMessage;
	private String stepName;
	private ArrayList<String> stepParameters;
	private ArrayList<Object> allSteps;
	private ArrayList<Object> backgroundSteps;
	private HashMap<String, String> stepDefinitionDescriptions;
	private String stepObjectName;
	private HashMap<String, ArrayList<ArrayList<String>>> stepObject;
	private TreeMap<String, Proposal> proposalMap;
	private ArrayList<String> componentObjects;
	private String stepObjectDescription;
	private Object[] alternateObjects;

	public EclipseImpl() {
		stepName = "";
		stepObjectName = "";
		componentObjects = new ArrayList<String>();
		stepParameters = new ArrayList<String>();
		allSteps = new ArrayList<Object>();
		backgroundSteps = new ArrayList<Object>();
		stepDefinitionDescriptions = new HashMap<String, String>();
	}

	public void addBackgroundStep(String stepName) {
		backgroundSteps.add(stepName);
	}

	public void addStep(String stepName) {
		this.stepName = stepName;
		allSteps.add(this.stepName);
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
		createStepDefinition(predicate);
		return predicate;
	}

	public Object createStepDefinition(String stepDefinitionName) {
		if (this.stepObject.get(stepDefinitionName) == null) {
			this.stepObject.put(stepDefinitionName, new ArrayList<ArrayList<String>>());
		}
		return this.stepObject.get(stepDefinitionName);
	}

	@Override
	public void createStepDefinitionParameters(Object stepDefinitionName) {
		this.stepObject.get(stepDefinitionName).add(stepParameters);
	}

	@Override
	public Object createStepObject(String objectQualifiedName) throws Exception {
		if (stepObject == null) {
			stepObjectName = objectQualifiedName;
			stepObject = new HashMap<String, ArrayList<ArrayList<String>>>();
			componentObjects.add(stepObjectName);
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
		for (String stepObject : componentObjects) {
			folders.add(stepObject.split("/")[0]);
		}
		return folders;
	}

	@Override
	public ArrayList<String> getFilesRecursively(String component) {
		return componentObjects;
	}

	@Override
	public ArrayList<Object> getPreviousSteps() {
		ArrayList<Object> previousSteps = new ArrayList<Object>();
		for (int i = 0; i < allSteps.size() - 1; i++) {
			previousSteps.add(allSteps.get(i));
		}
		return previousSteps;
	}

	public TreeMap<String, Proposal> getProposals() {
		return proposalMap;
	}

	@Override
	public Object getStep() {
		return stepName;
	}

	@Override
	public String getStepDefinitionDescription(Object stepDefinition) {
		return stepDefinitionDescriptions.get(stepDefinition);
	}

	@Override
	public String getStepDefinitionName(Object stepDefinition) {
		return (String) stepDefinition;
	}

	@Override
	public List<?> getStepDefinitionParameters(Object stepDefinition) {
		return this.stepObject.get(stepDefinition.toString());
	}

	@Override
	public String getStepDefinitionParametersDocumentation(Object parameters) {
		return getStepDefinitionParametersString(parameters);
	}

	@SuppressWarnings("unchecked")
	@Override
	public String getStepDefinitionParametersString(Object parameters) {
		return cellsToString((ArrayList<String>) parameters);
	}

	@Override
	public List<?> getStepDefinitions(Object stepObject) {
		ArrayList<String> stepDefinitionNames = new ArrayList<String>();
		for (String name : this.stepObject.keySet()) {
			stepDefinitionNames.add(name);
		}
		return stepDefinitionNames;
	}

	@Override
	public String getStepName() {
		return stepName;
	}

	@Override
	public String getStepName(Object step) {
		return step.toString();
	}

	@Override
	public Object getStepObject(String objectQualifiedName) throws Exception {
		if (objectQualifiedName.contentEquals(stepObjectName)) {
			return stepObject;
		} else {
			return null;
		}
	}

	@Override
	public String getStepObjectDescription(String fileName) {
		return stepObjectDescription;
	}

	@Override
	public String getStepParametersString() {
		return cellsToString(stepParameters);
	}

	public String getValidationMessage() {
		return this.validationMessage;
	}

	@Override
	public boolean hasParameters(Object stepDefinition) {
		return !this.stepParameters.isEmpty();
	}

	@Override
	public void saveObject(Object theObject, Map<Object, Object> options) throws Exception {
	}

	public void setAlternateObjects(Object[] alternateObjects) {
		this.alternateObjects = alternateObjects;
	}

	public void setProposalList(TreeMap<String, Proposal> proposalList) {
		this.proposalMap = proposalList;
	}

	public void setStepDefinitionDescription(String stepDefinition, String description) {
		stepDefinitionDescriptions.put(stepDefinition, description);
	}

	public void setStepObjectDescription(String description) {
		this.stepObjectDescription = description;
	}

	public void setStepParameters(String header) {
		this.stepParameters.add(header);
	}

	public void setStepSelection(String selection) {
		this.stepName = (String) allSteps.get(Integer.valueOf(selection) - 1);
	}

	public void setValidationMessage(String message) {
		this.validationMessage = message;
	}
}
