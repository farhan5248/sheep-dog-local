package org.farhan.mbt.core;

import java.util.ArrayList;

import org.farhan.dsl.lang.IResourceRepository;

public abstract class ConvertibleProject {

	protected IResourceRepository fa;
	public String tags = "";
	// TODO replace TEST_STEPS with OBJECT_STEPS and create OBJECT_FIELDS
	// TODO maybe move these into an enumeration constant
	public final String TEST_CASES = "specs";
	public final String TEST_STEPS = "stepdefs";
	public final String TEST_OBJECTS = "objects";

	protected ArrayList<IConvertibleObject> firstLayerObjects;
	protected ArrayList<IConvertibleObject> secondLayerObjects;
	protected ArrayList<IConvertibleObject> thirdLayerObjects;

	public ConvertibleProject(String tags, IResourceRepository fa) {
		firstLayerObjects = new ArrayList<IConvertibleObject>();
		secondLayerObjects = new ArrayList<IConvertibleObject>();
		thirdLayerObjects = new ArrayList<IConvertibleObject>();
		this.fa = fa;
		this.tags = tags;
	}

	public abstract IConvertibleObject addFile(String path) throws Exception;

	public abstract void deleteObject(IConvertibleObject srcObj);

	public abstract String getDir(String layer);

	public abstract String getFileExt(String layer);

	public abstract ArrayList<IConvertibleObject> getObjects(String layer);

	public IConvertibleObject getObject(String path) {
		if (path.startsWith(getDir(TEST_OBJECTS))) {
			for (IConvertibleObject obj : thirdLayerObjects) {
				if (obj.getPath().contentEquals(path)) {
					return obj;
				}
			}
		} else if (path.startsWith(getDir(TEST_STEPS))) {
			for (IConvertibleObject obj : secondLayerObjects) {
				if (obj.getPath().contentEquals(path)) {
					return obj;
				}
			}
		} else if (path.startsWith(getDir(TEST_CASES))) {
			for (IConvertibleObject obj : firstLayerObjects) {
				if (obj.getPath().contentEquals(path)) {
					return obj;
				}
			}
		}
		return null;
	}

	public abstract void init() throws Exception;
}
