package org.farhan.mbt.convert;

import java.util.ArrayList;

public interface ObjectRepository {

	// TODO I don't think the filetype will matter in the future, that filtering is
	// done by the transformation code
	public final String JAVA = ".java";
	public final String FEATURE = ".feature";
	public final String ASCIIDOC = ".asciidoc";

	public ArrayList<String> list(String tags, String path, String extension);

	public String get(String tags, String path) throws Exception;

	public void put(String tags, String path, String content) throws Exception;

	public boolean contains(String tags, String path);
	
	public void clear(String tags);
}
