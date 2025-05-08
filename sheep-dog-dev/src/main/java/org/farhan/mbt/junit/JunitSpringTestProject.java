package org.farhan.mbt.junit;

import org.farhan.mbt.convert.ConvertibleObject;
import org.farhan.mbt.convert.ObjectRepository;

public class JunitSpringTestProject extends JunitTestProject {

	public JunitSpringTestProject(String tags, ObjectRepository fa) {
		super(tags, fa);
	}

	@Override
	protected ConvertibleObject createClass(String path) {
		return new JunitSpringClass(path);
	}

}
