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
        object.assertInputOutputsState("Created as follows", "Header section");
        object.assertInputOutputsDataTable(dataTable, "Header section");
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file Methods section will be created as follows$")
    public void methodsSectionWillBeCreatedAsFollows(DataTable dataTable) {
        object.assertInputOutputsState("Created as follows", "Methods section");
        object.assertInputOutputsDataTable(dataTable, "Methods section");
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file is created as follows$")
    public void isCreatedAsFollows(String docString) {
        object.setInputOutputsState("Created as follows");
        object.setInputOutputsDocString("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file will be created as follows$")
    public void willBeCreatedAsFollows(String docString) {
        object.assertInputOutputsState("Created as follows");
        object.assertInputOutputsDocString("Content", docString);
    }

    @Given("^The code-prj project src-gen/test/java/org/farhan/objects/blah/ObjectPage.java file will be present$")
    public void willBePresent() {
        object.assertInputOutputsState("Present");
    }
}
