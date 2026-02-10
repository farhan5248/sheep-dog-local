package org.farhan.impl.ide;

import org.farhan.dsl.lang.ITable;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestStepContainer;
import org.farhan.dsl.lang.IText;

public class TestStepImpl implements ITestStep {

    String name;
    String stepObjectName;
    String stepDefinitionName;
    TestStepContainerImpl parent;
    TableImpl table;
    TextImpl text;

    @Override
    public ITestStepContainer getParent() {
        return parent;
    }

    @Override
    public ITable getTable() {
        return table;
    }

    @Override
    public IText getText() {
        return text;
    }

    @Override
    public void setTable(ITable value) {
        table = (TableImpl) value;
        table.parent = this;
    }

    @Override
    public void setText(IText value) {
        text = (TextImpl) value;
        text.parent = this;
    }

    public boolean equals(TestStepImpl object) {
        return this.equals(object);
    }

    @Override
    public String getStepObjectName() {
        return stepObjectName;
    }

    @Override
    public String getStepDefinitionName() {
        return stepDefinitionName;
    }

    @Override
    public void setStepObjectName(String value) {
        stepObjectName = value;
    }

    @Override
    public void setStepDefinitionName(String value) {
        stepDefinitionName = value;
    }

}
