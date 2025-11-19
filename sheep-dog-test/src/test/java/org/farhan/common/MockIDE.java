package org.farhan.common;

import java.util.ArrayList;

import org.farhan.dsl.issues.SheepDogIssueProposal;

public class MockIDE {

	private static ArrayList<SheepDogIssueProposal> proposalMap;
	private static String validationMessage;
	private static ArrayList<SheepDogIssueProposal> alternateObjects;

	public static ArrayList<SheepDogIssueProposal> getAlternateObjects() {
		return alternateObjects;
	}

	public static ArrayList<SheepDogIssueProposal> getProposals() {
		return proposalMap;
	}

	public static String getValidationMessage() {
		return validationMessage;
	}

	public static void setAlternateObjects(ArrayList<SheepDogIssueProposal> newAlternateObjects) {
		alternateObjects = newAlternateObjects;
	}

	public static void setProposalList(ArrayList<SheepDogIssueProposal> proposalList) {
		proposalMap = proposalList;
	}

	public static void setValidationMessage(String message) {
		validationMessage = message;
	}
}
