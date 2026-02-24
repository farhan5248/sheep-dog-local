package org.farhan.impl.ide;

import org.farhan.dsl.lang.ILine;
import org.farhan.dsl.lang.INestedDescription;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;

public class StepParametersImpl implements IStepParameters {

    StepDefinitionImpl parent;
    TableImpl table;
    String name;
    NestedDescriptionImpl nestedDescription;

    StepParametersImpl() {
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IStepDefinition getParent() {
        return parent;
    }

    @Override
    public INestedDescription getNestedDescription() {
        return nestedDescription;
    }

    @Override
    public ITable getTable() {
        return table;
    }

    @Override
    public void setName(String value) {
        name = value;
    }

    @Override
    public void setTable(ITable value) {
        this.table = (TableImpl) value;
        this.table.parent = this;
    }

    @Override
    public boolean addLine(ILine value) {
        if (nestedDescription == null) {
            nestedDescription = new NestedDescriptionImpl();
            nestedDescription.parent = this;
        }
        nestedDescription.addLine(value);
        return true;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
