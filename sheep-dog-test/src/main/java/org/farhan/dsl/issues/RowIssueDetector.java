package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RowIssueDetector {

	private static final Logger logger = LoggerFactory.getLogger(RowIssueDetector.class);

	public static String validateCellListWorkspace(IRow theRow) throws Exception {
		logger.debug("Entering validateCellListWorkspace");
		try {
			ITestStep theTestStep = (ITestStep) theRow.getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			IStepDefinition theStepDefinition = theStepObject
					.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
			if (theStepDefinition.getStepParameters(theTestStep.getTable().getRowList().getFirst()) == null) {
				logger.debug("Exiting validateCellListWorkspace");
				return RowIssueTypes.ROW_CELL_LIST_WORKSPACE.description;
			}
			logger.debug("Exiting validateCellListWorkspace");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateCellListWorkspace", e);
			throw e;
		}
	}

}
