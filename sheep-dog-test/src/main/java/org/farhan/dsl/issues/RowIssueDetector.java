package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class RowIssueDetector {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueDetector.class);

	public static String validateCellListWorkspace(IRow theRow) throws Exception {
		logger.debug("Entry: validateCellListWorkspace({})", theRow);
		String message = "";
		ITable table = theRow.getParent();
		if (table != null) {
			Object tableParent = table.getParent();
			if (tableParent instanceof ITestStep) {
				ITestStep testStep = (ITestStep) tableParent;
				String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
				if (!stepObjectFullName.isEmpty()) {
					ITestProject project = SheepDogUtility.getTestProjectParentForRow(theRow);
					if (project != null) {
						ITestDocument stepObjectDoc = project.getTestDocument(stepObjectFullName);
						if (stepObjectDoc instanceof IStepObject) {
							IStepObject stepObject = (IStepObject) stepObjectDoc;
							String stepDefName = testStep.getStepDefinitionName();
							if (stepDefName != null && !stepDefName.isEmpty()) {
								IStepDefinition stepDef = stepObject.getStepDefinition(stepDefName);
								if (stepDef != null) {
									String rowCells = SheepDogUtility.getCellListAsString(theRow.getCellList());
									boolean matched = false;
									for (IStepParameters sp : stepDef.getStepParameterList()) {
										if (sp.getTable() != null && !sp.getTable().getRowList().isEmpty()) {
											IRow headerRow = sp.getTable().getRow(0);
											String paramCells = SheepDogUtility
													.getCellListAsString(headerRow.getCellList());
											if (rowCells.equals(paramCells)) {
												matched = true;
												break;
											}
										}
									}
									if (!matched) {
										message = RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
									}
								}
							}
						}
					}
				}
			}
		}
		logger.debug("Exit: validateCellListWorkspace({})", message);
		return message;
	}
}
