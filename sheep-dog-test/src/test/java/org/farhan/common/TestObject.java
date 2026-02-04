package org.farhan.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.farhan.dsl.issues.SheepDogIssueProposal;
import org.junit.jupiter.api.Assertions;

import io.cucumber.datatable.DataTable;

public abstract class TestObject {

    public HashMap<String, String> keyValue = new HashMap<String, String>();

    private String cleanName(String name) {
        return name.replaceAll("[ \\-\\(\\)/]", "");
    }

    private void processInputOutputs(DataTable dataTable, String operation, String sectionName) {
        List<List<String>> data = dataTable.asLists();

        ArrayList<String> headers = new ArrayList<String>();
        for (String cell : data.get(0)) {
            headers.add(cell);
        }
        for (int i = 1; i < data.size(); i++) {
            HashMap<String, String> row = new HashMap<String, String>();
            for (int j = 0; j < data.get(i).size(); j++) {
                row.put(headers.get(j), data.get(i).get(j));
            }
            processInputOutputs(row, operation, sectionName);
        }
    }

    private void processInputOutputs(HashMap<String, String> row, String operation, String sectionName) {
        try {
            for (String fieldName : row.keySet()) {
                this.getClass().getMethod(operation + cleanName(sectionName) + cleanName(fieldName), HashMap.class)
                        .invoke(this, row);
            }
        } catch (Exception e) {
            Assertions.fail(e);
        }
    }

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
        HashMap<String, String> row = new HashMap<String, String>();
        row.put(key, "true");
        processInputOutputs(row, "assert", "");
    }

    public void assertInputOutputs(String key, boolean negativeTest) {
        HashMap<String, String> row = new HashMap<String, String>();
        row.put(key, Boolean.toString(negativeTest));
        processInputOutputs(row, "assert", "");
    }

    public void assertInputOutputs(String key, String value) {
        HashMap<String, String> row = new HashMap<String, String>();
        row.put(key, value);
        processInputOutputs(row, "assert", "");
    }

    public void assertInputOutputs(String key, String value, String sectionName) {
        HashMap<String, String> row = new HashMap<String, String>();
        row.put(key, value);
        processInputOutputs(row, "assert", sectionName);
    }

    public String getListProposalsString(ArrayList<SheepDogIssueProposal> proposals) {
        StringBuilder sb = new StringBuilder();
        sb.append("\nActual proposals (").append(proposals.size()).append("):");
        for (SheepDogIssueProposal p : proposals) {
            sb.append("\n  - ID: [").append(p.getId()).append("], Value: [").append(p.getValue()).append("]");
        }
        return sb.toString();
    }

    public String getSpecial(String value) {
        if (value.contentEquals("empty")) {
            return "";
        } else {
            return value;
        }
    }

    public void setComponent(String component) {
        keyValue.put("component", component);
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
        HashMap<String, String> row = new HashMap<String, String>();
        row.put(key, "true");
        processInputOutputs(row, "set", "");
    }

    public void setInputOutputs(String key, String value) {
        HashMap<String, String> row = new HashMap<String, String>();
        row.put(key, value);
        processInputOutputs(row, "set", "");
    }

    public void setPath(String path) {
        keyValue.put("path", path);
    }

    public void transition() {
    }
}
