package org.farhan.common;

import org.farhan.dsl.grammar.SheepDogFactory;
import org.farhan.impl.ide.SheepDogFactoryImpl;
import org.farhan.impl.objects.EditDocumentNodeActionImpl;
import org.farhan.impl.objects.AddDocumentActionImpl;
import org.farhan.impl.objects.AddDocumentNodeActionImpl;
import org.farhan.impl.objects.AppInputFileAsciidocFileImpl;
import org.farhan.impl.objects.Input2FileAsciidocFileImpl;
import org.farhan.impl.objects.InputFileAsciidocFileImpl;
import org.farhan.impl.objects.ListProposalsPopupImpl;
import org.farhan.impl.objects.ListQuickfixesPopupImpl;
import org.farhan.impl.objects.ProcessGrammarFragmentAsciidocFileImpl;
import org.farhan.impl.objects.ProcessIssues2AsciidocFileImpl;
import org.farhan.impl.objects.ProcessIssuesAsciidocFileImpl;
import org.farhan.impl.objects.TestObjectSheepDogImpl;
import org.farhan.impl.objects.ValidateAnnotationImpl;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarFragmentAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.farhan.objects.xtext.EditDocumentNodeAction;
import org.farhan.objects.xtext.AddDocumentAction;
import org.farhan.objects.xtext.AddDocumentNodeAction;
import org.farhan.objects.xtext.ListProposalsPopup;
import org.farhan.objects.xtext.ListQuickfixesPopup;
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
        SheepDogFactory.instance = new SheepDogFactoryImpl();
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
        bind(EditDocumentNodeAction.class).to(EditDocumentNodeActionImpl.class);
        bind(AddDocumentAction.class).to(AddDocumentActionImpl.class);
        bind(AddDocumentNodeAction.class).to(AddDocumentNodeActionImpl.class);
        bind(ListProposalsPopup.class).to(ListProposalsPopupImpl.class);
        bind(ListQuickfixesPopup.class).to(ListQuickfixesPopupImpl.class);
        bind(ValidateAnnotation.class).to(ValidateAnnotationImpl.class);
    }

}