package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SheepDogBuilder {

	private static final Logger logger = LoggerFactory.getLogger(SheepDogBuilder.class);

	public static IStepDefinition generateStepDefinition(ITestStep theTestStep, ITestProject theProject)
			throws Exception {
		logger.debug("Entering generateStepDefinition for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject == null) {
				theStepObject = theProject.createStepObject(qualifiedName);
			}
			String predicate = TestStepUtility.getPredicate(theTestStep.getName());
			IStepDefinition theStepDefinition = theStepObject.getStepDefinition(predicate);
			if (theStepDefinition == null) {
				theStepDefinition = theStepObject.createStepDefinition(predicate);
			}
			if (theTestStep.getTable() != null) {
				if (!theTestStep.getTable().getRowList().isEmpty()) {
					if (theStepDefinition.getStepParameters(theTestStep.getTable().getRowList().getFirst()) == null) {
						theStepDefinition.createStepParameters(theTestStep.getTable().getRowList().getFirst());
					}
				}
			}
			if (theTestStep.getText() != null) {

				IText theText = theTestStep.getText();
				if (!theText.getName().isEmpty()) {
					if (theStepDefinition.getStepParameters(theText) == null) {
						theStepDefinition.createStepParameters(theText);
					}
				}
			}
			logger.debug("Exiting generateStepDefinition");
			return theStepDefinition;
		} catch (Exception e) {
			logger.error("Failed in generateStepDefinition for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
