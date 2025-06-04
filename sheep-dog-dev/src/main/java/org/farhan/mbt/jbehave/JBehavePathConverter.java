package org.farhan.mbt.jbehave;

import org.farhan.mbt.core.UMLTestProject;

/**
 * Converts paths between UML and JBehave formats
 * This is a placeholder implementation that will need to be completed with
 * actual JBehave-specific path conversion logic.
 */
public class JBehavePathConverter {

    private UMLTestProject model;
    private JBehaveTestProject project;

    public JBehavePathConverter(UMLTestProject model, JBehaveTestProject project) {
        this.model = model;
        this.project = project;
    }

    /**
     * Convert a UML path to a JBehave file path
     * 
     * @param umlPath The UML path to convert
     * @param layer The layer (TEST_CASES, TEST_STEPS, TEST_OBJECTS)
     * @return The JBehave file path
     */
    public String convertFilePath(String umlPath, String layer) {
        String path = umlPath.replace(".", "/");
        return project.getDir(layer) + "/" + path + project.getFileExt(layer);
    }

    /**
     * Convert a UML path to a JBehave path
     * 
     * @param umlPath The UML path to convert
     * @return The JBehave path
     */
    public String convertUMLPath(String umlPath) {
        // For JBehave, we need to convert from src-gen/test/resources/jbehave/specs/path/to/Story.story
        // to specs.path.to.Story
        
        String path = umlPath;
        
        // Remove the directory prefix
        if (path.startsWith(project.getDir(project.TEST_CASES))) {
            path = path.substring(project.getDir(project.TEST_CASES).length());
        }
        
        // Remove the file extension
        if (path.endsWith(project.getFileExt(project.TEST_CASES))) {
            path = path.substring(0, path.length() - project.getFileExt(project.TEST_CASES).length());
        }
        
        // Convert slashes to dots
        path = path.replace("/", ".");
        
        // Remove leading dot if present
        if (path.startsWith(".")) {
            path = path.substring(1);
        }
        
        return path;
    }

    /**
     * Find the UML path for a JBehave file path
     * 
     * @param path The JBehave file path
     * @return The UML path
     */
    public String findUMLPath(String path) {
        return convertUMLPath(path);
    }
}
