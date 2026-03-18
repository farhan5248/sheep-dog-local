package org.farhan.impl.ide;

import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;

public class CellImpl implements ICell {

    private String name;
    private IRow parent;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public IRow getParent() {
        return parent;
    }

    @Override
    public void setParent(IRow value) {
        this.parent = value;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
