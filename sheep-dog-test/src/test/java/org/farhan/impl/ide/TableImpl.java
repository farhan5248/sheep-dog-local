package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITable;

public class TableImpl implements ITable {

    private Object parent;
    private List<IRow> rowList = new ArrayList<>();

    @Override
    public Object getParent() {
        return parent;
    }

    @Override
    public void setParent(Object value) {
        parent = value;
    }

    @Override
    public boolean addRow(IRow value) {
        value.setParent(this);
        return rowList.add(value);
    }

    @Override
    public IRow getRow(int index) {
        return rowList.get(index);
    }

    @Override
    public List<IRow> getRowList() {
        return rowList;
    }

}
