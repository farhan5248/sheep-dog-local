# {Language}Logger

## {Language}Logger implements both org.slf4j.Logger and LoggerProvider interfaces

Bridges SLF4J logging calls to Log4j in the Eclipse/OSGi environment.

**Examples**

- ```java
  public class SheepDogLogger implements Logger, LoggerProvider {
  ```

## {Language}Logger has a Log4j logger attribute

Holds the underlying Log4j logger for delegation.

**Examples**

- ```java
  // SheepDogLogger.java
  private org.apache.log4j.Logger log4jLogger;
  ```

## {Language}Logger has two constructors for different use cases

Default constructor for LoggerProvider registration, and parameterized constructor for class-specific loggers.

**Examples**

- ```java
  // SheepDogLogger.java
  public SheepDogLogger() {
      this.log4jLogger = null;
  }

  public SheepDogLogger(Class<?> clazz) {
      this.log4jLogger = org.apache.log4j.Logger.getLogger(clazz);
  }
  ```

## LoggerProvider.getLogger creates a new {Language}Logger for the specified class

Factory method implementation for the LoggerProvider interface.

**Examples**

- ```java
  // SheepDogLogger.java
  @Override
  public Logger getLogger(Class<?> clazz) {
      return new SheepDogLogger(clazz);
  }
  ```

## format method converts SLF4J placeholders to formatted strings

Private helper that replaces `{}` placeholders with argument values for Log4j.

**Examples**

- ```java
  // SheepDogLogger.java
  private String format(String format, Object... args) {
      String result = format;
      for (Object arg : args) {
          result = result.replaceFirst("\\{\\}", String.valueOf(arg));
      }
      return result;
  }
  ```

## Each logging level has overloaded methods matching org.slf4j.Logger interface

Methods for debug, info, warn, error, and trace levels with various signatures.

**Examples**

- ```java
  // SheepDogLogger.java
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
  ```

## isLevelEnabled methods delegate to Log4j level checks

Returns whether logging is enabled for the corresponding level.

**Examples**

- ```java
  // SheepDogLogger.java
  @Override
  public boolean isInfoEnabled() {
      return log4jLogger.isEnabledFor(Level.INFO);
  }

  @Override
  public boolean isDebugEnabled() {
      return log4jLogger.isEnabledFor(Level.DEBUG);
  }
  ```
