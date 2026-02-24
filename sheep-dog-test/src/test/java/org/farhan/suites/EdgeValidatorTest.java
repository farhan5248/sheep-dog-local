package org.farhan.suites;

import org.farhan.dsl.lang.StepDefinitionRefFragments;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeValidatorTest {

    @Test
    public void testIsEdge() {
        Assertions.assertTrue(StepObjectRefFragments
                .isObjectEdgeType("The Something1 application Something2 request is executed with"));
    }

    @Test
    public void testGetAppName() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentName("The Something1 application Something2 request is executed with")
                .contentEquals("Something1"));
    }

    @Test
    public void testGetAppType() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The Something1 application Something2 request is executed with")
                .contentEquals("application"));
    }

    @Test
    public void testGetObjName() {
        Assertions.assertTrue(
                StepObjectRefFragments.getObjectName("The Something1 application Something2 request is executed with")
                        .contentEquals("Something2"));
    }

    @Test
    public void testGetObjTypeRequest() {
        Assertions.assertTrue(
                StepObjectRefFragments.getObjectType("The Something1 application Something2 request is executed with")
                        .contentEquals("request"));
    }

    @Test
    public void testGetObjTypeJob() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 batchjob Something2 job is executed with").contentEquals("job"));
    }

    @Test
    public void testGetState() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getState("The Something1 application Something2 request is executed with")
                        .contentEquals("is executed with"));
    }

    @Test
    public void testGetStateModality() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateDesc("The Something1 application Something2 request is executed with").contentEquals("is"));
    }

    @Test
    public void testGetStateType() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 request is executed with")
                .contentEquals("executed with"));
    }

    @Test
    public void testStateRegexWith() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 request is executed with")
                .contentEquals("executed with"));
    }

    @Test
    public void testStateRegexIsSent() {
        Assertions.assertTrue(StepDefinitionRefFragments.getStateType("is sent").contentEquals("sent"));
    }

    @Test
    public void testStateRegexIsPerformed() {
        Assertions.assertTrue(StepDefinitionRefFragments.getStateType("is performed").contentEquals("performed"));
    }

    @Test
    public void testStateRegexIsTriggered() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 request is triggered").contentEquals("triggered"));
    }

    @Test
    public void testStateRegexIsntExecuted() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getStateType("The Something1 application Something2 request isn't executed")
                        .contentEquals("executed"));
    }

    @Test
    public void testStateRegexWillBeExecuted() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 request will be executed")
                .contentEquals("executed"));
    }

    @Test
    public void testStateRegexWontBeExecuted() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 request won't be executed")
                .contentEquals("executed"));
    }

    @Test
    public void testObjectRegexGoal() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 goal is executed").contentEquals("goal"));
    }

    @Test
    public void testObjectRegexAction() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 action is performed").contentEquals("action"));
    }

    @Test
    public void testAppRegexService() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The Something1 service Something2 request is sent").contentEquals("service"));
    }

    @Test
    public void testAppRegexApplication() {
        Assertions.assertTrue(
                StepObjectRefFragments.getComponentType("The Something1 application Something2 request is sent")
                        .contentEquals("application"));
    }

    @Test
    public void testAppRegexBatchJob() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The Something1 batchjob Something2 request is sent").contentEquals("batchjob"));
    }

    @Test
    public void testAppRegexPlugIn() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The Something1 plugin Something2 request is sent").contentEquals("plugin"));
    }

}
