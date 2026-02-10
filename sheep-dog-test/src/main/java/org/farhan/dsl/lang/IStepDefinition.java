package org.farhan.dsl.lang;

import java.util.List;

public interface IStepDefinition {

    boolean addStatement(IStatement value);

    boolean addStepParameters(IStepParameters value);

    String getName();

    IStepObject getParent();

    IStatement getStatement(int index);

    IStatement getStatement(String name);

    List<IStatement> getStatementList();

    List<IStepParameters> getStepParameterList();

    IStepParameters getStepParameters(int index);

    IStepParameters getStepParameters(String name);

    void setName(String value);

}