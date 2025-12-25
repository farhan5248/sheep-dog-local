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
	TestProjectImpl parent;
	ArrayList<StepDefinitionImpl> stepDefinitionList;
	ArrayList<StatementImpl> statementList;

	public StepObjectImpl(String qualifiedName) {
		this.qualifiedName = qualifiedName;
		String[] nameParts = qualifiedName.split("/");
		name = nameParts[nameParts.length - 1].replace(".feature", "");
		this.stepDefinitionList = new ArrayList<StepDefinitionImpl>();
		this.statementList = new ArrayList<StatementImpl>();
	}

	@Override
	public String getContent() throws Exception {
		return this.toString();
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
	public String getNameLong() {
		return qualifiedName;
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
	public List<IStatement> getStatementList() {
		return Collections.unmodifiableList(statementList);
	}

	@Override
	public IStepDefinition getStepDefinition(int index) {
		throw new UnsupportedOperationException("getStepDefinition(int index) is not implemented");
	}

	@Override
	public IStepDefinition getStepDefinition(String name) {
		for (IStepDefinition sd : stepDefinitionList) {
			if (sd.getName().contentEquals(name)) {
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
	public void setContent(String text) throws Exception {
		throw new UnsupportedOperationException("setContent(String text)  is not implemented");
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setNameLong(String value) {
		this.qualifiedName = value;
	}

	@Override
	public boolean addStatement(IStatement value) {
		statementList.add((StatementImpl) value);
		statementList.getLast().parent = this;
		return true;
	}

	@Override
	public boolean addStepDefinition(IStepDefinition value) {
		stepDefinitionList.add((StepDefinitionImpl) value);
		stepDefinitionList.getLast().parent = this;
		return true;
	}

}
