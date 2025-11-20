package org.farhan.dsl.lang;

/**
 * Root interface representing a SheepDog model file.
 * A model can be either a StepObject or TestSuite.
 * IStepObject and ITestSuite extend this interface.
 */
public interface IModel {

	String getQualifiedName();
	
	void setQualifiedName(String value);
	
	/**
	 * Gets the resource name/path for this model.
	 * Meta-attribute (not in grammar).
	 * @return the resource identifier
	 */
	String getResourceName();

	/**
	 * Sets the resource name/path for this model.
	 * Meta-attribute (not in grammar).
	 * @param value the resource identifier
	 */
	void setResourceName(String value);

	/**
	 * Gets the parent test project containing this model.
	 * Meta-attribute (not in grammar).
	 * @return the parent test project
	 */
	ITestProject getParent();

	/**
	 * Sets the parent test project for this model.
	 * Meta-attribute (not in grammar).
	 * @param value the parent test project
	 */
	void setParent(ITestProject value);
}
