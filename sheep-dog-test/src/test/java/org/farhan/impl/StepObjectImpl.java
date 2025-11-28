package org.farhan.impl;

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
		throw new UnsupportedOperationException("setStepDefinitionList(ArrayList<IStepDefinition> value) is not implemented");
	}

	@Override
	public String getResourceName() {
		throw new UnsupportedOperationException("getResourceName() is not implemented");
	}

	@Override
	public void setResourceName(String value) {
		throw new UnsupportedOperationException("setResourceName(String value) is not implemented");
	}

	@Override
	public String getNameLong() {
		throw new UnsupportedOperationException("getNameLong() is not implemented");
	}

	@Override
	public IStatement getStatement(int index) {
		throw new UnsupportedOperationException("getStatement(int index) is not implemented");
	}

	@Override
	public IStatement getStatement(String name) {
		throw new UnsupportedOperationException("getStatement(String name) is not implemented");
	}

	@Override
	public IStepDefinition getStepDefinition(int index) {
		throw new UnsupportedOperationException("getStepDefinition(int index) is not implemented");
	}

	@Override
	public void setNameLong(String value) {
		throw new UnsupportedOperationException("setNameLong(String value) is not implemented");
	}

}
