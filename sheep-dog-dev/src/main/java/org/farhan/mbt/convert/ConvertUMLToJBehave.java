package org.farhan.mbt.convert;

import java.util.ArrayList;

import org.farhan.mbt.core.UMLStepDefinition;
import org.farhan.mbt.core.UMLStepObject;
import org.farhan.mbt.core.UMLTestCase;
import org.farhan.mbt.core.UMLTestData;
import org.farhan.mbt.core.UMLTestProject;
import org.farhan.mbt.core.UMLTestSetup;
import org.farhan.mbt.core.UMLTestStep;
import org.farhan.mbt.core.UMLTestSuite;
import org.farhan.mbt.jbehave.JBehaveFeature;
import org.farhan.mbt.jbehave.JBehaveJava;
import org.farhan.mbt.jbehave.JBehavePathConverter;
import org.farhan.mbt.jbehave.JBehaveTestProject;

/**
 * Converts UML models to JBehave stories
 * This is a placeholder implementation that will need to be completed with
 * actual JBehave-specific conversion logic.
 */
public class ConvertUMLToJBehave extends Converter {

    protected UMLTestSuite srcObj;
    protected JBehaveFeature tgtObjTestSuite;
    protected JBehaveJava tgtObjStepObject;
    protected JBehavePathConverter pathConverter;

    public ConvertUMLToJBehave(String tags, ObjectRepository fa, Logger log) {
        super(tags, fa, log);
    }

    @Override
    public String convertFile(String path, String content) throws Exception {
        initProjects();
        if (path.startsWith(project.getDir(project.TEST_CASES))) {
            return convertTestSuite(path, content);
        } else {
            return convertStepObject(path, content);
        }
    }

    protected String convertStepObject(String path, String content) throws Exception {
        log.debug("step object: " + path);
        
        // TODO: Implement actual conversion from UML to JBehave step objects
        // This would involve:
        // 1. Getting the UML step object
        // 2. Creating a JBehave step object (class or interface)
        // 3. Converting the step definitions
        
        // For now, we'll create a simple placeholder
        UMLStepObject srcStepObject = model.getStepObject(pathConverter.findUMLPath(path));
        
        if (path.startsWith(project.getDir(project.TEST_STEPS))) {
            tgtObjStepObject = (JBehaveJava) project.addFile(path);
        } else {
            tgtObjStepObject = (JBehaveJava) project.addFile(path);
        }
        
        tgtObjStepObject.parse(content);
        
        // Add placeholder step definitions
        for (UMLStepDefinition srcStepDefinition : srcStepObject.getStepDefinitionList()) {
            ArrayList<String> parameters = new ArrayList<>();
            tgtObjStepObject.addStepDefinition(srcStepDefinition.getNameLong(), parameters);
        }
        
        return tgtObjStepObject.toString();
    }

    protected String convertTestSuite(String path, String content) throws Exception {
        log.debug("test suite: " + path);
        
        // TODO: Implement actual conversion from UML to JBehave stories
        // This would involve:
        // 1. Getting the UML test suite
        // 2. Creating a JBehave story
        // 3. Converting test cases, test steps, etc.
        
        // For now, we'll create a simple placeholder
        UMLTestSuite srcTestSuite = model.getTestSuite(pathConverter.findUMLPath(path));
        tgtObjTestSuite = (JBehaveFeature) project.addFile(path);
        tgtObjTestSuite.parse(content);
        
        // Create a simple JBehave story
        StringBuilder storyBuilder = new StringBuilder();
        
        // Add narrative
        storyBuilder.append("Narrative:\n");
        storyBuilder.append("In order to ").append(srcTestSuite.getName()).append("\n");
        storyBuilder.append("As a user\n");
        storyBuilder.append("I want to execute this story\n\n");
        
        // Add description if available
        if (srcTestSuite.getDescription() != null && !srcTestSuite.getDescription().isEmpty()) {
            storyBuilder.append(srcTestSuite.getDescription()).append("\n\n");
        }
        
        // Add scenarios for each test case
        for (UMLTestCase testCase : srcTestSuite.getTestCaseList()) {
            storyBuilder.append("Scenario: ").append(testCase.getName()).append("\n\n");
            
            // Add description if available
            if (testCase.getDescription() != null && !testCase.getDescription().isEmpty()) {
                storyBuilder.append(testCase.getDescription()).append("\n\n");
            }
            
            // Add steps
            for (UMLTestStep step : testCase.getTestStepList()) {
                storyBuilder.append(step.getNameLong()).append("\n");
            }
            
            storyBuilder.append("\n");
        }
        
        // Return the generated story
        return storyBuilder.toString();
    }

    @Override
    public ArrayList<String> getFileNames() throws Exception {
        initProjects();
        ArrayList<String> objects = new ArrayList<String>();
        
        // Add test suites (stories)
        for (UMLTestSuite co : model.getTestSuiteList()) {
            objects.add(pathConverter.convertFilePath(co.getUmlElement().getQualifiedName(), project.TEST_CASES));
        }
        
        // Add step objects (classes and interfaces)
        for (UMLStepObject co : model.getStepObjectList()) {
            objects.add(pathConverter.convertFilePath(co.getUmlElement().getQualifiedName(), project.TEST_STEPS));
            objects.add(pathConverter.convertFilePath(co.getUmlElement().getQualifiedName(), project.TEST_OBJECTS));
        }
        
        return objects;
    }

    public void initProjects() throws Exception {
        model = new UMLTestProject(this.tags, this.fa);
        project = new JBehaveTestProject(this.tags, this.fa);
        model.init();
        project.init();
        this.pathConverter = new JBehavePathConverter(model, (JBehaveTestProject) project);
    }
}
