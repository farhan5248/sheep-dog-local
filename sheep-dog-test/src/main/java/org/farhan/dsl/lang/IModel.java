package org.farhan.dsl.lang;

/**
 * Root interface representing a SheepDog model file. A model can be either a
 * StepObject or TestSuite. IStepObject and ITestSuite extend this interface.
 */
public interface IModel {

	String getNameLong();

	// TODO this is a meta attribute and shouldn't have a set. This corresponds to
	// the EMF UML qualified name. For it to work the way I'd like, a test suite or
	// step object should be added to a parent package. So I'd need to define a
	// package type and then the fullName/qualifiedName can be derived from that.
	void setNameLong(String value);

	/**
	 * Gets the parent test project containing this model. Meta-attribute (not in
	 * grammar).
	 * 
	 * @return the parent test project
	 */
	ITestProject getParent();

}
