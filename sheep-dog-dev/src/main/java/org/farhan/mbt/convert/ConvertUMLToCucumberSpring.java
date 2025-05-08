package org.farhan.mbt.convert;

import org.farhan.mbt.core.UMLTestProject;
import org.farhan.mbt.cucumber.CucumberPathConverter;
import org.farhan.mbt.cucumber.CucumberTestProject;
import org.farhan.mbt.cucumber.CucumberSpringTestProject;

public class ConvertUMLToCucumberSpring extends ConvertUMLToCucumber {

	public ConvertUMLToCucumberSpring(String tags, ObjectRepository fa, Logger log) {
		super(tags, fa, log);
	}

	public void initProjects() throws Exception {
		model = new UMLTestProject(this.tags, this.fa);
		project = new CucumberSpringTestProject(this.tags, this.fa);
		model.init();
		project.init();
		this.pathConverter = new CucumberPathConverter(model, (CucumberTestProject) project);
	}

}
