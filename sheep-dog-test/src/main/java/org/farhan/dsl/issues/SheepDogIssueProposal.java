package org.farhan.dsl.issues;

public class SheepDogIssueProposal {

    private String id;
    private String description;
    private String value;
    private String qualifiedName;

    public SheepDogIssueProposal() {
        this.id = "";
        this.description = "";
        this.value = "";
        this.qualifiedName = "";
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public String getQualifiedName() {
        return qualifiedName;
    }

    public String getValue() {
        return value;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQualifiedName(String qualifiedName) {
        this.qualifiedName = qualifiedName;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SheepDogIssueProposal [id=").append(id);
        sb.append(", description=").append(description);
        sb.append(", value=").append(value);
        sb.append(", qualifiedName=").append(qualifiedName);
        sb.append("]");
        return sb.toString();
    }

}
