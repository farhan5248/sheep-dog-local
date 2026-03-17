package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssues2AsciidocFileImpl extends TestObjectSheepDogImpl implements ProcessIssues2AsciidocFile {

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTestSuiteName(HashMap<String, String> keyMap) {
        ITestSuite doc = (ITestSuite) getProperty("cursor");
        return doc.getName();
    }

}
