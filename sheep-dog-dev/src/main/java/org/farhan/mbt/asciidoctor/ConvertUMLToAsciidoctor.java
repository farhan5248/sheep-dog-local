package org.farhan.mbt.asciidoctor;

import java.util.ArrayList;

import org.farhan.mbt.core.Converter;
import org.farhan.mbt.core.IObjectRepository;
import org.farhan.mbt.core.UMLStepObject;
import org.farhan.mbt.core.UMLTestCase;
import org.farhan.mbt.core.UMLTestData;
import org.farhan.mbt.core.UMLTestSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.farhan.mbt.core.UMLTestProject;
import org.farhan.mbt.core.UMLTestSetup;
import org.farhan.mbt.core.UMLTestStep;
import org.farhan.dsl.sheepdog.sheepDog.TestSetup;
import org.farhan.dsl.sheepdog.sheepDog.TestData;
import org.farhan.dsl.sheepdog.sheepDog.TestCase;
import org.farhan.dsl.sheepdog.sheepDog.TestStep;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;

public class ConvertUMLToAsciidoctor extends Converter {

	private static final Logger logger = LoggerFactory.getLogger(ConvertUMLToAsciidoctor.class);
	protected AsciiDoctorPathConverter pathConverter;
	private AsciiDoctorTestSuite tgtObjTestSuite;
	private AsciiDoctorStepObject tgtObjStepObject;

	public ConvertUMLToAsciidoctor(String tags, IObjectRepository fa) {
		super(tags, fa);
	}

	@Override
	public String convertFile(String path, String content) throws Exception {
		initProjects();
		if (path.startsWith(project.getDir(project.TEST_STEPS))) {
			return convertStepObject(path, content);
		} else {
			return convertTestSuite(path, content);
		}
	}

	private void convertStepDefinition(StepDefinition stepDefinition,
			org.farhan.mbt.core.UMLStepDefinition srcStepDefinition) throws Exception {
		logger.debug("step definition: " + srcStepDefinition.getName());
		tgtObjStepObject.setStepDefinitionDescription(stepDefinition,
				srcStepDefinition.getDescription(srcStepDefinition));
		for (org.farhan.mbt.core.UMLStepParameters sp : srcStepDefinition.getStepParametersList()) {
			convertStepParameters(tgtObjStepObject.addStepParameters(stepDefinition, sp.getName()), sp);
		}
	}

	private String convertStepObject(String path, String content) throws Exception {
		logger.debug("step object: " + path);
		UMLStepObject srcStepObject = model.getStepObject(pathConverter.findUMLPath(path));
		tgtObjStepObject = (AsciiDoctorStepObject) project.addFile(path);
		tgtObjStepObject.parse(content);
		tgtObjStepObject.setStepObjectName(srcStepObject.getName());
		tgtObjStepObject.setStepObjectDescription(srcStepObject.getDescription());
		for (org.farhan.mbt.core.UMLStepDefinition srcStepDefinition : srcStepObject.getStepDefinitionList()) {
			convertStepDefinition(tgtObjStepObject.addStepDefinition(srcStepDefinition.getName()), srcStepDefinition);
		}
		return tgtObjStepObject.toString();
	}

	private void convertStepParameters(StepParameters stepParameters,
			org.farhan.mbt.core.UMLStepParameters srcStepParameters) throws Exception {
		logger.debug("step parameter: " + srcStepParameters.getName());
		tgtObjStepObject.addStepParametersTable(stepParameters, srcStepParameters.getRowList().getFirst());
	}

	private void convertTestCase(TestCase scenario, UMLTestCase srcTestCase) {
		logger.debug("test case: " + srcTestCase.getName());
		tgtObjTestSuite.setScenarioDescription(scenario, srcTestCase.getDescription());
		for (UMLTestStep srcTestStep : srcTestCase.getTestStepList()) {
			convertTestStep(tgtObjTestSuite.addStep(scenario, srcTestStep.getName()), srcTestStep);
		}
		for (UMLTestData srcTestData : srcTestCase.getTestDataList()) {
			convertTestData(tgtObjTestSuite.addExamples(scenario, srcTestData.getName()), srcTestData);
		}
	}

	private void convertTestData(TestData examples, UMLTestData srcTestData) {
		logger.debug("test data: " + srcTestData.getName());
		tgtObjTestSuite.setExamplesDescription(examples, srcTestData.getDescription());
		tgtObjTestSuite.setExamplesTags(examples, srcTestData.getTags());
		tgtObjTestSuite.setExamplesTable(examples);
		for (ArrayList<String> row : srcTestData.getRowList()) {
			tgtObjTestSuite.addExamplesRow(examples, row);
		}
	}

	private void convertTestSetup(TestSetup background, UMLTestSetup srcTestSetup) {
		logger.debug("test setup: " + srcTestSetup.getName());
		tgtObjTestSuite.setBackgroundDescription(background, srcTestSetup.getDescription());
		for (UMLTestStep srcStep : srcTestSetup.getTestStepList()) {
			convertTestStep(tgtObjTestSuite.addStep(background, srcStep.getName()), srcStep);
		}
	}

	private void convertTestStep(TestStep step, UMLTestStep srcStep) {
		logger.debug("test step: " + srcStep.getName());
		if (srcStep.hasDocString()) {
			tgtObjTestSuite.setDocString(step, srcStep.getStepText());
		} else if (srcStep.hasStepTable()) {
			tgtObjTestSuite.createStepTable(step, srcStep.getStepData());
		}
	}

	private String convertTestSuite(String path, String content) throws Exception {
		logger.debug("test suite: " + path);
		UMLTestSuite srcTestSuite = model.getTestSuite(pathConverter.findUMLPath(path));
		tgtObjTestSuite = (AsciiDoctorTestSuite) project.addFile(path);
		tgtObjTestSuite.parse(content);
		tgtObjTestSuite.setFeatureName(srcTestSuite.getName());
		tgtObjTestSuite.setFeatureDescription(srcTestSuite.getDescription());

		if (srcTestSuite.hasTestSetup()) {
			convertTestSetup(tgtObjTestSuite.addBackground(srcTestSuite.getTestSetup().getName()),
					srcTestSuite.getTestSetup());
		}

		for (UMLTestCase srcTestCase : srcTestSuite.getTestCaseList()) {
			convertTestCase(tgtObjTestSuite.addScenario(srcTestCase.getName()), srcTestCase);
		}
		return tgtObjTestSuite.toString();
	}

	public ArrayList<String> getFileNames() throws Exception {
		initProjects();
		ArrayList<String> objects = new ArrayList<String>();
		for (UMLTestSuite co : model.getTestSuiteList()) {
			objects.add(pathConverter.convertFilePath(co.getUmlElement().getQualifiedName(), model.TEST_CASES));
		}
		for (UMLStepObject co : model.getStepObjectList()) {
			objects.add(pathConverter.convertFilePath(co.getUmlElement().getQualifiedName(), model.TEST_STEPS));
		}
		return objects;
	}

	public void initProjects() throws Exception {
		project = new AsciiDoctorTestProject(this.tags, this.fa);
		model = new UMLTestProject(this.tags, this.fa);
		project.init();
		model.init();
		this.pathConverter = new AsciiDoctorPathConverter(model, (AsciiDoctorTestProject) project);
	}
}
