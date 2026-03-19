package org.farhan.impl.objects;

import org.farhan.common.TestObject;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestCase;
import org.farhan.dsl.grammar.ITestData;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.dsl.grammar.SheepDogBuilder;
import org.farhan.dsl.grammar.SheepDogFactory;
import org.farhan.impl.ide.SheepDogFactoryImpl;

public class TestObjectSheepDogImpl extends TestObject {

    public static void reset() {
        SheepDogFactory.instance = new SheepDogFactoryImpl();
        ITestProject workspace = SheepDogBuilder.createTestProject();
        setProperty("workspace", workspace);
        setProperty("cursor", workspace);
    }

    protected void addStepObjectWithFullName(String stepObjectFullName) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepObject) {
            cursor = ((IStepObject) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createStepObject((ITestProject) getProperty("workspace"), stepObjectFullName));
    }

    protected void addTestSuiteWithFullName(String testSuiteFullName) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof ITestSuite) {
            cursor = ((ITestSuite) cursor).getParent();
        }
        setProperty("cursor",
                SheepDogBuilder.createTestSuite((ITestProject) getProperty("workspace"), testSuiteFullName));
    }

    protected void addStepDefinitionWithName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepDefinition) {
            cursor = ((IStepDefinition) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createStepDefinition((IStepObject) cursor, name));
    }

    protected void addStepParametersWithName(String name) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepParameters) {
            cursor = ((IStepParameters) cursor).getParent();
        }
        setProperty("cursor", SheepDogBuilder.createStepParameters((IStepDefinition) cursor, name));
    }

    protected String getDocumentFromWorkspaceAsString() {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
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

    @Override
    protected Object getOrCreateNode(Object parent, String elementType, int index) {
        switch (elementType) {
        case "Table": {
            Object child = getChildNode(parent, elementType, index);
            if (child != null)
                return child;
            if (parent instanceof ITestStep)
                return SheepDogBuilder.createTable((ITestStep) parent);
            if (parent instanceof ITestData)
                return SheepDogBuilder.createTable((ITestData) parent);
            return SheepDogBuilder.createTable((IStepParameters) parent);
        }
        case "Description": {
            Object child = getChildNode(parent, elementType, index);
            if (child != null)
                return child;
            if (parent instanceof ITestSuite)
                return SheepDogBuilder.createDescription((ITestSuite) parent);
            if (parent instanceof ITestStepContainer)
                return SheepDogBuilder.createDescription((ITestStepContainer) parent);
            if (parent instanceof IStepObject)
                return SheepDogBuilder.createDescription((IStepObject) parent);
            if (parent instanceof IStepDefinition)
                return SheepDogBuilder.createDescription((IStepDefinition) parent);
            if (parent instanceof IStepParameters)
                return SheepDogBuilder.createDescription((IStepParameters) parent);
            return SheepDogBuilder.createDescription((ITestData) parent);
        }
        default:
            try {
                return getChildNode(parent, elementType, index);
            } catch (IndexOutOfBoundsException e) {
                switch (elementType) {
                case "TestStepContainerList":
                    return SheepDogBuilder.createTestCase((ITestSuite) parent, "Test Case");
                case "TestStepList":
                    return SheepDogBuilder.createTestStep((ITestStepContainer) parent, "");
                case "RowList":
                    return SheepDogBuilder.createRow((ITable) parent);
                case "CellList":
                    return SheepDogBuilder.createCell((IRow) parent, "");
                case "StepDefinitionList":
                    return SheepDogBuilder.createStepDefinition((IStepObject) parent, "");
                case "StepParametersList":
                    return SheepDogBuilder.createStepParameters((IStepDefinition) parent, "");
                case "LineList":
                    return SheepDogBuilder.createLine((IDescription) parent, "");
                case "TestDataList":
                    return SheepDogBuilder.createTestData((ITestCase) parent, "");
                default:
                    throw new IllegalArgumentException("Unknown element type: " + elementType);
                }
            }
        }
    }

}
