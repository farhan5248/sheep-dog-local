package org.farhan.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;

import io.cucumber.datatable.DataTable;

public abstract class TestObject {

    protected HashMap<String, String> keyValue = new HashMap<String, String>();

    public void assertInputOutputs(DataTable dataTable) {
        processInputOutputs(dataTable, "assert", "");
    }

    public void assertInputOutputs(DataTable dataTable, String sectionName) {
        processInputOutputs(dataTable, "assert", sectionName);
    }

    public void assertInputOutputs(DataTable dataTable, String sectionName, boolean negativeTest) {
        processInputOutputs(dataTable, "assert", sectionName);
    }

    public void assertInputOutputs(String key) {
        processInputOutputs(key, "true", "assert", "");
    }

    public void assertInputOutputs(String key, boolean negativeTest) {
        processInputOutputs(key, Boolean.toString(negativeTest), "assert", "");
    }

    public void assertInputOutputs(String key, String value) {
        processInputOutputs(key, value, "assert", "");
    }

    public void assertInputOutputs(String key, String value, String sectionName) {
        processInputOutputs(key, value, "assert", sectionName);
    }

    public void setInputOutputs(DataTable dataTable) {
        processInputOutputs(dataTable, "set", "");
    }

    public void setInputOutputs(DataTable dataTable, String sectionName) {
        processInputOutputs(dataTable, "set", sectionName);
    }

    public void setInputOutputs(DataTable dataTable, String sectionName, boolean negativeTest) {
        processInputOutputs(dataTable, "set", sectionName);
    }

    public void setInputOutputs(String key) {
        processInputOutputs(key, "true", "set", "");
    }

    public void setInputOutputs(String key, String value) {
        processInputOutputs(key, value, "set", "");
    }

    public void transition() {
    }

    private void processInputOutputs(DataTable dataTable, String operation, String sectionName) {

        if (keyValue.get("part") != null) {
            if (operation.contentEquals("set")) {
                createStepDependencies(keyValue.get("part"));
            } else {
                setSelectedNode(keyValue.get("part"));
            }
        }

        List<List<String>> data = dataTable.asLists();
        ArrayList<String> headers = new ArrayList<String>();
        for (String cell : data.get(0)) {
            headers.add(cell);
        }
        for (int i = 1; i < data.size(); i++) {
            HashMap<String, String> row = new HashMap<String, String>();
            for (int j = 0; j < headers.size(); j++) {
                row.put(headers.get(j), data.get(i).get(j));
            }
            for (String fieldName : headers) {
                try {
                    this.getClass().getMethod(operation + sectionName.replaceAll("[ \\-\\(\\)/]", "")
                            + fieldName.replaceAll("[ \\-\\(\\)/]", ""), HashMap.class).invoke(this, row);
                } catch (Exception e) {
                    Assertions.fail(e);
                }
            }
        }
    }

    private void processInputOutputs(String key, String value, String operation, String sectionName) {

        if (keyValue.get("part") != null) {
            if (operation.contentEquals("set")) {
                createStepDependencies(keyValue.get("part"));
            } else {
                setSelectedNode(keyValue.get("part"));
            }
        }
        
        HashMap<String, String> row = new HashMap<String, String>();
        row.put(key, value);
        try {
            this.getClass().getMethod(
                    operation + sectionName.replaceAll("[ \\-\\(\\)/]", "") + key.replaceAll("[ \\-\\(\\)/]", ""),
                    HashMap.class).invoke(this, row);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    protected String listToString(ArrayList<?> proposals) {
        StringBuilder sb = new StringBuilder();
        for (Object p : proposals) {
            sb.append("\n").append(p.toString());
        }
        return sb.toString();
    }

    protected String replaceKeyword(String value) {
        if (value.contentEquals("empty")) {
            return "";
        } else {
            return value;
        }
    }

    void setComponent(String component) {
        keyValue.put("component", component);
    }

    void setPath(String path) {
        keyValue.put("path", path);
    }

    protected abstract void createStepDependencies(String path);

    protected abstract void setSelectedNode(String path);

    public void setPart(String part) {
        keyValue.put("part", part);
    }
}
