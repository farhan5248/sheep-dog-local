package org.farhan.dsl.lang;

public enum TestStepDetailTypes {

	SECTION("section", "Used to specify a part in a document"),
	FRAGMENT("fragment", "Used to specify a part in some code"),
	TABLE("table", "Table in a document"),
	SNIPPET("snippet", "Same as fragment"),
	LIST("list", "Same as table");

	public final String value;
	public final String description;

	TestStepDetailTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}