package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Static helper methods for grammar element operations.
 * <p>
 * Separates utility operations from grammar model classes, keeping interfaces
 * focused on data access.
 * </p>
 */
public class TestProjectUtility {
    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param testProject the test project to extract components from
     * @return ArrayList of unique component names sorted alphabetically
     */
    public static ArrayList<String> getComponentList(ITestProject testProject) {
        TreeSet<String> theSet = new TreeSet<String>();
        for (IStepObject so : testProject.getStepObjectList()) {
            theSet.add(getComponent(so));
        }
        ArrayList<String> theList = new ArrayList<String>();
        theList.addAll(theSet);
        return theList;
    }

    /**
     * Performs parsing, formatting, or computation operations on grammar elements
     * without maintaining state.
     *
     * @param testProject the test project to search
     * @param component   the component name to filter by
     * @return ArrayList of step objects belonging to the specified component
     */
    public static ArrayList<IStepObject> getStepObjectList(ITestProject testProject, String component) {
        ArrayList<IStepObject> theList = new ArrayList<IStepObject>();
        for (IStepObject so : testProject.getStepObjectList()) {
            if (getComponent(so).contentEquals(component)) {
                theList.add(so);
            }
        }
        return theList;
    }

    private static String getComponent(IStepObject stepObject) {
        return stepObject.getNameLong().split("/")[0];
    }
}
