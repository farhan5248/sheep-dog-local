package org.farhan.suites;

import org.farhan.dsl.lang.StepDefinitionRefFragments;
import org.farhan.dsl.lang.StepObjectRefFragments;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VertexValidatorTest {

    @Test
    public void testIsVertex() {
        Assertions.assertTrue(StepObjectRefFragments
                .isObjectVertexType("The graph-viewer application validate annotation file StepObjectRef type is empty"));
    }

    @Test
    public void testGetAppName() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentName("The graph-viewer application validate annotation file StepObjectRef type is empty")
                .contentEquals("graph-viewer"));
    }

    @Test
    public void testGetAppType() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The graph-viewer application validate annotation file StepObjectRef type is empty")
                .contentEquals("application"));
    }

    @Test
    public void testGetObjName() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectName("The graph-viewer application validate annotation file StepObjectRef type is empty")
                .contentEquals("validate annotation"));
    }

    @Test
    public void testGetObjType() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The graph-viewer application validate annotation file StepObjectRef type is empty")
                .contentEquals("file"));
    }

    @Test
    public void testGetDetailsName() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getPartDesc("StepObjectRef type is empty").contentEquals("StepObjectRef"));
    }

    @Test
    public void testGetDetails() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getPart("StepObjectRef type is empty").contentEquals("StepObjectRef type"));
    }

    @Test
    public void testGetDetailsType() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getPartType("The graph-viewer application validate annotation file StepObjectRef type is empty").contentEquals("type"));
    }

    @Test
    public void testGetState() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getState("The graph-viewer application validate annotation file StepObjectRef type is empty").contentEquals("is empty"));
    }

    @Test
    public void testGetStateModality() {
        Assertions
                .assertTrue(StepDefinitionRefFragments.getStateDesc("The graph-viewer application validate annotation file StepObjectRef type is empty").contentEquals("is"));
    }

    @Test
    public void testGetStateType() {
        Assertions.assertTrue(
                StepDefinitionRefFragments.getStateType("The graph-viewer application validate annotation file StepObjectRef type is empty").contentEquals("empty"));
    }

    @Test
    public void testStateRegexIsSet() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is set").contentEquals("set"));
    }

    @Test
    public void testStateRegexIsUnset() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is unset").contentEquals("unset"));
    }

    @Test
    public void testStateRegexIsEmpty() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is empty").contentEquals("empty"));
    }

    @Test
    public void testStateRegexIsPresent() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is present").contentEquals("present"));
    }

    @Test
    public void testStateRegexIsAbsent() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is absent").contentEquals("absent"));
    }

    @Test
    public void testStateRegexIsEnabled() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is enabled").contentEquals("enabled"));
    }

    @Test
    public void testStateRegexIsDisabled() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is disabled").contentEquals("disabled"));
    }

    @Test
    public void testStateRegexIsDownloaded() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is downloaded").contentEquals("downloaded"));
    }

    @Test
    public void testStateRegexIsUploaded() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is uploaded").contentEquals("uploaded"));
    }

    @Test
    public void testStateRegexAsFollows() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file is created as follows")
                .contentEquals("created as follows"));
    }

    @Test
    public void testStateRegexIsnt() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file isn't empty").contentEquals("empty"));
    }

    @Test
    public void testStateRegexWillBe() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file will be empty").contentEquals("empty"));
    }

    @Test
    public void testStateRegexWontBe() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getStateType("The graph-viewer application validate annotation file won't be empty").contentEquals("empty"));
    }

    @Test
    public void testDetailsRegexLanguage() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The graph-viewer application validate annotation file SheepDog language is empty")
                .contentEquals("language"));
    }

    @Test
    public void testDetailsRegexType() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The graph-viewer application validate annotation file StepObjectRef type is empty")
                .contentEquals("type"));
    }

    @Test
    public void testDetailsRegexAssignment() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The graph-viewer application validate annotation file StepObjectName assignment is empty")
                .contentEquals("assignment"));
    }

    @Test
    public void testDetailsRegexFragment() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The graph-viewer application validate annotation file Component fragment is empty")
                .contentEquals("fragment"));
    }

    @Test
    public void testDetailsRegexScope() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The graph-viewer application validate annotation file Only scope is empty")
                .contentEquals("scope"));
    }

    @Test
    public void testDetailsRegexNode() {
        Assertions.assertTrue(StepDefinitionRefFragments
                .getPartType("The graph-viewer application validate annotation file StepObjectRef node is empty")
                .contentEquals("node"));
    }

    @Test
    public void testObjectRegexDirectory() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The graph-viewer application output directory is empty").contentEquals("directory"));
    }

    @Test
    public void testObjectRegexPage() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The graph-viewer application home page is empty").contentEquals("page"));
    }

    @Test
    public void testObjectRegexDialog() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The graph-viewer application settings dialog is empty").contentEquals("dialog"));
    }

    @Test
    public void testObjectRegexResponse() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The graph-viewer application validate response is empty").contentEquals("response"));
    }

    @Test
    public void testObjectRegexPopup() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The xtext plugin list proposals popup is empty").contentEquals("popup"));
    }

    @Test
    public void testObjectRegexAnnotation() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The xtext plugin validate annotation is empty").contentEquals("annotation"));
    }

    @Test
    public void testObjectRegexHover() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The graph-viewer application description hover is empty").contentEquals("hover"));
    }

    @Test
    public void testObjectRegexTooltip() {
        Assertions.assertTrue(StepObjectRefFragments
                .getObjectType("The graph-viewer application status tooltip is empty").contentEquals("tooltip"));
    }

    @Test
    public void testAppRegexProject() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The spec-prj project validate annotation file is present").contentEquals("project"));
    }

    @Test
    public void testAppRegexService() {
        Assertions.assertTrue(StepObjectRefFragments.getComponentType("The sheep-dog-dev-svc service validate annotation file is empty")
                .contentEquals("service"));
    }

    @Test
    public void testAppRegexPlugIn() {
        Assertions.assertTrue(StepObjectRefFragments.getComponentType("The maven plugin validate annotation file is empty")
                .contentEquals("plugin"));
    }

    @Test
    public void testAppRegexBatchJob() {
        Assertions.assertTrue(StepObjectRefFragments
                .getComponentType("The nightly batchjob validate annotation file is empty").contentEquals("batchjob"));
    }
}
