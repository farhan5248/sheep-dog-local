package org.farhan.mbt.asciidoctor;

import java.util.TreeSet;
import org.farhan.mbt.core.Converter;
import org.farhan.dsl.lang.IResourceRepository;
import org.farhan.dsl.lang.SheepDogFactory;
import org.farhan.mbt.core.UMLStepObject;
import org.farhan.mbt.core.UMLTestCase;
import org.farhan.mbt.core.UMLTestData;
import org.farhan.mbt.core.UMLTestSetup;
import org.farhan.mbt.core.UMLTestStep;
import org.farhan.mbt.core.UMLTestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.farhan.mbt.core.UMLTestProject;
import org.farhan.dsl.sheepdog.sheepDog.TestStepContainer;
import org.farhan.dsl.sheepdog.sheepDog.TestData;
import org.farhan.dsl.lang.TestStepUtility;
import org.farhan.dsl.sheepdog.impl.SheepDogFactoryImpl;
import org.farhan.dsl.sheepdog.impl.TestStepImpl;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;

public class ConvertAsciidoctorToUML extends Converter {

	private static final Logger logger = LoggerFactory.getLogger(ConvertAsciidoctorToUML.class);
	// TODO why is this static?
	private static TreeSet<String> stepObjects = new TreeSet<String>();
	private static TreeSet<String> stepDefinitions = new TreeSet<String>();
	protected AsciiDoctorPathConverter pathConverter;
	private AsciiDoctorTestSuite srcObjTestSuite;
	private AsciiDoctorStepObject srcObjStepObject;

	public ConvertAsciidoctorToUML(String tags, IResourceRepository fa) {
		super(tags, fa);
	}

	@Override
	public void clearProjects() throws Exception {
		fa.clear(tags);
		stepObjects.clear();
		stepDefinitions.clear();
	}

	@Override
	public String convertFile(String path, String content) throws Exception {
		// TODO call initProjects outside of this method like clearObjects. When run as
		// a service, then the client will call initObjects once and then call
		// convertObject multiple times
		initProjects();
		if (path.startsWith(project.getDir(project.TEST_STEPS))) {
			convertStepObject(path, content);
		} else {
			convertTestSuite(path, content);
		}
		// TODO this method shouldn't return empty string, there needs to be the
		// equivalent of PUT (void) and GET (String) return types
		return "";
	}

	private void convertStepDefinition(org.farhan.mbt.core.UMLStepDefinition stepDefinition,
			StepDefinition srcStepDefinition) {
		logger.debug("step definition: " + srcStepDefinition.getName());
		stepDefinition.setNameLong(srcObjStepObject.getStepDefinitionNameLong(srcStepDefinition));
		stepDefinition.setDescription(srcObjStepObject.getStepDefinitionDescription(srcStepDefinition));
		for (StepParameters sp : srcObjStepObject.getStepParametersList(srcStepDefinition)) {
			convertStepParameters(stepDefinition.addStepParameters(srcObjStepObject.getStepParametersName(sp)), sp);
		}
	}

	private void convertStepObject(String path, String content) throws Exception {
		logger.debug("step object: " + path);
		srcObjStepObject = (AsciiDoctorStepObject) project.addFile(path);
		srcObjStepObject.parse(content);
		if (isStepObjectSelected()) {
			UMLStepObject stepObject = model.addStepObject(pathConverter.convertUMLPath(srcObjStepObject.getPath()));
			stepObject.setDescription(srcObjStepObject.getStepObjectDescription());
			for (StepDefinition sd : srcObjStepObject.getStepDefinitionList()) {
				if (stepDefinitions.contains(srcObjStepObject.getStepDefinitionNameLong(sd))) {
					convertStepDefinition(stepObject.addStepDefinition(srcObjStepObject.getStepDefinitionName(sd)), sd);
				}
			}
			model.save();
		} else {
			project.deleteObject(srcObjStepObject);
		}
	}

	private void convertStepParameters(org.farhan.mbt.core.UMLStepParameters stepParameters,
			StepParameters srcStepParameters) {
		logger.debug("step parameter: " + srcStepParameters.getName());
		stepParameters.setTable(srcObjStepObject.getStepParametersTable(srcStepParameters));
	}

	private void convertTestCase(TestStepContainer srcTestCase, UMLTestCase testCase) throws Exception {
		logger.debug("test case: " + srcTestCase.getName());
		testCase.setTags(srcObjTestSuite.getAbstractScenarioTags(srcTestCase));
		testCase.setDescription(srcObjTestSuite.getScenarioDescription(srcTestCase));
		for (TestStep srcStep : srcObjTestSuite.getStepList(srcTestCase)) {
			convertTestStep(testCase.addTestStep(srcObjTestSuite.getStepName(srcStep)), srcStep);
		}
		for (TestData srcExamples : srcObjTestSuite.getExamplesList(srcTestCase)) {
			convertTestData(testCase.addTestData(srcObjTestSuite.getExamplesName(srcExamples)), srcExamples);
		}
	}

	private void convertTestData(UMLTestData examples, TestData srcExamples) {
		logger.debug("test data: " + srcExamples.getName());
		examples.setTags(srcObjTestSuite.getExamplesTags(srcExamples));
		examples.setDescription(srcObjTestSuite.getExamplesDescription(srcExamples));
		examples.setTable(srcObjTestSuite.getExamplesTable(srcExamples));
		for (Row row : srcObjTestSuite.getExamplesRowList(srcExamples)) {
			examples.addRow(srcObjTestSuite.getExamplesRow(srcExamples, row));
		}
	}

	private void convertTestSetup(TestStepContainer srcBackground, UMLTestSetup background) throws Exception {
		logger.debug("test setup: " + srcBackground.getName());
		background.setTags(srcObjTestSuite.getAbstractScenarioTags(srcBackground));
		background.setDescription(srcObjTestSuite.getBackgroundDescription(srcBackground));
		for (TestStep srcStep : srcObjTestSuite.getStepList(srcBackground)) {
			convertTestStep(background.addTestStep(srcObjTestSuite.getStepName(srcStep)), srcStep);
		}
	}

	private void convertTestStep(UMLTestStep step, TestStep srcStep) throws Exception {
		logger.debug("test step: " + srcStep.getStepObjectName() + " " + srcStep.getStepDefinitionName());
		stepObjects.add(TestStepUtility.getStepObjectQualifiedName(new TestStepImpl(srcStep)));
		step.setKeyword(srcObjTestSuite.getStepKeyword(srcStep));
		step.setNameLong(srcObjTestSuite.getStepNameLong(srcStep));
		stepDefinitions.add(step.getNameLong().replaceFirst(step.getKeyword(), "").trim());
		if (srcObjTestSuite.hasDocString(srcStep)) {
			step.setStepText(srcObjTestSuite.getDocString(srcStep));
		} else if (srcObjTestSuite.hasStepTable(srcStep)) {
			step.setStepData(srcObjTestSuite.getStepTable(srcStep));
		}
	}

	private void convertTestSuite(String path, String content) throws Exception {
		logger.debug("test suite: " + path);
		srcObjTestSuite = (AsciiDoctorTestSuite) project.addFile(path);
		srcObjTestSuite.parse(content);
		if (tags.isEmpty() || isTestSuiteSelected() || isAnyTestCaseSelected()) {
			UMLTestSuite testSuite = model.addTestSuite(pathConverter.convertUMLPath(srcObjTestSuite.getPath()));
			testSuite.setTags(srcObjTestSuite.getFeatureTags());
			testSuite.setDescription(srcObjTestSuite.getFeatureDescription());
			for (TestStepContainer srcTestCase : srcObjTestSuite.getAbstractScenarioList()) {
				if (srcObjTestSuite.isBackground(srcTestCase)) {
					convertTestSetup(srcTestCase,
							testSuite.addTestSetup(srcObjTestSuite.getBackgroundName(srcTestCase)));
				} else if (tags.isEmpty() || isTestSuiteSelected() || isTestCaseSelected(srcTestCase)) {
					convertTestCase(srcTestCase, testSuite.addTestCase(srcObjTestSuite.getScenarioName(srcTestCase)));
				}
			}
			model.save();
		} else {
			project.deleteObject(srcObjTestSuite);
		}
	}

	public void initProjects() throws Exception {
		project = new AsciiDoctorTestProject(this.tags, this.fa);
		model = new UMLTestProject(this.tags, this.fa);
		project.init();
		model.init();
		pathConverter = new AsciiDoctorPathConverter(model, (AsciiDoctorTestProject) project);
		SheepDogFactory.instance = new SheepDogFactoryImpl(this.fa);
	}

	private boolean isAnyTestCaseSelected() {
		for (TestStepContainer a : srcObjTestSuite.getAbstractScenarioList()) {
			if (isTestCaseSelected(a)) {
				return true;
			}
		}
		return false;
	}

	private boolean isStepObjectSelected() {
		for (String s : stepObjects) {
			if (srcObjStepObject.getPath().contentEquals(project.getDir(project.TEST_STEPS) + "/" + s)) {
				return true;
			}
		}
		return false;
	}

	private boolean isTestCaseSelected(TestStepContainer a) {
		for (String t : srcObjTestSuite.getAbstractScenarioTags(a)) {
			if (t.trim().contentEquals(tags)) {
				return true;
			}
		}
		return false;
	}

	private boolean isTestSuiteSelected() throws Exception {
		// TODO this needs a test case
		for (String t : srcObjTestSuite.getFeatureTags()) {
			logger.debug("feature tag: " + t);
			if (t.trim().contentEquals(tags)) {
				return true;
			}
		}
		return false;
	}
}
