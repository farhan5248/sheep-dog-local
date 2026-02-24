package org.farhan.dsl.lang;

import java.util.List;

public interface IStepDefinition {

    boolean addLine(ILine value);

    boolean addStepParameters(IStepParameters value);

    String getName();

    IStepObject getParent();

    IDescription getDescription();

    List<IStepParameters> getStepParameterList();

    IStepParameters getStepParameters(int index);

    IStepParameters getStepParameters(String name);

    void setName(String value);

}
