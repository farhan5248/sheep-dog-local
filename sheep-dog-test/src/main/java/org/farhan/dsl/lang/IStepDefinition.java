package org.farhan.dsl.lang;

import java.util.List;

public interface IStepDefinition {

	String getName();

	String getNameLong();

	IStepObject getParent();

	IStatement getStatement(int index);

	IStatement getStatement(String name);

	List<IStatement> getStatementList();

	List<IStepParameters> getStepParameterList();

	IStepParameters getStepParameters(int index);

	IStepParameters getStepParameters(IRow row);

	IStepParameters getStepParameters(IText value);

	IStepParameters getStepParameters(String name);

	void setName(String value);

	void setNameLong(String value);

	boolean addStatement(IStatement value);

	boolean addStepParameters(IStepParameters value);

}