package org.farhan.mbt.convert;

import org.farhan.mbt.core.UMLTestProject;
import org.farhan.mbt.junit.JunitPathConverter;
import org.farhan.mbt.junit.JunitGuiceTestProject;

public class ConvertUMLToJunitGuice extends ConvertUMLToJunit {

	public ConvertUMLToJunitGuice(String tags, ObjectRepository fa, Logger log) {
		super(tags, fa, log);
	}

	public void initProjects() throws Exception {
		model = new UMLTestProject(this.tags, this.fa);
		project = new JunitGuiceTestProject(this.tags, this.fa);
		model.init();
		project.init();
		this.pathConverter = new JunitPathConverter(model, (JunitGuiceTestProject) project);
	}
}
