package org.farhan.dsl.lang;

/**
 * Data transfer object holding quick fix proposal data.
 * <p>
 * Separates proposal data (id, description, value) from proposal
 * generation and application logic.
 * </p>
 */
public class SheepDogIssueProposal {

    private String id;
    private String description;
    private Object value;

    /**
     * Initializes all proposal fields to empty strings for subsequent population.
     */
    public SheepDogIssueProposal() {
        this.id = "";
        this.description = "";
        this.value = "";
    }

    /**
     * Provides read access to proposal attributes, allowing resolvers and UI to
     * query proposal details.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Provides read access to proposal attributes, allowing resolvers and UI to
     * query proposal details.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Provides read access to proposal attributes, allowing resolvers and UI to
     * query proposal details.
     *
     * @return the value
     */
    public Object getValue() {
        return value;
    }

    /**
     * Provides write access for resolvers to populate proposal attributes during
     * generation.
     *
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Provides write access for resolvers to populate proposal attributes during
     * generation.
     *
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Provides write access for resolvers to populate proposal attributes during
     * generation.
     *
     * @param value the value to set
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * Generates formatted string representation for debugging and logging purposes.
     *
     * @return string representation of the proposal
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("SheepDogIssueProposal [id=").append(id);
        sb.append(", description=").append(description);
        sb.append(", value=").append(value);
        sb.append("]");
        return sb.toString();
    }

}
