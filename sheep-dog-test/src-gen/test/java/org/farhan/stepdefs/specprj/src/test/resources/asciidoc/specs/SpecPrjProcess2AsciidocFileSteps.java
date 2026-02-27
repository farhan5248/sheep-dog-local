package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.Process2AsciidocFile;

@ScenarioScoped
public class SpecPrjProcess2AsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjProcess2AsciidocFileSteps(Process2AsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/specs/Process2.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite node is created as follows$")
    public void testSuiteNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite");
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1 node will be created as follows$")
    public void testSuite1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1");
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestCase node is created as follows$")
    public void testSuite1TestCaseNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestCase");
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestCase/1 node will be created as follows$")
    public void testSuite1TestCase1NodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestCase/1");
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestCase/1/TestStep node is created as follows$")
    public void testSuite1TestCase1TestStepNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestCase/1/TestStep");
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestCase/1/TestStep/1/Table/Row/1/Cell node is created as follows$")
    public void testSuite1TestCase1TestStep1TableRow1CellNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestCase/1/TestStep/1/Table/Row/1/Cell");
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestCase/1/TestStep/1/Table/Row/1/Cell node will be created as follows$")
    public void testSuite1TestCase1TestStep1TableRow1CellNodeWillBeCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestCase/1/TestStep/1/Table/Row/1/Cell/1");
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestCase/1/TestStep/1/Table/Row/2/Cell node is created as follows$")
    public void testSuite1TestCase1TestStep1TableRow2CellNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestCase/1/TestStep/1/Table/Row/2/Cell");
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestCase/1/TestStep/1/Text node is created as follows$")
    public void testSuite1TestCase1TestStep1TextNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestCase/1/TestStep/1/Text");
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestCase/2/TestStep node is created as follows$")
    public void testSuite1TestCase2TestStepNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestCase/2/TestStep");
        object.setInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/Process2.asciidoc file TestSuite/1/TestSetup/1/TestStep node is created as follows$")
    public void testSuite1TestSetup1TestStepNodeIsCreatedAsFollows(DataTable dataTable) {
        object.setPart("TestSuite/1/TestSetup/1/TestStep");
        object.setInputOutputs(dataTable);
    }
}
