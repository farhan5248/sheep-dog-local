package org.farhan.dsl.lang;

import java.util.List;

/**
 * Repository interface for file I/O operations.
 * <p>
 * Separates persistence contracts from business logic, allowing different
 * implementations (filesystem, in-memory, Eclipse workspace).
 * </p>
 */
public interface IResourceRepository {

	/**
	 * Clears all resources with the specified tags.
	 *
	 * @param tags the tags identifying resources to clear
	 */
	public void clear(String tags);

	/**
	 * Checks if a resource exists at the specified path with given tags.
	 *
	 * @param tags the tags identifying the resource
	 * @param path the path to the resource
	 * @return true if the resource exists, false otherwise
	 */
	public boolean contains(String tags, String path);

	/**
	 * Deletes the resource at the specified path with given tags.
	 *
	 * @param tags the tags identifying the resource
	 * @param path the path to the resource
	 */
	public void delete(String tags, String path);

	/**
	 * Retrieves the content of the resource at the specified path with given tags.
	 *
	 * @param tags the tags identifying the resource
	 * @param path the path to the resource
	 * @return the content of the resource
	 * @throws Exception if the resource cannot be retrieved
	 */
	public String get(String tags, String path) throws Exception;

	/**
	 * Lists all resources matching the path pattern, extension, and tags.
	 *
	 * @param tags the tags identifying the resources
	 * @param path the path pattern to match
	 * @param extension the file extension to filter by
	 * @return a list of resource paths
	 */
	public List<String> list(String tags, String path, String extension);

	/**
	 * Stores content at the specified path with given tags.
	 *
	 * @param tags the tags identifying the resource
	 * @param path the path to store the resource
	 * @param content the content to store
	 * @throws Exception if the resource cannot be stored
	 */
	public void put(String tags, String path, String content) throws Exception;
}
