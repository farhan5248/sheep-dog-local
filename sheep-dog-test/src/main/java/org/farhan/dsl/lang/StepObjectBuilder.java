package org.farhan.dsl.lang;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StepObjectBuilder {

	private static final Logger logger = LoggerFactory.getLogger(StepObjectBuilder.class);

	public static void generateStepDefinition(ITestStep theTestStep, Map<Object, Object> options) throws Exception {
		logger.debug("Entering generateStepDefinition for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject == null) {
				theStepObject = theProject.createStepObject(qualifiedName);
			}
			String predicate = TestStepUtility.getPredicate(theTestStep.getName());
			IStepDefinition theStepDefinition = theStepObject.getStepDefinition(predicate);
			if (theStepDefinition == null) {
				theStepDefinition = theStepObject.createStepDefinition(predicate);
			}
			// TODO create ITable
			if (theTestStep.getTable() != null) {
				if (!theTestStep.getTable().isEmpty()) {
					if (theStepDefinition.getStepParameters(theTestStep.getTable().getFirst()) == null) {
						theStepDefinition.createStepParameters(theTestStep.getTable().getFirst());
					}
				}
			}
			// TODO create IText
			if (theTestStep.getText() != null) {
				if (!theTestStep.getText().isEmpty()) {
					if (theStepDefinition.getStepParameters(theTestStep.getText()) == null) {
						theStepDefinition.createStepParameters(theTestStep.getText());
					}
				}
			}
			logger.debug("Exiting generateStepDefinition");
		} catch (Exception e) {
			logger.error("Failed in generateStepDefinition for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
