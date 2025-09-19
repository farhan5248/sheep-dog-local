package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepDefinition {

	IStepParameters createStepParameters(ArrayList<String> table);

	String getName();

	String getNameLong();

	IStepObject getParent();

	ArrayList<IStatement> getStatementList();

	ArrayList<IStepParameters> getStepParameterList();

	IStepParameters getStepParameters(ArrayList<String> table);

	void setName(String value);

	void setNameLong(String value);

	void setParent(IStepObject value);

	void setStatementList(ArrayList<IStatement> value);

	void setStepParametersList(ArrayList<IStepParameters> value);
}