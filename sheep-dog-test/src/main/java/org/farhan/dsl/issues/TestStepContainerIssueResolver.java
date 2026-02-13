package org.farhan.dsl.issues;

import java.util.ArrayList;

import org.farhan.dsl.lang.ITestStepContainer;

/**
 * Quick fix proposal generation for validation errors.
 * <p>
 * Separates fix proposal logic from detection and application, enabling
 * IDE-independent validation tooling.
 * </p>
 */
public class TestStepContainerIssueResolver {

	/**
	 * Generates proposals correcting values when an assignment exists but is
	 * invalid.
	 *
	 * @param theTestStepContainer the element needing corrections
	 * @return list of quick fix proposals
	 */
	public static ArrayList<SheepDogIssueProposal> correctNameOnly(ITestStepContainer theTestStepContainer) {
		return null;
	}

}
