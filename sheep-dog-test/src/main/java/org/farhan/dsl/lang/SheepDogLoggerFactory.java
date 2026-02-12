package org.farhan.dsl.lang;

import org.slf4j.Logger;

/**
 * Facade for logger creation that abstracts SLF4J vs custom logger providers.
 * <p>
 * Separates logging infrastructure concerns from business logic by hiding
 * provider selection and fallback.
 * </p>
 */
public class SheepDogLoggerFactory {

	/**
	 * Custom logger implementation. When set, this is used instead of SLF4J.
	 */
	private static SheepDogLoggerProvider provider = null;

	/**
	 * Configures custom logger provider for environments without SLF4J
	 * implementations (like Eclipse OSGi).
	 *
	 * @param provider the custom logger provider
	 * @throws IllegalArgumentException if provider is null
	 */
	public static void setLoggerImplementation(SheepDogLoggerProvider provider) {
		if (provider == null) {
			throw new IllegalArgumentException("Logger implementation cannot be null");
		} else {
			SheepDogLoggerFactory.provider = provider;
		}
	}

	/**
	 * Creates logger for a class by selecting SLF4J or custom provider based on
	 * availability.
	 *
	 * @param clazz the class to create a logger for
	 * @return the logger instance
	 */
	public static Logger getLogger(Class<?> clazz) {
		// Use custom impl if SLF4J has no real provider
		if (org.slf4j.LoggerFactory.getILoggerFactory() instanceof org.slf4j.helpers.NOPLoggerFactory) {
			if (provider != null) {
				return provider.getLogger(clazz);
			}
		}
		// Use SLF4J (either real provider exists, or fall back to NOP)
		return org.slf4j.LoggerFactory.getLogger(clazz);
	}

}
