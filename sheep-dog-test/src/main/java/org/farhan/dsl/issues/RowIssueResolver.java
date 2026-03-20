package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.grammar.IRow;
import org.farhan.dsl.grammar.IStepDefinition;
import org.farhan.dsl.grammar.IStepParameters;
import org.farhan.dsl.grammar.SheepDogIssueProposal;
import org.farhan.dsl.grammar.SheepDogLoggerFactory;
import org.farhan.dsl.grammar.SheepDogUtility;
import org.slf4j.Logger;

public class RowIssueResolver {

	private static final Logger logger = SheepDogLoggerFactory.getLogger(RowIssueResolver.class);

	public static ArrayList<SheepDogIssueProposal> correctCellListWorkspace(IRow theRow) throws Exception {
		logger.debug("Entry: correctCellListWorkspace({})", theRow);
		ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
		IStepDefinition stepDef = SheepDogUtility.getStepDefinitionParentForRow(theRow);
		if (stepDef != null) {
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
		}
		logger.debug("Exit: correctCellListWorkspace({})", proposals);
		return proposals;
	}
}
