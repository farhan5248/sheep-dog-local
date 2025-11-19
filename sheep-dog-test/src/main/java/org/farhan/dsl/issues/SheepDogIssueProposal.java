package org.farhan.dsl.issues;

public class SheepDogIssueProposal {

	private String id;
	private String description;
	private String value;

	public SheepDogIssueProposal() {
		this.id = "";
		this.description = "";
		this.value = "";
	}

	public SheepDogIssueProposal(String id, String description, String value) {
		this.id = id;
		this.description = description;
		this.value = value;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getValue() {
		return value;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
