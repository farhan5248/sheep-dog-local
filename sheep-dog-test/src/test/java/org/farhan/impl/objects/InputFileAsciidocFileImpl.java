package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.IRow;
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
        String path = keyMap.get("Node Path");
        String lastPath = getProperty("lastStepParamsPath") != null ? getProperty("lastStepParamsPath").toString() : "";
        if (!path.equals(lastPath)) {
            setProperty("stepParamsIndex", 0);
            setProperty("lastStepParamsPath", path);
        }
        setCursorAtNode(path);
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
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepDefinition) {
            IStepDefinition sd = (IStepDefinition) cursor;
            int index = getProperty("stepParamsIndex") != null ? ((Integer) getProperty("stepParamsIndex")) : 0;
            IStepParameters sp = sd.getStepParameters(index);
            setProperty("stepParamsIndex", index + 1);
            return sp.getName();
        }
        IStepParameters sp = (IStepParameters) cursor;
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

    @Override
    public void setLineListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
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
        navigateToDocument();
        return null;
    }

    @Override
    public String getLineListNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        setCursorAtNode(keyMap.get("Node Path"));
        return null;
    }

    @Override
    public String getLineListNodeLineContent(HashMap<String, String> keyMap) {
        ILine line = (ILine) getProperty("cursor");
        return line.getName();
    }

    @Override
    public void setCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        addStepDefinitionWithName(keyMap.get("Step Definition Name"));
    }

    @Override
    public void setStepParametersName(HashMap<String, String> keyMap) {
        addStepParametersWithName(keyMap.get("Step Parameters Name"));
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getStepDefinitionName(HashMap<String, String> keyMap) {
        if (getProperty("cursor") instanceof IStepObject) {
            IStepObject doc = (IStepObject) getProperty("cursor");
            IStepDefinition sd = doc.getStepDefinition(0);
            setProperty("cursor", sd);
            return sd != null ? sd.getName() : null;
        }
        IStepDefinition sd = (IStepDefinition) getProperty("cursor");
        return sd.getName();
    }

    @Override
    public String getStepParametersName(HashMap<String, String> keyMap) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IStepDefinition) {
            IStepDefinition sd = (IStepDefinition) cursor;
            IStepParameters sp = sd.getStepParameters(0);
            setProperty("cursor", sp);
            return sp != null ? sp.getName() : null;
        }
        IStepParameters sp = (IStepParameters) cursor;
        return sp.getName();
    }

    @Override
    public void setCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setCellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public String getCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getCellListNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        String path = keyMap.get("Node Path");
        String lastPath = getProperty("lastCellListPath") != null ? getProperty("lastCellListPath").toString() : "";
        if (!path.equals(lastPath)) {
            setProperty("cellListIndex", 0);
            setProperty("lastCellListPath", path);
        }
        setCursorAtNode(path);
        return null;
    }

    @Override
    public String getCellListNodeCellName(HashMap<String, String> keyMap) {
        Object cursor = getProperty("cursor");
        if (cursor instanceof IRow) {
            IRow row = (IRow) cursor;
            int index = getProperty("cellListIndex") != null ? ((Integer) getProperty("cellListIndex")) : 0;
            ICell cell = row.getCell(index);
            setProperty("cellListIndex", index + 1);
            return cell.getName();
        }
        ICell cell = (ICell) cursor;
        return cell.getName();
    }

}
