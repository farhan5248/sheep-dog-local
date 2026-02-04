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
import org.eclipse.xtext.resource.SaveOptions;
import org.farhan.dsl.sheepdog.sheepDog.Cell;
import org.farhan.dsl.sheepdog.sheepDog.Row;
import org.farhan.dsl.sheepdog.sheepDog.SheepDogFactory;
import org.farhan.dsl.sheepdog.sheepDog.Statement;
import org.farhan.dsl.sheepdog.sheepDog.StepDefinition;
import org.farhan.dsl.sheepdog.sheepDog.StepObject;
import org.farhan.dsl.sheepdog.sheepDog.StepParameters;
import org.farhan.mbt.core.IConvertibleObject;

public class AsciiDoctorStepObject implements IConvertibleObject {

	private StepObject theStepObject;
	private String thePath;

	public AsciiDoctorStepObject(String thePath) {
		this.thePath = thePath;
		String[] pathParts = thePath.split("/");
		String name = pathParts[pathParts.length - 1].replace(".asciidoc", "");
		theStepObject = SheepDogFactory.eINSTANCE.createStepObject();
		theStepObject.setName(name);
	}

	private String convertStatementsToString(EList<Statement> statements) {
		String contents = "";
		for (Statement s : statements) {
			contents += s.getName() + "\n";
		}
		return contents.trim();
	}

	public StepDefinition addStepDefinition(String stepDefinitionName) {
		deleteStepDefinition(stepDefinitionName);
		StepDefinition stepDefinition = SheepDogFactory.eINSTANCE.createStepDefinition();
		stepDefinition.setName(stepDefinitionName);
		theStepObject.getStepDefinitionList().add(stepDefinition);
		return stepDefinition;
	}

	public StepParameters addStepParameters(StepDefinition stepDefinition, String stepParametersName) {
		StepParameters stepParameters = SheepDogFactory.eINSTANCE.createStepParameters();
		stepParameters.setName(stepParametersName);
		stepDefinition.getStepParameterList().add(stepParameters);
		return stepParameters;
	}

	public void createStepParametersRow(StepParameters stepParameters, ArrayList<String> stepParametersRow) {
		Row row = SheepDogFactory.eINSTANCE.createRow();
		for (String srcCell : stepParametersRow) {
			Cell cell = SheepDogFactory.eINSTANCE.createCell();
			cell.setName(srcCell);
			row.getCellList().add(cell);
		}
		stepParameters.getTable().getRowList().add(row);
	}

	public void addStepParametersTable(StepParameters stepParameters, ArrayList<String> headers) {
		stepParameters.setTable(SheepDogFactory.eINSTANCE.createTable());
		Row row = SheepDogFactory.eINSTANCE.createRow();
		for (String srcCell : headers) {
			Cell cell = SheepDogFactory.eINSTANCE.createCell();
			cell.setName(srcCell);
			row.getCellList().add(cell);
		}
		stepParameters.getTable().getRowList().add(row);
	}

	private void deleteStepDefinition(String name) {
		EList<StepDefinition> list = theStepObject.getStepDefinitionList();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().contentEquals(name)) {
				list.remove(i);
				return;
			}
		}
	}

	@Override
	public Object get() {
		return theStepObject;
	}

	@Override
	public String getPath() {
		return thePath;
	}

	public String getStepDefinitionDescription(StepDefinition stepDefinitionSrc) {
		return convertStatementsToString(stepDefinitionSrc.getStatementList());
	}

	public EList<StepDefinition> getStepDefinitionList() {
		return theStepObject.getStepDefinitionList();
	}

	public String getStepDefinitionName(StepDefinition stepDefinitionSrc) {
		return stepDefinitionSrc.getName();
	}

	public String getStepObjectDescription() {
		return convertStatementsToString(theStepObject.getStatementList());
	}

	public String getStepObjectName() {
		return theStepObject.getName();
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
			theStepObject = (StepObject) resource.getContents().get(0);
		} catch (Exception e) {
			throw new Exception("There was a problem parsing file: " + thePath, e);
		}
	}

	public void setStepDefinitionDescription(StepDefinition stepDefinition, String stepDefinitionDescription) {
		if (!stepDefinitionDescription.isEmpty()) {
			for (String line : stepDefinitionDescription.split("\n")) {
				Statement statement = SheepDogFactory.eINSTANCE.createStatement();
				statement.setName(line);
				stepDefinition.getStatementList().add(statement);
			}
		}
	}

	public void setStepObjectDescription(String stepObjectDescription) {
		if (!stepObjectDescription.isEmpty()) {
			theStepObject.getStatementList().clear();
			for (String line : stepObjectDescription.split("\n")) {
				Statement statement = SheepDogFactory.eINSTANCE.createStatement();
				statement.setName(line);
				theStepObject.getStatementList().add(statement);
			}
		}
	}

	public void setStepObjectName(String stepObjectName) {
		theStepObject.setName(stepObjectName);
	}

	public String toString() {
		URI uri = URI.createFileURI(thePath);
		Resource resource = new ResourceSetImpl().createResource(uri);
		resource.getContents().add(theStepObject);
		Map<Object, Object> options = SaveOptions.newBuilder().format().getOptions().toOptionsMap();
		OutputStream os = new ByteArrayOutputStream();
		try {
			resource.save(os, options);
		} catch (IOException e) {
			return null;
		}
		return os.toString();
	}

	public String getStepDefinitionNameLong(StepDefinition stepDefinitionSrc) {
		String noRoot = getPath().replaceFirst("^src/test/resources/asciidoc/stepdefs/", "");
		String component = noRoot.split("/")[0];
		String object = noRoot.replaceFirst("^" + component + "/", "").replaceFirst(".asciidoc$", "");
		return "The " + component + " " + object + " " + stepDefinitionSrc.getName();
	}

}
