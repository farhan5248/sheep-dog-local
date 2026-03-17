package org.farhan.dsl.grammar;

import java.util.ArrayList;

import org.slf4j.Logger;

public class SheepDogUtility {

    private static final Logger logger = SheepDogLoggerFactory.getLogger(SheepDogUtility.class);

    public static ITestProject getTestProjectParentForTestStep(ITestStep theStep) {
        logger.debug("getTestProjectParentForTestStep(theStep={})", theStep);
        ITestProject result = null;
        if (theStep != null && theStep.getParent() != null && theStep.getParent().getParent() != null) {
            result = theStep.getParent().getParent().getParent();
        }
        logger.debug("getTestProjectParentForTestStep() = {}", result);
        return result;
    }

    public static ArrayList<ITestStep> getTestStepListUpToTestStep(ITestStep theTestStep) {
        logger.debug("getTestStepListUpToTestStep(theTestStep={})", theTestStep);
        ArrayList<ITestStep> steps = new ArrayList<>();
        if (theTestStep != null && theTestStep.getParent() != null) {
            for (ITestStep step : theTestStep.getParent().getTestStepList()) {
                if (step == theTestStep) break;
                steps.add(step);
            }
        }
        logger.debug("getTestStepListUpToTestStep() = {}", steps);
        return steps;
    }

}
