package org.farhan.dsl.issues;

import org.farhan.dsl.lang.ITestSuite;

/**
 * Validation logic for grammar elements at different scopes.
 * <p>
 * Separates validation rules from grammar model and UI, enabling reuse across
 * editors and build tools.
 * </p>
 */
public class TestSuiteIssueDetector {

	/**
	 * Validates a specific grammar assignment at element-only, file, or workspace
	 * scope, returning empty string if valid or error description if invalid.
	 *
	 * @param theTestSuite the element to validate
	 * @return empty string if valid, error description otherwise
	 * @throws Exception if validation fails
	 */
	public static String validateNameOnly(ITestSuite theTestSuite) throws Exception {
		if (theTestSuite != null && theTestSuite.getName() != null && !theTestSuite.getName().isEmpty()) {
			String name = theTestSuite.getName();
			if (!Character.isUpperCase(name.charAt(0))) {
				return "Name should start with a capital";
			}
		}
		return "";
	}
}
