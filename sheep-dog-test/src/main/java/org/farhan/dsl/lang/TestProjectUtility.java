package org.farhan.dsl.lang;

import java.util.ArrayList;
import java.util.TreeSet;

public class TestProjectUtility {
	public static ArrayList<String> getComponentList(ITestProject testProject) {
		TreeSet<String> componentSet = new TreeSet<String>();
		for (IStepObject so : testProject.getStepObjectList()) {
			componentSet.add(so.getQualifiedName().split("/")[0]);
		}
		ArrayList<String> componentList = new ArrayList<String>();
		componentList.addAll(componentSet);
		return componentList;
	}

	public static ArrayList<IStepObject> getStepObjectList(ITestProject testProject, String component) {
		ArrayList<IStepObject> componentStepObjectList = new ArrayList<IStepObject>();
		for (IStepObject so : testProject.getStepObjectList()) {
			if (so.getQualifiedName().startsWith(component)) {
				componentStepObjectList.add(so);
			}
		}
		return componentStepObjectList;
	}
}
