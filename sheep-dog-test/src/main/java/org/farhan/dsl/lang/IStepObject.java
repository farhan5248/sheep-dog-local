package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IStepObject {

	String getName();

	ITestProject getParent();

	String getQualifiedName();

	ArrayList<IStepDefinition> getStepDefinitionList();

	void setName(String value);

	void setParent(ITestProject value);
	
	void setQualifiedName(String value);
	
	void setStepDefinitionList(ArrayList<IStepDefinition> value);
}