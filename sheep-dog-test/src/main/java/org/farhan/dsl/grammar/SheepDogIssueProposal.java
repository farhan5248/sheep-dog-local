package org.farhan.dsl.grammar;

public class SheepDogIssueProposal {

    private String id = "";
    private String description = "";
    private Object value = "";

    public SheepDogIssueProposal() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String toString() {
        return id + " " + description + " " + value;
    }

}
