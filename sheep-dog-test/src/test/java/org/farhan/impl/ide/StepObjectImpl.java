package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.*;

public class StepObjectImpl implements IStepObject {

    private String fullName;
    private String name;
    private IDescription description;
    private List<IStepDefinition> stepDefinitionList = new ArrayList<>();

    @Override
    public String getContent() throws Exception {
        return null;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public ITestProject getParent() {
        return null;
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
            if (name.equals(sd.getName())) {
                return sd;
            }
        }
        return null;
    }

    @Override
    public List<IStepDefinition> getStepDefinitionList() {
        return stepDefinitionList;
    }

    @Override
    public void setContent(String text) throws Exception {
    }

    @Override
    public void setFullName(String value) {
        this.fullName = value;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public void setDescription(IDescription value) {
        this.description = value;
    }

    @Override
    public boolean addLine(ILine value) {
        return false;
    }

    @Override
    public boolean addStepDefinition(IStepDefinition value) {
        value.setParent(this);
        int i = 0;
        while (i < stepDefinitionList.size() && stepDefinitionList.get(i).getName().compareTo(value.getName()) < 0) {
            i++;
        }
        stepDefinitionList.add(i, value);
        return true;
    }

}
