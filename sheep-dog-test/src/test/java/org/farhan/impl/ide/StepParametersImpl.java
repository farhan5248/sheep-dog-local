package org.farhan.impl.ide;

import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.INestedDescription;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;

public class StepParametersImpl implements IStepParameters {

    StepDefinitionImpl parent;
    TableImpl table;
    String name;
    NestedDescriptionImpl nestedDescription;

    StepParametersImpl() {
        this.nestedDescription = new NestedDescriptionImpl();
        this.nestedDescription.parent = this;
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
    public void setNestedDescription(INestedDescription value) {
        nestedDescription = (NestedDescriptionImpl) value;
        nestedDescription.parent = this;
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
