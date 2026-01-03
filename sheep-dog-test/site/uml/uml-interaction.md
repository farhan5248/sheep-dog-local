# UML Interaction Patterns

## Logging

Logging patterns specific to sheep-dog-test that supplement the practices defined in [logging.md](../../../../arch-logging.md) and [impl-slf4j.md](../../../../impl-slf4j.md).

**Rules:**
- All {Feature}IssueDetector classes have loggers
- All {Feature}IssueResolver classes have loggers
- {Language}Builder class has logger
- {Feature}Utility classes do NOT have loggers
- I{Feature} interfaces do NOT have loggers
- {Language}Factory does NOT have logger
- Classes that read or write files through IResourceRepository should log these operations:

## Exceptions

**Rules:**
- Declare `throws Exception` in method signature for methods that can fail
- No specific exception types (IOException, NullPointerException, etc.)
- No custom exception classes defined
- No RuntimeException usage
- No try-catch blocks (exceptions propagate naturally)
- No graceful degradation (no catching and continuing)
- No null returns to signal failure
- Interfaces declare `throws Exception` in method signatures for content operations `getContent()`, `setContent()`, repository `get()`, `put()`
