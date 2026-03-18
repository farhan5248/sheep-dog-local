package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITable;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class InputFileAsciidocFileImpl extends TestObjectSheepDogImpl implements InputFileAsciidocFile {

    @Override
    public String getCellListNodeCellName(HashMap<String, String> keyMap) {
        return assertCellName(replaceKeyword(keyMap.get("Cell Name")));
    }

    @Override
    public String getCellListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
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
    public String getLineListNodeLineContent(HashMap<String, String> keyMap) {
        return assertLineContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public String getLineListNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
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
    public String getStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        return assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
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
    public String getStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        return assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public String getTableNodeNodePath(HashMap<String, String> keyMap) {
        return setCursorAtNode(keyMap.get("Node Path")) ? keyMap.get("Node Path") : null;
    }

    @Override
    public String getTableNodeState(HashMap<String, String> keyMap) {
        ITable table = getTableFromCursor();
        return table == null ? null : table.toString();
    }

    @Override
    public void setCellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setLineListNodeLineContent(HashMap<String, String> keyMap) {
        addLineWithContent(replaceKeyword(keyMap.get("Line Content")));
    }

    @Override
    public void setLineListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepDefinitionListNodeStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public void setStepParametersListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setStepParametersListNodeStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public void setCreated(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getStepDefinitionName(HashMap<String, String> keyMap) {
        return assertStepDefinitionName(replaceKeyword(keyMap.get("Step Definition Name")));
    }

    @Override
    public String getStepParametersName(HashMap<String, String> keyMap) {
        return assertStepParametersName(replaceKeyword(keyMap.get("Step Parameters Name")));
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getTableNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getDescriptionNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setLineListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getLineListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setStepDefinitionListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getStepDefinitionListNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getStepDefinitionListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public void setStepParametersListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        addStepObjectWithFullName(getFullNameFromPath());
    }

    @Override
    public String getStepParametersListNodeAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getStepParametersListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }
}
