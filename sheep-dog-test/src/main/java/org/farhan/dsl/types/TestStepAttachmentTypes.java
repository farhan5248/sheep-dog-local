package org.farhan.dsl.types;

public enum TestStepAttachmentTypes {

	WITH("with", "Used to specify plugin parameters"),
	AS_FOLLOWS("as follows", "Used to specify data on a page or in a file");

	public final String value;
	public final String description;

	TestStepAttachmentTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}
