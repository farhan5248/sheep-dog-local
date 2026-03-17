package org.farhan.impl.ide;

import org.farhan.dsl.grammar.*;

public class TestDataImpl implements ITestData {

    private String name;
    private IDescription description;
    private ITable table;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public ITestCase getParent() {
        return null;
    }

    @Override
    public IDescription getDescription() {
        return description;
    }

    @Override
    public void setDescription(IDescription value) {
        this.description = value;
    }

    @Override
    public ITable getTable() {
        return table;
    }

    @Override
    public void setTable(ITable value) {
        this.table = value;
    }

    @Override
    public boolean addLine(ILine value) {
        return false;
    }

}
