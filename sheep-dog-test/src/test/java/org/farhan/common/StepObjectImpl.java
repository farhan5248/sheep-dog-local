package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;

public class StepObjectImpl implements IStepObject {

	private String name;
	private String qualifiedName;
	private ITestProject testProject;
	private ArrayList<IStepDefinition> stepDefinitionList;
	private ArrayList<IStatement> statementList;

	public StepObjectImpl(String qualifiedName) {
		this.qualifiedName = qualifiedName;
		String[] nameParts = qualifiedName.split("/");
		name = nameParts[nameParts.length - 1].replace(".feature", "");
		this.stepDefinitionList = new ArrayList<IStepDefinition>();
		this.statementList = new ArrayList<IStatement>();
	}

	@Override
	public IStepDefinition createStepDefinition(String predicate) {
		IStepDefinition stepDefinition = getStepDefinition(predicate);
		if (stepDefinition == null) {
			stepDefinition = new StepDefinitionImpl(predicate);
			stepDefinition.setParent(this);
			stepDefinitionList.add(stepDefinition);
		}
		return stepDefinition;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ITestProject getParent() {
		return testProject;
	}

	@Override
	public String getQualifiedName() {
		return qualifiedName;
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		return statementList;
	}

	@Override
	public IStepDefinition getStepDefinition(String predicate) {
		for (IStepDefinition sd : stepDefinitionList) {
			if (sd.getName().contentEquals(predicate)) {
				return sd;
			}
		}
		return null;
	}

	@Override
	public ArrayList<IStepDefinition> getStepDefinitionList() {
		return stepDefinitionList;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setParent(ITestProject value) {
		testProject = value;
	}

	@Override
	public void setQualifiedName(String value) {
		this.qualifiedName = value;
	}

	@Override
	public void setStepDefinitionList(ArrayList<IStepDefinition> value) {
		// TODO Auto-generated method stub

	}

}
