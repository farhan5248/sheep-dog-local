package org.farhan.impl.ide;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;

public class StepParametersImpl implements IStepParameters {

    StepDefinitionImpl parent;
    TableImpl table;
    String name;
    DescriptionImpl description;

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
    public IDescription getDescription() {
        return description;
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
    public void setDescription(IDescription value) {
        description = (DescriptionImpl) value;
        description.parent = this;
    }

    @Override
    public boolean addLine(ILine value) {
        if (description == null) {
            description = new DescriptionImpl();
            description.parent = this;
        }
        description.addLine(value);
        return true;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
