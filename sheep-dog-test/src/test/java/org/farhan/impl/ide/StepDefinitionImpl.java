package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.List;
import org.farhan.dsl.grammar.*;

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
        int insertIndex = stepParameterList.size();
        for (int i = 0; i < stepParameterList.size(); i++) {
            if (value.getName().compareTo(stepParameterList.get(i).getName()) < 0) {
                insertIndex = i;
                break;
            }
        }
        stepParameterList.add(insertIndex, value);
        return true;
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
