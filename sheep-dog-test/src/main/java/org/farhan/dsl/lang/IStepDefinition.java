package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepDefinition {

	// TODO keep until IText is added
	IStepParameters createStepParametersTmp(ArrayList<String> table);
	IStepParameters getStepParametersTmp(ArrayList<String> table);

	IStepParameters createStepParameters(IRow row);

	String getName();

	String getNameLong();

	IStepObject getParent();

	ArrayList<IStatement> getStatementList();

	ArrayList<IStepParameters> getStepParameterList();

	IStepParameters getStepParameters(IRow row);

	void setName(String value);

	void setNameLong(String value);

	void setParent(IStepObject value);

	void setStatementList(ArrayList<IStatement> value);

	void setStepParametersList(ArrayList<IStepParameters> value);
}