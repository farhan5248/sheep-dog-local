package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepDefinition {

	IStepParameters createStepParameters(ArrayList<String> table);

	IStepParameters createStepParameters(String text);

	String getName();

	String getNameLong();

	IStepObject getParent();

	ArrayList<IStatement> getStatementList();

	ArrayList<IStepParameters> getStepParameterList();

	IStepParameters getStepParameters(ArrayList<String> table);

	IStepParameters getStepParameters(String text);

	void setName(String value);

	void setNameLong(String value);

	void setParent(IStepObject value);

	void setStatementList(ArrayList<IStatement> value);

	void setStepParametersList(ArrayList<IStepParameters> value);
}