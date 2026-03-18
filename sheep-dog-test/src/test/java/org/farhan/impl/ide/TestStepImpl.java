package org.farhan.impl.ide;

import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.IText;
import org.farhan.dsl.grammar.StepDefinitionRefFragments;
import org.farhan.dsl.grammar.StepObjectRefFragments;

public class TestStepImpl implements ITestStep {

    private String fullName;
    private String stepObjectName;
    private String stepDefinitionName;
    ITestStepContainer parent;
    private ITable table;
    private IText text;

    @Override
    public String getFullName() {
        return fullName;
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
    public void setFullName(String value) {
        fullName = value;
        stepObjectName = StepObjectRefFragments.getAll(value);
        stepDefinitionName = StepDefinitionRefFragments.getAll(value.replace(stepObjectName, ""));
    }

    @Override
    public void setStepObjectName(String value) {
        stepObjectName = value;
    }

    @Override
    public void setStepDefinitionName(String value) {
        stepDefinitionName = value;
    }

    @Override
    public void setTable(ITable value) {
        table = (TableImpl) value;
        ((TableImpl) value).parent = this;
    }

    @Override
    public void setText(IText value) {
        text = (TextImpl) value;
        ((TextImpl) value).parent = this;
    }

    @Override
    public String toString() {
        return fullName != null ? fullName : "";
    }

}
