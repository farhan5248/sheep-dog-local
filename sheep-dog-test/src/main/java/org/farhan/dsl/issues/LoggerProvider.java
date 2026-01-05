package org.farhan.dsl.issues;

import org.slf4j.Logger;

public interface LoggerProvider {

	public Logger getLogger(Class<?> clazz);

}
