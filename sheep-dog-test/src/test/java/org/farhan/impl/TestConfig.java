package org.farhan.impl;

import org.farhan.common.TestObject;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarFragmentAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.farhan.objects.xtext.AddDocumentAction;
import org.farhan.objects.xtext.AddDocumentNodeAction;
import org.farhan.objects.xtext.EditDocumentAction;
import org.farhan.objects.xtext.EditDocumentNodeAction;
import org.farhan.objects.xtext.ListQuickfixesAction;
import org.farhan.objects.xtext.ListQuickfixesPopup;
import org.farhan.objects.xtext.ValidateAction;
import org.farhan.objects.xtext.ValidateAnnotation;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Stage;

import io.cucumber.guice.CucumberModules;
import io.cucumber.guice.InjectorSource;
import io.cucumber.java.Before;

public final class TestConfig extends AbstractModule implements InjectorSource {

    @Override
    public Injector getInjector() {
        return Guice.createInjector(Stage.DEVELOPMENT, CucumberModules.createScenarioModule(), new TestConfig());
    }

    @Before
    public void resetTestProject() throws Exception {
        TestObject.reset();
        TestObjectSheepDogImpl.reset();
    }

    @Override
    protected void configure() {

        bind(org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile.class)
                .to(AppInputFileAsciidocFileImpl.class);
        bind(Input2FileAsciidocFile.class).to(Input2FileAsciidocFileImpl.class);
        bind(InputFileAsciidocFile.class).to(InputFileAsciidocFileImpl.class);
        bind(ProcessIssues2AsciidocFile.class).to(ProcessIssues2AsciidocFileImpl.class);
        bind(ProcessIssuesAsciidocFile.class).to(ProcessIssuesAsciidocFileImpl.class);
        bind(ProcessGrammarFragmentAsciidocFile.class).to(ProcessGrammarFragmentAsciidocFileImpl.class);
        bind(AddDocumentAction.class).to(AddDocumentActionImpl.class);
        bind(AddDocumentNodeAction.class).to(AddDocumentNodeActionImpl.class);
        bind(EditDocumentAction.class).to(EditDocumentActionImpl.class);
        bind(EditDocumentNodeAction.class).to(EditDocumentNodeActionImpl.class);
        bind(ListQuickfixesAction.class).to(ListQuickfixesActionImpl.class);
        bind(ListQuickfixesPopup.class).to(ListQuickfixesPopupImpl.class);
        bind(ValidateAction.class).to(ValidateActionImpl.class);
        bind(ValidateAnnotation.class).to(ValidateAnnotationImpl.class);
    }

}