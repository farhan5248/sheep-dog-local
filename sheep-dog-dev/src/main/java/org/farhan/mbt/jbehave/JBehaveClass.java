package org.farhan.mbt.jbehave;

import java.util.ArrayList;

/**
 * Represents a JBehave step definition class
 * This is a placeholder implementation that will need to be completed with
 * actual JBehave-specific code generation logic.
 */
public class JBehaveClass extends JBehaveJava {

    public JBehaveClass(String path) {
        super(path);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Package declaration
        sb.append("package ").append(packageName).append(";\n\n");
        
        // Imports
        sb.append("import org.jbehave.core.annotations.Given;\n");
        sb.append("import org.jbehave.core.annotations.When;\n");
        sb.append("import org.jbehave.core.annotations.Then;\n");
        sb.append("import org.jbehave.core.annotations.Alias;\n");
        sb.append("import org.jbehave.core.model.ExamplesTable;\n");
        
        for (String importStatement : imports) {
            sb.append("import ").append(importStatement).append(";\n");
        }
        sb.append("\n");
        
        // Class declaration
        sb.append("public class ").append(className).append(" {\n\n");
        
        // Constructor
        sb.append("    public ").append(className).append("() {\n");
        sb.append("        // TODO: Initialize JBehave step definition class\n");
        sb.append("    }\n\n");
        
        // Step definitions
        for (String stepDefinition : stepDefinitions) {
            // Extract the step type (Given, When, Then) from the step name
            String stepType = "Given";
            if (stepDefinition.startsWith("When:")) {
                stepType = "When";
            } else if (stepDefinition.startsWith("Then:")) {
                stepType = "Then";
            }
            
            String stepName = stepDefinition.substring(stepDefinition.indexOf(" ") + 1);
            
            sb.append("    @").append(stepType).append("(\"").append(stepName).append("\")\n");
            sb.append("    public void ").append(stepNameToMethodName(stepName)).append("() {\n");
            sb.append("        // TODO: Implement step definition\n");
            sb.append("    }\n\n");
        }
        
        // Close class
        sb.append("}\n");
        
        return sb.toString();
    }
    
    /**
     * Convert a step name to a valid Java method name
     */
    private String stepNameToMethodName(String stepName) {
        // Replace spaces and special characters with underscores
        String methodName = stepName.replaceAll("[^a-zA-Z0-9]", "_");
        
        // Ensure the method name starts with a lowercase letter
        if (!methodName.isEmpty()) {
            methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);
        }
        
        return methodName;
    }
}
