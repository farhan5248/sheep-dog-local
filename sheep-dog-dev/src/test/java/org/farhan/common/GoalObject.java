package org.farhan.common;

import java.util.ArrayList;

import org.farhan.mbt.convert.Converter;
import org.farhan.mbt.convert.Logger;
import org.farhan.mbt.convert.ObjectRepository;
import org.junit.jupiter.api.Assertions;

public abstract class GoalObject extends TestObject {

	// TODO don't hardcode the directories?
	protected String[] dirs = { "src/test/resources/asciidoc/", "src-gen/test/resources/cucumber/" };
	protected ObjectRepository or;
	protected SourceRepository sr;
	protected LoggerImpl log;
	protected String tags;

	public GoalObject() {
		or = new FileObjectRepository();
		sr = new SourceRepository();
		log = new LoggerImpl();
		attributes.put("tags", "");
	}

	protected void runGoal(String goal) {

		try {
			tags = attributes.get("tags");
			Class<?> mojoClass = Class.forName(goal);
			Converter mojo = (Converter) mojoClass.getConstructor(String.class, ObjectRepository.class, Logger.class)
					.newInstance(tags, or, log);

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
		} catch (Exception e) {
			Assertions.fail("There was an error executing the test step\n" + getStackTraceAsString(e));
		}
	}
}
