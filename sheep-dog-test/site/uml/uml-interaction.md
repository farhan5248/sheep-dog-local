# UML Interaction Patterns

## Logging

SLF4J logging patterns specific to sheep-dog-test that supplement [arch-logging.md](../../../../arch-logging.md). These patterns define which classes have loggers and which operations should be logged.

### Logger Declaration Pattern

Detector, resolver, and builder classes declare SLF4J loggers using the custom LoggerFactory for tracking operations and debugging.

**Note**: Import is `org.farhan.dsl.issues.LoggerFactory` (custom), not `org.slf4j.LoggerFactory`.

**Examples**

- {Type}IssueDetector classes:
```java
private static final Logger logger = LoggerFactory.getLogger(TestStepIssueDetector.class);
```

- {Type}IssueResolver classes:
```java
private static final Logger logger = LoggerFactory.getLogger(TestStepIssueResolver.class);
```

- {Language}Builder class:
```java
private static final Logger logger = LoggerFactory.getLogger(SheepDogBuilder.class);
```

### Entry/Exit Logging Pattern

All public methods in Detector, Resolver, and Builder classes MUST have entry and exit logging.

**Rules**
- Entry log is the first statement in each public method
- Exit log is placed before each return statement

See [arch-logging.md](../../../../arch-logging.md) "Specific Rules" section for pattern details.

### No Logger Pattern

Utility classes, interfaces, and factory classes do not declare loggers to keep them lightweight and focused on their single responsibility.

**Examples**

- {Type}Utility classes have no logger
- I{Type} interfaces have no logger
- {Language}Factory has no logger

### File Operation Logging Pattern

Classes that read or write files through IResourceRepository log these I/O operations for debugging and troubleshooting.

**Examples**

```java
logger.debug("Reading file: {}", path);
repository.get(path);
```

```java
logger.debug("Writing file: {}", path);
repository.put(path, content);
```

## Exception Handling

Java Exception class is used for all error propagation without catching or handling. This simple approach ensures all errors propagate to test execution layer where they can be properly reported.

### Exception Propagation Pattern

Methods declare throws Exception in signatures and allow all exceptions to propagate naturally without try-catch blocks.

**Examples**

- Method signatures:
```java
public void getContent() throws Exception {
    // Implementation that may throw
}
```

```java
public void setContent(String content) throws Exception {
    // Implementation that may throw
}
```

- Interface methods:
```java
public interface IResourceRepository {
    Object get(String path) throws Exception;
    void put(String path, Object content) throws Exception;
}
```

### No Exception Handling Pattern

No try-catch blocks, custom exceptions, RuntimeException usage, null returns for errors, or graceful degradation. All errors propagate immediately.

**Examples**

- No try-catch:
```java
// Not allowed
try {
    riskyOperation();
} catch (Exception e) {
    // handle
}
```

- No custom exceptions:
```java
// Not allowed
class CustomException extends Exception { }
```

- No null returns for errors:
```java
// Not allowed
public Object loadFile() {
    try {
        return readFile();
    } catch (Exception e) {
        return null; // Bad - use throws Exception instead
    }
}
```
