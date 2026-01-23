package org.farhan.common;

import org.farhan.dsl.lang.SheepDogFactory;
import org.farhan.impl.GenerateStepDefinitionActionImpl;
import org.farhan.impl.InputFileAsciidocFileImpl;
import org.farhan.impl.ListProposalsActionImpl;
import org.farhan.impl.ListProposalsDialogImpl;
import org.farhan.impl.ListQuickfixesActionImpl;
import org.farhan.impl.ListQuickfixesDialogImpl;
import org.farhan.impl.AppInputFileAsciidocFileImpl;
import org.farhan.impl.Process2AsciidocFileImpl;
import org.farhan.impl.SheepDogFactoryImpl;
import org.farhan.impl.ValidateActionImpl;
import org.farhan.impl.ValidateDialogImpl;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.farhan.objects.xtext.ListProposalsAction;
import org.farhan.objects.xtext.ListProposalsDialog;
import org.farhan.objects.xtext.ListQuickfixesAction;
import org.farhan.objects.xtext.ListQuickfixesDialog;
import org.farhan.objects.xtext.ValidateAction;
import org.farhan.objects.xtext.ValidateDialog;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;
import io.cucumber.java.Before;

public final class GuiceConfig extends AbstractModule implements InjectorSource {

	@Override
	public Injector getInjector() {
		return Guice.createInjector(Stage.DEVELOPMENT, CucumberModules.createScenarioModule(), new GuiceConfig());
	}

	@Before
	public void resetTestProject() throws Exception {
		SheepDogFactory.instance = new SheepDogFactoryImpl();
		TestObject.reset();
		MockIDE.reset();
	}

	@Override
	protected void configure() {
		bind(InputFileAsciidocFile.class).to(InputFileAsciidocFileImpl.class);
		bind(org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile.class)
				.to(AppInputFileAsciidocFileImpl.class);
		bind(Process2AsciidocFile.class).to(Process2AsciidocFileImpl.class);
		bind(GenerateStepDefinitionAction.class).to(GenerateStepDefinitionActionImpl.class);
		bind(ListProposalsAction.class).to(ListProposalsActionImpl.class);
		bind(ListProposalsDialog.class).to(ListProposalsDialogImpl.class);
		bind(ListQuickfixesAction.class).to(ListQuickfixesActionImpl.class);
		bind(ListQuickfixesDialog.class).to(ListQuickfixesDialogImpl.class);
		bind(ValidateAction.class).to(ValidateActionImpl.class);
		bind(ValidateDialog.class).to(ValidateDialogImpl.class);
	}

}