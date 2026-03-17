package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.ICell;
import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.ITable;

public class RowImpl implements IRow {

    private String name;
    private ITable parent;
    private List<ICell> cellList = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public ITable getParent() {
        return parent;
    }

    @Override
    public boolean addCell(ICell value) {
        return cellList.add(value);
    }

    @Override
    public ICell getCell(int index) {
        return cellList.get(index);
    }

    @Override
    public ICell getCell(String name) {
        for (ICell cell : cellList) {
            if (name.equals(cell.getName())) {
                return cell;
            }
        }
        return null;
    }

    @Override
    public List<ICell> getCellList() {
        return cellList;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
