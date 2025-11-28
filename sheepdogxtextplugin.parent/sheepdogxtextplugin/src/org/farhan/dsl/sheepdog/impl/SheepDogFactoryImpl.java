package org.farhan.dsl.sheepdog.impl;

import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.ISheepDogFactory;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestCase;
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

	@Override
	public IStepDefinition createStepDefinition(String predicate) {
		StepDefinition stepDefinition = SheepDogFactory.eINSTANCE.createStepDefinition();
		stepDefinition.setName(predicate);
		return new StepDefinitionImpl(stepDefinition);
	}

	@Override
	public IStepObject createStepObject(String qualifiedName) {
		StepObject eObject = SheepDogFactory.eINSTANCE.createStepObject();
		// TODO this is a temp hack. After #81 is completed, Resource operations will be
		// in the addStepObject method which will set the resource, read/write from the
		// file system etc
		TestProjectImpl tmpProject = new TestProjectImpl(null);
		eObject.setName((new File(qualifiedName)).getName().replaceFirst(tmpProject.getFileExtension() + "$", ""));
		Resource theResource = new ResourceSetImpl().createResource(URI.createFileURI(tmpProject.layer2dir + "/" + qualifiedName));
		theResource.getContents().add(eObject);
		IStepObject stepObject = new StepObjectImpl(eObject);
		stepObject.setQualifiedName(qualifiedName);
		return stepObject;
	}

	@Override
	public IStepParameters createStepParameters(IRow header) {
		StepParameters parameters = SheepDogFactory.eINSTANCE.createStepParameters();
		// TODO after #81, the name will be set when this is added to the
		// parent.addElement method
		parameters.setName("1");
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
