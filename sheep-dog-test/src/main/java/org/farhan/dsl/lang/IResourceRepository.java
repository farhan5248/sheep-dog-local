package org.farhan.dsl.lang;

import java.util.ArrayList;

public interface IResourceRepository {

	public void clear(String tags);

	public boolean contains(String tags, String path);

	public void delete(String tags, String path);

	public String get(String tags, String path) throws Exception;

	public ArrayList<String> list(String tags, String path, String extension);

	public void put(String tags, String path, String content) throws Exception;
}
