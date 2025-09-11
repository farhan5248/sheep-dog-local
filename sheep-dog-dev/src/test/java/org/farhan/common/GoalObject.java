package org.farhan.common;

import java.util.ArrayList;

import org.farhan.mbt.core.Converter;
import org.farhan.mbt.core.ObjectRepository;
import org.junit.jupiter.api.Assertions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class GoalObject extends TestObject {

	private static final Logger logger = LoggerFactory.getLogger(GoalObject.class);

	// TODO don't hardcode the directories
	protected String[] dirs = { "src/test/resources/asciidoc/", "src-gen/test/resources/cucumber/" };
	protected ObjectRepository or;
	protected SourceRepository sr;
	protected String tags;

	public GoalObject() {
		or = new FileObjectRepository();
		sr = new SourceRepository();
		attributes.put("tags", "");
	}

	protected void runGoal(String goal) {
		logger.debug("Entering runGoal for goal: {}", goal != null ? goal : "null");
		try {
			tags = attributes.get("tags");
			Class<?> mojoClass = Class.forName(goal);
			Converter mojo = (Converter) mojoClass.getConstructor(String.class, ObjectRepository.class)
					.newInstance(tags, or);

			if (mojo.getClass().getName().endsWith("ToUML")) {
				mojo.clearProjects();
				for (String dir : dirs) {
					ArrayList<String> tempFiles = new ArrayList<String>();
					for (String fileName : sr.list(dir, "")) {
						if (fileName.startsWith(dir + "stepdefs")) {
							tempFiles.add(fileName);
						} else {
							mojo.convertFile(fileName, sr.get(fileName));
						}
					}
					for (String fileName : tempFiles) {
						mojo.convertFile(fileName, sr.get(fileName));
					}
				}
			} else {
				for (String fileName : mojo.getFileNames()) {
					String content = mojo.convertFile(fileName, sr.contains(fileName) ? sr.get(fileName) : "");
					if (!content.isEmpty()) {
						sr.put(fileName, content);
					}
				}
			}
			logger.debug("Exiting runGoal");
		} catch (Exception e) {
			logger.error("Failed in runGoal for goal '{}': {}", goal != null ? goal : "null", e.getMessage(), e);
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
