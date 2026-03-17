package org.farhan.impl.ide;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;

public class LineImpl implements ILine {

    private String name;
    private IDescription parent;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public IDescription getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
