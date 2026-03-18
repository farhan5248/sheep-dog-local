package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITable;

public class TableImpl implements ITable {

    Object parent;
    private List<IRow> rowList = new ArrayList<>();

    @Override
    public Object getParent() {
        return parent;
    }

    @Override
    public boolean addRow(IRow value) {
        RowImpl impl = (RowImpl) value;
        rowList.add(impl);
        impl.parent = this;
        return true;
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
