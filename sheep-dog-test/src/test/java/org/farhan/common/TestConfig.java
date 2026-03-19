package org.farhan.common;

import org.farhan.impl.objects.AddDocumentActionImpl;
import org.farhan.impl.objects.Input2FileAsciidocFileImpl;
import org.farhan.impl.objects.InputFileAsciidocFileImpl;
import org.farhan.impl.objects.TestObjectSheepDogImpl;
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
        bind(org.farhan.objects.xtext.AddDocumentAction.class).to(AddDocumentActionImpl.class);
        bind(org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.InputFileAsciidocFile.class)
                .to(InputFileAsciidocFileImpl.class);
        bind(org.farhan.objects.specprj.src.test.resources.asciidoc.stepdefs.dailybatchjob.Input2FileAsciidocFile.class)
                .to(Input2FileAsciidocFileImpl.class);
    }

}