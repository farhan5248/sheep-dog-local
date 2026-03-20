package org.farhan.mock;

import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.ITestStepContainer;
import org.farhan.dsl.grammar.IText;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestStepImpl implements ITestStep {

    String name;
    String stepObjectName;
    String stepDefinitionName;
    TestStepContainerImpl parent;
    TableImpl table;
    TextImpl text;

    @Override
    public String getFullName() {
        String obj = stepObjectName != null ? stepObjectName : "";
        String def = stepDefinitionName != null ? stepDefinitionName : "";
        return (obj + " " + def).trim();
    }

    @Override
    public void setFullName(String value) {
        Matcher m = Pattern.compile(
                "^(.+\\s(?:file|page|response|dialog|directory|request|goal|job|action|popup|annotation|hover|tooltip))(?:\\s+(.+))?$")
                .matcher(value);
        if (m.find()) {
            stepObjectName = m.group(1);
            stepDefinitionName = m.group(2) != null ? m.group(2) : "";
        } else {
            stepObjectName = "";
            stepDefinitionName = value;
        }
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

    @Override
    public String toString() {
        String obj = stepObjectName != null ? stepObjectName : "";
        String def = stepDefinitionName != null ? stepDefinitionName : "";
        return (obj + " " + def).trim();
    }

}
