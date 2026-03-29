package org.farhan.common;

import java.io.File;

import org.farhan.impl.AsciidoctorToUmlGoalImpl;
import org.farhan.impl.ObjectPageAsciidocFileImpl;
import org.farhan.impl.ProcessAsciidocFileImpl;
import org.farhan.impl.PstUmlFileImpl;
import org.farhan.impl.UmlToAsciidoctorGoalImpl;
import org.farhan.objects.maven.AsciidoctorToUmlGoal;
import org.farhan.objects.maven.UmlToAsciidoctorGoal;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.app.ProcessAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;
import org.farhan.objects.specprj.uml.PstUmlFile;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;
import io.cucumber.java.Before;

public final class TestConfig extends AbstractModule implements InjectorSource {

	public static String getWorkingDir() {
		return "target/src-gen/";
	}

	public void deleteDir(File aDir) {
		if (aDir.exists()) {
			for (String s : aDir.list()) {
				File f = new File(aDir.getAbsolutePath() + File.separator + s);
				if (f.isDirectory()) {
					deleteDir(f);
				}
				f.delete();
			}
		}
	}

	@Before
	public void resetTestProject() throws Exception {
		deleteDir(new File(getWorkingDir()));
	}

	@Override
	protected void configure() {
		bind(AsciidoctorToUmlGoal.class).to(AsciidoctorToUmlGoalImpl.class);
		bind(ProcessAsciidocFile.class).to(ProcessAsciidocFileImpl.class);
		bind(org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile.class)
				.to(ProcessAsciidocFileImpl.class);
		bind(ObjectPageAsciidocFile.class).to(ObjectPageAsciidocFileImpl.class);
		bind(PstUmlFile.class).to(PstUmlFileImpl.class);
		bind(UmlToAsciidoctorGoal.class).to(UmlToAsciidoctorGoalImpl.class);
	}

	@Override
	public Injector getInjector() {
		return Guice.createInjector(Stage.DEVELOPMENT, CucumberModules.createScenarioModule(), new TestConfig());
	}
}
