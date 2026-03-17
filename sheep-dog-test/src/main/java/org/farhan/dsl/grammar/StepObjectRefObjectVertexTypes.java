package org.farhan.dsl.grammar;

public enum StepObjectRefObjectVertexTypes {

    FILE("file", "Any sort of file"),
    DIRECTORY("directory", "File directory"),
    PAGE("page", "Web page"),
    DIALOG("dialog", "Window dialog box"),
    RESPONSE("response", "Web service response"),
    POPUP("popup", "List of options for quickfix or content proposal"),
    ANNOTATION("annotation", "Visual indicator for error or warning messages"),
    HOVER("hover", "Popup displaying information on mouse hover"),
    TOOLTIP("tooltip", "Small popup displaying descriptive text");

    public final String value;
    public final String description;

    StepObjectRefObjectVertexTypes(String value, String description) {
        this.value = value;
        this.description = description;
    }

}
