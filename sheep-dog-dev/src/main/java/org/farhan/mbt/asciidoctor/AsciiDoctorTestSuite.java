package org.farhan.mbt.asciidoctor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.impl.RuleCallImpl;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.resource.SaveOptions;
import org.farhan.dsl.common.LanguageHelper;
import org.farhan.dsl.common.StatementNameHelper;
import org.farhan.dsl.common.TestStepNameHelper;
import org.farhan.dsl.sheepdog.LanguageAccessImpl;
import org.farhan.dsl.sheepdog.sheepDog.TestStepContainer;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.TestData;
import org.farhan.dsl.sheepdog.sheepDog.TestSuite;
import org.farhan.mbt.core.ConvertibleObject;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;

public class AsciiDoctorTestSuite implements ConvertibleObject {

	private TestSuite theFeature;
	private String thePath;

	public AsciiDoctorTestSuite(String thePath) {
		this.thePath = thePath;
		// TODO don't assume it's a feature, it could be a StepObject. Mimic the Java
		// Wrapper and how it handles interfaces vs classes.
		String[] pathParts = thePath.split("/");
		String name = pathParts[pathParts.length - 1].replace(".asciidoc", "");
		theFeature = SheepDogFactory.eINSTANCE.createTestSuite();
		theFeature.setName(name);
	}

	public TestSetup addBackground(String backgroundName) {
		deleteAbstractScenario(backgroundName);
		TestSetup background = SheepDogFactory.eINSTANCE.createTestSetup();
		background.setName(backgroundName);
		theFeature.getTestStepContainerList().add(background);
		return background;
	}

	public TestData addExamples(TestCase abstractScenario, String examplesName) {
		TestData examples = SheepDogFactory.eINSTANCE.createTestData();
		examples.setName(examplesName);
		abstractScenario.getTestDataList().add(examples);
		return examples;
	}

	public void addExamplesRow(TestData examples, ArrayList<String> examplesRow) {
		Row row = SheepDogFactory.eINSTANCE.createRow();
		for (String srcCell : examplesRow) {
			Cell cell = SheepDogFactory.eINSTANCE.createCell();
			cell.setName(srcCell);
			row.getCellList().add(cell);
		}
		examples.getTable().getRowList().add(row);
	}

	public TestCase addScenario(String scenarioName) {
		deleteAbstractScenario(scenarioName);
		TestCase scenario = SheepDogFactory.eINSTANCE.createTestCase();
		scenario.setName(scenarioName);
		theFeature.getTestStepContainerList().add(scenario);
		return scenario;
	}

	@SuppressWarnings("null")
	public TestStep addStep(TestStepContainer abstractScenario, String name) {
		String keyword = name.split(" ")[0];
		TestStep step = null;
		switch (keyword) {
		case "Given:":
			step = SheepDogFactory.eINSTANCE.createGiven();
			break;
		case "When:":
			step = SheepDogFactory.eINSTANCE.createWhen();
			break;
		case "Then:":
			step = SheepDogFactory.eINSTANCE.createThen();
			break;
		case "And:":
			step = SheepDogFactory.eINSTANCE.createAnd();
			break;
		}
		step.setName(name.substring(keyword.length() + 1));
		abstractScenario.getTestStepList().add(step);
		return step;
	}

	private String convertStatementsToString(EList<Statement> statements) {
		String contents = "";
		for (Statement s : statements) {
			contents += s.getName() + "\n";
		}
		return contents.trim();
	}

	public TestCase createScenarioOutline(String scenarioName) {
		return addScenario(scenarioName);
	}

	public void createStepTable(TestStep step, ArrayList<ArrayList<String>> stepTableRowList) {
		step.setTable(SheepDogFactory.eINSTANCE.createTable());
		for (ArrayList<String> srcRow : stepTableRowList) {
			Row row = SheepDogFactory.eINSTANCE.createRow();
			for (String srcCell : srcRow) {
				Cell cell = SheepDogFactory.eINSTANCE.createCell();
				srcCell = srcCell.replace("<", "{").replace(">", "}");
				cell.setName(srcCell);
				row.getCellList().add(cell);
			}
			step.getTable().getRowList().add(row);
		}
	}

	private void deleteAbstractScenario(String name) {
		EList<TestStepContainer> list = theFeature.getTestStepContainerList();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contentEquals(name)) {
				list.remove(i);
				return;
			}
		}
	}

	@Override
	public Object get() {
		return theFeature;
	}

	public EList<TestStepContainer> getAbstractScenarioList() {
		return theFeature.getTestStepContainerList();
	}

	public ArrayList<String> getAbstractScenarioTags(TestStepContainer abstractScenario) {
		ArrayList<String> tags = new ArrayList<String>();
		for (Statement s : abstractScenario.getStatementList()) {
			tags.addAll(StatementNameHelper.getTags(s.getName()));
		}
		return tags;
	}

	public String getBackgroundDescription(TestStepContainer abstractScenario) {
		return convertStatementsToString(abstractScenario.getStatementList());
	}

	public String getBackgroundName(TestStepContainer abstractScenario) {
		return abstractScenario.getName();
	}

	public String getDocString(TestStep step) {
		return step.getText().getName().replaceFirst("^----\n", "").replaceFirst("\n----$", "").replace("\\----",
				"----");
	}

	public EList<TestData> getExamplesList(TestStepContainer abstractScenario) {
		return ((TestCase) abstractScenario).getTestDataList();
	}

	public String getExamplesName(TestData examples) {
		return examples.getName();
	}

	public ArrayList<String> getExamplesRow(TestData examples, Row examplesRow) {
		ArrayList<String> row = new ArrayList<String>();
		EList<Cell> header = examples.getTable().getRowList().getFirst().getCellList();
		for (int i = 0; i < header.size(); i++) {
			row.add(examplesRow.getCellList().get(i).getName());
		}
		return row;
	}

	public ArrayList<Row> getExamplesRowList(TestData examples) {
		ArrayList<Row> body = new ArrayList<Row>();
		body.addAll(examples.getTable().getRowList());
		body.remove(0);
		return body;
	}

	public ArrayList<String> getExamplesTable(TestData examples) {
		ArrayList<String> header = new ArrayList<String>();
		for (Cell c : examples.getTable().getRowList().getFirst().getCellList()) {
			header.add(c.getName());
		}
		return header;
	}

	public ArrayList<String> getExamplesTags(TestData examples) {
		ArrayList<String> tags = new ArrayList<String>();
		if (examples.getStatementList() != null) {
			for (Statement s : examples.getStatementList().getStatementList()) {
				tags.addAll(StatementNameHelper.getTags(s.getName()));
			}
		}
		return tags;
	}

	public String getFeatureDescription() {
		return convertStatementsToString(theFeature.getStatementList());
	}

	public String getFeatureName() {
		return theFeature.getName();
	}

	public ArrayList<String> getFeatureTags() {
		ArrayList<String> tags = new ArrayList<String>();
		for (Statement s : theFeature.getStatementList()) {
			tags.addAll(StatementNameHelper.getTags(s.getName()));
		}
		return tags;
	}

	@Override
	public String getPath() {
		return thePath;
	}

	public String getScenarioDescription(TestStepContainer scenario) {
		return convertStatementsToString(scenario.getStatementList());
	}

	public String getScenarioName(TestStepContainer abstractScenario) {
		return abstractScenario.getName();
	}

	public String getScenarioOutlineDescription(TestStepContainer abstractScenario) {
		return convertStatementsToString(abstractScenario.getStatementList());
	}

	public String getScenarioOutlineName(TestStepContainer abstractScenario) {
		return abstractScenario.getName();
	}

	public String getStepDefinitionDescription(StepDefinition stepDefinitionSrc) {
		return convertStatementsToString(stepDefinitionSrc.getStatementList());
	}

	public String getStepDefinitionName(StepDefinition stepDefinitionSrc) {
		return stepDefinitionSrc.getName();
	}

	public String getStepDefinitionNameLong(StepDefinition stepDefinitionSrc) {
		String noRoot = getPath().replaceFirst("^src/test/resources/asciidoc/stepdefs/", "");
		String component = noRoot.split("/")[0];
		String object = noRoot.replaceFirst("^" + component + "/", "").replaceFirst(".asciidoc$", "");
		return "The " + component + ", " + object + " " + stepDefinitionSrc.getName();
	}

	public String getStepKeyword(TestStep step) {
		CompositeNodeWithSemanticElement keyword = (CompositeNodeWithSemanticElement) step.eAdapters().getFirst();
		RuleCallImpl rc = (RuleCallImpl) keyword.getGrammarElement();
		return rc.getRule().getName() + ":";
	}

	public EList<TestStep> getStepList(TestStepContainer abstractScenario) {
		return abstractScenario.getTestStepList();
	}

	public String getStepName(TestStep step) {
		return getStepKeyword(step) + " " + step.getName();
	}

	public String getStepNameLong(TestStep step) {
		String stepObjectNameLong = LanguageHelper.getStepObjectQualifiedName(new LanguageAccessImpl(step));
		String component = stepObjectNameLong.split("/")[0];
		String object = stepObjectNameLong.replaceFirst("^" + component + "/", "").replaceFirst(".asciidoc$", "");
		String stepNameLong = "The " + component + ", " + object + " "
				+ TestStepNameHelper.getPredicate(step.getName());
		return getStepKeyword(step) + " " + stepNameLong;
	}

	public EList<StepParameters> getStepParametersList(StepDefinition stepDefinitionSrc) {
		return stepDefinitionSrc.getStepParameterList();
	}

	public String getStepParametersName(StepParameters stepParametersSrc) {
		return stepParametersSrc.getName();
	}

	public ArrayList<String> getStepParametersRow(StepParameters stepParametersSrc, Row parametersRow) {
		ArrayList<String> row = new ArrayList<String>();
		EList<Cell> header = stepParametersSrc.getTable().getRowList().getFirst().getCellList();
		for (int i = 0; i < header.size(); i++) {
			row.add(parametersRow.getCellList().get(i).getName());
		}
		return row;
	}

	public ArrayList<Row> getStepParametersRowList(StepParameters stepParametersSrc) {
		ArrayList<Row> body = new ArrayList<Row>();
		body.addAll(stepParametersSrc.getTable().getRowList());
		body.remove(0);
		return body;
	}

	public ArrayList<String> getStepParametersTable(StepParameters stepParametersSrc) {
		ArrayList<String> header = new ArrayList<String>();
		for (Cell c : stepParametersSrc.getTable().getRowList().getFirst().getCellList()) {
			header.add(c.getName());
		}
		return header;
	}

	public ArrayList<ArrayList<String>> getStepTable(TestStep step) {
		ArrayList<ArrayList<String>> stepTableRowList = new ArrayList<ArrayList<String>>();
		ArrayList<String> row;
		for (Row r : step.getTable().getRowList()) {
			row = new ArrayList<String>();
			for (Cell c : r.getCellList()) {
				row.add(c.getName());
			}
			stepTableRowList.add(row);
		}
		return stepTableRowList;

	}

	public boolean hasDocString(TestStep step) {
		return step.getText() != null;
	}

	public boolean hasStepTable(TestStep step) {
		return step.getTable() != null;
	}

	public boolean isBackground(TestStepContainer abstractScenario) {
		return abstractScenario instanceof TestSetup;
	}

	@Override
	public void parse(String text) throws Exception {
		try {
			if (text.isEmpty()) {
				return;
			}
			URI uri = URI.createFileURI(thePath);
			Resource resource = new ResourceSetImpl().createResource(uri);
			InputStream content = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
			resource.load(content, Collections.EMPTY_MAP);
			theFeature = (TestSuite) resource.getContents().get(0);
		} catch (Exception e) {
			throw new Exception("There was a problem parsing file: " + thePath);
		}
	}

	public void setBackgroundDescription(TestSetup background, String backgroundDescription) {
		setDescription(background, backgroundDescription);
	}

	private void setDescription(TestStepContainer abstractScenario, String scenarioDescription) {
		if (!scenarioDescription.isEmpty()) {
			abstractScenario.getStatementList().clear();
			for (String line : scenarioDescription.split("\n")) {
				Statement statement = SheepDogFactory.eINSTANCE.createStatement();
				statement.setName(line);
				abstractScenario.getStatementList().add(statement);
			}
		}
	}

	public void setDocString(TestStep step, String docString) {
		step.setText(SheepDogFactory.eINSTANCE.createText());
		step.getText().setName("----\n" + docString.replace("----", "\\----") + "\n----");
	}

	public void setExamplesTable(TestData examples, ArrayList<String> headers) {
		examples.setTable(SheepDogFactory.eINSTANCE.createTable());
		Row row = SheepDogFactory.eINSTANCE.createRow();
		for (String srcCell : headers) {
			Cell cell = SheepDogFactory.eINSTANCE.createCell();
			cell.setName(srcCell);
			row.getCellList().add(cell);
		}
		examples.getTable().getRowList().add(row);
	}

	public void setFeatureDescription(String featureDescription) {
		if (!featureDescription.isEmpty()) {
			theFeature.getStatementList().clear();
			for (String line : featureDescription.split("\n")) {
				Statement statement = SheepDogFactory.eINSTANCE.createStatement();
				statement.setName(line);
				theFeature.getStatementList().add(statement);
			}
		}
	}

	public void setFeatureName(String featureName) {
		theFeature.setName(featureName);
	}

	public void setScenarioDescription(TestCase scenario, String scenarioDescription) {
		setDescription(scenario, scenarioDescription);
	}

	public void setScenarioOutlineDescription(TestCase scenarioOutline, String scenarioOutlineDescription) {
		setDescription(scenarioOutline, scenarioOutlineDescription);
	}

	public void setStepDefinitionDescription(StepDefinition stepDefinition, String stepDefinitionDescription) {
		if (!stepDefinitionDescription.isEmpty()) {
			for (String line : stepDefinitionDescription.split("\n")) {
				Statement statement = SheepDogFactory.eINSTANCE.createStatement();
				// TODO test what happens if there's multiple \n, don't assume there's just one.
				// Then create the EOL like Given is created
				statement.setName(line);
				stepDefinition.getStatementList().add(statement);
			}
		}
	}

	public String toString() {
		URI uri = URI.createFileURI(thePath);
		Resource resource = new ResourceSetImpl().createResource(uri);
		resource.getContents().add(theFeature);
		Map<Object, Object> options = SaveOptions.newBuilder().format().getOptions().toOptionsMap();
		OutputStream os = new ByteArrayOutputStream();
		try {
			resource.save(os, options);
		} catch (IOException e) {
			return null;
		}
		return os.toString();
	}

	public void setExamplesTags(TestData examples, ArrayList<String> tags) {
		// TODO the tags should be in the example description. This method is for tags
		// not in the source asciidoc files. It'll be addressed in another work-item
	}

	public String getExamplesDescription(TestData examples) {
		if (examples.getStatementList() != null) {
			return convertStatementsToString(examples.getStatementList().getStatementList());
		} else {
			return "";
		}
	}

	public void setExamplesDescription(TestData examples, String description) {
		if (!description.isEmpty()) {
			examples.setStatementList(SheepDogFactory.eINSTANCE.createStatementList());
			for (String line : description.split("\n")) {
				Statement statement = SheepDogFactory.eINSTANCE.createStatement();
				statement.setName(line);
				examples.getStatementList().getStatementList().add(statement);
			}
		}
	}

}
