package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.SheepDogBuilder;
import org.farhan.impl.ide.CellImpl;
import org.farhan.impl.ide.RowImpl;
import org.farhan.impl.ide.TableImpl;
import org.farhan.impl.ide.TestStepContainerImpl;
import org.farhan.impl.ide.TestStepImpl;
import org.farhan.impl.ide.TestSuiteImpl;

public class TestIDEElement extends TestObject {

    public static ITestProject testProject;
    public static Object focus;

    public static ArrayList<SheepDogIssueProposal> listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
    public static ArrayList<SheepDogIssueProposal> listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();
    public static String validateDialog = "";

    // TODO elementType needs to go, instead check if focus instanceOf IType and set
    // focus to element type. setType should set the focus. isType does isntance of
    public static TestSuiteImpl testSuite;
    public static TestStepContainerImpl testStepContainer;
    public static TestStepImpl testStep;
    public static ITable stepTable;
    public static IText stepText;
    public static String elementType;

    public void addCell(String name) {
        RowImpl row;
        if (focus instanceof IRow) {
            row = (RowImpl) focus;
        } else {
            row = (RowImpl) ((CellImpl) focus).getParent();
        }
        focus = SheepDogBuilder.createCell(row, name);
    }

    public void addRow() {
        focus = SheepDogBuilder.createRow((ITable) focus);
    }

    public void addTable() {
        focus = SheepDogBuilder.createTable((ITestStep) focus);
        stepTable = (TableImpl) focus;
    }

    public void addTestCaseStep(String stepName) {
        addTestStepContainer("Test Case");
        focus = SheepDogBuilder.createTestStep((ITestStepContainer) focus, stepName);
        testStep = (TestStepImpl) focus;
    }

    public void addTestSetupStep(String stepName) {
        addTestStepContainer("Background");
        focus = SheepDogBuilder.createTestStep((ITestStepContainer) focus, stepName);
        testStep = (TestStepImpl) focus;
    }

    public void addTestStepContainer(String testStepContainerName) {
        addTestSuite("Test Suite");
        if (testStepContainerName.contentEquals("Background")) {
            focus = SheepDogBuilder.createTestSetup((ITestSuite) focus, testStepContainerName);
        } else {
            focus = SheepDogBuilder.createTestCase((ITestSuite) focus, testStepContainerName);
        }
        testStepContainer = (TestStepContainerImpl) focus;
    }

    public void addTestSuite(String testSuiteName) {
        focus = SheepDogBuilder.createTestSuite(testProject, testSuiteName);
        testSuite = (TestSuiteImpl) focus;
    }

    public void addText(String name) {
        focus = SheepDogBuilder.createText((ITestStep) focus, name);
        stepText = (IText) focus;
    }

    public static void applyProposal(ArrayList<SheepDogIssueProposal> proposals) throws Exception {
        for (SheepDogIssueProposal p : proposals) {
            if (!p.getQualifiedName().isEmpty()) {
                IStepObject stepObject = SheepDogBuilder.createStepObject(null, p.getQualifiedName());
                stepObject.setContent(p.getValue());
                testProject.addStepObject(stepObject);
            }
        }
    }

    public static void reset() {
        testProject = SheepDogBuilder.createTestProject();
        focus = testProject;

        validateDialog = "";
        listProposalsDialog = new ArrayList<SheepDogIssueProposal>();
        listQuickfixesDialog = new ArrayList<SheepDogIssueProposal>();

        testSuite = null;
        testStepContainer = null;
        testStep = null;
        stepTable = null;
        stepText = null;
        elementType = null;
    }

    public static void setElementType(String name) {
        // TODO this should be a full path up to the element so that it can be found in
        // the tree and assigned to focus
        elementType = name;
    }

    public static boolean isElementType(String name) {

        /*
         * TODO once setElementType is changed, then this will apply if
         * (name.equals("Test Suite")) { return focus instanceof ITestSuite; } else if
         * (name.equals("Test Step Container")) { return focus instanceof
         * ITestStepContainer; } else if (name.equals("Test Step")) { return focus
         * instanceof ITestStep; } else if (name.equals("Row")) { return focus
         * instanceof IRow; } else if (name.equals("Cell")) { return focus instanceof
         * ICell; } else if (name.equals("Text")) { return focus instanceof IText; }
         * return false;
         */
        return elementType.contentEquals(name);
    }

}
