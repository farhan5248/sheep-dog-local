package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface ILanguageAccess {

	public Object createStepDefinition(Object stepObject, String predicate);

	public void createStepDefinitionParameters(Object stepDefinition);

	public Object createStepObject(String objectQualifiedName) throws Exception;

	public ArrayList<Object> getAllSteps();

	public ArrayList<Object> getBackgroundSteps();

	public ArrayList<String> getFiles() throws Exception;

	public ArrayList<String> getFilesRecursively(String component) throws Exception;

	public ArrayList<Object> getPreviousSteps();

	public Object getStep();

	public String getStepDefinitionDescription(Object stepDefinition);

	public String getStepDefinitionName(Object stepDefinition);

	public List<?> getStepDefinitionParameters(Object stepDefinition);

	public String getStepDefinitionParametersString(Object parameters);

	public List<?> getStepDefinitions(Object stepObject);

	public String getStepName();

	public String getStepName(Object step);

	public Object getStepObject(String objectQualifiedName) throws Exception;

	public String getStepObjectDescription(String fileName) throws Exception;

	public String getStepParametersString();

	public boolean hasParameters(Object stepDefinition);

	public void saveObject(Object thObject, Map<Object, Object> options) throws Exception;

	public String getFileExtension();

	public String getStepDefinitionParametersDocumentation(Object parameters);

}
