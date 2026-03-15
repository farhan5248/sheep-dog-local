package org.farhan.impl;

import org.farhan.mbt.maven.MBTMojo;
import org.junit.jupiter.api.Assertions;

public abstract class TestObjectGoalImpl extends TestObjectSheepDogImpl {

	public TestObjectGoalImpl() {
		setProperty("tags", "");
	}

	protected void runGoal(String goal, String baseDir) {
		runGoal(goal, baseDir, "");
	}

	protected void runGoal(String goal, String baseDir, String repoDir) {
		try {
			Class<?> mojoClass = Class.forName(goal);
			MBTMojo mojo = (MBTMojo) mojoClass.getConstructor().newInstance();
			mojo.tags = getProperty("tags").toString();
			mojo.baseDir = baseDir;
			mojo.repoDir = repoDir;
			mojo.execute();
		} catch (Exception e) {
			Assertions.fail(e);
		}
	}
}
