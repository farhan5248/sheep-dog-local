package org.farhan.common;

import java.io.File;

import org.farhan.impl.AsciidoctorToUmlGoalImpl;
import org.farhan.impl.BlahObjectPageStepsJavaFileImpl;
import org.farhan.impl.CucumberToUmlGoalImpl;
import org.farhan.impl.ObjectPageAsciidocFileImpl;
import org.farhan.impl.ObjectPageJavaFileImpl;
import org.farhan.impl.ProcessAsciidocFileImpl;
import org.farhan.impl.ProcessFeatureFileImpl;
import org.farhan.impl.PstUmlFileImpl;
import org.farhan.impl.UmlToAsciidoctorGoalImpl;
import org.farhan.impl.UmlToCucumberGoalImpl;
import org.farhan.impl.UmlToCucumberGuiceGoalImpl;
import org.farhan.impl.UmlToCucumberSpringGoalImpl;
import org.farhan.objects.maven.AsciidoctorToUmlGoal;
import org.farhan.objects.maven.CucumberToUmlGoal;
import org.farhan.objects.maven.UmlToAsciidoctorGoal;
import org.farhan.objects.maven.UmlToCucumberGoal;
import org.farhan.objects.maven.UmlToCucumberGuiceGoal;
import org.farhan.objects.maven.UmlToCucumberSpringGoal;
import org.farhan.objects.maven.UmlToJunitGuiceGoal;
import org.farhan.objects.maven.UmlToJunitSpringGoal;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah.ObjectPageJavaFile;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.stepdefs.blah.BlahObjectPageStepsJavaFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.app.ProcessAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.blahapplication.ObjectPageAsciidocFile;
import org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.app.ProcessFeatureFile;
import org.farhan.objects.specprj.uml.PstUmlFile;

import com.google.inject.AbstractModule;

public final class Config2 extends AbstractModule {

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

	public void deleteFiles() throws Exception {
		deleteDir(new File(getWorkingDir()));
	}

	@Override
	protected void configure() {
		bind(AsciidoctorToUmlGoal.class).to(AsciidoctorToUmlGoalImpl.class);
		bind(BlahObjectPageStepsJavaFile.class).to(BlahObjectPageStepsJavaFileImpl.class);
		bind(org.farhan.objects.codeprj.srcgen.test.java.org.farhan.suites.blah.BlahObjectPageStepsJavaFile.class)
				.to(BlahObjectPageStepsJavaFileImpl.class);
		bind(CucumberToUmlGoal.class).to(CucumberToUmlGoalImpl.class);
		bind(ObjectPageJavaFile.class).to(ObjectPageJavaFileImpl.class);
		bind(ProcessAsciidocFile.class).to(ProcessAsciidocFileImpl.class);
		bind(org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessAsciidocFile.class)
				.to(ProcessAsciidocFileImpl.class);
		bind(ObjectPageAsciidocFile.class).to(ObjectPageAsciidocFileImpl.class);
		bind(ProcessFeatureFile.class).to(ProcessFeatureFileImpl.class);
		bind(org.farhan.objects.codeprj.srcgen.test.resources.cucumber.specs.ProcessFeatureFile.class)
				.to(ProcessFeatureFileImpl.class);
		bind(PstUmlFile.class).to(PstUmlFileImpl.class);
		bind(UmlToAsciidoctorGoal.class).to(UmlToAsciidoctorGoalImpl.class);
		bind(UmlToCucumberGoal.class).to(UmlToCucumberGoalImpl.class);
		bind(UmlToCucumberSpringGoal.class).to(UmlToCucumberSpringGoalImpl.class);
		bind(UmlToCucumberGuiceGoal.class).to(UmlToCucumberGuiceGoalImpl.class);
	}

}