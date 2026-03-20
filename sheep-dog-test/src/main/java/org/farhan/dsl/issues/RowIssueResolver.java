package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepObject;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.ITable;
import org.farhan.dsl.grammar.ITestDocument;
import org.farhan.dsl.grammar.ITestProject;
import org.farhan.dsl.grammar.ITestStep;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class RowIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(IRow theRow) throws Exception {
		logger.debug("Entry: correctCellListWorkspace({})", theRow);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		ITable table = theRow.getParent();
		if (table == null) {
			logger.debug("Exit: correctCellListWorkspace({})", proposals);
			return proposals;
		}
		Object tableParent = table.getParent();
		if (!(tableParent instanceof ITestStep)) {
			logger.debug("Exit: correctCellListWorkspace({})", proposals);
			return proposals;
		}
		ITestStep testStep = (ITestStep) tableParent;
		String stepObjectFullName = SheepDogUtility.getStepObjectFullNameForTestStep(testStep);
		if (stepObjectFullName.isEmpty()) {
			logger.debug("Exit: correctCellListWorkspace({})", proposals);
			return proposals;
		}
		ITestProject project = SheepDogUtility.getTestProjectParentForRow(theRow);
		if (project == null) {
			logger.debug("Exit: correctCellListWorkspace({})", proposals);
			return proposals;
		}
		ITestDocument doc = project.getTestDocument(stepObjectFullName);
		if (!(doc instanceof IStepObject)) {
			logger.debug("Exit: correctCellListWorkspace({})", proposals);
			return proposals;
		}
		IStepObject stepObject = (IStepObject) doc;
		String stepDefName = testStep.getStepDefinitionName();
		if (stepDefName == null || stepDefName.isEmpty()) {
			logger.debug("Exit: correctCellListWorkspace({})", proposals);
			return proposals;
		}
		IStepDefinition stepDef = stepObject.getStepDefinition(stepDefName);
		if (stepDef == null) {
			logger.debug("Exit: correctCellListWorkspace({})", proposals);
			return proposals;
		}
		for (IStepParameters sp : stepDef.getStepParameterList()) {
			SheepDogIssueProposal proposal = new SheepDogIssueProposal();
			proposal.setId(sp.getName());
			proposal.setDescription("");
			proposal.setValue(sp.getName());
			proposals.add(proposal);
		}
		String rowCells = SheepDogUtility.getCellListAsString(theRow.getCellList());
		SheepDogIssueProposal generateProposal = new SheepDogIssueProposal();
		generateProposal.setId("Generate " + rowCells);
		generateProposal.setDescription("");
		proposals.add(generateProposal);
		logger.debug("Exit: correctCellListWorkspace({})", proposals);
		return proposals;
	}
}
