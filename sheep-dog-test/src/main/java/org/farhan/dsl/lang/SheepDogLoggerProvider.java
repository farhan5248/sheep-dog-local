package org.farhan.dsl.lang;

import org.slf4j.Logger;

/**
 * Interface for custom logger implementations.
 * <p>
 * Separates logger provider contract from logger usage, enabling dependency
 * injection in environments without SLF4J.
 * </p>
 */
public interface SheepDogLoggerProvider {

	/**
	 * Creates a logger instance for the specified class when custom logging is
	 * needed.
	 *
	 * @param clazz the class to create a logger for
	 * @return the logger instance
	 */
	public Logger getLogger(Class<?> clazz);

}
