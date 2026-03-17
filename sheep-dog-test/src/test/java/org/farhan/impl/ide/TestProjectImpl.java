package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.*;

public class TestProjectImpl implements ITestProject {

    private String name;
    private List<ITestDocument> testDocumentList = new ArrayList<>();

    @Override
    public boolean addStepObject(IStepObject value) {
        return testDocumentList.add(value);
    }

    @Override
    public boolean addTestSuite(ITestSuite value) {
        value.setParent(this);
        return testDocumentList.add(value);
    }

    @Override
    public String getFileExtension() {
        return "asciidoc";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITestDocument getTestDocument(int index) {
        return testDocumentList.get(index);
    }

    @Override
    public ITestDocument getTestDocument(String fullName) {
        for (ITestDocument doc : testDocumentList) {
            if (fullName.equals(doc.getFullName())) {
                return doc;
            }
        }
        return null;
    }

    @Override
    public List<ITestDocument> getTestDocumentList() {
        return testDocumentList;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

}
