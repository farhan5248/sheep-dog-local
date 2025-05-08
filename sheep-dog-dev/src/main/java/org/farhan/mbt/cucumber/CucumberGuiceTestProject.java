package org.farhan.mbt.cucumber;

import org.farhan.mbt.convert.ConvertibleObject;
import org.farhan.mbt.convert.ObjectRepository;

public class CucumberGuiceTestProject extends CucumberTestProject {

	public CucumberGuiceTestProject(String tags, ObjectRepository fa) {
		super(tags, fa);
	}

	@Override
	protected ConvertibleObject createClass(String file) {
		return new CucumberGuiceClass(file);
	}
}
