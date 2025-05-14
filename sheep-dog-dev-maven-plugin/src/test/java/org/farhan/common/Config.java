package org.farhan.common;

import java.io.File;
import org.farhan.impl.AsciidoctorToUmlGoalImpl;
import org.farhan.impl.CucumberToUmlGoalImpl;
import org.farhan.impl.ObjectPageAsciidocFileImpl;
import org.farhan.impl.ObjectPageJavaFileImpl;
import org.farhan.impl.ProcessAsciidocFileImpl;
import org.farhan.impl.ProcessAsciidocFileImpl2;
import org.farhan.impl.ProcessFeatureFileImpl;
import org.farhan.impl.ProcessFeatureFileImpl2;
import org.farhan.impl.BlahObjectPageStepsJavaFileImpl;
import org.farhan.impl.UmlToAsciidoctorGoalImpl;
import org.farhan.impl.UmlToCucumberGoalImpl;
import org.farhan.impl.UmlToCucumberGuiceGoalImpl;
import org.farhan.impl.UmlToCucumberSpringGoalImpl;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah.ObjectPageJavaFile;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.stepdefs.blah.BlahObjectPageStepsJavaFile;
import org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.app.ProcessFeatureFile;
import org.farhan.objects.maven.AsciidoctorToUmlGoal;
import org.farhan.objects.maven.CucumberToUmlGoal;
import org.farhan.objects.maven.UmlToAsciidoctorGoal;
import org.farhan.objects.maven.UmlToCucumberGoal;
import org.farhan.objects.maven.UmlToCucumberGuiceGoal;
import org.farhan.objects.maven.UmlToCucumberSpringGoal;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.app.ProcessAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;
import io.cucumber.java.Before;

public final class Config extends AbstractModule implements InjectorSource {

	public static String getWorkingDir() {
		return "target/src-gen/";
	}

	public void deleteDir(File aDir) throws Exception {
		if (aDir.exists()) {
			for (String s : aDir.list()) {
				File f = new File(aDir.getAbsolutePath() + File.separator + s);
				if (f.isDirectory()) {
					deleteDir(f);
				} else {
					if (!f.delete()) {
						throw new Exception("Failed to delete: " + f.getAbsolutePath());
					}
				}
			}
		}
	}

	@Before
	public void before() throws Exception {
		deleteDir(new File(getWorkingDir()));
	}

	@Override
	protected void configure() {
		bind(AsciidoctorToUmlGoal.class).to(AsciidoctorToUmlGoalImpl.class);
		bind(BlahObjectPageStepsJavaFile.class).to(BlahObjectPageStepsJavaFileImpl.class);
		bind(ObjectPageJavaFile.class).to(ObjectPageJavaFileImpl.class);
		bind(CucumberToUmlGoal.class).to(CucumberToUmlGoalImpl.class);
		bind(ObjectPageAsciidocFile.class).to(ObjectPageAsciidocFileImpl.class);
		bind(ProcessAsciidocFile.class).to(ProcessAsciidocFileImpl.class);
		bind(org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile.class)
				.to(ProcessAsciidocFileImpl2.class);
		bind(ProcessFeatureFile.class).to(ProcessFeatureFileImpl.class);
		bind(org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.ProcessFeatureFile.class)
				.to(ProcessFeatureFileImpl2.class);
		bind(UmlToAsciidoctorGoal.class).to(UmlToAsciidoctorGoalImpl.class);
		bind(UmlToCucumberGoal.class).to(UmlToCucumberGoalImpl.class);
		bind(UmlToCucumberSpringGoal.class).to(UmlToCucumberSpringGoalImpl.class);
		bind(UmlToCucumberGuiceGoal.class).to(UmlToCucumberGuiceGoalImpl.class);
	}

	@Override
	public Injector getInjector() {
		return Guice.createInjector(Stage.DEVELOPMENT, CucumberModules.createScenarioModule(), new Config());
	}
}