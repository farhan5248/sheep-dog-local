package org.farhan.dsl.types;

public enum TestStepStateModalityTypes {

	IS("is", "Maps to setter method"),
	ISNT("isn't", "Maps to setter method but used to remove something"),
	WILL_BE("will be", "Maps to assertion method"),
	WONT_BE("won't be", "Maps to assertion method for negative testing");

	public final String value;
	public final String description;

	TestStepStateModalityTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}