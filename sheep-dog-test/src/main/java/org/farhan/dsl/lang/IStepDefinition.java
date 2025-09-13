package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepDefinition {

	String getName();

	String getNameLong();

	IStepObject getParent();

	ArrayList<IStatement> getStatementList();

	void setStatementList(ArrayList<IStatement> value);

	ArrayList<IStepParameters> getStepParameterList();

	void setName(String value);

	void setNameLong(String value);
	
	void setParent(IStepObject value);
	
	void setStepParametersList(ArrayList<IStepParameters> value);
}