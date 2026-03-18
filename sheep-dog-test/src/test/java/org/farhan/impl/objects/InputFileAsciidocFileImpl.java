package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
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
        if (sd == null) {
            return null;
        }
        return sd.getName();
    }

    @Override
    public String getStepParametersListNodeAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        // Reset the row counter when starting a new assertion
        setProperty("stepParametersRowCounter", 0);
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
        Object cursor = getProperty("cursor");
        if (cursor == null) {
            return null;
        }

        // When cursor is at StepDefinition level (path like "StepDefinitionList/1/StepParametersList"),
        // we need to iterate through StepParameters using a row counter
        if (cursor instanceof IStepDefinition) {
            IStepDefinition sd = (IStepDefinition) cursor;
            if (sd.getStepParameterList() == null || sd.getStepParameterList().isEmpty()) {
                return null;
            }

            // Get or initialize the row counter for this assertion
            String counterKey = "stepParametersRowCounter";
            Object counterObj = getProperty(counterKey);
            int rowIndex = 0;
            if (counterObj != null) {
                rowIndex = (Integer) counterObj;
            }

            // Get the step parameters at the current row index
            if (rowIndex < sd.getStepParameterList().size()) {
                String result = sd.getStepParameters(rowIndex).getName();
                // Increment counter for next row
                setProperty(counterKey, rowIndex + 1);
                return result;
            }

            return null;
        }

        // When cursor is at specific StepParameters (path like "StepDefinitionList/1/StepParametersList/2")
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
    public void setStepParametersName(HashMap<String, String> keyMap) {
        String parametersName = keyMap.get("Step Parameters Name");
        if (parametersName != null && !parametersName.trim().isEmpty()) {
            addStepParametersWithName(parametersName);
        }
    }

    @Override
    public void setStepDefinitionName(HashMap<String, String> keyMap) {
        String definitionName = keyMap.get("Step Definition Name");
        if (definitionName != null && !definitionName.trim().isEmpty()) {
            addStepDefinitionWithName(definitionName);
        }
    }

    @Override
    public void setCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToOrCreateDocument();
    }

    @Override
    public void setCellListNodeNodePath(HashMap<String, String> keyMap) {
        createNodeDependencies(keyMap.get("Node Path"));
    }

    @Override
    public void setCellListNodeCellName(HashMap<String, String> keyMap) {
        addCellWithName(keyMap.get("Cell Name"));
    }

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        return null;
    }

    @Override
    public String getStepDefinitionName(HashMap<String, String> keyMap) {
        Object cursor = getProperty("cursor");
        IStepDefinition sd;

        if (cursor instanceof IStepObject) {
            // Cursor is at document level, navigate to first step definition
            IStepObject doc = (IStepObject) cursor;
            sd = doc.getStepDefinition(0);
        } else {
            // Cursor should already be at step definition
            sd = (IStepDefinition) cursor;
        }

        if (sd == null) {
            return null;
        }
        return sd.getName();
    }

    @Override
    public String getStepParametersName(HashMap<String, String> keyMap) {
        Object cursor = getProperty("cursor");
        IStepParameters sp;

        if (cursor instanceof IStepObject) {
            // Cursor is at document level, navigate to first step definition, then first step parameters
            IStepObject doc = (IStepObject) cursor;
            IStepDefinition sd = doc.getStepDefinition(0);
            if (sd == null || sd.getStepParameterList() == null || sd.getStepParameterList().isEmpty()) {
                return null;
            }
            sp = sd.getStepParameters(0);
        } else if (cursor instanceof IStepDefinition) {
            // Cursor is at step definition level, navigate to first step parameters
            IStepDefinition sd = (IStepDefinition) cursor;
            if (sd.getStepParameterList() == null || sd.getStepParameterList().isEmpty()) {
                return null;
            }
            sp = sd.getStepParameters(0);
        } else {
            // Cursor should already be at step parameters
            sp = (IStepParameters) cursor;
        }

        if (sp == null) {
            return null;
        }
        return sp.getName();
    }

    @Override
    public String getCellListNodeCreatedAsFollows(HashMap<String, String> keyMap) {
        navigateToDocument();
        // Reset the row counter when starting a new assertion
        setProperty("cellListRowCounter", 0);
        return null;
    }

    @Override
    public String getCellListNodeNodePath(HashMap<String, String> keyMap) {
        navigateToDocument();
        setCursorAtNode(keyMap.get("Node Path"));
        return null;
    }

    @Override
    public String getCellListNodeCellName(HashMap<String, String> keyMap) {
        Object cursor = getProperty("cursor");
        if (cursor == null) {
            return null;
        }

        // When cursor is at Row level (path like "...Table/RowList/1/CellList"),
        // we need to iterate through Cells using a row counter
        if (cursor instanceof org.farhan.dsl.grammar.IRow) {
            org.farhan.dsl.grammar.IRow row = (org.farhan.dsl.grammar.IRow) cursor;
            if (row.getCellList() == null || row.getCellList().isEmpty()) {
                return null;
            }

            // Get or initialize the row counter for this assertion
            String counterKey = "cellListRowCounter";
            Object counterObj = getProperty(counterKey);
            int rowIndex = 0;
            if (counterObj != null) {
                rowIndex = (Integer) counterObj;
            }

            // Get the cell at the current row index
            if (rowIndex < row.getCellList().size()) {
                String result = row.getCell(rowIndex).getName();
                // Increment counter for next row
                setProperty(counterKey, rowIndex + 1);
                return result;
            }

            return null;
        }

        // When cursor is at specific Cell (path with cell index)
        if (cursor instanceof org.farhan.dsl.grammar.ICell) {
            org.farhan.dsl.grammar.ICell cell = (org.farhan.dsl.grammar.ICell) cursor;
            return cell.getName();
        }

        return null;
    }

}
