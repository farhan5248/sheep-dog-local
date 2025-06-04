package org.farhan.mbt.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Converts UML model to JBehave stories using Eclipse Xtext and EMF
 *
 */
@Mojo(name = "uml-to-jbehave", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class UMLToJBehaveMojo extends MBTMojo {

        public void execute() throws MojoExecutionException {
                super.execute("org.farhan.mbt.convert.ConvertUMLToJBehave", "", "");
        }
}
