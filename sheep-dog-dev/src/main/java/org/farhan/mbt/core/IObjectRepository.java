package org.farhan.mbt.core;

import java.util.ArrayList;

public interface IObjectRepository extends org.farhan.dsl.lang.IObjectRepository {
	
	// TODO delete this class and use the one it extends

	public ArrayList<String> list(String tags, String path, String extension);

	public String get(String tags, String path) throws Exception;

	public void put(String tags, String path, String content) throws Exception;

	public boolean contains(String tags, String path);

	public void clear(String tags);

	public void delete(String tags, String path);
}
