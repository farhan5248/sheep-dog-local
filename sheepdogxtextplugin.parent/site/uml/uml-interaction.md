# UML Interaction Patterns

## Logging

Logging patterns specific to sheepdogxtextplugin that supplement [arch-logging.md](../../../../arch-logging.md).

**Framework**: Eclipse Xtext uses Log4j 1.2 (via reload4j/orbit bundle), which does **not** support SLF4J-style parameterized logging with `{}` placeholders.

See [arch-xtext-logging.md](../../../../arch-xtext-logging.md) "When to Add Logging" section for when to add logging and entry/exit logging requirements.

### Logger Initialization

{Language}Logger is set as the LoggerProvider in {Language}RuntimeModule.configure():

**Example**
```java
LoggerFactory.setLoggerImplementation(new SheepDogLogger());
```

### Entry/Exit Logging Pattern

Methods that delegate to sheep-dog-test business logic use entry/exit debug logging.

See [impl-log4j.md](../../../../impl-log4j.md) for entry, exit, and error logging patterns.

### Error Logging Pattern

See [impl-log4j.md](../../../../impl-log4j.md) "Error Logging Pattern" section.

## Exceptions

Exception handling for Xtext IDE integration. See [arch-xtext-logging.md](../../../../arch-xtext-logging.md) "Xtext IDE Exception Handling" section for rationale and patterns.
