# UML Interaction Patterns

## Logging

Logging patterns specific to sheepdogxtextplugin that supplement arch-logging.md and impl-log4j.md. All manually edited classes that call sheep-dog-test methods must have loggers. Generated classes do NOT have loggers. Methods calling sheep-dog-test use entry/exit logging with parameterized format.

### Entry/Exit Logging Pattern

Methods that delegate to sheep-dog-test business logic use entry/exit debug logging.

**Examples**
- ```java
  logger.debug("Entering check{Feature} for element: {}", element.getName());
  // delegate to business logic
  logger.debug("Exiting check{Feature}");
  ```

### Error Logging Pattern

Exceptions from sheep-dog-test calls are logged with parameterized format including the exception object as the final parameter.

**Examples**
- ```java
  logger.error("Failed in check{Feature} for {}: {}", element.getName(), e.getMessage(), e);
  ```

## Exceptions

Exception handling for Xtext IDE integration that supplements arch-logging.md. Catch and log exceptions from sheep-dog-test calls without throwing to framework. IModification.apply() BadLocationException can propagate as framework handles it.
