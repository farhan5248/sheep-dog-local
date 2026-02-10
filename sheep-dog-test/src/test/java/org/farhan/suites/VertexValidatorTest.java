package org.farhan.suites;

import org.farhan.dsl.lang.StepDefinitionRef;
import org.farhan.dsl.lang.StepObjectRef;
import org.farhan.dsl.lang.SheepDogUtility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VertexValidatorTest {

    @Test
    public void testIsVertex() {
        Assertions.assertTrue(StepObjectRef
                .isObjectVertexType("The Something1 application Something2 file Something3 section is empty"));
    }

    @Test
    public void testGetAppName() {
        Assertions.assertTrue(
                StepObjectRef.getComponentName("The Something1 application Something2 file Something3 section is empty")
                        .contentEquals("Something1"));
    }

    @Test
    public void testGetAppType() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 application Something2 file Something3 section is empty")
                        .contentEquals("application"));
    }

    @Test
    public void testGetObjName() {
        Assertions.assertTrue(
                StepObjectRef.getObjectName("The Something1 application Something2 file Something3 section is empty")
                        .contentEquals("Something2"));
    }

    @Test
    public void testGetObjType() {
        Assertions.assertTrue(
                StepObjectRef.getObjectType("The Something1 application Something2 file Something3 section is empty")
                        .contentEquals("file"));
    }

    @Test
    public void testGetDetailsName() {
        Assertions.assertTrue(
                StepDefinitionRef.getPartDesc("Something3 section is empty")
                        .contentEquals("Something3"));
    }

    @Test
    public void testGetDetails() {
        Assertions.assertTrue(
                StepDefinitionRef.getPart("Something3 section is empty")
                        .contentEquals("Something3 section"));
    }

    @Test
    public void testGetDetailsType() {
        Assertions.assertTrue(
                StepDefinitionRef.getPartType("Something3 section is empty")
                        .contentEquals("section"));
    }

    @Test
    public void testGetState() {
        Assertions.assertTrue(
                StepDefinitionRef.getState("Something3 section is empty")
                        .contentEquals("is empty"));
    }

    @Test
    public void testGetStateModality() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateDesc("Something3 section is empty")
                        .contentEquals("is"));
    }

    @Test
    public void testGetStateType() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("Something3 section is empty")
                        .contentEquals("empty"));
    }

    @Test
    public void testStateRegexIsSet() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is set")
                        .contentEquals("set"));
    }

    @Test
    public void testStateRegexIsUnset() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is unset")
                        .contentEquals("unset"));
    }

    @Test
    public void testStateRegexIsEmpty() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is empty")
                        .contentEquals("empty"));
    }

    @Test
    public void testStateRegexIsPresent() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is present")
                        .contentEquals("present"));
    }

    @Test
    public void testStateRegexIsAbsent() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is absent")
                        .contentEquals("absent"));
    }

    @Test
    public void testStateRegexIsEnabled() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is enabled")
                        .contentEquals("enabled"));
    }

    @Test
    public void testStateRegexIsDisabled() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is disabled")
                        .contentEquals("disabled"));
    }

    @Test
    public void testStateRegexIsDownloaded() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is downloaded")
                        .contentEquals("downloaded"));
    }

    @Test
    public void testStateRegexIsUploaded() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is uploaded")
                        .contentEquals("uploaded"));
    }

    @Test
    public void testStateRegexAsFollows() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file is created as follows")
                        .contentEquals("created"));
    }

    @Test
    public void testGetAttachment() {
        Assertions.assertTrue(
                StepDefinitionRef.getAttachment("The Something1 application Something2 file is created as follows")
                        .contentEquals("as follows"));
    }

    @Test
    public void testIsNegativeStep() {
        Assertions.assertTrue(
                SheepDogUtility.isNegativeStep("The Something1 application Something2 file isn't empty"));
    }

    @Test
    public void testStateRegexIsnt() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file isn't empty")
                        .contentEquals("empty"));
    }

    @Test
    public void testStateRegexWillBe() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file will be empty")
                        .contentEquals("empty"));
    }

    @Test
    public void testStateRegexWontBe() {
        Assertions.assertTrue(
                StepDefinitionRef.getStateType("The Something1 application Something2 file won't be empty")
                        .contentEquals("empty"));
    }

    @Test
    public void testDetailsRegexSection() {
        Assertions.assertTrue(
                StepDefinitionRef.getPartType("The Something1 application Something2 file Something3 section is empty")
                        .contentEquals("section"));
    }

    @Test
    public void testDetailsRegexList() {
        Assertions.assertTrue(
                StepDefinitionRef.getPartType("The Something1 application Something2 file Something3 list is empty")
                        .contentEquals("list"));
    }

    @Test
    public void testDetailsRegexFragment() {
        Assertions.assertTrue(
                StepDefinitionRef.getPartType("The Something1 application Something2 file Something3 fragment is empty")
                        .contentEquals("fragment"));
    }

    @Test
    public void testDetailsRegexTable() {
        Assertions.assertTrue(
                StepDefinitionRef.getPartType("The Something1 application Something2 file Something3 table is empty")
                        .contentEquals("table"));
    }

    @Test
    public void testDetailsRegexSnippet() {
        Assertions.assertTrue(
                StepDefinitionRef.getPartType("The Something1 application Something2 file Something3 snippet is empty")
                        .contentEquals("snippet"));
    }

    @Test
    public void testObjectRegexDirectory() {
        Assertions.assertTrue(
                StepObjectRef.getObjectType("The Something1 application Something2 directory is empty")
                        .contentEquals("directory"));
    }

    @Test
    public void testObjectRegexPage() {
        Assertions.assertTrue(
                StepObjectRef.getObjectType("The Something1 application Something2 page is empty")
                        .contentEquals("page"));
    }

    @Test
    public void testObjectRegexDialog() {
        Assertions.assertTrue(
                StepObjectRef.getObjectType("The Something1 application Something2 dialog is empty")
                        .contentEquals("dialog"));
    }

    @Test
    public void testObjectRegexResponse() {
        Assertions.assertTrue(
                StepObjectRef.getObjectType("The Something1 application Something2 response is empty")
                        .contentEquals("response"));
    }

    @Test
    public void testAppRegexProject() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 project Something2 file is present")
                        .contentEquals("project"));
    }

    @Test
    public void testAppRegexService() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 service Something2 file is empty")
                        .contentEquals("service"));
    }

    @Test
    public void testAppRegexPlugIn() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 plugin Something2 file is empty")
                        .contentEquals("plugin"));
    }

    @Test
    public void testAppRegexBatchJob() {
        Assertions.assertTrue(
                StepObjectRef.getComponentType("The Something1 batchjob Something2 file is empty")
                        .contentEquals("batchjob"));
    }
}
