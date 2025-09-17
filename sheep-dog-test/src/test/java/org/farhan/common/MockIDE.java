package org.farhan.common;

import java.util.TreeMap;
import org.farhan.dsl.lang.TestStepIssueProposal;

public class MockIDE {

	private static TreeMap<String, TestStepIssueProposal> proposalMap;
	private static String validationMessage;
	private static Object[] alternateObjects;

	public static Object[] getAlternateObjects() {
		return alternateObjects;
	}

	public static TreeMap<String, TestStepIssueProposal> getProposals() {
		return proposalMap;
	}

	public static String getValidationMessage() {
		return validationMessage;
	}

	public static void setAlternateObjects(Object[] newAlternateObjects) {
		alternateObjects = newAlternateObjects;
	}

	public static void setProposalList(TreeMap<String, TestStepIssueProposal> proposalList) {
		proposalMap = proposalList;
	}

	public static void setValidationMessage(String message) {
		validationMessage = message;
	}
}
