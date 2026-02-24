package org.farhan.dsl.lang;

import java.util.List;

public interface IStepObject extends IModel {

	String getContent() throws Exception;

	String getName();

	ITestProject getParent();

	IDescription getDescription();

	IStepDefinition getStepDefinition(int index);

	IStepDefinition getStepDefinition(String name);

	List<IStepDefinition> getStepDefinitionList();

	void setContent(String text) throws Exception;

	void setName(String value);

	boolean addLine(ILine value);

	boolean addStepDefinition(IStepDefinition value);

}
