package org.farhan.mbt.junit;

import org.farhan.mbt.convert.ConvertibleObject;
import org.farhan.mbt.convert.ObjectRepository;

public class JunitGuiceTestProject extends JunitTestProject {

	public JunitGuiceTestProject(String tags, ObjectRepository fa) {
		super(tags, fa);
	}

	@Override
	protected ConvertibleObject createClass(String file) {
		return new JunitGuiceClass(file);
	}
}
