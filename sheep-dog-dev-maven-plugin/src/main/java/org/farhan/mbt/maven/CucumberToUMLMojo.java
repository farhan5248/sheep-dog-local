package org.farhan.mbt.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Converts tagged Cucumber scenarios to a UML model using Eclipse Xtext and EMF
 *
 */
@Mojo(name = "cucumber-to-uml", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class CucumberToUMLMojo extends MBTMojo {

	public void execute() throws MojoExecutionException {
		super.execute("org.farhan.mbt.convert.ConvertCucumberToUML", "src-gen/test/resources/cucumber/", ".feature");
	}
}