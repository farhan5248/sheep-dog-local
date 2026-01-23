package org.farhan.common;

import org.farhan.dsl.lang.SheepDogFactory;
import org.farhan.impl.GenerateStepDefinitionActionImpl;
import org.farhan.impl.InputFileAsciidocFileImpl;
import org.farhan.impl.AppInputFileAsciidocFileImpl;
import org.farhan.impl.Process2AsciidocFileImpl;
import org.farhan.impl.ProposeDialogImpl;
import org.farhan.impl.ProposeTestStepActionImpl;
import org.farhan.impl.ProposeTestStepTableActionImpl;
import org.farhan.impl.SheepDogFactoryImpl;
import org.farhan.impl.ValidateCellActionImpl;
import org.farhan.impl.ValidateDialogImpl;
import org.farhan.impl.ValidateRowActionImpl;
import org.farhan.impl.ValidateTestStepActionImpl;
import org.farhan.impl.ValidateTestStepContainerActionImpl;
import org.farhan.impl.ValidateTestSuiteActionImpl;
import org.farhan.impl.ValidateTextActionImpl;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.farhan.objects.xtext.ProposeDialog;
import org.farhan.objects.xtext.ProposeTestStepAction;
import org.farhan.objects.xtext.ProposeTestStepTableAction;
import org.farhan.objects.xtext.ValidateCellAction;
import org.farhan.objects.xtext.ValidateDialog;
import org.farhan.objects.xtext.ValidateRowAction;
import org.farhan.objects.xtext.ValidateTestStepAction;
import org.farhan.objects.xtext.ValidateTestStepContainerAction;
import org.farhan.objects.xtext.ValidateTestSuiteAction;
import org.farhan.objects.xtext.ValidateTextAction;

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
		bind(GenerateStepDefinitionAction.class).to(GenerateStepDefinitionActionImpl.class);
		bind(InputFileAsciidocFile.class).to(InputFileAsciidocFileImpl.class);
		bind(org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile.class)
				.to(AppInputFileAsciidocFileImpl.class);
		bind(Process2AsciidocFile.class).to(Process2AsciidocFileImpl.class);
		bind(ValidateDialog.class).to(ValidateDialogImpl.class);
		bind(ValidateTestSuiteAction.class).to(ValidateTestSuiteActionImpl.class);
		bind(ValidateTestStepContainerAction.class).to(ValidateTestStepContainerActionImpl.class);
		bind(ValidateTestStepAction.class).to(ValidateTestStepActionImpl.class);
		bind(ValidateTextAction.class).to(ValidateTextActionImpl.class);
		bind(ValidateRowAction.class).to(ValidateRowActionImpl.class);
		bind(ValidateCellAction.class).to(ValidateCellActionImpl.class);
		bind(ProposeDialog.class).to(ProposeDialogImpl.class);
		bind(ProposeTestStepTableAction.class).to(ProposeTestStepTableActionImpl.class);
		bind(ProposeTestStepAction.class).to(ProposeTestStepActionImpl.class);
	}

}