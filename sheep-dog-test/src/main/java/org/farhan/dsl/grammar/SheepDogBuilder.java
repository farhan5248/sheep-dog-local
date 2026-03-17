package org.farhan.dsl.grammar;

import org.slf4j.Logger;

public class SheepDogBuilder {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(SheepDogBuilder.class);

    public static ITestProject createTestProject() {
        logger.debug("createTestProject()");
        ITestProject testProject = SheepDogFactory.instance.createTestProject();
        logger.debug("createTestProject() = {}", testProject);
        return testProject;
    }

    public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
        logger.debug("createStepDefinition(parent={}, name={})", parent, name);
        IStepDefinition stepDefinition = null;
        if (parent != null)
            stepDefinition = parent.getStepDefinition(name);
        if (stepDefinition == null) {
            stepDefinition = SheepDogFactory.instance.createStepDefinition();
            stepDefinition.setName(name);
            if (parent != null)
                parent.addStepDefinition(stepDefinition);
        }
        logger.debug("createStepDefinition() = {}", stepDefinition);
        return stepDefinition;
    }

    public static IStepParameters createStepParameters(IStepDefinition parent, String name) {
        logger.debug("createStepParameters(parent={}, name={})", parent, name);
        IStepParameters stepParameters = null;
        if (parent != null)
            stepParameters = parent.getStepParameters(name);
        if (stepParameters == null) {
            stepParameters = SheepDogFactory.instance.createStepParameters();
            stepParameters.setName(name);
            if (parent != null)
                parent.addStepParameters(stepParameters);
        }
        logger.debug("createStepParameters() = {}", stepParameters);
        return stepParameters;
    }

    public static IStepObject createStepObject(ITestProject parent, String fullName) {
        logger.debug("createStepObject(parent={}, fullName={})", parent, fullName);
        IStepObject stepObject = SheepDogFactory.instance.createStepObject();
        stepObject.setFullName(fullName);
        String[] parts = fullName.split("/");
        String lastPart = parts[parts.length - 1];
        String name = lastPart.replaceFirst("\\.[^.]+$", "");
        stepObject.setName(name);
        if (parent != null)
            parent.addStepObject(stepObject);
        logger.debug("createStepObject() = {}", stepObject);
        return stepObject;
    }

}
