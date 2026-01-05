package org.farhan.dsl.issues;

import org.slf4j.Logger;

/**
 * Factory for creating loggers. Uses SLF4J by default when available, otherwise
 * falls back to a custom logger implementation.
 */
public class LoggerFactory {

	/**
	 * Custom logger implementation. When set, this is used instead of SLF4J.
	 */
	private static LoggerProvider provider = null;

	public static void setLoggerImplementation(LoggerProvider provider) {
		if (provider == null) {
			throw new IllegalArgumentException("Logger implementation cannot be null");
		} else {
			LoggerFactory.provider = provider;
		}
	}

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
