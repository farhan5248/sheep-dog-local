package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;
import org.slf4j.Logger;

public class CellIssueResolver {

    public static ArrayList<SheepDogIssueProposal> correctCapitalizeNameOnly(ICell theCell) {
        Logger logger = SheepDogLoggerFactory.getLogger(CellIssueResolver.class);
        logger.debug("Entering correctCapitalizeNameOnly");

        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        if (theCell == null) {
            logger.debug("Exiting correctCapitalizeNameOnly - cell is null");
            return proposals;
        }

        String cellName = theCell.getName();
        if (cellName == null || cellName.isEmpty()) {
            logger.debug("Exiting correctCapitalizeNameOnly - cell name is null or empty");
            return proposals;
        }

        // Check if the name starts with a lowercase letter
        if (!SheepDogUtility.startsWithCapital(cellName)) {
            // Create a proposal to capitalize the first letter
            String capitalizedName = Character.toUpperCase(cellName.charAt(0)) + cellName.substring(1);

            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Capitalize cell name");
            proposal.setDescription("Capitalize the first letter of the name");
            proposal.setValue(capitalizedName);
            proposals.add(proposal);
        }

        logger.debug("Exiting correctCapitalizeNameOnly with " + proposals.size() + " proposals");
        return proposals;
    }
}
