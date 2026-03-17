package org.farhan.impl.objects;

import org.farhan.common.TestObject;
import org.farhan.dsl.builder.SheepDogBuilder;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.SheepDogFactory;
import org.farhan.dsl.grammar.SheepDogFactoryImpl;

public class TestObjectSheepDogImpl extends TestObject {

    public static void reset() {
        SheepDogFactory.instance = new SheepDogFactoryImpl();
        setProperty("workspace", SheepDogBuilder.createTestProject());
    }

    @Override
    protected Object getOrCreateNode(Object parent, String elementType, int index) {
        return null;
    }

    protected void addStepDefinitionWithName(String name) {
        IStepObject parent = (IStepObject) getProperty("cursor");
        IStepDefinition stepDef = SheepDogBuilder.createStepDefinition(parent, name);
        setProperty("cursor", stepDef);
    }

    protected void addStepObjectWithFullName(String fullName) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        IStepObject stepObject = SheepDogBuilder.createStepObject(workspace, fullName);
        setProperty("cursor", stepObject);
    }

}
