package org.farhan.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;

public class StepObjectImpl implements IStepObject {

	String name;
	private String qualifiedName;
	private TestProjectImpl parent;
	ArrayList<IStepDefinition> stepDefinitionList;
	ArrayList<IStatement> statementList;

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
		return parent;
	}

	@Override
	public String getQualifiedName() {
		return qualifiedName;
	}

	@Override
	public List<IStatement> getStatementList() {
		return Collections.unmodifiableList(statementList);
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
	public List<IStepDefinition> getStepDefinitionList() {
		return Collections.unmodifiableList(stepDefinitionList);
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setParent(ITestProject value) {
		parent = (TestProjectImpl) value;
		parent.stepObjectList.add(this);
	}

	@Override
	public void setQualifiedName(String value) {
		this.qualifiedName = value;
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
