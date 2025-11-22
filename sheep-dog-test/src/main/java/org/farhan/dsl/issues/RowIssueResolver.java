package org.farhan.dsl.issues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.IRow;
import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.StatementUtility;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RowIssueResolver {

	private static final Logger logger = LoggerFactory.getLogger(RowIssueResolver.class);

	private static String cellsToString(List<ICell> cells) {
		// TODO this should be a csv list, think about it from the perspective of the
		// test case, \| is ugly
		String cellsAsString = "";
		List<String> sortedCells = new ArrayList<String>();
		for (ICell cell : cells) {
			sortedCells.add(cell.getName());
		}
		Collections.sort(sortedCells);
		for (String cell : sortedCells) {
			cellsAsString += "| " + cell;
		}
		return cellsAsString.trim();
	}

	public static ArrayList<SheepDogIssueProposal> proposeCellListWorkspace(IRow theRow) {
		logger.debug("Entering proposeCellListWorkspace");
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<SheepDogIssueProposal>();
		SheepDogIssueProposal proposal;

		if (theRow.getParent().getParent() instanceof ITestStep) {
			ITestStep theTestStep = (ITestStep) theRow.getParent().getParent();
			if (TestStepIssueDetector.isValid(theTestStep.getName())) {
				String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
				IStepObject theStepObject = theTestStep.getParent().getParent().getParent()
						.getStepObject(qualifiedName);
				if (theStepObject != null) {
					IStepDefinition stepDefinition = theStepObject
							.getStepDefinition(TestStepUtility.getPredicate(theTestStep.getName()));
					if (stepDefinition != null) {
						for (IStepParameters parameters : stepDefinition.getStepParameterList()) {
							proposal = new SheepDogIssueProposal();
							proposal.setId(cellsToString(parameters.getTable().getRowList().getFirst().getCellList()));
							// TODO make a test for getStepDefinitionParametersDocumentation
							proposal.setDescription(
									StatementUtility.getStatementListAsString(parameters.getStatementList()));
							String replacement = cellsToString(
									parameters.getTable().getRowList().getFirst().getCellList());
							if (!replacement.contentEquals("| Content")) {
								proposal.setValue(replacement);
							}
							proposals.add(proposal);
						}
					}
				}
			}
		}

		logger.debug("Exiting proposeCellListWorkspace with {} proposals", proposals.size());
		return proposals;
	}

}
