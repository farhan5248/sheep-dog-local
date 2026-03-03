package org.farhan.impl.objects;

import java.util.Arrays;
import java.util.HashMap;
import org.farhan.common.TestIDEObject;
import org.farhan.dsl.grammar.PhraseFragments;
import org.farhan.dsl.grammar.StepDefinitionRefFragments;
import org.farhan.dsl.grammar.StepDefinitionRefPartTypes;
import org.farhan.dsl.grammar.StepDefinitionRefStateTypes;
import org.farhan.dsl.grammar.StepObjectRefComponentTypes;
import org.farhan.dsl.grammar.StepObjectRefFragments;
import org.farhan.dsl.grammar.StepObjectRefObjectEdgeTypes;
import org.farhan.dsl.grammar.StepObjectRefObjectVertexTypes;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarAsciidocFile;
import org.junit.jupiter.api.Assertions;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessGrammarAsciidocFileImpl extends TestIDEObject implements ProcessGrammarAsciidocFile {

    @Override
    public void assertPhraseTagFragmentTagList(HashMap<String, String> keyMap) {
        String expected = replaceKeyword(keyMap.get("Tag List"));
        Assertions.assertTrue(PhraseFragments.getTagAsList(objectKeyMap.get("Line").toString())
                .containsAll(expected.isEmpty() ? Arrays.asList() : Arrays.asList(expected.split(", "))));
    }

    @Override
    public void assertPhraseTodoFragmentTodoDescription(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Description")),
                PhraseFragments.getTodoDesc(objectKeyMap.get("Line").toString()));
    }

    @Override
    public void assertPhraseTodoFragmentTodoType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Todo Type")),
                PhraseFragments.getTodoType(objectKeyMap.get("Line").toString()));
    }

    @Override
    public void assertStepDefinitionRefPartFragmentPart(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part")), StepDefinitionRefFragments.getPart(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefPartFragmentPartDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Description")),
                StepDefinitionRefFragments.getPartDesc(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefPartFragmentPartType(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Type")),
                StepDefinitionRefFragments.getPartType(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefPartFragmentPartTypeDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String partType = StepDefinitionRefFragments.getPartType(stepDefRef);
        Assertions.assertEquals(replaceKeyword(keyMap.get("Part Type Description")),
                StepDefinitionRefPartTypes.valueOf(partType.toUpperCase()).description);
    }

    @Override
    public void assertStepDefinitionRefStateFragmentState(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State")), StepDefinitionRefFragments.getState(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefStateFragmentStateDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Description")),
                StepDefinitionRefFragments.getStateDesc(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefStateFragmentStateType(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Type")),
                StepDefinitionRefFragments.getStateType(stepDefRef));
    }

    @Override
    public void assertStepDefinitionRefStateFragmentStateTypeDescription(HashMap<String, String> keyMap) {
        String stepDefRef = getStepDefinitionRef();
        String stateType = StepDefinitionRefFragments.getStateType(stepDefRef);
        String description = Arrays.stream(StepDefinitionRefStateTypes.values()).filter(e -> e.value.equals(stateType))
                .findFirst().orElseThrow().description;
        Assertions.assertEquals(replaceKeyword(keyMap.get("State Type Description")), description);
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponent(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component")),
                StepObjectRefFragments.getComponent(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponentName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Name")),
                StepObjectRefFragments.getComponentName(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponentType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type")),
                StepObjectRefFragments.getComponentType(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefComponentFragmentComponentTypeDescription(HashMap<String, String> keyMap) {
        String componentType = StepObjectRefFragments
                .getComponentType(objectKeyMap.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Component Type Description")),
                StepObjectRefComponentTypes.valueOf(componentType.toUpperCase()).description);
    }

    @Override
    public void assertStepObjectRefObjectEdgeFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectEdgeType(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectEdgeFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectEdgeType(objectKeyMap.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type Description")),
                StepObjectRefObjectEdgeTypes.valueOf(objectType.toUpperCase()).description);
    }

    @Override
    public void assertStepObjectRefObjectFragmentObject(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object")),
                StepObjectRefFragments.getObject(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectFragmentObjectName(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Name")),
                StepObjectRefFragments.getObjectName(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectType(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectVertexFragmentObjectType(HashMap<String, String> keyMap) {
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type")),
                StepObjectRefFragments.getObjectVertexType(objectKeyMap.get("Test Step Full Name").toString()));
    }

    @Override
    public void assertStepObjectRefObjectVertexFragmentObjectTypeDescription(HashMap<String, String> keyMap) {
        String objectType = StepObjectRefFragments
                .getObjectVertexType(objectKeyMap.get("Test Step Full Name").toString());
        Assertions.assertEquals(replaceKeyword(keyMap.get("Object Type Description")),
                StepObjectRefObjectVertexTypes.valueOf(objectType.toUpperCase()).description);
    }

    @Override
    public void setLineTypeLine(HashMap<String, String> keyMap) {
        objectKeyMap.put("Line", keyMap.get("Line"));
    }

    @Override
    public void setTestStepTypeTestStepFullName(HashMap<String, String> keyMap) {
        objectKeyMap.put("Test Step Full Name", keyMap.get("Test Step Full Name"));
    }

    private String getStepDefinitionRef() {
        String testStep = objectKeyMap.get("Test Step Full Name").toString();
        return testStep.substring(StepObjectRefFragments.getAll(testStep).length()).trim();
    }

    @Override
    public void assertAssignment(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void assertType(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void assertMultiplicity(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setCellTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setDescriptionTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setLineTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setModelTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setNestedDescriptionTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setRowTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setStepDefinitionTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void assertName(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setStepObjectTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setStepObjectTypeFullName(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setStepParametersTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTableTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestCaseTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestDataTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestProjectTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestSetupTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void assertGroup(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void assertKeyword(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void assertStepObjectName(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void assertStepDefinitionName(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestStepTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestStepTypeFullName(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestStepContainerTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestSuiteTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTestSuiteTypeFullName(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void setTextTypeAsFollows(HashMap<String, String> keyMap) {
        // TODO Auto-generated method stub
        
    }
}
