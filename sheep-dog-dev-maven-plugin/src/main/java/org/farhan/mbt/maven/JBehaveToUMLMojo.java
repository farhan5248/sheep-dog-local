package org.farhan.mbt.maven;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * Converts JBehave stories to a UML model using Eclipse Xtext and EMF
 *
 */
@Mojo(name = "jbehave-to-uml", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class JBehaveToUMLMojo extends MBTMojo {

        public void execute() throws MojoExecutionException {
                super.execute("org.farhan.mbt.convert.ConvertJBehaveToUML", "src-gen/test/resources/jbehave/", ".story");
        }
}
