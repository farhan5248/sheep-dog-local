package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.ITestProject;

public class StepObjectImpl implements IStepObject {

    String name;
    String fullName;
    String content;
    TestProjectImpl parent;
    ArrayList<StepDefinitionImpl> stepDefinitionList;
    DescriptionImpl description;

    StepObjectImpl() {
        this.stepDefinitionList = new ArrayList<StepDefinitionImpl>();
        this.description = new DescriptionImpl();
        this.description.parent = this;
    }

    @Override
    public String getContent() throws Exception {
        // TODO create a proper toString method
        content = this.toString();
        return content;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITestProject getParent() {
        return parent;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public IDescription getDescription() {
        return description;
    }

    @Override
    public IStepDefinition getStepDefinition(int index) {
        return stepDefinitionList.get(index);
    }

    @Override
    public IStepDefinition getStepDefinition(String name) {
        for (IStepDefinition sd : stepDefinitionList) {
            if (sd.getName().contentEquals(name)) {
                return sd;
            }
        }
        return null;
    }

    @Override
    public List<IStepDefinition> getStepDefinitionList() {
        return Collections.unmodifiableList(stepDefinitionList);
    }

    @Override
    public void setContent(String text) throws Exception {
        content = text;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public void setFullName(String value) {
        this.fullName = value;
        String[] nameParts = fullName.split("/");
        name = nameParts[nameParts.length - 1].replace(".feature", "");
    }

    @Override
    public void setDescription(IDescription value) {
        description = (DescriptionImpl) value;
        description.parent = this;
    }

    @Override
    public boolean addLine(ILine value) {
        if (description == null) {
            description = new DescriptionImpl();
            description.parent = this;
        }
        description.addLine(value);
        return true;
    }

    @Override
    public boolean addStepDefinition(IStepDefinition value) {
        stepDefinitionList.add((StepDefinitionImpl) value);
        stepDefinitionList.getLast().parent = this;
        return true;
    }

    @Override
    public String toString() {
        return fullName != null ? fullName : (name != null ? name : "");
    }

}
