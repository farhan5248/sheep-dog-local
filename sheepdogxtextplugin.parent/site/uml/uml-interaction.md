# UML Interaction Patterns

## Logging

Logging patterns specific to sheepdogxtextplugin that supplement [arch-logging.md](../../../../arch-logging.md).

**Framework**: Eclipse Xtext uses Log4j 1.2 (via reload4j/orbit bundle), which does **not** support SLF4J-style parameterized logging with `{}` placeholders.

**When to add logging:**
- All manually edited classes that call sheep-dog-test methods must have loggers
- Generated classes (in src-gen/) do NOT have loggers
- Methods calling sheep-dog-test business logic use entry/exit debug logging

**When entry/exit logging is required:**
ALL methods that call sheep-dog-test business logic must include entry/exit debug logging for tracing execution flow. This includes:
- Methods that directly call `*IssueDetector` or `*IssueResolver` classes
- Methods that call `createAcceptor()` which delegates to `*Resolver` classes

### Logger Initialization

{Language}Logger is set as the LoggerProvider in {Language}RuntimeModule.configure():

**Example**
```java
LoggerFactory.setLoggerImplementation(new SheepDogLogger());
```

### Entry/Exit Logging Pattern

Methods that delegate to sheep-dog-test business logic use entry/exit debug logging.

See [arch-logging.md](../../../../arch-logging.md) "Log4j 1.2 Projects (String Concatenation)" section for patterns.

### Error Logging Pattern

See [arch-logging.md](../../../../arch-logging.md) "Error Logging Pattern (Log4j 1.2)" section.

## Exceptions

Exception handling for Xtext IDE integration. See [arch-xtext-logging.md](../../../../arch-xtext-logging.md) "Xtext IDE Exception Handling" section for rationale and patterns.
