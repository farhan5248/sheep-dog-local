package org.farhan.mbt.cucumber;

import org.farhan.mbt.core.ObjectRepository;
import org.farhan.mbt.core.UMLTestProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertUMLToCucumberGuice extends ConvertUMLToCucumber {
	private static final Logger logger = LoggerFactory.getLogger(ConvertUMLToCucumberGuice.class);

	public ConvertUMLToCucumberGuice(String tags, ObjectRepository fa) {
		super(tags, fa);
	}

	public void initProjects() throws Exception {
		model = new UMLTestProject(this.tags, this.fa);
		project = new CucumberGuiceTestProject(this.tags, this.fa);
		model.init();
		project.init();
		this.pathConverter = new CucumberPathConverter(model, (CucumberTestProject) project);
	}
}
