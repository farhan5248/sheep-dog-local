package org.farhan.dsl.lang;

public class Proposal {

	private String display;
	private String documentation;
	private String replacement;

	public Proposal(String display, String documentation, String replacement) {
		this.display = display;
		this.documentation = documentation;
		this.replacement = replacement;
	}

	public Proposal() {
	}

	public String getDisplay() {
		return display;
	}

	public String getDocumentation() {
		return documentation;
	}

	public String getReplacement() {
		return replacement;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setDocumentation(String documentation) {
		this.documentation = documentation;
	}

	public void setReplacement(String replacement) {
		this.replacement = replacement;
	}

}
