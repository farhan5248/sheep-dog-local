package org.farhan.dsl.builder;

import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.SheepDogFactory;

public class SheepDogBuilder {

    public static ITestProject createTestProject() {
        ITestProject testProject = SheepDogFactory.instance.createTestProject();
        return testProject;
    }

    public static IStepDefinition createStepDefinition(IStepObject parent, String name) {
        IStepDefinition stepDefinition = SheepDogFactory.instance.createStepDefinition();
        stepDefinition.setName(name);
        parent.addStepDefinition(stepDefinition);
        return stepDefinition;
    }

    public static IStepObject createStepObject(ITestProject parent, String fullName) {
        IStepObject stepObject = SheepDogFactory.instance.createStepObject();
        stepObject.setFullName(fullName);
        String[] parts = fullName.split("/");
        String lastPart = parts[parts.length - 1];
        String name = lastPart.replaceFirst("\\.[^.]+$", "");
        stepObject.setName(name);
        parent.addStepObject(stepObject);
        return stepObject;
    }

}
