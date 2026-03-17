package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestObjectSheepDogImpl implements InputFileAsciidocFile {

    private void navigateToDocument() {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
    }

    @Override
    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getDescriptionNodeState(HashMap<String, String> keyMap) {
        IStepObject doc = (IStepObject) getProperty("cursor");
        IDescription desc = doc.getDescription();
        if (desc == null) {
            return null;
        }
        return desc.toString();
    }

    @Override
    public String getStepDefinitionListNodeAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        setCursorAtNode(keyMap.get("Node Path"));
        return null;
    }

    @Override
    public String getStepDefinitionListNodeState(HashMap<String, String> keyMap) {
        IStepObject doc = (IStepObject) getProperty("cursor");
        if (doc == null) {
            return null;
        }
        return listToString(doc.getStepDefinitionList());
    }

    @Override
    public void setCreated(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    private void navigateToOrCreateDocument() {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument(getFullNameFromPath());
        if (doc == null) {
            addStepObjectWithFullName(getFullNameFromPath());
        } else {
            setProperty("cursor", doc);
        }
    }

    @Override
    public void setStepDefinitionListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(keyMap.get("Step Definition Name"));
    }

    @Override
    public String getStepDefinitionListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        IStepDefinition sd = (IStepDefinition) getProperty("cursor");
        return sd.getName();
    }

    @Override
    public String getStepParametersListNodeAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        setCursorAtNode(keyMap.get("Node Path"));
        return null;
    }

    @Override
    public String getStepParametersListNodeState(HashMap<String, String> keyMap) {
        IStepDefinition sd = (IStepDefinition) getProperty("cursor");
        if (sd == null) {
            return null;
        }
        return listToString(sd.getStepParameterList());
    }

    @Override
    public void setStepParametersListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(keyMap.get("Step Parameters Name"));
    }

    @Override
    public String getStepParametersListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        IStepParameters sp = (IStepParameters) getProperty("cursor");
        return sp.getName();
    }

    @Override
    public String getTableNodeAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getTableNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        setCursorAtNode(keyMap.get("Node Path"));
        return null;
    }

    @Override
    public String getTableNodeState(HashMap<String, String> keyMap) {
        return null;
    }

}
