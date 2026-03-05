package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.ILine;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.SheepDogUtility;

public class StepDefinitionImpl implements IStepDefinition {

    String name;
    ArrayList<StepParametersImpl> stepParametersList;
    DescriptionImpl description;
    StepObjectImpl parent;

    StepDefinitionImpl() {
        this.stepParametersList = new ArrayList<StepParametersImpl>();
        this.description = new DescriptionImpl();
        this.description.parent = this;
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
            String rowAsString = sp.getTable().getRowList().isEmpty() ? ""
                    : SheepDogUtility.getCellListAsString(sp.getTable().getRowList().getFirst().getCellList());
            if (name.contentEquals(rowAsString)) {
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
        stepParametersList.add((StepParametersImpl) value);
        stepParametersList.getLast().parent = this;
        return true;
    }

    @Override
    public String toString() {
        return name != null ? name : "";
    }

}
