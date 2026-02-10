package org.farhan.mbt.cucumber;

import org.farhan.dsl.lang.IResourceRepository;
import org.farhan.mbt.core.UMLTestProject;

public class ConvertUMLToCucumberSpring extends ConvertUMLToCucumber {

    public ConvertUMLToCucumberSpring(String tags, IResourceRepository fa) {
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
