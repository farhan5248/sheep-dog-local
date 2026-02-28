package org.farhan.common;

import org.farhan.dsl.lang.SheepDogFactory;
import org.farhan.impl.ide.SheepDogFactoryImpl;
import org.farhan.impl.objects.AppInputFileAsciidocFileImpl;
import org.farhan.impl.objects.ApplyQuickfixActionImpl;
import org.farhan.impl.objects.ContentHighlightActionImpl;
import org.farhan.impl.objects.InputFileAsciidocFileImpl;
import org.farhan.impl.objects.ListProposalsActionImpl;
import org.farhan.impl.objects.ListProposalsPopupImpl;
import org.farhan.impl.objects.ListQuickfixesActionImpl;
import org.farhan.impl.objects.ListQuickfixesPopupImpl;
import org.farhan.impl.objects.Process2AsciidocFileImpl;
import org.farhan.impl.objects.ProcessGrammarAsciidocFileImpl;
import org.farhan.impl.objects.ValidateActionImpl;
import org.farhan.impl.objects.ValidateAnnotationImpl;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.farhan.objects.xtext.ApplyQuickfixAction;
import org.farhan.objects.xtext.ContentHighlightAction;
import org.farhan.objects.xtext.ListProposalsAction;
import org.farhan.objects.xtext.ListProposalsPopup;
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
        SheepDogFactory.instance = new SheepDogFactoryImpl();
        TestIDEObject.reset();
    }

    @Override
    protected void configure() {
        bind(InputFileAsciidocFile.class).to(InputFileAsciidocFileImpl.class);
        bind(org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.app.InputFileAsciidocFile.class)
                .to(AppInputFileAsciidocFileImpl.class);
        bind(Process2AsciidocFile.class).to(Process2AsciidocFileImpl.class);
        bind(ProcessGrammarAsciidocFile.class).to(ProcessGrammarAsciidocFileImpl.class);
        bind(ApplyQuickfixAction.class).to(ApplyQuickfixActionImpl.class);
        bind(ContentHighlightAction.class).to(ContentHighlightActionImpl.class);
        bind(ListProposalsAction.class).to(ListProposalsActionImpl.class);
        bind(ListProposalsPopup.class).to(ListProposalsPopupImpl.class);
        bind(ListQuickfixesAction.class).to(ListQuickfixesActionImpl.class);
        bind(ListQuickfixesPopup.class).to(ListQuickfixesPopupImpl.class);
        bind(ValidateAction.class).to(ValidateActionImpl.class);
        bind(ValidateAnnotation.class).to(ValidateAnnotationImpl.class);
    }

}