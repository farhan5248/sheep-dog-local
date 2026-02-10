package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IStatement;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITable;

public class StepParametersImpl implements IStepParameters {

    StepDefinitionImpl parent;
    TableImpl table;
    String name;
    ArrayList<StatementImpl> statementList;

    StepParametersImpl() {
        this.statementList = new ArrayList<StatementImpl>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IStepDefinition getParent() {
        return parent;
    }

    @Override
    public List<IStatement> getStatementList() {
        return Collections.unmodifiableList(statementList);
    }

    @Override
    public ITable getTable() {
        return table;
    }

    @Override
    public void setName(String value) {
        name = value;
    }

    @Override
    public void setTable(ITable value) {
        this.table = (TableImpl) value;
        this.table.parent = this;
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
    public boolean addStatement(IStatement value) {
        statementList.add((StatementImpl) value);
        statementList.getLast().parent = this;
        return true;
    }

}
