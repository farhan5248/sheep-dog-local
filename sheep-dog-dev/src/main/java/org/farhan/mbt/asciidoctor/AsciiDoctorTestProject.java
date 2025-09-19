
package org.farhan.mbt.asciidoctor;

import java.util.ArrayList;

import org.farhan.dsl.sheepdog.SheepDogStandaloneSetup;
import org.farhan.mbt.core.IConvertibleObject;
import org.farhan.mbt.core.ConvertibleProject;
import org.farhan.dsl.lang.IResourceRepository;

public class AsciiDoctorTestProject extends ConvertibleProject {

	public AsciiDoctorTestProject(String tags, IResourceRepository fa) {
		super(tags, fa);
	}

	@Override
	public IConvertibleObject addFile(String path) throws Exception {

		// TODO calculate an actual checksum
		fa.put(tags, path, "sha checksum");
		IConvertibleObject co = getObject(path);
		if (co != null) {
			return co;
		} else {
			if (path.startsWith(getDir(TEST_STEPS))) {
				co = new AsciiDoctorStepObject(path);
				secondLayerObjects.add(co);
			} else {
				co = new AsciiDoctorTestSuite(path);
				firstLayerObjects.add(co);
			}
			return co;
		}
	}

	@Override
	public String getDir(String layer) {
		switch (layer) {
		case TEST_CASES:
			return "src/test/resources/asciidoc/" + TEST_CASES;
		case TEST_STEPS:
			return "src/test/resources/asciidoc/" + TEST_STEPS;
		case TEST_OBJECTS:
			return "src/test/resources/asciidoc/" + TEST_OBJECTS;
		default:
			return "src/test/resources/asciidoc";
		}
	}

	@Override
	public String getFileExt(String layer) {
		return ".asciidoc";
	}

	@Override
	public ArrayList<IConvertibleObject> getObjects(String layer) {
		// TODO nothing uses this so return null?
		ArrayList<IConvertibleObject> layerFiles = null;
		switch (layer) {
		case TEST_CASES:
			layerFiles = firstLayerObjects;
			break;
		}
		return layerFiles;
	}

	@Override
	public void init() throws Exception {
		SheepDogStandaloneSetup.doSetup();
	}

	@Override
	public void deleteObject(IConvertibleObject srcObj) {
		firstLayerObjects.remove(srcObj);
	}

}
