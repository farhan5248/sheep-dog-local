package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.StepDefinitionUtility;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;

public class RowIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(RowIssueDetector.class);

	public static String validateCellListWorkspace(IRow theRow) throws Exception {
		logger.debug("Entering validateCellListWorkspace");
		// TODO validate that each row should have the max number of columns perhaps in
		// a TableIssueDetector
		ITestStep theTestStep = (ITestStep) theRow.getParent().getParent();
		String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
		IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
		if (theStepObject != null) {
			IStepDefinition theStepDefinition = theStepObject
					.getStepDefinition(TestStepUtility.getStepDefinitionName(theTestStep.getName()));
			if (theStepDefinition != null) {
				if (StepDefinitionUtility.getStepParameters(theStepDefinition,
						theTestStep.getTable().getRowList().getFirst()) == null) {
					logger.debug("Exiting validateCellListWorkspace");
					return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
				}
			}
		}
		logger.debug("Exiting validateCellListWorkspace");
		return "";
	}

}
