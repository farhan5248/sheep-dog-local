package org.farhan.dsl.grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;

public class RowIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueDetector.class);

	public static String validateCellListWorkspace(IRow theRow) throws Exception {
		logger.debug("validateCellListWorkspace(theRow={})", theRow);
		String result = "";
		ITable table = theRow.getParent();
		if (table == null) {
			return result;
		}
		Object tableParent = table.getParent();
		if (!(tableParent instanceof ITestStep)) {
			return result;
		}
		ITestStep testStep = (ITestStep) tableParent;
		String fullName = testStep.getFullName();
		if (fullName == null || fullName.isEmpty()) {
			return result;
		}
		String component = StepObjectRefFragments.getComponent(fullName);
		String objectName = StepObjectRefFragments.getObject(fullName);
		if (component.isEmpty()) {
			return result;
		}
		ITestProject workspace = SheepDogUtility.getTestProjectParentForTestStep(testStep);
		if (workspace == null) {
			return result;
		}
		IStepObject matchingStepObject = null;
		for (ITestDocument doc : workspace.getTestDocumentList()) {
			if (doc instanceof IStepObject) {
				IStepObject stepObject = (IStepObject) doc;
				String soFullName = stepObject.getFullName();
				if (soFullName == null) continue;
				String[] parts = soFullName.split("/");
				if (parts.length < 3) continue;
				String docComponent = String.join("/", Arrays.copyOfRange(parts, 1, parts.length - 1));
				if (docComponent.equals(component) && stepObject.getName().equals(objectName)) {
					matchingStepObject = stepObject;
					break;
				}
			}
		}
		if (matchingStepObject == null) {
			return result;
		}
		String stepDefinitionName = testStep.getStepDefinitionName();
		if (stepDefinitionName == null || stepDefinitionName.isEmpty()) {
			return result;
		}
		IStepDefinition stepDef = matchingStepObject.getStepDefinition(stepDefinitionName);
		if (stepDef == null) {
			return result;
		}
		List<String> rowCellNames = new ArrayList<>();
		for (ICell cell : theRow.getCellList()) {
			rowCellNames.add(cell.getName());
		}
		boolean found = false;
		for (IStepParameters stepParams : stepDef.getStepParameterList()) {
			ITable paramsTable = stepParams.getTable();
			if (paramsTable == null) continue;
			List<IRow> rows = paramsTable.getRowList();
			if (rows.isEmpty()) continue;
			IRow headerRow = rows.get(0);
			List<String> paramCellNames = new ArrayList<>();
			for (ICell cell : headerRow.getCellList()) {
				paramCellNames.add(cell.getName());
			}
			if (rowCellNames.equals(paramCellNames)) {
				found = true;
				break;
			}
		}
		if (!found) {
			result = RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
		}
		logger.debug("validateCellListWorkspace() = {}", result);
		return result;
	}
}
