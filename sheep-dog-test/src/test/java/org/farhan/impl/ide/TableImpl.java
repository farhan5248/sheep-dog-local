package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITable;

public class TableImpl implements ITable {

    private List<IRow> rowList = new ArrayList<>();

    @Override
    public Object getParent() {
        return null;
    }

    @Override
    public boolean addRow(IRow value) {
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
