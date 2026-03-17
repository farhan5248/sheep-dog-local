package org.farhan.dsl.grammar;

public enum StepDefinitionRefPartTypes {

    TYPE("type", "Grammar types (non-terminal rules) defined in the .xtext file"),
    LANGUAGE("language", "The name of the Xtext grammar/language implementation"),
    ASSIGNMENT("assignment", "Named assignments within grammar rules"),
    FRAGMENT("fragment", "Test step regex fragments defining type enumerations"),
    SCOPE("scope", "Issue scope levels from TypeIssueTypes enum"),
    NODE("node", "AST node elements in the parsed syntax tree");

    public final String value;
    public final String description;

    StepDefinitionRefPartTypes(String value, String description) {
        this.value = value;
        this.description = description;
    }

}
