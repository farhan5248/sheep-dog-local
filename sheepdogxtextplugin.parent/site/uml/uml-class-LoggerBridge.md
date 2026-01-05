# LoggerBridge

## Purpose

Implements both `org.slf4j.Logger` and `LoggerProvider` interfaces to bridge SLF4J logging calls to Log4j in the Eclipse/OSGi environment.

## Implements

- org.slf4j.Logger
- org.farhan.dsl.issues.LoggerProvider

## Attributes

- `log4jLogger`: org.apache.log4j.Logger - The underlying Log4j logger

## Constructors

### LoggerBridge()

Default constructor used when registered as LoggerProvider. Sets log4jLogger to null.

### LoggerBridge(Class<?>)

Creates a LoggerBridge with a Log4j logger for the specified class.

## Key Methods

### getLogger(Class<?>) : Logger

LoggerProvider implementation. Creates a new LoggerBridge for the specified class.

### format(String, Object...) : String

Private helper that converts SLF4J `{}` placeholders to formatted strings for Log4j.

**Conversion Logic**
- Iterates through args
- Replaces each `{}` with `String.valueOf(arg)`

### Logging Methods (debug, info, warn, error, trace)

Each logging level has multiple overloaded methods matching org.slf4j.Logger interface:
- `level(String msg)`
- `level(String format, Object arg)`
- `level(String format, Object arg1, Object arg2)`
- `level(String format, Object... arguments)`
- `level(String msg, Throwable t)`
- `level(Marker marker, ...)` variants

All format variants call `format()` helper before delegating to Log4j.

### isLevelEnabled Methods

Returns `log4jLogger.isEnabledFor(Level.LEVEL)` for the corresponding level.