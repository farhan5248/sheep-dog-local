package org.farhan.mbt.jbehave;

import java.util.ArrayList;

/**
 * Represents a JBehave interface for step definitions
 * This is a placeholder implementation that will need to be completed with
 * actual JBehave-specific code generation logic.
 */
public class JBehaveInterface extends JBehaveJava {

    public JBehaveInterface(String path) {
        super(path);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Package declaration
        sb.append("package ").append(packageName).append(";\n\n");
        
        // Imports
        sb.append("import java.util.HashMap;\n");
        
        for (String importStatement : imports) {
            sb.append("import ").append(importStatement).append(";\n");
        }
        sb.append("\n");
        
        // Interface declaration
        sb.append("public interface ").append(className).append(" {\n\n");
        
        // Method declarations for step definitions
        for (String stepDefinition : stepDefinitions) {
            String stepName = stepDefinition;
            if (stepName.contains(":")) {
                stepName = stepName.substring(stepName.indexOf(":") + 1).trim();
            }
            
            // Convert step name to method name
            String methodName = "set" + stepNameToMethodName(stepName, true);
            
            sb.append("    public void ").append(methodName).append("(HashMap<String, String> keyMap);\n\n");
        }
        
        // Close interface
        sb.append("}\n");
        
        return sb.toString();
    }
    
    /**
     * Convert a step name to a valid Java method name
     * 
     * @param stepName The step name to convert
     * @param capitalize Whether to capitalize the first letter
     * @return A valid Java method name
     */
    private String stepNameToMethodName(String stepName, boolean capitalize) {
        // Replace spaces and special characters with underscores
        String methodName = stepName.replaceAll("[^a-zA-Z0-9]", "_");
        
        // Ensure the method name starts with the correct case
        if (!methodName.isEmpty()) {
            if (capitalize) {
                methodName = Character.toUpperCase(methodName.charAt(0)) + methodName.substring(1);
            } else {
                methodName = Character.toLowerCase(methodName.charAt(0)) + methodName.substring(1);
            }
        }
        
        return methodName;
    }
}
