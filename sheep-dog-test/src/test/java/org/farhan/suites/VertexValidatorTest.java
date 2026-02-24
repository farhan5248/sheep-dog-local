package org.farhan.suites;

import org.farhan.dsl.lang.StepDefinitionRefFragments;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VertexValidatorTest {

    @Test
    public void testIsVertex() {
        Assertions.assertTrue(StepObjectRefFragments
                .isObjectVertexType("The Something1 application Something2 file Something3 type is empty"));
    }

    @Test
    public void testGetAppName() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentName("The Something1 application Something2 file Something3 type is empty")
                .contentEquals("Something1"));
    }

    @Test
    public void testGetAppType() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The Something1 application Something2 file Something3 type is empty")
                .contentEquals("application"));
    }

    @Test
    public void testGetObjName() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectName("The Something1 application Something2 file Something3 type is empty")
                .contentEquals("Something2"));
    }

    @Test
    public void testGetObjType() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 file Something3 type is empty")
                .contentEquals("file"));
    }

    @Test
    public void testGetDetailsName() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getPartDesc("Something3 type is empty").contentEquals("Something3"));
    }

    @Test
    public void testGetDetails() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getPart("Something3 type is empty").contentEquals("Something3 type"));
    }

    @Test
    public void testGetDetailsType() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getPartType("Something3 type is empty").contentEquals("type"));
    }

    @Test
    public void testGetState() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getState("Something3 type is empty").contentEquals("is empty"));
    }

    @Test
    public void testGetStateModality() {
        Assertions
                .assertTrue(StepDefinitionRefFragments.getStateDesc("Something3 type is empty").contentEquals("is"));
    }

    @Test
    public void testGetStateType() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getStateType("Something3 type is empty").contentEquals("empty"));
    }

    @Test
    public void testStateRegexIsSet() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is set").contentEquals("set"));
    }

    @Test
    public void testStateRegexIsUnset() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is unset").contentEquals("unset"));
    }

    @Test
    public void testStateRegexIsEmpty() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is empty").contentEquals("empty"));
    }

    @Test
    public void testStateRegexIsPresent() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is present").contentEquals("present"));
    }

    @Test
    public void testStateRegexIsAbsent() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is absent").contentEquals("absent"));
    }

    @Test
    public void testStateRegexIsEnabled() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is enabled").contentEquals("enabled"));
    }

    @Test
    public void testStateRegexIsDisabled() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is disabled").contentEquals("disabled"));
    }

    @Test
    public void testStateRegexIsDownloaded() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is downloaded").contentEquals("downloaded"));
    }

    @Test
    public void testStateRegexIsUploaded() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is uploaded").contentEquals("uploaded"));
    }

    @Test
    public void testStateRegexAsFollows() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file is created as follows")
                .contentEquals("created"));
    }

    @Test
    public void testGetAttachment() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getAttachment("The Something1 application Something2 file is created as follows")
                .contentEquals("as follows"));
    }

    @Test
    public void testStateRegexIsnt() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file isn't empty").contentEquals("empty"));
    }

    @Test
    public void testStateRegexWillBe() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file will be empty").contentEquals("empty"));
    }

    @Test
    public void testStateRegexWontBe() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The Something1 application Something2 file won't be empty").contentEquals("empty"));
    }

    @Test
    public void testDetailsRegexLanguage() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The Something1 application Something2 file Something3 language is empty")
                .contentEquals("language"));
    }

    @Test
    public void testDetailsRegexType() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The Something1 application Something2 file Something3 type is empty")
                .contentEquals("type"));
    }

    @Test
    public void testDetailsRegexAssignment() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The Something1 application Something2 file Something3 assignment is empty")
                .contentEquals("assignment"));
    }

    @Test
    public void testDetailsRegexFragment() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The Something1 application Something2 file Something3 fragment is empty")
                .contentEquals("fragment"));
    }

    @Test
    public void testDetailsRegexScope() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The Something1 application Something2 file Something3 scope is empty")
                .contentEquals("scope"));
    }

    @Test
    public void testObjectRegexDirectory() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 directory is empty").contentEquals("directory"));
    }

    @Test
    public void testObjectRegexPage() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 page is empty").contentEquals("page"));
    }

    @Test
    public void testObjectRegexDialog() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 dialog is empty").contentEquals("dialog"));
    }

    @Test
    public void testObjectRegexResponse() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 response is empty").contentEquals("response"));
    }

    @Test
    public void testObjectRegexPopup() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 popup is empty").contentEquals("popup"));
    }

    @Test
    public void testObjectRegexAnnotation() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 annotation is empty").contentEquals("annotation"));
    }

    @Test
    public void testObjectRegexHover() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 hover is empty").contentEquals("hover"));
    }

    @Test
    public void testObjectRegexTooltip() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The Something1 application Something2 tooltip is empty").contentEquals("tooltip"));
    }

    @Test
    public void testAppRegexProject() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The Something1 project Something2 file is present").contentEquals("project"));
    }

    @Test
    public void testAppRegexService() {
        Assertions.assertTrue(StepObjectRefFragments.getComponentType("The Something1 service Something2 file is empty")
                .contentEquals("service"));
    }

    @Test
    public void testAppRegexPlugIn() {
        Assertions.assertTrue(StepObjectRefFragments.getComponentType("The Something1 plugin Something2 file is empty")
                .contentEquals("plugin"));
    }

    @Test
    public void testAppRegexBatchJob() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The Something1 batchjob Something2 file is empty").contentEquals("batchjob"));
    }
}
