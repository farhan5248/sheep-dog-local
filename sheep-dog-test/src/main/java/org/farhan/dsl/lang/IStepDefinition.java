package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepDefinition {

	IStepParameters createStepParameters(IRow row);

	IStepParameters createStepParameters(IText value);

	String getName();

	String getNameLong();

	IStepObject getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	ArrayList<IStatement> getStatementList();

	ArrayList<IStepParameters> getStepParameterList();

	IStepParameters getStepParameters(int index);

	IStepParameters getStepParameters(IRow row);

	IStepParameters getStepParameters(IText value);

	IStepParameters getStepParameters(String name);

	void setName(String value);

	void setNameLong(String value);

	void setParent(IStepObject value);

	void setStatementList(ArrayList<IStatement> value);

	void setStepParametersList(ArrayList<IStepParameters> value);
}