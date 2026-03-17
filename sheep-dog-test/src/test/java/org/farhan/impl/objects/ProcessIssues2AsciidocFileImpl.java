package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;

import io.cucumber.guice.ScenarioScoped;

@ScenarioScoped
public class ProcessIssues2AsciidocFileImpl extends TestObjectSheepDogImpl implements ProcessIssues2AsciidocFile {

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        ITestProject workspace = (ITestProject) getProperty("workspace");
        ITestDocument doc = workspace.getTestDocument(getFullNameFromPath());
        setProperty("cursor", doc);
        return null;
    }

    @Override
    public String getTestSuiteName(HashMap<String, String> keyMap) {
        ITestSuite doc = (ITestSuite) getProperty("cursor");
        return doc.getName();
    }

}
