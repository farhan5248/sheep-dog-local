package org.farhan.stepdefs.codeprj.srcgen.test.java.org.farhan.suites.blah;

import com.google.inject.Inject;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.suites.blah.BlahObjectPageStepsJavaFile;

@ScenarioScoped
public class CodePrjBlahObjectPageStepsJavaFileSteps extends TestSteps {

    @Inject
    public CodePrjBlahObjectPageStepsJavaFileSteps(BlahObjectPageStepsJavaFile object) {
        super(object, "code-prj", "src-gen/test/java/org/farhan/suites/blah/BlahObjectPageSteps.java");
    }

    @Given("^The code-prj project, src-gen/test/java/org/farhan/suites/blah/BlahObjectPageSteps.java file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertInputOutputs("Content", docString);
    }
}
