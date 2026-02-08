package org.farhan.dsl.lang;

/**
 * Singleton holder that provides global access to the concrete factory instance.
 * <p>
 * Separates factory instance management from factory operations and builder
 * logic.
 * </p>
 */
public class SheepDogFactory {

	/**
	 * Stores the concrete factory implementation, allowing builders and other
	 * consumers to create grammar instances.
	 */
	public static ISheepDogFactory instance;

}
