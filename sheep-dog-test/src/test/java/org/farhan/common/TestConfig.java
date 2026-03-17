package org.farhan.common;

import org.farhan.impl.objects.AddDocumentActionImpl;
import org.farhan.impl.objects.EditDocumentActionImpl;
import org.farhan.impl.objects.Input2FileAsciidocFileImpl;
import org.farhan.impl.objects.InputFileAsciidocFileImpl;
import org.farhan.impl.objects.ProcessIssues2AsciidocFileImpl;
import org.farhan.impl.objects.ProcessGrammarFragmentAsciidocFileImpl;
import org.farhan.impl.objects.ProcessIssuesAsciidocFileImpl;
import org.farhan.impl.objects.TestObjectSheepDogImpl;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarFragmentAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssuesAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile;
import org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile;
import org.farhan.objects.xtext.AddDocumentAction;
import org.farhan.objects.xtext.EditDocumentAction;
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
        bind(AddDocumentAction.class).to(AddDocumentActionImpl.class);
        bind(EditDocumentAction.class).to(EditDocumentActionImpl.class);
        bind(InputFileAsciidocFile.class).to(InputFileAsciidocFileImpl.class);
        bind(Input2FileAsciidocFile.class).to(Input2FileAsciidocFileImpl.class);
        bind(ProcessIssues2AsciidocFile.class).to(ProcessIssues2AsciidocFileImpl.class);
        bind(ProcessGrammarFragmentAsciidocFile.class).to(ProcessGrammarFragmentAsciidocFileImpl.class);
        bind(ProcessIssuesAsciidocFile.class).to(ProcessIssuesAsciidocFileImpl.class);
    }

}