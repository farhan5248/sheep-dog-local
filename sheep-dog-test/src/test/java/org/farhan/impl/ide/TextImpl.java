package org.farhan.impl.ide;

import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.IText;

public class TextImpl implements IText {

    private String name;
    ITestStep parent;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public ITestStep getParent() {
        return parent;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
