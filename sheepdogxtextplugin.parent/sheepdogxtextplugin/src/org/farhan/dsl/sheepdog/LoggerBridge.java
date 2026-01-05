package org.farhan.dsl.sheepdog;

import org.apache.log4j.Level;
import org.slf4j.Logger;
import org.slf4j.Marker;
import org.farhan.dsl.issues.LoggerProvider;

public class LoggerBridge implements Logger, LoggerProvider {

	private org.apache.log4j.Logger log4jLogger = null;

	public LoggerBridge(Class<?> clazz) {
		log4jLogger = org.apache.log4j.Logger.getLogger(clazz);
	}

	public LoggerBridge() {
		log4jLogger = null;
	}

	@Override
	public Logger getLogger(Class<?> clazz) {
		return new LoggerBridge(clazz);
	}

	private String format(String pattern, Object... args) {
		if (args == null || args.length == 0) {
			return pattern;
		}
		String result = pattern;
		for (Object arg : args) {
			int idx = result.indexOf("{}");
			if (idx >= 0) {
				result = result.substring(0, idx) + String.valueOf(arg) + result.substring(idx + 2);
			}
		}
		return result;
	}

	// ========== DEBUG ==========

	@Override
	public void debug(String msg) {
		log4jLogger.debug(msg);
	}

	@Override
	public void debug(String format, Object arg) {
		log4jLogger.debug(format(format, arg));
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		log4jLogger.debug(format(format, arg1, arg2));
	}

	@Override
	public void debug(String format, Object... arguments) {
		log4jLogger.debug(format(format, arguments));
	}

	@Override
	public void debug(String msg, Throwable t) {
		log4jLogger.debug(msg, t);
	}

	@Override
	public boolean isDebugEnabled() {
		return log4jLogger.isEnabledFor(Level.DEBUG);
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		return isDebugEnabled();
	}

	@Override
	public void debug(Marker marker, String msg) {
		log4jLogger.debug(msg);
	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		log4jLogger.debug(format(format, arg));
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		log4jLogger.debug(format(format, arg1, arg2));
	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		log4jLogger.debug(format(format, arguments));
	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		log4jLogger.debug(msg, t);
	}

	// ========== INFO ==========

	@Override
	public void info(String msg) {
		log4jLogger.info(msg);
	}

	@Override
	public void info(String format, Object arg) {
		log4jLogger.info(format(format, arg));
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		log4jLogger.info(format(format, arg1, arg2));
	}

	@Override
	public void info(String format, Object... arguments) {
		log4jLogger.info(format(format, arguments));
	}

	@Override
	public void info(String msg, Throwable t) {
		log4jLogger.info(msg, t);
	}

	@Override
	public boolean isInfoEnabled() {
		return log4jLogger.isEnabledFor(Level.INFO);
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return isInfoEnabled();
	}

	@Override
	public void info(Marker marker, String msg) {
		log4jLogger.info(msg);
	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		log4jLogger.info(format(format, arg));
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		log4jLogger.info(format(format, arg1, arg2));
	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {
		log4jLogger.info(format(format, arguments));
	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		log4jLogger.info(msg, t);
	}

	// ========== WARN ==========

	@Override
	public void warn(String msg) {
		log4jLogger.warn(msg);
	}

	@Override
	public void warn(String format, Object arg) {
		log4jLogger.warn(format(format, arg));
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		log4jLogger.warn(format(format, arg1, arg2));
	}

	@Override
	public void warn(String format, Object... arguments) {
		log4jLogger.warn(format(format, arguments));
	}

	@Override
	public void warn(String msg, Throwable t) {
		log4jLogger.warn(msg, t);
	}

	@Override
	public boolean isWarnEnabled() {
		return log4jLogger.isEnabledFor(Level.WARN);
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		return isWarnEnabled();
	}

	@Override
	public void warn(Marker marker, String msg) {
		log4jLogger.warn(msg);
	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		log4jLogger.warn(format(format, arg));
	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		log4jLogger.warn(format(format, arg1, arg2));
	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		log4jLogger.warn(format(format, arguments));
	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		log4jLogger.warn(msg, t);
	}

	// ========== ERROR ==========

	@Override
	public void error(String msg) {
		log4jLogger.error(msg);
	}

	@Override
	public void error(String format, Object arg) {
		log4jLogger.error(format(format, arg));
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		log4jLogger.error(format(format, arg1, arg2));
	}

	@Override
	public void error(String format, Object... arguments) {
		log4jLogger.error(format(format, arguments));
	}

	@Override
	public void error(String msg, Throwable t) {
		log4jLogger.error(msg, t);
	}

	@Override
	public boolean isErrorEnabled() {
		return log4jLogger.isEnabledFor(Level.ERROR);
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		return isErrorEnabled();
	}

	@Override
	public void error(Marker marker, String msg) {
		log4jLogger.error(msg);
	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		log4jLogger.error(format(format, arg));
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		log4jLogger.error(format(format, arg1, arg2));
	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {
		log4jLogger.error(format(format, arguments));
	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		log4jLogger.error(msg, t);
	}

	// ========== TRACE ==========

	@Override
	public void trace(String msg) {
		log4jLogger.trace(msg);
	}

	@Override
	public void trace(String format, Object arg) {
		log4jLogger.trace(format(format, arg));
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		log4jLogger.trace(format(format, arg1, arg2));
	}

	@Override
	public void trace(String format, Object... arguments) {
		log4jLogger.trace(format(format, arguments));
	}

	@Override
	public void trace(String msg, Throwable t) {
		log4jLogger.trace(msg, t);
	}

	@Override
	public boolean isTraceEnabled() {
		return log4jLogger.isEnabledFor(Level.TRACE);
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		return isTraceEnabled();
	}

	@Override
	public void trace(Marker marker, String msg) {
		log4jLogger.trace(msg);
	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		log4jLogger.trace(format(format, arg));
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		log4jLogger.trace(format(format, arg1, arg2));
	}

	@Override
	public void trace(Marker marker, String format, Object... arguments) {
		log4jLogger.trace(format(format, arguments));
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		log4jLogger.trace(msg, t);
	}

	// ========== NAME ==========

	@Override
	public String getName() {
		return log4jLogger.getName();
	}

}
