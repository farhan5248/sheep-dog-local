package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.issues.SheepDogIssueProposal;

public class MockIDE {

	private static ArrayList<SheepDogIssueProposal> proposalList = new ArrayList<SheepDogIssueProposal>();
	private static String validationMessage = "";
	private static ArrayList<SheepDogIssueProposal> alternateObjects = new ArrayList<SheepDogIssueProposal>();

	public static ArrayList<SheepDogIssueProposal> getAlternateObjects() {
		return alternateObjects;
	}

	public static ArrayList<SheepDogIssueProposal> getProposals() {
		return proposalList;
	}

	public static String getValidationMessage() {
		return validationMessage;
	}

	public static void reset() {
		MockIDE.validationMessage = "";
		MockIDE.proposalList = new ArrayList<SheepDogIssueProposal>();
	}

	public static void setAlternateObjects(ArrayList<SheepDogIssueProposal> newAlternateObjects) {
		alternateObjects = newAlternateObjects;
	}

	public static void setProposalList(ArrayList<SheepDogIssueProposal> proposalList) {
		MockIDE.proposalList = proposalList;
	}

	public static void setValidationMessage(String message) {
		validationMessage = message;
	}
}
