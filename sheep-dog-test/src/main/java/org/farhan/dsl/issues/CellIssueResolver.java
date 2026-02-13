package org.farhan.dsl.issues;

import java.util.ArrayList;
import org.farhan.dsl.lang.ICell;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class CellIssueResolver {

    /**
     * Generates proposals correcting values when an assignment exists but is
     * invalid.
     *
     * @param theCell the element needing corrections
     * @return list of quick fix proposals
     */
    public static ArrayList<SheepDogIssueProposal> correctNameOnly(ICell theCell) {
        return null;
    }

}
