package org.farhan.mbt.cucumber;

import org.farhan.mbt.convert.ConvertibleObject;
import org.farhan.mbt.convert.ObjectRepository;

public class CucumberSpringTestProject extends CucumberTestProject {

	public CucumberSpringTestProject(String tags, ObjectRepository fa) {
		super(tags, fa);
	}

	@Override
	protected ConvertibleObject createClass(String path) {
		return new CucumberSpringClass(path);
	}

}
