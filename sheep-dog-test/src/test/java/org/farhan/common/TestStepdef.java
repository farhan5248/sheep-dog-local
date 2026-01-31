package org.farhan.common;

public class TestStepdef {

	protected TestObject object;

	public TestStepdef(Object object, String component, String objectName) {
		this.object = (TestObject) object;
		this.object.setComponent(component);
		this.object.setPath(objectName);
	}

}
