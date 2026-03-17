package org.farhan.impl.objects;

import org.farhan.common.TestObject;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogFactory;
import org.farhan.impl.ide.SheepDogFactoryImpl;

public class TestObjectSheepDogImpl extends TestObject {

    public static void reset() {
        SheepDogFactory.instance = new SheepDogFactoryImpl();
        setProperty("workspace", SheepDogBuilder.createTestProject());
    }

    @Override
    protected Object getOrCreateNode(Object parent, String elementType, int index) {
        if ("StepDefinitionList".equals(elementType) && parent instanceof IStepObject) {
            IStepObject stepObject = (IStepObject) parent;
            if (index < stepObject.getStepDefinitionList().size()) {
                return stepObject.getStepDefinition(index);
            }
            return SheepDogBuilder.createStepDefinition(stepObject, "StepDefinition" + (index + 1));
        }
        if ("StepParametersList".equals(elementType) && parent instanceof IStepDefinition) {
            IStepDefinition stepDef = (IStepDefinition) parent;
            if (index < stepDef.getStepParameterList().size()) {
                return stepDef.getStepParameters(index);
            }
            return SheepDogBuilder.createStepParameters(stepDef, "StepParameters" + (index + 1));
        }
        return null;
    }

    protected void addStepDefinitionWithName(String name) {
        IStepObject parent = (IStepObject) getProperty("cursor");
        IStepDefinition stepDef = SheepDogBuilder.createStepDefinition(parent, name);
        setProperty("cursor", stepDef);
    }

    protected void addStepParametersWithName(String name) {
        IStepDefinition parent = (IStepDefinition) getProperty("cursor");
        IStepParameters stepParams = SheepDogBuilder.createStepParameters(parent, name);
        setProperty("cursor", stepParams);
    }

    protected void addTestSuiteWithFullName(String fullName) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestSuite testSuite = SheepDogBuilder.createTestSuite(workspace, fullName);
        setProperty("cursor", testSuite);
    }

    protected void addStepObjectWithFullName(String fullName) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        IStepObject stepObject = SheepDogBuilder.createStepObject(workspace, fullName);
        setProperty("cursor", stepObject);
    }

    protected void addTestCaseWithName(String name) {
        ITestSuite parent = (ITestSuite) getProperty("cursor");
        ITestCase testCase = SheepDogBuilder.createTestCase(parent, name);
        setProperty("cursor", testCase);
    }

}
