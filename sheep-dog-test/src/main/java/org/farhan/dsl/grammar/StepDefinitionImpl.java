package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.List;

public class StepDefinitionImpl implements IStepDefinition {

    private String name;
    private IDescription description;
    private List<IStepParameters> stepParameterList = new ArrayList<>();

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String value) {
        this.name = value;
    }

    @Override
    public IStepObject getParent() {
        return null;
    }

    @Override
    public IDescription getDescription() {
        return description;
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
    public boolean addStepParameters(IStepParameters value) {
        return stepParameterList.add(value);
    }

    @Override
    public List<IStepParameters> getStepParameterList() {
        return stepParameterList;
    }

    @Override
    public IStepParameters getStepParameters(int index) {
        return stepParameterList.get(index);
    }

    @Override
    public IStepParameters getStepParameters(String name) {
        for (IStepParameters sp : stepParameterList) {
            if (name.equals(sp.getName())) {
                return sp;
            }
        }
        return null;
    }

}
