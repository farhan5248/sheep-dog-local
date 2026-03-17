package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;

public class DescriptionImpl implements IDescription {

    private List<ILine> lineList = new ArrayList<>();
    private Object parent;

    @Override
    public ILine getLine(int index) {
        return lineList.get(index);
    }

    @Override
    public ILine getLine(String name) {
        for (ILine line : lineList) {
            if (name.equals(line.getName())) {
                return line;
            }
        }
        return null;
    }

    @Override
    public List<ILine> getLineList() {
        return lineList;
    }

    @Override
    public Object getParent() {
        return parent;
    }

    @Override
    public boolean addLine(ILine value) {
        return lineList.add(value);
    }

    @Override
    public String toString() {
        return "Description[lines=" + lineList.size() + "]";
    }

}
