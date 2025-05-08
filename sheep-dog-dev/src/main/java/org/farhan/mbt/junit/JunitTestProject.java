package org.farhan.mbt.junit;

import java.util.ArrayList;

import org.farhan.mbt.convert.ConvertibleObject;
import org.farhan.mbt.convert.ConvertibleProject;
import org.farhan.mbt.convert.ObjectRepository;

public class JunitTestProject extends ConvertibleProject {

	public final String TEST_CASES = "suites";
	public final String TEST_OBJECTS = "objects";

	public JunitTestProject(String tags, ObjectRepository fa) {
		super(tags, fa);
	}

	@Override
	public ConvertibleObject addFile(String path) throws Exception {
		// TODO calculate an actual checksum
		fa.put(tags, path, "sha checksum");
		ConvertibleObject aConvertibleObject = getObject(path);
		if (aConvertibleObject != null) {
			return aConvertibleObject;
		} else {
			if (!path.startsWith(getDir(TEST_CASES))) {
				aConvertibleObject = new JunitInterface(path);
				secondLayerObjects.add(aConvertibleObject);
			} else {
				aConvertibleObject = createClass(path);
				firstLayerObjects.add(aConvertibleObject);
			}
			return aConvertibleObject;
		}
	}

	protected ConvertibleObject createClass(String path) {
		return new JunitClass(path);
	}

	@Override
	public String getDir(String layer) {
		switch (layer) {
		case TEST_CASES:
			return "src-gen/test/java/org/farhan/" + TEST_CASES;
		case TEST_OBJECTS:
			return "src-gen/test/java/org/farhan/" + TEST_OBJECTS;
		default:
			return "";
		}
	}

	@Override
	public String getFileExt(String layer) {
		return ".java";
	}

	@Override
	public ArrayList<ConvertibleObject> getObjects(String layer) {

		ArrayList<ConvertibleObject> layerObjects = null;
		switch (layer) {
		case TEST_CASES:
			layerObjects = firstLayerObjects;
			break;
		case TEST_OBJECTS:
			layerObjects = secondLayerObjects;
			break;
		}
		return layerObjects;
	}

	@Override
	public void init() throws Exception {
		// TODO do I need to override this?
	}

	@Override
	public void deleteObject(ConvertibleObject srcObj) {
		firstLayerObjects.remove(srcObj);
		secondLayerObjects.remove(srcObj);
	}

}
