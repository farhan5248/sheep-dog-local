package org.farhan.dsl.sheepdog.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.farhan.dsl.grammar.IDescription;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;

public class StepDefinitionImpl implements IStepDefinition {

    StepDefinition eObject;
    private Object container;

    public StepDefinitionImpl(StepDefinition value) {
        this.eObject = value;
    }

    @Override
    public void setDescription(IDescription value) {
        eObject.setDescription(((DescriptionImpl) value).eObject);
    }

    @Override
    public String getName() {
        return eObject.getName();
    }

    @Override
    public IDescription getDescription() {
        if (eObject.getDescription() != null) {
            return new DescriptionImpl(eObject.getDescription());
        }
        return null;
    }

    @Override
    public EList<IStepParameters> getStepParameterList() {
        EList<IStepParameters> list = new BasicEList<IStepParameters>();
        for (StepParameters t : eObject.getStepParameterList()) {
            StepParametersImpl stepParameters = new StepParametersImpl((StepParameters) t);
            list.add(stepParameters);
        }
        return list;
    }

    @Override
    public void setName(String value) {
        eObject.setName(value);
    }

    @Override
    public Object getContainer() {
        if (container != null) return container;
        return new StepObjectImpl((org.farhan.dsl.sheepdog.sheepDog.StepObject) eObject.eContainer());
    }

    @Override
    public void setContainer(Object value) {
        this.container = value;
    }

}
