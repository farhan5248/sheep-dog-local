package org.farhan.impl.ide;

import org.farhan.dsl.grammar.*;

public class StepParametersImpl implements IStepParameters {

    private String name;
    private IDescription description;
    private ITable table;
    private IStepDefinition parent;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public IStepDefinition getParent() {
        return parent;
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
