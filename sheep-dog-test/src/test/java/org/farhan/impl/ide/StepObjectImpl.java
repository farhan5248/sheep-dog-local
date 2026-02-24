package org.farhan.impl.ide;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.IDescription;
import org.farhan.dsl.lang.ILine;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;

public class StepObjectImpl implements IStepObject {

	String name;
	String qualifiedName;
	String content;
	TestProjectImpl parent;
	ArrayList<StepDefinitionImpl> stepDefinitionList;
	DescriptionImpl description;

	StepObjectImpl() {
		this.stepDefinitionList = new ArrayList<StepDefinitionImpl>();
	}

	@Override
	public String getContent() throws Exception {
		// TODO create a proper toString method
		content = this.toString();
		return content;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ITestProject getParent() {
		return parent;
	}

	@Override
	public String getNameLong() {
		return qualifiedName;
	}

	@Override
	public IDescription getDescription() {
		return description;
	}

	@Override
	public IStepDefinition getStepDefinition(int index) {
		throw new UnsupportedOperationException("getStepDefinition(int index) is not implemented");
	}

	@Override
	public IStepDefinition getStepDefinition(String name) {
		for (IStepDefinition sd : stepDefinitionList) {
			if (sd.getName().contentEquals(name)) {
				return sd;
			}
		}
		return null;
	}

	@Override
	public List<IStepDefinition> getStepDefinitionList() {
		return Collections.unmodifiableList(stepDefinitionList);
	}

	@Override
	public void setContent(String text) throws Exception {
		content = text;
	}

	@Override
	public void setName(String value) {
		this.name = value;
	}

	@Override
	public void setNameLong(String value) {
		this.qualifiedName = value;
		String[] nameParts = qualifiedName.split("/");
		name = nameParts[nameParts.length - 1].replace(".feature", "");
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
	public boolean addStepDefinition(IStepDefinition value) {
		stepDefinitionList.add((StepDefinitionImpl) value);
		stepDefinitionList.getLast().parent = this;
		return true;
	}

	@Override
	public String toString() {
		return qualifiedName != null ? qualifiedName : (name != null ? name : "");
	}

}
