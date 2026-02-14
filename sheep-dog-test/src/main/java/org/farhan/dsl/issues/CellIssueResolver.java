package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ICell;
import org.farhan.dsl.lang.SheepDogLoggerFactory;
import org.slf4j.Logger;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class CellIssueResolver {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(CellIssueResolver.class);

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theCell the element needing corrections
     * @return list of quick fix proposals
     * @throws Exception if an error occurs during proposal generation
     */
    public static ArrayList<SheepDogIssueProposal> correctNameOnly(ICell theCell) throws Exception {
        logger.debug("Entering correctNameOnly");
        ArrayList<SheepDogIssueProposal> proposals = new ArrayList<>();

        String cellName = theCell.getName();
        if (cellName != null && !cellName.isEmpty()) {
            // Capitalize first letter
            String correctedName = cellName.substring(0, 1).toUpperCase() + cellName.substring(1);

            SheepDogIssueProposal proposal = new SheepDogIssueProposal();
            proposal.setId("Capitalize cell name");
            proposal.setDescription("Capitalize the first letter of the name");
            proposal.setValue(correctedName);
            proposals.add(proposal);
        }

        logger.debug("Exiting correctNameOnly with {} proposals", proposals.size());
        return proposals;
    }

}
