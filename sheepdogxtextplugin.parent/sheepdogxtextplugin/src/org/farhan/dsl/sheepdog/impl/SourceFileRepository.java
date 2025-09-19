package org.farhan.dsl.sheepdog.impl;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.farhan.dsl.lang.IResourceRepository;

public class SourceFileRepository implements IResourceRepository {

	private final String projectPath;

	public SourceFileRepository(String uriPath) {
		IFile resource = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uriPath));
		this.projectPath = (new File(resource.getProject().getLocationURI())).getAbsolutePath();
	}

	@Override
	public void clear(String tags) {
		deleteDir(new File(projectPath));
	}

	@Override
	public boolean contains(String tags, String path) {
		path = projectPath + path;
		return new File(path).exists();
	}

	@Override
	public void delete(String tags, String path) {
		path = projectPath + path;
		new File(path).delete();
	}
	
	private void deleteDir(File aDir) {
		if (aDir.exists()) {
			for (String s : aDir.list()) {
				File f = new File(aDir.getAbsolutePath() + File.separator + s);
				if (f.isDirectory()) {
					deleteDir(f);
				}
				f.delete();
			}
		}
	}


	@Override
	public String get(String tags, String path) throws Exception {
		path = projectPath + path;
		return new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
	}

	@Override
	public ArrayList<String> list(String tags, String subDir, String extension) {
		ArrayList<String> files = new ArrayList<String>();
		File aDir = new File(projectPath + subDir);
		if (aDir.exists()) {
			for (String f : aDir.list()) {
				String aDirObjPath = (subDir + f.replace(File.separator, "/"));
				if ((new File(projectPath + aDirObjPath)).isDirectory()) {
					files.addAll(list("", aDirObjPath + "/", extension));
				} else if (aDirObjPath.toLowerCase().endsWith(extension.toLowerCase())) {
					files.add(aDirObjPath.replaceFirst(projectPath, ""));
				}
			}
		}
		return files;
	}

	@Override
	public void put(String tags, String path, String content) throws Exception {
		path = projectPath + path;
		new File(path).getParentFile().mkdirs();
		PrintWriter pw = new PrintWriter(path, StandardCharsets.UTF_8);
		pw.write(content);
		pw.flush();
		pw.close();
	}
}
