package org.farhan.mbt.convert;

import java.util.ArrayList;

public abstract class ConvertibleProject {

	protected ObjectRepository fa;
	public String tags = "";
	// TODO replace TEST_STEPS with OBJECT_STEPS and create OBJECT_FIELDS
	// TODO maybe move these into an enumeration constant
	public final String TEST_CASES = "specs";
	public final String TEST_STEPS = "stepdefs";
	public final String TEST_OBJECTS = "objects";

	protected ArrayList<ConvertibleObject> firstLayerObjects;
	protected ArrayList<ConvertibleObject> secondLayerObjects;
	protected ArrayList<ConvertibleObject> thirdLayerObjects;

	public ConvertibleProject(String tags, ObjectRepository fa) {
		firstLayerObjects = new ArrayList<ConvertibleObject>();
		secondLayerObjects = new ArrayList<ConvertibleObject>();
		thirdLayerObjects = new ArrayList<ConvertibleObject>();
		this.fa = fa;
		this.tags = tags;
	}

	public abstract ConvertibleObject addFile(String path) throws Exception;

	public abstract void deleteObject(ConvertibleObject srcObj);

	public abstract String getDir(String layer);

	public abstract String getFileExt(String layer);

	public abstract ArrayList<ConvertibleObject> getObjects(String layer);

	public ConvertibleObject getObject(String path) {
		if (path.startsWith(getDir(TEST_OBJECTS))) {
			for (ConvertibleObject obj : thirdLayerObjects) {
				if (obj.getPath().contentEquals(path)) {
					return obj;
				}
			}
		} else if (path.startsWith(getDir(TEST_STEPS))) {
			for (ConvertibleObject obj : secondLayerObjects) {
				if (obj.getPath().contentEquals(path)) {
					return obj;
				}
			}
		} else if (path.startsWith(getDir(TEST_CASES))) {
			for (ConvertibleObject obj : firstLayerObjects) {
				if (obj.getPath().contentEquals(path)) {
					return obj;
				}
			}
		}
		return null;
	}

	public abstract void init() throws Exception;
}
