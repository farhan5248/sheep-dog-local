package org.farhan.impl.objects;

import java.util.HashMap;

import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestSuite;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessIssues2AsciidocFile;

public class ProcessIssues2AsciidocFileImpl extends TestObjectSheepDogImpl implements ProcessIssues2AsciidocFile {

    @Override
    public String getCreatedAsFollows(HashMap<String, String> keyMap) {
        setProperty("cursor", ((ITestProject) getProperty("workspace")).getTestDocument(getFullNameFromPath()));
        return getProperty("cursor") == null ? null : getProperty("cursor").toString();
    }

    @Override
    public String getTestSuiteName(HashMap<String, String> keyMap) {
        if (getProperty("cursor") == null)
            return null;
        return ((ITestSuite) getProperty("cursor")).getName();
    }

}
