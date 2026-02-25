package org.farhan.suites;

import org.farhan.dsl.lang.StepDefinitionRefFragments;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EdgeValidatorTest {

    @Test
    public void testIsEdge() {
        Assertions.assertTrue(StepObjectRefFragments
                .isObjectEdgeType("The graph-viewer application uml-to-cucumber request is executed with"));
    }

    @Test
    public void testGetAppName() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentName("The graph-viewer application uml-to-cucumber request is executed with")
                .contentEquals("graph-viewer"));
    }

    @Test
    public void testGetAppType() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The graph-viewer application uml-to-cucumber request is executed with")
                .contentEquals("application"));
    }

    @Test
    public void testGetObjName() {
        Assertions.assertTrue(
                StepObjectRefFragments.getObjectName("The graph-viewer application uml-to-cucumber request is executed with")
                        .contentEquals("uml-to-cucumber"));
    }

    @Test
    public void testGetObjTypeRequest() {
        Assertions.assertTrue(
                StepObjectRefFragments.getObjectType("The graph-viewer application uml-to-cucumber request is executed with")
                        .contentEquals("request"));
    }

    @Test
    public void testGetObjTypeJob() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The nightly batchjob process job is executed with").contentEquals("job"));
    }

    @Test
    public void testGetState() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getState("The graph-viewer application uml-to-cucumber request is executed with")
                        .contentEquals("is executed with"));
    }

    @Test
    public void testGetStateModality() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateDesc("The graph-viewer application uml-to-cucumber request is executed with").contentEquals("is"));
    }

    @Test
    public void testGetStateType() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application uml-to-cucumber request is executed with")
                .contentEquals("executed with"));
    }

    @Test
    public void testStateRegexWith() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application uml-to-cucumber request is executed with")
                .contentEquals("executed with"));
    }

    @Test
    public void testStateRegexIsSent() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The sheep-dog-dev-svc service uml-to-cucumber request is sent").contentEquals("sent"));
    }

    @Test
    public void testStateRegexIsPerformed() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The xtext plugin validate action is performed").contentEquals("performed"));
    }

    @Test
    public void testStateRegexIsTriggered() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application uml-to-cucumber request is triggered").contentEquals("triggered"));
    }

    @Test
    public void testStateRegexIsntExecuted() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getStateType("The graph-viewer application uml-to-cucumber request isn't executed")
                        .contentEquals("executed"));
    }

    @Test
    public void testStateRegexWillBeExecuted() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application uml-to-cucumber request will be executed")
                .contentEquals("executed"));
    }

    @Test
    public void testStateRegexWontBeExecuted() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application uml-to-cucumber request won't be executed")
                .contentEquals("executed"));
    }

    @Test
    public void testObjectRegexGoal() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The maven plugin asciidoctor-to-uml goal is executed").contentEquals("goal"));
    }

    @Test
    public void testObjectRegexAction() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The xtext plugin validate action is performed").contentEquals("action"));
    }

    @Test
    public void testAppRegexService() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The sheep-dog-dev-svc service uml-to-cucumber request is sent").contentEquals("service"));
    }

    @Test
    public void testAppRegexApplication() {
        Assertions.assertTrue(
                StepObjectRefFragments.getComponentType("The graph-viewer application uml-to-cucumber request is sent")
                        .contentEquals("application"));
    }

    @Test
    public void testAppRegexBatchJob() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The nightly batchjob uml-to-cucumber request is sent").contentEquals("batchjob"));
    }

    @Test
    public void testAppRegexPlugIn() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The maven plugin uml-to-cucumber request is sent").contentEquals("plugin"));
    }

}
