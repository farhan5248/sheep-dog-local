package org.farhan.mock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;


public class StepDefinitionImpl implements IStepDefinition {

    String name;
    ArrayList<StepParametersImpl> stepParametersList;
    DescriptionImpl description;
    StepObjectImpl parent;

    StepDefinitionImpl() {
        this.stepParametersList = new ArrayList<StepParametersImpl>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IStepObject getParent() {
        return parent;
    }

    @Override
    public IDescription getDescription() {
        return description;
    }

    @Override
    public List<IStepParameters> getStepParameterList() {
        return Collections.unmodifiableList(stepParametersList);
    }

    @Override
    public IStepParameters getStepParameters(int index) {
        return stepParametersList.get(index);
    }

    @Override
    public IStepParameters getStepParameters(String name) {
        for (IStepParameters sp : stepParametersList) {
            if (name.contentEquals(sp.getName())) {
                return sp;
            }
        }
        return null;
    }

    @Override
    public void setName(String value) {
        this.name = value;
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
    public boolean addStepParameters(IStepParameters value) {
        StepParametersImpl impl = (StepParametersImpl) value;
        int insertIndex = Collections.binarySearch(
                stepParametersList.stream().map(StepParametersImpl::getName).toList(),
                impl.getName());
        if (insertIndex < 0) {
            insertIndex = -(insertIndex + 1);
        }
        stepParametersList.add(insertIndex, impl);
        impl.parent = this;
        return true;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
