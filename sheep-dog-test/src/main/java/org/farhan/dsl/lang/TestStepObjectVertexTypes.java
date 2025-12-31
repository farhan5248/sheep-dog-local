package org.farhan.dsl.lang;

public enum TestStepObjectVertexTypes {

	FILE("file", "Any sort of file"),
	PAGE("page", "Web page"),
	RESPONSE("response", "Web service response"),
	DIALOG("dialog", "Window dialog box"),
	DIRECTORY("directory", "File directory");

	public final String value;
	public final String description;

	TestStepObjectVertexTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}