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

	public static String validateReference(IRow theRow) throws Exception {
		logger.debug("Entering validateReference");
		try {
			ITestStep theTestStep = theRow.getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theTestStep.getParent().getParent().getParent().getStepObject(qualifiedName);
			IStepDefinition theStepDefinition = theStepObject
					.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
			if (theStepDefinition.getStepParameters(theTestStep.getTable().getRowList().getFirst()) == null) {
				logger.debug("Exiting validateReference");
				return RowIssueTypes.ROW_REFERENCE_CELL_LIST.description;
			}
			logger.debug("Exiting validateReference");
			return "";
		} catch (Exception e) {
			logger.error("Failed in validateReference", e);
			throw e;
		}
	}

}
