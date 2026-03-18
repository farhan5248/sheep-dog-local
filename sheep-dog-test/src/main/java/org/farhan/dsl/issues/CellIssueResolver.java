package org.farhan.dsl.issues;

import org.farhan.dsl.grammar.*;

import java.util.ArrayList;
import org.slf4j.Logger;

public class CellIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueResolver.class);

    public static ArrayList<SheepDogIssueProposal> correctCapitalizeNameOnly(ICell theCell) {
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
            proposals.add(SheepDogUtility.createProposal(
                "Capitalize cell name",
                "Capitalize the first letter of the name",
                SheepDogUtility.capitalizeFirstLetter(cellName)
            ));
        }

        logger.debug("Exiting correctCapitalizeNameOnly with " + proposals.size() + " proposals");
        return proposals;
    }
}
