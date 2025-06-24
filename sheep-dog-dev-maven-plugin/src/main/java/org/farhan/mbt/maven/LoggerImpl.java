package org.farhan.mbt.maven;

import org.apache.maven.plugin.logging.Log;
import org.farhan.mbt.core.Logger;

public class LoggerImpl implements Logger {

	private Log log;

	public LoggerImpl(Log log) {
		this.log = log;
	}

	@Override
	public void debug(String message) {
		log.debug(message);
	}

}
