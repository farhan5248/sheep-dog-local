package org.farhan.dsl.issues;

import org.farhan.dsl.lang.IStepDefinition;
import org.farhan.dsl.lang.IStepObject;
import org.farhan.dsl.lang.IStepParameters;
import org.farhan.dsl.lang.ITestProject;
import org.farhan.dsl.lang.ITestStep;
import org.farhan.dsl.lang.IText;
import org.farhan.dsl.lang.TestStepUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SheepDogBuilder {

	private static final Logger logger = LoggerFactory.getLogger(SheepDogBuilder.class);

	public static IStepObject buildStepObject(ITestStep theTestStep) throws Exception {
		logger.debug("Entering generateStepObject for step: {}", theTestStep != null ? theTestStep.getName() : "null");
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject == null) {
				theStepObject = theProject.createStepObject(qualifiedName);
			}
			logger.debug("Exiting generateStepObject");
			return theStepObject;
		} catch (Exception e) {
			logger.error("Failed in generateStepObject for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static IStepDefinition buildStepDefinition(ITestStep theTestStep) throws Exception {
		logger.debug("Entering generateStepDefinition for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject != null) {
				String predicate = TestStepUtility.getPredicate(theTestStep.getName());
				IStepDefinition theStepDefinition = theStepObject.getStepDefinition(predicate);
				if (theStepDefinition == null) {
					theStepDefinition = theStepObject.createStepDefinition(predicate);
				}
				return theStepDefinition;
			}
			logger.debug("Exiting generateStepDefinition");
			return null;
		} catch (Exception e) {
			logger.error("Failed in generateStepDefinition for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

	public static IStepParameters buildStepParameters(ITestStep theTestStep) throws Exception {
		logger.debug("Entering generateStepParameters for step: {}",
				theTestStep != null ? theTestStep.getName() : "null");
		try {
			IStepParameters theStepParameters = null;
			ITestProject theProject = theTestStep.getParent().getParent().getParent();
			String qualifiedName = TestStepUtility.getStepObjectQualifiedName(theTestStep);
			IStepObject theStepObject = theProject.getStepObject(qualifiedName);
			if (theStepObject != null) {
				String predicate = TestStepUtility.getPredicate(theTestStep.getName());
				IStepDefinition theStepDefinition = theStepObject.getStepDefinition(predicate);
				if (theStepDefinition != null) {
					if (theTestStep.getTable() != null) {
						if (!theTestStep.getTable().getRowList().isEmpty()) {
							if (theStepDefinition
									.getStepParameters(theTestStep.getTable().getRowList().getFirst()) == null) {
								theStepParameters = theStepDefinition
										.createStepParameters(theTestStep.getTable().getRowList().getFirst());
							}
						}
					}
					if (theTestStep.getText() != null) {
						IText theText = theTestStep.getText();
						if (!theText.getName().isEmpty()) {
							if (theStepDefinition.getStepParameters(theText) == null) {
								theStepParameters = theStepDefinition.createStepParameters(theText);
							}
						}
					}
				}
			}
			logger.debug("Exiting generateStepParameters");
			return theStepParameters;
		} catch (Exception e) {
			logger.error("Failed in generateStepParameters for step '{}': {}",
					theTestStep != null ? theTestStep.getName() : "null", e.getMessage(), e);
			throw e;
		}
	}

}
