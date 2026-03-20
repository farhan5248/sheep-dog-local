package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;

public class InputFileAsciidocFileImpl extends TestObjectSheepDogImpl implements InputFileAsciidocFile {

    @Override
    public void setCreated(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getDescriptionNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getDescriptionNodeState(HashMap<String, String> keyMap) {
        IDescription desc = getDescriptionFromCursor();
        return desc == null ? null : desc.toString();
    }

    @Override
    public String getStepDefinitionListNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getStepDefinitionListNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return listToCsvString(((IStepObject) getProperty("cursor")).getStepDefinitionList());
    }

    @Override
    public void setStepDefinitionListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
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
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return ((IStepDefinition) getProperty("cursor")).getName();
    }

    @Override
    public String getStepParametersListNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getStepParametersListNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return listToCsvString(((IStepDefinition) getProperty("cursor")).getStepParameterList());
    }

    @Override
    public void setStepParametersListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
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
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return ((IStepParameters) getProperty("cursor")).getName();
    }

    @Override
    public void setLineListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public void setLineListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(keyMap.get("Line Content"));
    }

    @Override
    public String getLineListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getLineListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getLineListNodeLineContent(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return ((ILine) getProperty("cursor")).getName();
    }

    @Override
    public String getTableNodeAsFollows(HashMap<String, String> keyMap) {
        return getDocumentFromWorkspaceAsString();
    }

    @Override
    public String getTableNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getTableNodeState(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        IStepParameters sp = (IStepParameters) getProperty("cursor");
        if (sp.getTable() == null)
            return null;
        return listToCsvString(sp.getTable().getRowList());
    }

}
