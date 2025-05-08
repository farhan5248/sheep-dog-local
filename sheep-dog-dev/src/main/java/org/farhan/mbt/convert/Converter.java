package org.farhan.mbt.convert;

import java.util.ArrayList;

import org.farhan.mbt.core.UMLTestProject;

public abstract class Converter {

	protected String tags = "";
	protected ConvertibleProject project;
	protected UMLTestProject model;
	protected ObjectRepository fa;
	protected Logger log;

	public Converter(String tags, ObjectRepository fa, Logger log) {
		this.tags = tags;
		this.fa = fa;
		this.log = log;
	}

	public abstract void initProjects() throws Exception;

	public void clearProjects() throws Exception {
		fa.clear(tags);
	}

	public ArrayList<String> getFileNames() throws Exception {
		// TODO this is temp hack until I figure out how to manage the objects, the
		// project files and model better. This only applies to converters that
		// transform the model into files
		return null;
	}

	// TODO change return type to void and create getFileContent method
	public abstract String convertFile(String path, String content) throws Exception;

}
