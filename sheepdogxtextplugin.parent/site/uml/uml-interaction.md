# UML Interaction Patterns

## Logging

Logging patterns specific to sheepdogxtextplugin that supplement [arch-logging.md](../../../../arch-logging.md).

**Framework**: Eclipse Xtext uses Log4j 1.2 (via reload4j/orbit bundle), which does **not** support SLF4J-style parameterized logging with `{}` placeholders. See arch-logging.md "Log4j 1.2 Projects (String Concatenation)" section for general patterns.

**When to add logging:**
- All manually edited classes that call sheep-dog-test methods must have loggers
- Generated classes (in src-gen/) do NOT have loggers
- Methods calling sheep-dog-test business logic use entry/exit debug logging

**When entry/exit logging is required:**
ALL methods that call sheep-dog-test business logic must include entry/exit debug logging for tracing execution flow. This includes:
- Methods that directly call `*IssueDetector` or `*IssueResolver` classes
- Methods that call `createAcceptor()` which delegates to `*Resolver` classes

### Logger Initialization

LoggerBridge is set as the LoggerProvider in SheepDogRuntimeModule.configure():

**Example**
```java
LoggerFactory.setLoggerImplementation(new LoggerBridge());
```

### Entry/Exit Logging Pattern

Methods that delegate to sheep-dog-test business logic use entry/exit debug logging.

**Examples**

Multi-line method with try/catch:
- ```java
  logger.debug("Entering check{Type} for element: " + (element != null ? element.getName() : "null"));
  // delegate to business logic
  logger.debug("Exiting check{Type}");
  ```

Simple one-line delegation (extract element variable first for logging):
- ```java
  public void fixCellNameOnly(final Issue issue, IssueResolutionAcceptor acceptor) {
      Cell cell = (Cell) getEObject(issue);
      logger.debug("Entering fixCellNameOnly for element: " + (cell != null ? cell.getName() : "null"));
      createAcceptor(issue, acceptor, CellIssueResolver.correctNameOnly(new CellImpl(cell)));
      logger.debug("Exiting fixCellNameOnly");
  }
  ```

### Error Logging Pattern

Exceptions from sheep-dog-test calls are logged with string concatenation for the message, and the exception object as the final parameter.

**Examples**
- ```java
  logger.error("Failed in check{Type} for : "+ e.getMessage(), e);
  ```

## Exceptions

Exception handling for Xtext IDE integration that supplements arch-logging.md. Catch and log exceptions from sheep-dog-test calls without throwing to framework. IModification.apply() BadLocationException can propagate as framework handles it.
