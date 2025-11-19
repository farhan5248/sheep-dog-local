package org.farhan.dsl.types;

public enum TestStepTimeTypes {

	AT(" at", "Specifies exact time"),
	BEFORE(" before", "Specifies time constraint - earlier than"),
	AFTER(" after", "Specifies time constraint - later than"),
	IN(" in", "Specifies duration or time period"),
	ON(" on", "Specifies specific date or time");

	public final String value;
	public final String description;

	TestStepTimeTypes(String value, String description) {
		this.value = value;
		this.description = description;
	}
}