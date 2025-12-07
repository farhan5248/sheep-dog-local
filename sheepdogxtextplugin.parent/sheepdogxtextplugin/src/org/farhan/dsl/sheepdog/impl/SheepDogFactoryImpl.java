package org.farhan.dsl.sheepdog.impl;

import java.io.File;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IResourceRepository;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ISheepDogFactory;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestCase;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestSetup;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.ITestSuite;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;

public class SheepDogFactoryImpl implements ISheepDogFactory {

	// TODO this assumes that there's just one open project in the eclipse
	// workspace.
	private static TestProjectImpl testProject;
	private static IResourceRepository sr;

	public SheepDogFactoryImpl(IResourceRepository sourceFileRepository) {
		sr = sourceFileRepository;
	}

	@Override
	public IStepDefinition createStepDefinition(String predicate) {
		StepDefinition stepDefinition = SheepDogFactory.eINSTANCE.createStepDefinition();
		stepDefinition.setName(predicate);
		return new StepDefinitionImpl(stepDefinition);
	}

	@Override
	public IStepObject createStepObject(String qualifiedName) {
		StepObject eObject = SheepDogFactory.eINSTANCE.createStepObject();
		String extension = org.farhan.dsl.lang.SheepDogFactory.instance.createTestProject().getFileExtension();
		eObject.setName((new File(qualifiedName)).getName().replaceFirst(extension + "$", ""));
		IStepObject stepObject = new StepObjectImpl(eObject);
		stepObject.setQualifiedName(qualifiedName);
		return stepObject;
	}

	@Override
	public IStepParameters createStepParameters(IRow header) {
		StepParameters parameters = SheepDogFactory.eINSTANCE.createStepParameters();
		parameters.setTable(SheepDogFactory.eINSTANCE.createTable());
		Row row = SheepDogFactory.eINSTANCE.createRow();
		parameters.getTable().getRowList().add(row);
		for (ICell srcCell : header.getCellList()) {
			Cell cell = SheepDogFactory.eINSTANCE.createCell();
			cell.setName(srcCell.getName());
			row.getCellList().add(cell);
		}
		return new StepParametersImpl(parameters);
	}

	@Override
	public IStepParameters createStepParameters(IText value) {
		StepParameters parameters = SheepDogFactory.eINSTANCE.createStepParameters();
		parameters.setName("1");
		parameters.setTable(SheepDogFactory.eINSTANCE.createTable());
		Row row = SheepDogFactory.eINSTANCE.createRow();
		parameters.getTable().getRowList().add(row);
		// TODO make test for this
		// This is a docstring and also the abuse of this method :P
		Cell cell = SheepDogFactory.eINSTANCE.createCell();
		cell.setName("Content");
		row.getCellList().add(cell);
		return new StepParametersImpl(parameters);
	}

	@Override
	public ITestCase createTestCase(String value) {
		throw new UnsupportedOperationException("createTestCase(String value) is not implemented");
	}

	@Override
	public ITestProject createTestProject() {
		if (testProject == null) {
			testProject = new TestProjectImpl(sr);
		}
		return testProject;
	}

	@Override
	public ITestSetup createTestSetup(String name) {
		throw new UnsupportedOperationException("createTestSetup(String name) is not implemented");
	}

	@Override
	public ITestStep createTestStep(String value) {
		throw new UnsupportedOperationException("createTestStep(String value) is not implemented");
	}

	@Override
	public ITestSuite createTestSuite(String qualifiedName) {
		throw new UnsupportedOperationException("createTestSuite(String qualifiedName) is not implemented");
	}

}
