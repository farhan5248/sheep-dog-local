package org.farhan.dsl.sheepdog.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.eclipse.xtext.resource.SaveOptions;
import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;

public class StepObjectImpl implements IStepObject {

	private static TestProjectImpl parent;
	StepObject eObject;
	private String qualifiedName;

	public StepObjectImpl(StepObject eObject) {
		this.eObject = eObject;
	}

	@Override
	public String getName() {
		return eObject.getName();
	}

	@Override
	public ITestProject getParent() {
		throw new UnsupportedOperationException("ITestProject getParent() is not implemented");
	}

	@Override
	public String getQualifiedName() {
		return qualifiedName;
	}

	@Override
	public ArrayList<IStatement> getStatementList() {
		ArrayList<IStatement> statementList = new ArrayList<IStatement>();
		for (Statement s : eObject.getStatementList()) {
			statementList.add(new StatementImpl(s));
		}
		return statementList;
	}

	@Override
	public IStepDefinition getStepDefinition(String predicate) {
		for (StepDefinition sd : eObject.getStepDefinitionList()) {
			if (sd.getName().contentEquals(predicate)) {
				StepDefinitionImpl stepDefinition = new StepDefinitionImpl((StepDefinition) sd);
				stepDefinition.setParent(this);
				return stepDefinition;
			}
		}
		return null;
	}

	@Override
	public ArrayList<IStepDefinition> getStepDefinitionList() {
		ArrayList<IStepDefinition> list = new ArrayList<IStepDefinition>();
		for (StepDefinition t : eObject.getStepDefinitionList()) {
			StepDefinitionImpl stepDefinition = new StepDefinitionImpl((StepDefinition) t);
			stepDefinition.setParent(this);
			list.add(stepDefinition);
		}
		return list;
	}

	@Override
	public void setName(String value) {
		eObject.setName(value);
	}

	@Override
	public void setParent(ITestProject value) {
		parent = (TestProjectImpl) value;
		parent.addStepObject(qualifiedName, toString());
	}

	@Override
	public void setQualifiedName(String value) {
		this.qualifiedName = value;
	}

	public String toString() {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			eObject.eResource().save(os, SaveOptions.newBuilder().format().getOptions().toOptionsMap());
		} catch (IOException e) {
			return e.getLocalizedMessage();
		}
		return os.toString();
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
