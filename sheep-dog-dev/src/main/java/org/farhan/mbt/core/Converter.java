package org.farhan.mbt.core;

import java.util.ArrayList;

public abstract class Converter {

	protected String tags = "";
	protected ConvertibleProject project;
	protected UMLTestProject model;
	protected IObjectRepository fa;

	public Converter(String tags, IObjectRepository fa) {
		this.tags = tags;
		this.fa = fa;
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
