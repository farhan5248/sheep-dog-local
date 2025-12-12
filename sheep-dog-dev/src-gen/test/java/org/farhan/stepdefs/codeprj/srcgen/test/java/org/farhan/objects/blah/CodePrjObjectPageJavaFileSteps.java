package org.farhan.stepdefs.codeprj.srcgen.test.java.org.farhan.objects.blah;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.codeprj.srcgen.test.java.org.farhan.objects.blah.ObjectPageJavaFile;

@ScenarioScoped
public class CodePrjObjectPageJavaFileSteps extends TestSteps {

    @Inject
    public CodePrjObjectPageJavaFileSteps(ObjectPageJavaFile object) {
        super(object, "code-prj", "src-gen/test/java/org/farhan/objects/blah/ObjectPage.java");
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file Header section will be created as follows$")
    public void headerSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "HeaderSection");
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file Methods section will be created as follows$")
    public void methodsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable, "MethodsSection");
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputs("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertInputOutputs("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file will be present$")
    public void willBePresent() {
        object.assertInputOutputs("Present");
    }
}
