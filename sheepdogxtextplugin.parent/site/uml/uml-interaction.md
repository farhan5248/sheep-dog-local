# UML Interaction Patterns

## Logging

Logging patterns specific to sheepdogxtextplugin that supplement [arch-logging.md](../../../../arch-logging.md) and [impl-log4j.md](../../../../impl-log4j.md).

**Rules:**
- All manually edited classes that call sheep-dog-test methods must have loggers
- Generated classes do NOT have loggers
- Methods calling sheep-dog-test use entry/exit logging (per arch-logging.md)
- Use parameterized logging: `logger.error("Failed in {}: {}", methodName, e.getMessage(), e)`

### Entry/Exit Logging Pattern

```java
logger.debug("Entering check{Feature} for element: {}", element.getName());
// delegate to business logic
logger.debug("Exiting check{Feature}");
```

### Error Logging Pattern

**Modern Approach** (pass exception to logger):
```java
logger.error("Failed in check{Feature} for {}: {}", element.getName(), e.getMessage(), e);
```

**Key Points:**
- The exception object `e` is passed as the **final parameter**
- The logging framework automatically extracts and formats the stack trace
- **Do NOT use** `e.printStackTrace()` - it's discouraged because:
  - Not thread-safe (produces interleaved output in multi-threaded apps)
  - Goes to stderr instead of structured logging
  - Cannot be routed to monitoring tools
  - Clutters console with unstructured output

## Exceptions

Exception handling for Xtext IDE integration that supplements [arch-logging.md](../../../../arch-logging.md). See [arch-xtext.md](../../../../arch-xtext.md) for framework rationale.

**Rules:**
- Catch and log exceptions from sheep-dog-test calls (do not throw to framework)
- Log using parameterized format: `logger.error("Failed in {}: {}", methodName, e.getMessage(), e)`
- IModification.apply() BadLocationException can propagate (framework handles it)
