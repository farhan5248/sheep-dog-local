package org.farhan.dsl.grammar;

import java.util.ArrayList;

import org.slf4j.Logger;

public class CellIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctNameOnly(ICell theCell) throws Exception {
        logger.debug("correctNameOnly(theCell={})", theCell);
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();
        String name = theCell.getName();
        if (name == null || name.isEmpty()) {
            logger.debug("correctNameOnly() = {}", proposals);
            return proposals;
        }
        String capitalized = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        SheepDogIssueProposal proposal = new SheepDogIssueProposal();
        proposal.setId("Capitalize cell name");
        proposal.setDescription("Capitalize the first letter of the name");
        proposal.setValue(capitalized);
        proposals.add(proposal);
        logger.debug("correctNameOnly() = {}", proposals);
        return proposals;
    }
}
