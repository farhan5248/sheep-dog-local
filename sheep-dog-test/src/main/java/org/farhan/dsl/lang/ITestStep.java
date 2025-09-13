package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface ITestStep {

	String getName();

	String getNameLong();

	ITestStepContainer getParent();

	ArrayList<ArrayList<String>> getTable();

	String getText();

	void setName(String value);

	void setNameLong(String value);

	void setParent(ITestStepContainer value);
	
	void setTable(ArrayList<ArrayList<String>> value);
	
	void setText(String value);

}