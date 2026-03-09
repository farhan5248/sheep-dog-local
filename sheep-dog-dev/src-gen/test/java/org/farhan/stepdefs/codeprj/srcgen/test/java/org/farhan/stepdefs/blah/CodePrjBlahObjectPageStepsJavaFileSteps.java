package org.farhan.stepdefs.codeprj.srcgen.test.java.org.farhan.stepdefs.blah;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.stepdefs.blah.BlahObjectPageStepsJavaFile;

@ScenarioScoped
public class CodePrjBlahObjectPageStepsJavaFileSteps extends TestSteps {

    @Inject
    public CodePrjBlahObjectPageStepsJavaFileSteps(BlahObjectPageStepsJavaFile object) {
        super(object, "code-prj", "src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java");
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java file Header section will be created as follows$")
    public void headerSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "HeaderSection");
        object.assertInputOutputsDataTable(dataTable, "HeaderSection");
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java file Methods section will be created as follows$")
    public void methodsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "MethodsSection");
        object.assertInputOutputsDataTable(dataTable, "MethodsSection");
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputsState("Created as follows");
        object.setInputOutputsDocString("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertInputOutputsState("Created as follows");
        object.assertInputOutputsDocString("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/stepdefs/blah/BlahObjectPageSteps.java file will be present$")
    public void willBePresent() {
        object.assertInputOutputsState("Present");
    }
}
