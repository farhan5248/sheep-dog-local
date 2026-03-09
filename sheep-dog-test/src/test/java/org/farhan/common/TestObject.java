package org.farhan.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Assertions;

import io.cucumber.datatable.DataTable;

public abstract class TestObject {

    protected HashMap<String, Object> properties = new HashMap<String, Object>();

    public void assertInputOutputsDataTable(DataTable dataTable) {
        processInputOutputs(dataTable, "assert", "");
    }

    public void assertInputOutputsDataTable(DataTable dataTable, String sectionName) {
        processInputOutputs(dataTable, "assert", sectionName);
    }

    public void assertInputOutputsDataTable(DataTable dataTable, String sectionName, boolean negativeTest) {
        processInputOutputs(dataTable, "assert", sectionName);
    }

    public void assertInputOutputsDocString(String key, String value) {
        processInputOutputs(key, value, "assert", "");
    }

    public void assertInputOutputsState(String key) {
        processInputOutputs(key, "true", "assert", "");
    }

    public void assertInputOutputsState(String key, boolean negativeTest) {
        processInputOutputs(key, Boolean.toString(negativeTest), "assert", "");
    }

    public void assertInputOutputsState(String key, String sectionName) {
        processInputOutputs(key, "", "assert", sectionName);
    }

    public void assertInputOutputsState(String key, String value, String sectionName) {
        processInputOutputs(key, value, "assert", sectionName);
    }

    public void setInputOutputsDataTable(DataTable dataTable) {
        processInputOutputs(dataTable, "set", "");
    }

    public void setInputOutputsDataTable(DataTable dataTable, String sectionName) {
        processInputOutputs(dataTable, "set", sectionName);
    }

    public void setInputOutputsDataTable(DataTable dataTable, String sectionName, boolean negativeTest) {
        processInputOutputs(dataTable, "set", sectionName);
    }

    public void setInputOutputsDocString(String key, String value) {
        processInputOutputs(key, value, "set", "");
    }

    public void setInputOutputsState(String key) {
        processInputOutputs(key, "true", "set", "");
    }

    public void setPart(String part) {
        properties.put("part", part);
    }

    public void transition() {
    }

    protected String listToString(ArrayList<?> proposals) {
        StringBuilder sb = new StringBuilder();
        for (Object p : proposals) {
            sb.append("\n").append(p.toString());
        }
        return sb.toString();
    }

    protected void processInputOutputs(DataTable dataTable, String operation, String sectionName) {

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
                    this.getClass().getMethod(operation + convertToPascalCase(sectionName)
                            + convertToPascalCase(fieldName), HashMap.class).invoke(this, row);
                } catch (Exception e) {
                    Assertions.fail(e);
                }
            }
        }
    }

    protected void processInputOutputs(String key, String value, String operation, String sectionName) {

        HashMap<String, String> row = new HashMap<String, String>();
        row.put(key, value);
        try {
            this.getClass().getMethod(
                    operation + convertToPascalCase(sectionName) + convertToPascalCase(key),
                    HashMap.class).invoke(this, row);
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

    private String convertToPascalCase(String s) {
        StringBuilder result = new StringBuilder();
        for (String word : s.split("[ \\-\\(\\)/]+")) {
            if (!word.isEmpty()) {
                result.append(Character.toUpperCase(word.charAt(0)));
                if (word.length() > 1) {
                    result.append(word.substring(1));
                }
            }
        }
        return result.toString();
    }

    protected String replaceKeyword(String value) {
        if (value.contentEquals("empty")) {
            return "";
        } else {
            return value;
        }
    }

    protected void setComponent(String component) {
        properties.put("component", component);
    }

    protected void setPath(String path) {
        properties.put("path", path);
    }

    public void setInputOutputsState(String string, String string2) {
        // TODO Auto-generated method stub
        
    }
}
