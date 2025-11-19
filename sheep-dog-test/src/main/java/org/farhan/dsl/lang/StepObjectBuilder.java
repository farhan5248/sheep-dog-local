package org.farhan.dsl.lang;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepObjectBuilder {

	private static final Logger logger = LoggerFactory.getLogger(StepObjectBuilder.class);

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
			// TODO create IText
			if (theTestStep.getText() != null) {
				if (!theTestStep.getText().isEmpty()) {
					ArrayList<String> headers = new ArrayList<String>();
					headers.add("Content");
					if (theStepDefinition.getStepParametersTmp(headers) == null) {
						theStepDefinition.createStepParametersTmp(headers);
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
