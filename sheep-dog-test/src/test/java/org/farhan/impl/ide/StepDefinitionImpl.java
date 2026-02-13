package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.SheepDogUtility;

public class StepDefinitionImpl implements IStepDefinition {

    String name;
    ArrayList<StepParametersImpl> stepParametersList;
    ArrayList<StatementImpl> statementList;
    StepObjectImpl parent;

    StepDefinitionImpl() {
        this.stepParametersList = new ArrayList<StepParametersImpl>();
        this.statementList = new ArrayList<StatementImpl>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IStepObject getParent() {
        throw new UnsupportedOperationException("getParent() is not implemented");
    }

    @Override
    public IStatement getStatement(int index) {
        throw new UnsupportedOperationException("getStatement(int index) is not implemented");
    }

    @Override
    public IStatement getStatement(String name) {
        throw new UnsupportedOperationException("getStatement(String name) is not implemented");
    }

    @Override
    public List<IStatement> getStatementList() {
        return Collections.unmodifiableList(statementList);
    }

    @Override
    public List<IStepParameters> getStepParameterList() {
        return Collections.unmodifiableList(stepParametersList);
    }

    @Override
    public IStepParameters getStepParameters(int index) {
        throw new UnsupportedOperationException("getStepParameters(int index) is not implemented");
    }

    @Override
    public IStepParameters getStepParameters(String name) {
        for (IStepParameters sp : stepParametersList) {
            String rowAsString = SheepDogUtility
                    .getCellListAsString(sp.getTable().getRowList().getFirst().getCellList());
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
    public boolean addStatement(IStatement value) {
        statementList.add((StatementImpl) value);
        statementList.getLast().parent = this;
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
