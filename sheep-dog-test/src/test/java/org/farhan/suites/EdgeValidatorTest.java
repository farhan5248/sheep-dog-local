package org.farhan.suites;

import org.farhan.dsl.lang.StepDefinitionRef;
import org.farhan.dsl.lang.StepObjectRef;
import org.farhan.dsl.lang.SheepDogUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeValidatorTest {

    @Test
    public void testIsEdge() {
        Assertions.assertTrue(
                StepObjectRef.isObjectEdgeType("The Something1 application Something2 request is executed with"));
    }

    @Test
    public void testGetAppName() {
        Assertions.assertTrue(
                StepObjectRef.getComponentName("The Something1 application Something2 request is executed with")
                        .contentEquals("Something1"));
    }

    @Test
    public void testGetAppType() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 application Something2 request is executed with")
                        .contentEquals("application"));
    }

    @Test
    public void testGetObjName() {
        Assertions.assertTrue(
                StepObjectRef.getObjectName("The Something1 application Something2 request is executed with")
                        .contentEquals("Something2"));
    }

    @Test
    public void testGetObjTypeRequest() {
        Assertions.assertTrue(
                StepObjectRef.getObjectType("The Something1 application Something2 request is executed with")
                        .contentEquals("request"));
    }

    @Test
    public void testGetObjTypeJob() {
        Assertions.assertTrue(StepObjectRef.getObjectType("The Something1 batchjob Something2 job is executed with")
                .contentEquals("job"));
    }

    @Test
    public void testGetState() {
        Assertions
                .assertTrue(StepDefinitionRef.getState("The Something1 application Something2 request is executed with")
                        .contentEquals("is executed"));
    }

    @Test
    public void testGetStateModality() {
        Assertions.assertTrue(StepDefinitionRef
                .getStateDesc("The Something1 application Something2 request is executed with").contentEquals("is"));
    }

    @Test
    public void testGetStateType() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 request is executed with")
                        .contentEquals("executed"));
    }

    @Test
    public void testGetAttachment() {
        Assertions.assertTrue(StepDefinitionRef
                .getAttachment("The Something1 application Something2 request is executed with").contentEquals("with"));
    }

    @Test
    public void testGetTime() {
        Assertions.assertTrue(StepDefinitionRef
                .getTime("The Something1 application Something2 request is executed on time").contentEquals("on time"));
    }

    @Test
    public void testStateRegexWith() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 request is executed with")
                        .contentEquals("executed"));
    }

    @Test
    public void testStateRegexIsSent() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 request is sent")
                        .contentEquals("sent"));
    }

    @Test
    public void testStateRegexIsPerformed() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is performed")
                        .contentEquals("performed"));
    }

    @Test
    public void testStateRegexIsTriggered() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 request is triggered")
                        .contentEquals("triggered"));
    }

    @Test
    public void testIsNegativeStep() {
        Assertions.assertTrue(
                SheepDogUtility.isNegativeStep("The Something1 application Something2 request isn't executed"));
    }

    @Test
    public void testStateRegexIsntExecuted() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 request isn't executed")
                        .contentEquals("executed"));
    }

    @Test
    public void testStateRegexWillBeExecuted() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 request will be executed")
                        .contentEquals("executed"));
    }

    @Test
    public void testStateRegexWontBeExecuted() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 request won't be executed")
                        .contentEquals("executed"));
    }

    @Test
    public void testObjectRegexGoal() {
        Assertions.assertTrue(
                StepObjectRef.getObjectType("The Something1 application Something2 goal is executed")
                        .contentEquals("goal"));
    }

    @Test
    public void testObjectRegexAction() {
        Assertions.assertTrue(
                StepObjectRef.getObjectType("The Something1 application Something2 action is performed")
                        .contentEquals("action"));
    }

    @Test
    public void testAppRegexService() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 service Something2 request is sent")
                        .contentEquals("service"));
    }

    @Test
    public void testAppRegexApplication() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 application Something2 request is sent")
                        .contentEquals("application"));
    }

    @Test
    public void testAppRegexBatchJob() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 batchjob Something2 request is sent")
                        .contentEquals("batchjob"));
    }

    @Test
    public void testAppRegexPlugIn() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 plugin Something2 request is sent")
                        .contentEquals("plugin"));
    }

    @Test
    public void testTimeRegexAt() {
        Assertions.assertTrue(
                StepDefinitionRef.getTimeType("The Something1 plugin Something2 request is sent at noon")
                        .contentEquals("at"));
    }

    @Test
    public void testTimeRegexBefore() {
        Assertions.assertTrue(
                StepDefinitionRef.getTimeType("The Something1 plugin Something2 request is sent before midday")
                        .contentEquals("before"));
    }

    @Test
    public void testTimeRegexAfter() {
        Assertions.assertTrue(
                StepDefinitionRef.getTimeType("The Something1 plugin Something2 request is sent after the next day")
                        .contentEquals("after"));
    }

    @Test
    public void testTimeRegexIn() {
        Assertions.assertTrue(
                StepDefinitionRef.getTimeType("The Something1 plugin Something2 request is sent in 5 years")
                        .contentEquals("in"));
    }

    @Test
    public void testTimeRegexOnTime() {
        Assertions.assertTrue(
                StepDefinitionRef.getTime("The Something1 plugin Something2 request is sent on time")
                        .contentEquals("on time"));
    }

}
