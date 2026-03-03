package org.farhan.stepdefs.specprj.src.test.resources.asciidoc.specs;

import com.google.inject.Inject;
import io.cucumber.datatable.DataTable;
import io.cucumber.guice.ScenarioScoped;
import io.cucumber.java.en.Given;
import org.farhan.common.TestSteps;
import org.farhan.objects.specprj.src.test.resources.asciidoc.specs.ProcessGrammarTypeAsciidocFile;

@ScenarioScoped
public class SpecPrjProcessGrammarTypeAsciidocFileSteps extends TestSteps {

    @Inject
    public SpecPrjProcessGrammarTypeAsciidocFileSteps(ProcessGrammarTypeAsciidocFile object) {
        super(object, "spec-prj", "src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Cell type assignments will be as follows$")
    public void cellTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Cell type is as follows$")
    public void cellTypeIsAsFollows() {
        object.setInputOutputs("As follows", "CellType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Description type assignments will be as follows$")
    public void descriptionTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Description type is as follows$")
    public void descriptionTypeIsAsFollows() {
        object.setInputOutputs("As follows", "DescriptionType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Line type assignments will be as follows$")
    public void lineTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Line type is as follows$")
    public void lineTypeIsAsFollows() {
        object.setInputOutputs("As follows", "LineType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Model type concrete types will be as follows$")
    public void modelTypeConcreteTypesWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Model type is as follows$")
    public void modelTypeIsAsFollows() {
        object.setInputOutputs("As follows", "ModelType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file NestedDescription type assignments will be as follows$")
    public void nestedDescriptionTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file NestedDescription type is as follows$")
    public void nestedDescriptionTypeIsAsFollows() {
        object.setInputOutputs("As follows", "NestedDescriptionType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Row type assignments will be as follows$")
    public void rowTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Row type is as follows$")
    public void rowTypeIsAsFollows() {
        object.setInputOutputs("As follows", "RowType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file StepDefinition type assignments will be as follows$")
    public void stepDefinitionTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file StepDefinition type is as follows$")
    public void stepDefinitionTypeIsAsFollows() {
        object.setInputOutputs("As follows", "StepDefinitionType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file StepObject type assignments will be as follows$")
    public void stepObjectTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file StepObject type derived attributes will be as follows$")
    public void stepObjectTypeDerivedAttributesWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file StepObject type is as follows$")
    public void stepObjectTypeIsAsFollows() {
        object.setInputOutputs("As follows", "StepObjectType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file StepObject type is created as follows$")
    public void stepObjectTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "StepObjectType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file StepParameters type assignments will be as follows$")
    public void stepParametersTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file StepParameters type is as follows$")
    public void stepParametersTypeIsAsFollows() {
        object.setInputOutputs("As follows", "StepParametersType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Table type assignments will be as follows$")
    public void tableTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Table type is as follows$")
    public void tableTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TableType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestCase type assignments will be as follows$")
    public void testCaseTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestCase type is as follows$")
    public void testCaseTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TestCaseType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestData type assignments will be as follows$")
    public void testDataTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestData type is as follows$")
    public void testDataTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TestDataType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestProject type assignments will be as follows$")
    public void testProjectTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestProject type is as follows$")
    public void testProjectTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TestProjectType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSetup type assignments will be as follows$")
    public void testSetupTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSetup type is as follows$")
    public void testSetupTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TestSetupType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestStep type assignments will be as follows$")
    public void testStepTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestStep type concrete types will be as follows$")
    public void testStepTypeConcreteTypesWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestStep type derived attributes will be as follows$")
    public void testStepTypeDerivedAttributesWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestStep type is as follows$")
    public void testStepTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TestStepType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestStep type is created as follows$")
    public void testStepTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestStepType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestStepContainer type concrete types will be as follows$")
    public void testStepContainerTypeConcreteTypesWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestStepContainer type is as follows$")
    public void testStepContainerTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TestStepContainerType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSuite type assignments will be as follows$")
    public void testSuiteTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSuite type derived attributes will be as follows$")
    public void testSuiteTypeDerivedAttributesWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSuite type is as follows$")
    public void testSuiteTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TestSuiteType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file TestSuite type is created as follows$")
    public void testSuiteTypeIsCreatedAsFollows(DataTable dataTable) {
        object.setInputOutputs(dataTable, "TestSuiteType");
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Text type assignments will be as follows$")
    public void textTypeAssignmentsWillBeAsFollows(DataTable dataTable) {
        object.assertInputOutputs(dataTable);
    }

    @Given("^The spec-prj project src/test/resources/asciidoc/specs/ProcessGrammarType.asciidoc file Text type is as follows$")
    public void textTypeIsAsFollows() {
        object.setInputOutputs("As follows", "TextType");
    }
}
