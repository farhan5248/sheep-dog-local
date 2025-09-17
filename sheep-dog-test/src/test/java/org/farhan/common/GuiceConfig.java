package org.farhan.common;

import org.farhan.impl.GenerateStepDefinitionActionImpl;
import org.farhan.impl.InputFileAsciidocFileImpl;
import org.farhan.impl.Process2AsciidocFileImpl;
import org.farhan.impl.ProposeContentDialogImpl;
import org.farhan.impl.ProposeTestStepActionImpl;
import org.farhan.impl.ProposeTestStepTableActionImpl;
import org.farhan.impl.QuickfixDialogImpl;
import org.farhan.impl.ValidateErrorActionImpl;
import org.farhan.impl.ValidateErrorDialogImpl;
import org.farhan.impl.ValidateWarningActionImpl;
import org.farhan.impl.ValidateWarningDialogImpl;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile;
import org.farhan.objects.xtext.GenerateStepDefinitionAction;
import org.farhan.objects.xtext.ProposeContentDialog;
import org.farhan.objects.xtext.ProposeTestStepAction;
import org.farhan.objects.xtext.ProposeTestStepTableAction;
import org.farhan.objects.xtext.QuickfixDialog;
import org.farhan.objects.xtext.ValidateErrorAction;
import org.farhan.objects.xtext.ValidateErrorDialog;
import org.farhan.objects.xtext.ValidateWarningAction;
import org.farhan.objects.xtext.ValidateWarningDialog;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;
import io.cucumber.java.Before;

public final class GuiceConfig extends AbstractModule implements InjectorSource {

	@Override
	protected void configure() {
		bind(GenerateStepDefinitionAction.class).to(GenerateStepDefinitionActionImpl.class);
		bind(InputFileAsciidocFile.class).to(InputFileAsciidocFileImpl.class);
		bind(org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile.class)
				.to(InputFileAsciidocFileImpl.class);
		bind(Process2AsciidocFile.class).to(Process2AsciidocFileImpl.class);
		bind(QuickfixDialog.class).to(QuickfixDialogImpl.class);
		bind(ValidateErrorAction.class).to(ValidateErrorActionImpl.class);
		bind(ValidateErrorDialog.class).to(ValidateErrorDialogImpl.class);
		bind(ProposeTestStepTableAction.class).to(ProposeTestStepTableActionImpl.class);
		bind(ProposeTestStepAction.class).to(ProposeTestStepActionImpl.class);
		bind(ProposeContentDialog.class).to(ProposeContentDialogImpl.class);
		bind(ValidateWarningAction.class).to(ValidateWarningActionImpl.class);
		bind(ValidateWarningDialog.class).to(ValidateWarningDialogImpl.class);
	}

	@Override
	public Injector getInjector() {
		return Guice.createInjector(Stage.DEVELOPMENT, CucumberModules.createScenarioModule(), new GuiceConfig());
	}

	@Before
	public void resetTestProject() throws Exception {
		// Not sure I like this approach, feels hacky
		TestObject.testProject = new TestProjectImpl();
	}

}