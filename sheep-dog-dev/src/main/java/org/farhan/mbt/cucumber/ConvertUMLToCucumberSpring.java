package org.farhan.mbt.cucumber;

import org.farhan.mbt.core.IObjectRepository;
import org.farhan.mbt.core.UMLTestProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConvertUMLToCucumberSpring extends ConvertUMLToCucumber {
	private static final Logger logger = LoggerFactory.getLogger(ConvertUMLToCucumberSpring.class);

	public ConvertUMLToCucumberSpring(String tags, IObjectRepository fa) {
		super(tags, fa);
	}

	public void initProjects() throws Exception {
		model = new UMLTestProject(this.tags, this.fa);
		project = new CucumberSpringTestProject(this.tags, this.fa);
		model.init();
		project.init();
		this.pathConverter = new CucumberPathConverter(model, (CucumberTestProject) project);
	}

}
