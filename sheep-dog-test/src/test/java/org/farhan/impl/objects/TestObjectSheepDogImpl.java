package org.farhan.impl.objects;

import java.util.ArrayList;

import org.farhan.common.TestObject;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogFactory;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.impl.ide.SheepDogFactoryImpl;

public class TestObjectSheepDogImpl extends TestObject {

    public static void reset() {
        SheepDogFactory.instance = new SheepDogFactoryImpl();
        ITestProject workspace = SheepDogBuilder.createTestProject();
        setProperty("workspace", workspace);
        setProperty("cursor", workspace);
        setProperty("validate annotation.Content", "");
        setProperty("list proposals popup", new ArrayList<SheepDogIssueProposal>());
        setProperty("list quickfixes popup", new ArrayList<SheepDogIssueProposal>());
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

    protected IDescription getDescriptionFromCursor() {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestSuite)
            return ((ITestSuite) cursor).getDescription();
        else if (cursor instanceof ITestStepContainer)
            return ((ITestStepContainer) cursor).getDescription();
        else if (cursor instanceof IStepObject)
            return ((IStepObject) cursor).getDescription();
        else if (cursor instanceof IStepDefinition)
            return ((IStepDefinition) cursor).getDescription();
        else if (cursor instanceof IStepParameters)
            return ((IStepParameters) cursor).getDescription();
        else if (cursor instanceof ITestData)
            return ((ITestData) cursor).getDescription();
        return null;
    }

}
